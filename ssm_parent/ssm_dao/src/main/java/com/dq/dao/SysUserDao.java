package com.dq.dao;

import com.dq.domain.SysUser;
import org.apache.ibatis.annotations.Select;

public interface SysUserDao {
    @Select("select * from sys_user where username=#{username}")
    SysUser getByUsername(String username);
}
