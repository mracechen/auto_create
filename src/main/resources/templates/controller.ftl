package ${basePackage}.controller;


import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.vo.entity.${modelNameUpperCamel}EntityVO;
import ${basePackage}.vo.request.${modelNameUpperCamel}RequestVO;
import ${basePackage}.vo.response.${modelNameUpperCamel}ResponseVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @author: ${author}
* @create: ${date}
**/
@Slf4j
@RestController
@RequestMapping(value = "${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

@Autowired
private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

@RequestMapping(value = "/listPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ApiOperation("获取列表")
@MyOperationLog
public ResponseEntity<Result<PageResult<${modelNameUpperCamel}ResponseVO>>> get${modelLastName}PageList(${modelNameUpperCamel}RequestVO ${modelNameLowerCamel}RequestVO) {
    List<${modelNameUpperCamel}ResponseVO> ${modelNameLowerCamel}ResponseVOList = this.${modelNameLowerCamel}Service.query${modelNameUpperCamel}PageList(${modelNameLowerCamel}RequestVO);
        Integer number = this.${modelNameLowerCamel}Service.query${modelNameUpperCamel}Count(${modelNameLowerCamel}RequestVO);
        PageResult<${modelNameUpperCamel}ResponseVO> pageResult = new PageResult<${modelNameUpperCamel}ResponseVO>();
        pageResult.setDataList(${modelNameLowerCamel}ResponseVOList);
        pageResult.setTotal(number);
        return new ResponseEntity<>(Result.ok(pageResult), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("获取信息")
    @MyOperationLog
    @Authorization(permission="${modelName}:${tableLastName}:view")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<${modelNameUpperCamel}EntityVO>> get${modelLastName}(@RequestParam String id) {
    ${modelNameUpperCamel}EntityVO ${modelNameLowerCamel}EntityVO = this.${modelNameLowerCamel}Service.get${modelNameUpperCamel}EntityVO(id);
        return new ResponseEntity<>(Result.ok(${modelNameLowerCamel}EntityVO), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("新增")
    @MyOperationLog
    @Authorization(permission="${modelName}:${tableLastName}:add")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<Object>> add${modelLastName}(@RequestBody @Validated ${modelNameUpperCamel}EntityVO ${modelNameLowerCamel}EntityVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.getErrorMessage(bindingResult);
        }
        this.${modelNameLowerCamel}Service.add${modelNameUpperCamel}(${modelNameLowerCamel}EntityVO);
        return new ResponseEntity<>(Result.ok(null), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("更新")
    @MyOperationLog
    @Authorization(permission="${modelName}:${tableLastName}:update")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<Object>> update${modelLastName}(@RequestBody @Validated ${modelNameUpperCamel}EntityVO ${modelNameLowerCamel}EntityVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.getErrorMessage(bindingResult);
        }
        this.${modelNameLowerCamel}Service.update${modelNameUpperCamel}(${modelNameLowerCamel}EntityVO);
        return new ResponseEntity<>(Result.ok(null), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("删除")
    @MyOperationLog
    @Authorization(permission="${modelName}:${tableLastName}:delete")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<Object>> delete${modelLastName}(@RequestParam String id) {
        this.${modelNameLowerCamel}Service.delete${modelNameUpperCamel}(id);
        return new ResponseEntity<>(Result.ok(null), HttpStatus.OK);
    }

    public ResponseEntity<Result<Object>> getErrorMessage(BindingResult bindingResult){
        String errorMessage = "";
        for (ObjectError objectError : bindingResult.getAllErrors()) {
            errorMessage += objectError.getDefaultMessage();
        }
        return new ResponseEntity<>(Result.error(ResultCode.FAIL, errorMessage), HttpStatus.OK);
    }

}
