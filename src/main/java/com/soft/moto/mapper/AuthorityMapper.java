package com.soft.moto.mapper;

import com.soft.moto.model.Authority;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * 权限持久层
 * @author sucx
 */
@Repository
public interface AuthorityMapper {
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
    int insert(Authority record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(Authority record);

    /**
     * 查询
     * @param id
     * @return
     */
    Authority selectByPrimaryKey(String id);

    /**
     * 根据用户查询权限
     * @param userId
     * @return
     */
    Set<Authority> selectAuthorityByUser(String userId);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Authority record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Authority record);
}