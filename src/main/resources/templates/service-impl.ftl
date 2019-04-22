package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.vo.entity.${modelNameUpperCamel}EntityVO;
import ${basePackage}.vo.request.${modelNameUpperCamel}RequestVO;
import ${basePackage}.vo.response.${modelNameUpperCamel}ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
* @author: ${author}
* @create: ${date}
**/
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

@Autowired
private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

/**
* 获取分页列表
* @param ${modelNameLowerCamel}RequestVO
* @return
*/
@Override
public List<${modelNameUpperCamel}ResponseVO> query${modelNameUpperCamel}PageList(${modelNameUpperCamel}RequestVO ${modelNameLowerCamel}RequestVO) {
    List<${modelNameUpperCamel}ResponseVO> ${modelNameLowerCamel}ResponseVOList = new LinkedList<>();
    Condition condition = new Condition(${modelNameUpperCamel}.class);
    condition.createCriteria();
    /*根据实际情况添加
    if (!(StringUtils.isEmpty(${modelNameLowerCamel}RequestVO.getLoginName()))) {
        condition.getOredCriteria().get(0).andLike("loginName", "%" + ${modelNameLowerCamel}RequestVO.getLoginName() + "%");
    }
    if (!(StringUtils.isEmpty(${modelNameLowerCamel}RequestVO.getLoginName()))) {
        ondition.createCriteria().andEqualTo("userId", ${modelNameLowerCamel}RequestVO.getUserId());
    }
    */
    List<${modelNameUpperCamel}> ${modelNameLowerCamel}List = this.selectByCondition(condition);
    if (${modelNameLowerCamel}List != null && ${modelNameLowerCamel}List.size() > 0) {
        for (${modelNameUpperCamel} ${modelNameLowerCamel} : ${modelNameLowerCamel}List) {
            ${modelNameUpperCamel}ResponseVO ${modelNameLowerCamel}ListResponseVO = new ${modelNameUpperCamel}ResponseVO();
            BeanUtils.copyProperties(${modelNameLowerCamel},${modelNameLowerCamel}ListResponseVO);
            ${modelNameLowerCamel}ResponseVOList.add(${modelNameLowerCamel}ListResponseVO);
        }
    }
    return ${modelNameLowerCamel}ResponseVOList;
}

/**
* 获取总条数
* @param ${modelNameLowerCamel}RequestVO
* @return
*/
@Override
public Integer query${modelNameUpperCamel}Count(${modelNameUpperCamel}RequestVO ${modelNameLowerCamel}RequestVO) {
    Condition condition = new Condition(${modelNameUpperCamel}.class);
    condition.createCriteria();
    /*根据实际情况添加
    if (!(StringUtils.isEmpty(${modelNameLowerCamel}RequestVO.getLoginName()))) {
        condition.getOredCriteria().get(0).andLike("loginName", "%" + ${modelNameLowerCamel}RequestVO.getLoginName() + "%");
    }
    if (!(StringUtils.isEmpty(${modelNameLowerCamel}RequestVO.getLoginName()))) {
        condition.createCriteria().andEqualTo("userId", ${modelNameLowerCamel}RequestVO.getUserId());
    }
    */
    return this.selectCountByCondition(condition);
}

/**
* 添加
* @param ${modelNameLowerCamel}EntityVO
*/
@Override
public void add${modelNameUpperCamel}(${modelNameUpperCamel}EntityVO ${modelNameLowerCamel}EntityVO) {
    ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
    BeanUtils.copyProperties(${modelNameLowerCamel}EntityVO, ${modelNameLowerCamel});
    this.insertSelective(${modelNameLowerCamel});
}

/**
* 修改
* @param ${modelNameLowerCamel}EntityVO
*/
@Override
public void update${modelNameUpperCamel}(${modelNameUpperCamel}EntityVO ${modelNameLowerCamel}EntityVO) {
    ${modelNameUpperCamel} ${modelNameLowerCamel} = this.selectByPrimaryKey(${modelNameLowerCamel}EntityVO.getId());
    BeanUtils.copyProperties(${modelNameLowerCamel}EntityVO, ${modelNameLowerCamel});
    this.updateByPrimaryKeySelective(${modelNameLowerCamel});
}

/**
* 删除
* @param id
*/
@Override
public void delete${modelNameUpperCamel}(String id) {
    ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
    ${modelNameLowerCamel}.setId(id);
    ${modelNameLowerCamel}.setStateFlag(CommonEnum.StateFlagEnum.STATE_FLAG_DELETE.getCode());
    this.updateByPrimaryKeySelective(${modelNameLowerCamel});
}

/**
* 获取详细信息
* @param id
* @return
*/
@Override
public ${modelNameUpperCamel}EntityVO get${modelNameUpperCamel}EntityVO(String id) {
    ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
    ${modelNameLowerCamel}.setId(id);
    ${modelNameLowerCamel} = this.selectOne(${modelNameLowerCamel});
    if(null == ${modelNameLowerCamel}){
        return null;
    }
    ${modelNameUpperCamel}EntityVO ${modelNameLowerCamel}EntityVO = new ${modelNameUpperCamel}EntityVO();
        BeanUtils.copyProperties(${modelNameLowerCamel},${modelNameLowerCamel}EntityVO);
        return ${modelNameLowerCamel}EntityVO;
    }
}
