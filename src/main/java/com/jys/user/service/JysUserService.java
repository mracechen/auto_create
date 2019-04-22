package com.jys.user.service;
import com.jys.user.model.JysUser;
import com.jys.user.vo.entity.JysUserEntityVO;
import com.jys.user.vo.request.JysUserRequestVO;
import com.jys.user.vo.response.JysUserResponseVO;

import java.util.List;

/**
* @author: chenjie
* @create: 2019/04/19
**/
public interface JysUserService extends Service<JysUser> {

/**
* 获取分页列表
* @param jysUserRequestVO
* @return
*/
List<JysUserResponseVO> queryJysUserPageList(JysUserRequestVO jysUserRequestVO);

    /**
    * 获取总条数
    * @param jysUserRequestVO
    * @return
    */
    Integer queryJysUserCount(JysUserRequestVO jysUserRequestVO);

    /**
    * 获取详细信息
    * @param id
    * @return
    */
    JysUserEntityVO getJysUserEntityVO(String id);

    /**
    * 新增
    * @param jysUserEntityVO 系统用户实体数据
    */
    void addJysUser(JysUserEntityVO jysUserEntityVO);

    /**
    * 修改
    * @param jysUserEntityVO 系统用户实体数据
    */
    void updateJysUser(JysUserEntityVO jysUserEntityVO);

    /**
    * 删除
    * @param id
    */
    void deleteJysUser(String id);
}
