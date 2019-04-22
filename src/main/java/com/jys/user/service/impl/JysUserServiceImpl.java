package com.jys.user.service.impl;

import com.jys.user.dao.JysUserMapper;
import com.jys.user.model.JysUser;
import com.jys.user.service.JysUserService;
import com.jys.user.vo.entity.JysUserEntityVO;
import com.jys.user.vo.request.JysUserRequestVO;
import com.jys.user.vo.response.JysUserResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
* @author: chenjie
* @create: 2019/04/19
**/
@Service
@Transactional
public class JysUserServiceImpl extends AbstractService<JysUser> implements JysUserService {

@Autowired
private JysUserMapper jysUserMapper;

/**
* 获取分页列表
* @param jysUserRequestVO
* @return
*/
@Override
public List<JysUserResponseVO> queryJysUserPageList(JysUserRequestVO jysUserRequestVO) {
    List<JysUserResponseVO> jysUserResponseVOList = new LinkedList<>();
    Condition condition = new Condition(JysUser.class);
    condition.createCriteria();
    /*根据实际情况添加
    if (!(StringUtils.isEmpty(jysUserRequestVO.getLoginName()))) {
        condition.getOredCriteria().get(0).andLike("loginName", "%" + jysUserRequestVO.getLoginName() + "%");
    }
    if (!(StringUtils.isEmpty(jysUserRequestVO.getLoginName()))) {
        ondition.createCriteria().andEqualTo("userId", jysUserRequestVO.getUserId());
    }
    */
    List<JysUser> jysUserList = this.selectByCondition(condition);
    if (jysUserList != null && jysUserList.size() > 0) {
        for (JysUser jysUser : jysUserList) {
            JysUserResponseVO jysUserListResponseVO = new JysUserResponseVO();
            BeanUtils.copyProperties(jysUser,jysUserListResponseVO);
            jysUserResponseVOList.add(jysUserListResponseVO);
        }
    }
    return jysUserResponseVOList;
}

/**
* 获取总条数
* @param jysUserRequestVO
* @return
*/
@Override
public Integer queryJysUserCount(JysUserRequestVO jysUserRequestVO) {
    Condition condition = new Condition(JysUser.class);
    condition.createCriteria();
    /*根据实际情况添加
    if (!(StringUtils.isEmpty(jysUserRequestVO.getLoginName()))) {
        condition.getOredCriteria().get(0).andLike("loginName", "%" + jysUserRequestVO.getLoginName() + "%");
    }
    if (!(StringUtils.isEmpty(jysUserRequestVO.getLoginName()))) {
        condition.createCriteria().andEqualTo("userId", jysUserRequestVO.getUserId());
    }
    */
    return this.selectCountByCondition(condition);
}

/**
* 添加
* @param jysUserEntityVO
*/
@Override
public void addJysUser(JysUserEntityVO jysUserEntityVO) {
    JysUser jysUser = new JysUser();
    BeanUtils.copyProperties(jysUserEntityVO, jysUser);
    this.insertSelective(jysUser);
}

/**
* 修改
* @param jysUserEntityVO
*/
@Override
public void updateJysUser(JysUserEntityVO jysUserEntityVO) {
    JysUser jysUser = this.selectByPrimaryKey(jysUserEntityVO.getId());
    BeanUtils.copyProperties(jysUserEntityVO, jysUser);
    this.updateByPrimaryKeySelective(jysUser);
}

/**
* 删除
* @param id
*/
@Override
public void deleteJysUser(String id) {
    JysUser jysUser = new JysUser();
    jysUser.setId(id);
    jysUser.setStateFlag(CommonEnum.StateFlagEnum.STATE_FLAG_DELETE.getCode());
    this.updateByPrimaryKeySelective(jysUser);
}

/**
* 获取详细信息
* @param id
* @return
*/
@Override
public JysUserEntityVO getJysUserEntityVO(String id) {
    JysUser jysUser = new JysUser();
    jysUser.setId(id);
    jysUser = this.selectOne(jysUser);
    if(null == jysUser){
        return null;
    }
    JysUserEntityVO jysUserEntityVO = new JysUserEntityVO();
        BeanUtils.copyProperties(jysUser,jysUserEntityVO);
        return jysUserEntityVO;
    }
}
