package com.bosssoft.hr.train.chp5.ssm.service;


import com.bosssoft.hr.train.chp5.ssm.exception.DeleteBeanException;
import com.bosssoft.hr.train.chp5.ssm.exception.SaveBeanException;
import com.bosssoft.hr.train.chp5.ssm.exception.UpdateBeanException;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.Dictionary;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 数据字典业务层接口
 * @author likang
 * @date 2019/7/24 14:15
 */
public interface DictionaryService {

    /**
     * 插入一个数据字典值
     * @param dictionary 数据字典
     * @return 影响的行数
     * @throws SaveBeanException 保存失败异常
     */
    Integer insertOne(Dictionary dictionary) throws SaveBeanException;

    /**
     * 批量插入数据字典值
     * @param dictionaryList 数据字典列表
     * @return 影响的行数
     */
    Integer insertBatch(List<Dictionary> dictionaryList);

    /**
     * 更新数据字典值
     * @param dictionary 数据字典
     * @return 影响的行数
     * @throws UpdateBeanException 更新异常
     */
    Integer updateOne(Dictionary dictionary) throws UpdateBeanException;

    /**
     * 批量更新数据字典值
     * @param dictionaryList 数据字典列表
     * @return 影响的行数
     */
    Integer updateBatch(List<Dictionary> dictionaryList);

    /**
     * 根据编号查询数据字典
     * @param id 数据字典编号
     * @return 数据字典
     */
    Dictionary selectOneById(Long id);

    /**
     * 查询全部的数据字典值
     * @return 数据字典列表
     */
    List<Dictionary> selectList();

    /**
     * 根据参数分页查询数据字典
     * @param dictionary 数据字典的参数列表
     * @param size 查询页面的数据大小
     * @param page 目标查询的页面
     * @return 数据字典集合
     */
    PageInfo<Dictionary> selectListByPage(Dictionary dictionary, Integer size, Integer page);

    /**
     *
     * 根据编号删除数据字典值,删除只是修改数据字典的状态值为禁用
     * @param id 编号
     * @return 影响行数
     * @throws DeleteBeanException 删除异常
     */
    Integer deleteOneById(Long id) throws DeleteBeanException;

    /**
     * 批量删除数据字典值,删除只是修改数据字典的状态值为禁用
     * @param ids 编号集合
     * @return 影响的行数
     */
    Integer deleteBatch(List<Long> ids);
}
