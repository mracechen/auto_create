package com.jys.model;

import lombok.Data;

import java.util.Date;

@Data
public class JysUser {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String loginPassword;

    /**
     * 交易密码
     */
    private String tranPassword;

    /**
     * 平台唯一标识码
     */
    private String uid;

    /**
     * 国家
     */
    private String countryId;

    /**
     * 手机号
     */
    private String userMobile;

    /**
     * 校验开关
     */
    private Integer checkFlag;

    /**
     * 最后一次登录ip
     */
    private String lastIp;

    /**
     * 头像
     */
    private String headIcon;

    /**
     * 信用
     */
    private Integer credit;

    /**
     * email
     */
    private String email;

    /**
     * 谷歌账号
     */
    private String google;

    /**
     * 邀请码
     */
    private String invitationCode;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 是否逻辑删除，1-是 0-否
     */
    private Integer deleted;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户id
     * @return user_id 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 用户名
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 登录密码
     * @return login_password 登录密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 登录密码
     * @param loginPassword 登录密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /**
     * 交易密码
     * @return tran_password 交易密码
     */
    public String getTranPassword() {
        return tranPassword;
    }

    /**
     * 交易密码
     * @param tranPassword 交易密码
     */
    public void setTranPassword(String tranPassword) {
        this.tranPassword = tranPassword == null ? null : tranPassword.trim();
    }

    /**
     * 平台唯一标识码
     * @return uid 平台唯一标识码
     */
    public String getUid() {
        return uid;
    }

    /**
     * 平台唯一标识码
     * @param uid 平台唯一标识码
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * 国家
     * @return country_id 国家
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * 国家
     * @param countryId 国家
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId == null ? null : countryId.trim();
    }

    /**
     * 手机号
     * @return user_mobile 手机号
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 手机号
     * @param userMobile 手机号
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     * 校验开关
     * @return check_flag 校验开关
     */
    public Integer getCheckFlag() {
        return checkFlag;
    }

    /**
     * 校验开关
     * @param checkFlag 校验开关
     */
    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    /**
     * 最后一次登录ip
     * @return last_ip 最后一次登录ip
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 最后一次登录ip
     * @param lastIp 最后一次登录ip
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    /**
     * 头像
     * @return head_icon 头像
     */
    public String getHeadIcon() {
        return headIcon;
    }

    /**
     * 头像
     * @param headIcon 头像
     */
    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon == null ? null : headIcon.trim();
    }

    /**
     * 信用
     * @return credit 信用
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * 信用
     * @param credit 信用
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    /**
     * email
     * @return email email
     */
    public String getEmail() {
        return email;
    }

    /**
     * email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 谷歌账号
     * @return google 谷歌账号
     */
    public String getGoogle() {
        return google;
    }

    /**
     * 谷歌账号
     * @param google 谷歌账号
     */
    public void setGoogle(String google) {
        this.google = google == null ? null : google.trim();
    }

    /**
     * 邀请码
     * @return invitation_code 邀请码
     */
    public String getInvitationCode() {
        return invitationCode;
    }

    /**
     * 邀请码
     * @param invitationCode 邀请码
     */
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 更新时间
     * @return update_date 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 是否逻辑删除，1-是 0-否
     * @return deleted 是否逻辑删除，1-是 0-否
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 是否逻辑删除，1-是 0-否
     * @param deleted 是否逻辑删除，1-是 0-否
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}