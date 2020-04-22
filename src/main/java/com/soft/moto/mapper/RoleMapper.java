package com.soft.moto.mapper;

import com.soft.moto.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author sucx
 */
@Repository
public interface RoleMapper {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Role record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(Role record);

    /**
     * 查询
     * @param id
     * @return
     */
    Role selectByPrimaryKey(String id);

    /**
     * 根据用户查询角色
     * @param userId
     * @return
     */
    Set<Role> selectRoleByUser(String userId);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Role record);
}