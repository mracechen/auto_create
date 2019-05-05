package com.jys.service.impl;

import com.jys.mapper.JysUserMapper;
import com.jys.model.JysUser;
import com.jys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JysUserMapper<JysUser> mapper;

    @Override
    public void setBaseMapper() {

    }

    @Override
    public int deleteByPrimaryKey(String s) {
        return 0;
    }

    @Override
    public int insert(JysUserMapper record) {
        return 0;
    }

    @Override
    public int insertSelective(JysUserMapper record) {
        return 0;
    }

    @Override
    public JysUserMapper selectByPrimaryKey(String s) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(JysUserMapper record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(JysUserMapper record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(JysUserMapper record) {
        return 0;
    }

    @Override
    public List<JysUser> getByPage() {
        return mapper.selectByPage();
    }
}