package com.soft.moto.mapper;

import com.soft.moto.model.User;
import org.springframework.stereotype.Repository;

/**
 *  用户持久层
 * @author sucx
 */
@Repository
public interface UserMapper {
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
    int insert(User record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 查询
     * @param id
     * @return
     */
    User selectByPrimaryKey(String id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据用户账户查询
     * @param userCode
     * @return
     */
    User selectUserByUserCode(String userCode);
}