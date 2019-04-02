package com.dq.service;

import com.dq.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SysUserService extends UserDetailsService {
    SysUser getByUsername(String username);
}
