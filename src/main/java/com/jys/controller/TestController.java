package com.jys.controller;

import com.common.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jys.mapper.AreaDOMapper;
import com.jys.mapper.CityDOMapper;
import com.jys.mapper.ProvinceDOMapper;
import com.jys.model.AreaDO;
import com.jys.model.CityDO;
import com.jys.model.JysUser;
import com.jys.model.ProvinceDO;
import com.jys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import utils.SingleArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@RestController
@ComponentScan
public class TestController {

    @Autowired
    private UserService service;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ProvinceDOMapper provinceDOMapper;

    @Autowired
    private CityDOMapper cityDOMapper;

    @Autowired
    private AreaDOMapper areaDOMapper;

    @RequestMapping(value = "/a")
    public List<Province> a() {
        List<Province> provinceList = null;
        try {
            //2018年11月中华人民共和国县以上行政区划代码网页
            Document doc = Jsoup.connect("http://www.mca.gov.cn/article/sj/xzqh/2019/201901-06/201902061009.html").maxBodySize(0).get();
            Elements elements = doc.getElementsByClass("xl7016597");
            List<String> stringList = elements.eachText();
            List<String> stringName = new ArrayList<String>();
            List<String> stringCode = new ArrayList<String>();
            for (int i = 0; i < stringList.size(); i++) {
                if (i % 2 == 0) {
                    //地区代码
                    stringCode.add(stringList.get(i));
                } else {
                    //地区名字
                    stringName.add(stringList.get(i));
                }
            }
            //正常情况 两个 list size 应该 一样
            System.out.println("stringName  size= " + stringName.size() + "   stringCode   size= " + stringCode.size());
            if (stringName.size() != stringCode.size()) {
                throw new RuntimeException("数据错误");
            }
            provinceList = processData(stringName, stringCode);
            Date date = new Date();
            for(Province p:provinceList){
                ProvinceDO provinceDO = new ProvinceDO();
                provinceDO.setTid(p.getCode());
                provinceDO.setDelFlag("0");
                provinceDO.setUpdateDate(date);
                provinceDO.setCreateDate(date);
                provinceDO.setCountryId(1);
                provinceDO.setProvinceCode(p.getCode());
                provinceDO.setProvinceName(p.getName());
                provinceDOMapper.insert(provinceDO);
                for(City c:p.getCityList()){
                    CityDO cityDO = new CityDO();
                    cityDO.setTid(c.getCode());
                    cityDO.setCreateDate(date);
                    cityDO.setUpdateDate(date);
                    cityDO.setDelFlag("0");
                    cityDO.setCityName(c.getName());
                    cityDO.setProvinceId(p.getCode());
                    cityDO.setCityCode(c.getCode());
                    cityDOMapper.insert(cityDO);
                    for(Area a:c.getAreaList()){
                        AreaDO areaDO = new AreaDO();
                        areaDO.setDelFlag("0");
                        areaDO.setUpdateDate(date);
                        areaDO.setCreateDate(date);
                        areaDO.setAreaCode(a.getCode());
                        areaDO.setAreaName(a.getName());
                        areaDO.setCityId(c.getCode());
                        areaDO.setTid(a.getCode());
                        areaDOMapper.insert(areaDO);
                    }
                }
            }
            System.out.println(provinceList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return provinceList;
    }


    private static List<Province> processData(List<String> stringName, List<String> stringCode) {
        List<Province> provinceList = new ArrayList<Province>();
        for (int i = 0; i < stringCode.size(); i++) {
            String provinceName = stringName.get(i);
            String provinceCode = stringCode.get(i);
            if (provinceCode.endsWith("0000")) {
                Province province = new Province();
                provinceList.add(province);
                province.setCode(provinceCode);
                province.setName(provinceName);
                List<City> cities = new ArrayList<City>();
                province.setCityList(cities);
                //香港，澳门，台湾，没有市级行政单位划分，城市 地区 和省份保持一致
                if (provinceName.contains("香港") || provinceName.contains("澳门") || provinceName.contains("台湾")) {
                    City city = new City();
                    List<Area> areas = new ArrayList<Area>();
                    city.setName(provinceName);
                    city.setCode(provinceCode);
                    city.setAreaList(areas);
                    cities.add(city);
                    Area area = new Area();
                    area.setName(provinceName);
                    area.setCode(provinceCode);
                    areas.add(area);
                }
                //直辖市 城市和省份名称一样
                if (provinceName.contains("北京") || provinceName.contains("上海") || provinceName.contains("天津") || provinceName.contains("重庆")) {
                    City city = new City();
                    List<Area> areas = new ArrayList<Area>();
                    city.setName(provinceName);
                    city.setCode(provinceCode);
                    city.setAreaList(areas);
                    cities.add(city);
                    //县区
                    for (int k = 0; k < stringCode.size(); k++) {
                        String areaName = stringName.get(k);
                        String areaCode = stringCode.get(k);
                        if (!provinceCode.equals(areaCode) && areaCode.startsWith(provinceCode.substring(0, 2))) {
                            Area area = new Area();
                            area.setName(areaName);
                            area.setCode(areaCode);
                            areas.add(area);
                        }
                    }
                }
                for (int j = 0; j < stringCode.size(); j++) {
                    String cityName = stringName.get(j);
                    String cityCode = stringCode.get(j);
                    //遍历获取地级市
                    if (!cityCode.equals(provinceCode) && cityCode.startsWith(provinceCode.substring(0, 2)) && cityCode.endsWith("00")) {
                        City city = new City();
                        List<Area> areas = new ArrayList<Area>();
                        city.setName(cityName);
                        city.setCode(cityCode);
                        city.setAreaList(areas);
                        cities.add(city);
                        //遍历获取县区
                        for (int k = 0; k < stringCode.size(); k++) {
                            String areaName = stringName.get(k);
                            String areaCode = stringCode.get(k);
                            if (!areaCode.equals(cityCode) && areaCode.startsWith(cityCode.substring(0, 4))) {
                                Area area = new Area();
                                area.setName(areaName);
                                area.setCode(areaCode);
                                areas.add(area);
                            }
                        }
                    }
                }
            }
        }
        return provinceList;
    }
}