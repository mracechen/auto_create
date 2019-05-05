package com.jys.service;

import com.common.Service;
import com.jys.mapper.JysUserMapper;
import com.jys.model.JysUser;

import java.util.List;

public interface UserService extends Service<JysUserMapper,String>{
    public List<JysUser> getByPage();
}