package com.jys.user.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* 列表实体类
* @author: chenjie
* @create: 2019/04/19
**/
@Data
public class JysUserResponseVO {

@ApiModelProperty(value = "用户id")
private String userId;

@ApiModelProperty(value = "用户名")
private String userName;

@ApiModelProperty(value = "登录密码")
private String loginPassword;

@ApiModelProperty(value = "交易密码")
private String tranPassword;

@ApiModelProperty(value = "平台唯一标识码")
private String uid;

@ApiModelProperty(value = "国家")
private String countryId;

@ApiModelProperty(value = "手机号")
private String userMobile;

@ApiModelProperty(value = "校验开关")
private Integer checkFlag;

@ApiModelProperty(value = "最后一次登录ip")
private String lastIp;

@ApiModelProperty(value = "头像")
private String headIcon;

@ApiModelProperty(value = "信用")
private Integer credit;

@ApiModelProperty(value = "email")
private String email;

@ApiModelProperty(value = "谷歌账号")
private String google;

@ApiModelProperty(value = "邀请码")
private String invitationCode;

@ApiModelProperty(value = "创建时间")
private Date createDate;

@ApiModelProperty(value = "更新时间")
private Date updateDate;

@ApiModelProperty(value = "是否逻辑删除，1-是 0-否")
private Integer deleted;

@ApiModelProperty(value = "备注")
private String remark;
}
