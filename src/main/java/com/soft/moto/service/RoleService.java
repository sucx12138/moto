package com.soft.moto.service;

import com.soft.moto.model.Role;

import java.util.List;
import java.util.Map;

/**
 * @author sucx
 * @projectName moto
 * @description:
 * @date 2020/4/2216:26
 */

public interface RoleService {
    /**
     * 查询角色树
     * @param role
     * @return
     */
    List<Role> selectRoleList(Role role);

    Map<Role, Role> selectRoleMap(Role role);
}
