package com.soft.moto.config.security;

import com.soft.moto.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sucx
 * @projectName moto
 * @description: 登陆服务
 * @date 2020/4/2116:16
 */
@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    /**
     * 加载用户数据 , 返回UserDetail 实例
     * @param userCode  用户登录userCode
     * @return  返回User实体类 做用户校验
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
        //根据用户名-查询用户信息
        com.soft.moto.model.User systemUser = userMapper.selectUserByUserCode(userCode);
        if (null == systemUser){
            throw new UsernameNotFoundException("用户不存在...");
        }
        //获取用户权限
        String[] authorities = new String[0];
        if (!CollectionUtils.isEmpty(systemUser.getAuthorities())){
            final List<String> collect = systemUser.getAuthorities().stream().map(item -> item.getCode()).collect(Collectors.toList());
            authorities = new String[collect.size()];
            collect.toArray(authorities);
        }
        //根据用户查询权限
        return new User(userCode,passwordEncoder.encode(systemUser.getPassword()),
                true,true,true,true,
                AuthorityUtils.createAuthorityList(authorities));

    }
}
