package com.jys.user.controller;


import com.jys.user.service.JysUserService;
import com.jys.user.vo.entity.JysUserEntityVO;
import com.jys.user.vo.request.JysUserRequestVO;
import com.jys.user.vo.response.JysUserResponseVO;

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
* @author: chenjie
* @create: 2019/04/19
**/
@Slf4j
@RestController
@RequestMapping(value = "/jys/user")
public class JysUserController {

@Autowired
private JysUserService jysUserService;

@RequestMapping(value = "/listPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ApiOperation("获取列表")
@MyOperationLog
public ResponseEntity<Result<PageResult<JysUserResponseVO>>> getUserPageList(JysUserRequestVO jysUserRequestVO) {
    List<JysUserResponseVO> jysUserResponseVOList = this.jysUserService.queryJysUserPageList(jysUserRequestVO);
        Integer number = this.jysUserService.queryJysUserCount(jysUserRequestVO);
        PageResult<JysUserResponseVO> pageResult = new PageResult<JysUserResponseVO>();
        pageResult.setDataList(jysUserResponseVOList);
        pageResult.setTotal(number);
        return new ResponseEntity<>(Result.ok(pageResult), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("获取信息")
    @MyOperationLog
    @Authorization(permission=":user:view")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<JysUserEntityVO>> getUser(@RequestParam String id) {
    JysUserEntityVO jysUserEntityVO = this.jysUserService.getJysUserEntityVO(id);
        return new ResponseEntity<>(Result.ok(jysUserEntityVO), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("新增")
    @MyOperationLog
    @Authorization(permission=":user:add")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<Object>> addUser(@RequestBody @Validated JysUserEntityVO jysUserEntityVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.getErrorMessage(bindingResult);
        }
        this.jysUserService.addJysUser(jysUserEntityVO);
        return new ResponseEntity<>(Result.ok(null), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("更新")
    @MyOperationLog
    @Authorization(permission=":user:update")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<Object>> updateUser(@RequestBody @Validated JysUserEntityVO jysUserEntityVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.getErrorMessage(bindingResult);
        }
        this.jysUserService.updateJysUser(jysUserEntityVO);
        return new ResponseEntity<>(Result.ok(null), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("删除")
    @MyOperationLog
    @Authorization(permission=":user:delete")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<Object>> deleteUser(@RequestParam String id) {
        this.jysUserService.deleteJysUser(id);
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
