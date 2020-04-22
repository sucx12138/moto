package com.soft.moto.mapper;

import com.soft.moto.model.Menu;
import org.springframework.stereotype.Repository;

/**
 * 菜单持久层
 * @author sucx
 */
@Repository
public interface MenuMapper {
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
    int insert(Menu record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(Menu record);

    /**
     * 查询
     * @param id
     * @return
     */
    Menu selectByPrimaryKey(String id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *  更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Menu record);
}