package com.soft.moto.service.impl;

import com.soft.moto.mapper.RoleMapper;
import com.soft.moto.model.Role;
import com.soft.moto.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sucx
 * @projectName moto
 * @description:
 * @date 2020/4/2216:26
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "role")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    @Cacheable
    public List<Role> selectRoleList(Role role) {
        return roleMapper.selectRoleList(role);
    }

    @Override
    @Cacheable(keyGenerator = "keyGenerator")
    public Map<Role, Role> selectRoleMap(Role role) {
        final List<Role> roles = roleMapper.selectRoleList(role);
        Map<Role,Role> result = new HashMap<>(0);
        roles.forEach(item -> result.put(item,item));
        return result;
    }
}
