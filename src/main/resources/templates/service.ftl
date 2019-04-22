package ${basePackage}.service;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.vo.entity.${modelNameUpperCamel}EntityVO;
import ${basePackage}.vo.request.${modelNameUpperCamel}RequestVO;
import ${basePackage}.vo.response.${modelNameUpperCamel}ResponseVO;

import java.util.List;

/**
* @author: ${author}
* @create: ${date}
**/
public interface ${modelNameUpperCamel}Service extends Service<${modelNameUpperCamel}> {

/**
* 获取分页列表
* @param ${modelNameLowerCamel}RequestVO
* @return
*/
List<${modelNameUpperCamel}ResponseVO> query${modelNameUpperCamel}PageList(${modelNameUpperCamel}RequestVO ${modelNameLowerCamel}RequestVO);

    /**
    * 获取总条数
    * @param ${modelNameLowerCamel}RequestVO
    * @return
    */
    Integer query${modelNameUpperCamel}Count(${modelNameUpperCamel}RequestVO ${modelNameLowerCamel}RequestVO);

    /**
    * 获取详细信息
    * @param id
    * @return
    */
    ${modelNameUpperCamel}EntityVO get${modelNameUpperCamel}EntityVO(String id);

    /**
    * 新增
    * @param ${modelNameLowerCamel}EntityVO 系统用户实体数据
    */
    void add${modelNameUpperCamel}(${modelNameUpperCamel}EntityVO ${modelNameLowerCamel}EntityVO);

    /**
    * 修改
    * @param ${modelNameLowerCamel}EntityVO 系统用户实体数据
    */
    void update${modelNameUpperCamel}(${modelNameUpperCamel}EntityVO ${modelNameLowerCamel}EntityVO);

    /**
    * 删除
    * @param id
    */
    void delete${modelNameUpperCamel}(String id);
}
