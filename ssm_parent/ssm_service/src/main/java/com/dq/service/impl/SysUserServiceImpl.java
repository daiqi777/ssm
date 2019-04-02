package com.dq.service.impl;

import com.dq.dao.SysUserDao;
import com.dq.domain.SysUser;
import com.dq.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser getByUsername(String username) {
        return sysUserDao.getByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       List<GrantedAuthority> authorities = new ArrayList<>();

       authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        SysUser sysuser = sysUserDao.getByUsername(username);

        User user =new User(username, "{noop}"+ sysuser.getPassword(), authorities);
        return user;
    }
}
