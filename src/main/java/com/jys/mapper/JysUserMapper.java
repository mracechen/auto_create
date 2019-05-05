package com.jys.mapper;

import com.common.BaseMapper;
import com.jys.model.JysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JysUserMapper<JysUser> extends BaseMapper<JysUser,String>{
    /**
     *
     * @mbg.generated
     */
    int insert(JysUser record);

    List<JysUser> selectByPage();

    /**
     *
     * @mbg.generated
     */
    List<JysUser> selectAll();
}