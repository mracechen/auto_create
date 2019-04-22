package com.jys.user.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "jys_user")
public class JysUser {
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 登录密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 交易密码
     */
    @Column(name = "tran_password")
    private String tranPassword;

    /**
     * 平台唯一标识码
     */
    private String uid;

    /**
     * 国家
     */
    @Column(name = "country_id")
    private String countryId;

    /**
     * 手机号
     */
    @Column(name = "user_mobile")
    private String userMobile;

    /**
     * 校验开关
     */
    @Column(name = "check_flag")
    private Integer checkFlag;

    /**
     * 最后一次登录ip
     */
    @Column(name = "last_ip")
    private String lastIp;

    /**
     * 头像
     */
    @Column(name = "head_icon")
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
    @Column(name = "invitation_code")
    private String invitationCode;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取登录密码
     *
     * @return login_password - 登录密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置登录密码
     *
     * @param loginPassword 登录密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * 获取交易密码
     *
     * @return tran_password - 交易密码
     */
    public String getTranPassword() {
        return tranPassword;
    }

    /**
     * 设置交易密码
     *
     * @param tranPassword 交易密码
     */
    public void setTranPassword(String tranPassword) {
        this.tranPassword = tranPassword;
    }

    /**
     * 获取平台唯一标识码
     *
     * @return uid - 平台唯一标识码
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置平台唯一标识码
     *
     * @param uid 平台唯一标识码
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取国家
     *
     * @return country_id - 国家
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * 设置国家
     *
     * @param countryId 国家
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * 获取手机号
     *
     * @return user_mobile - 手机号
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 设置手机号
     *
     * @param userMobile 手机号
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * 获取校验开关
     *
     * @return check_flag - 校验开关
     */
    public Integer getCheckFlag() {
        return checkFlag;
    }

    /**
     * 设置校验开关
     *
     * @param checkFlag 校验开关
     */
    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    /**
     * 获取最后一次登录ip
     *
     * @return last_ip - 最后一次登录ip
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 设置最后一次登录ip
     *
     * @param lastIp 最后一次登录ip
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * 获取头像
     *
     * @return head_icon - 头像
     */
    public String getHeadIcon() {
        return headIcon;
    }

    /**
     * 设置头像
     *
     * @param headIcon 头像
     */
    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    /**
     * 获取信用
     *
     * @return credit - 信用
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * 设置信用
     *
     * @param credit 信用
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    /**
     * 获取email
     *
     * @return email - email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取谷歌账号
     *
     * @return google - 谷歌账号
     */
    public String getGoogle() {
        return google;
    }

    /**
     * 设置谷歌账号
     *
     * @param google 谷歌账号
     */
    public void setGoogle(String google) {
        this.google = google;
    }

    /**
     * 获取邀请码
     *
     * @return invitation_code - 邀请码
     */
    public String getInvitationCode() {
        return invitationCode;
    }

    /**
     * 设置邀请码
     *
     * @param invitationCode 邀请码
     */
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取是否逻辑删除，1-是 0-否
     *
     * @return deleted - 是否逻辑删除，1-是 0-否
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否逻辑删除，1-是 0-否
     *
     * @param deleted 是否逻辑删除，1-是 0-否
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}