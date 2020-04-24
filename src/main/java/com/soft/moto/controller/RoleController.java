package com.soft.moto.controller;

import com.soft.moto.common.model.ResponseModel;
import com.soft.moto.model.Role;
import com.soft.moto.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author sucx
 * @projectName moto
 * @description:
 * @date 2020/4/2216:02
 */
@RestController
@RequestMapping("/system")
public class RoleController {


    @Autowired
    private RoleService roleService;
    @GetMapping("/roleList")
    @PreAuthorize("hasAuthority('code_10')")
    public ResponseModel selectRoleList(Role role){
        final List<Role> roles = roleService.selectRoleList(role);
        return ResponseModel.ok(roles);
    }

    @GetMapping("/roleMap")
    @PreAuthorize("hasAuthority('code_1')")
    public ResponseModel selectRoleMap(Role role){
        final Map<Role,Role> roles = roleService.selectRoleMap(role);
        return ResponseModel.ok(roles);
    }
}
