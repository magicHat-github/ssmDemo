package com.bosssoft.hr.train.chp5.ssm.service.impl;


import com.bosssoft.hr.train.chp5.ssm.annotation.LogService;
import com.bosssoft.hr.train.chp5.ssm.dao.DictionaryDao;
import com.bosssoft.hr.train.chp5.ssm.exception.DeleteBeanException;
import com.bosssoft.hr.train.chp5.ssm.exception.SaveBeanException;
import com.bosssoft.hr.train.chp5.ssm.exception.UpdateBeanException;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.Dictionary;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.User;
import com.bosssoft.hr.train.chp5.ssm.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 数据字典业务层的实现
 * @see DictionaryService
 * @author likang
 * @date 2019/7/24 14:27
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DictionaryDao dictionaryDao;

    @Override
    @LogService(value = "添加数据字典")
    @Transactional(rollbackFor = SaveBeanException.class)
    public Integer insertOne(Dictionary dictionary, User user) throws SaveBeanException {
        Integer rows = null;
        if (dictionary!=null && user!=null){
            Date now = new Date();
            dictionary.setCreatedBy(user.getUserId());
            dictionary.setCreatedTime(now);
            dictionary.setUpdatedBy(user.getUserId());
            dictionary.setUpdatedTime(now);
            dictionary.setVersion(0L);
            dictionary.setStatus(true);
            rows = dictionaryDao.insert(dictionary);
            if (rows == 0){
                throw new SaveBeanException();
            }
        }
        return rows;
    }

    @Override
    public Integer insertBatch(List<Dictionary> dictionaryList) {
        return null;
    }

    @Override
    @LogService(value = "修改数据字典")
    @Transactional(rollbackFor = UpdateBeanException.class)
    public Integer updateOne(Dictionary dictionary, User user) throws UpdateBeanException {
        Integer rows = null;
        if (dictionary!=null && user!=null){
            dictionary.setUpdatedBy(user.getUserId());
            dictionary.setUpdatedTime(new Date());
            rows = dictionaryDao.updateByPrimaryKeySelective(dictionary);
            if (rows==0){
                throw new UpdateBeanException();
            }
        }
        return rows;
    }

    @Override
    public Integer updateBatch(List<Dictionary> dictionaryList) {
        return null;
    }

    @Override
    @LogService(value = "根据ID查找数据字典")
    public Dictionary selectOneById(Long id) {
        Dictionary dictionary = null;
        if (id!=null){
            Dictionary selectDictionary = new Dictionary();
            selectDictionary.setCategoryId(id);
            dictionary = dictionaryDao.selectOne(selectDictionary);
        }
        return dictionary;
    }

    @Override
    @LogService(value = "查找数据字典集合")
    public List<Dictionary> selectList() {
        return dictionaryDao.selectAll();
    }

    @Override
    @LogService("根据参数分页查询数据字典")
    public List<Dictionary> selectListByPage(Dictionary dictionary, Integer size, Integer page) {
        List<Dictionary> dictionaryList = null;
        if (dictionary!=null) {
            Example example = new Example(Dictionary.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotEmpty(dictionary.getName())) {
                criteria.andLike("name", "%" + dictionary.getName() + "%");
            }
            if (StringUtils.isNotEmpty(dictionary.getCategory())) {
                criteria.andLike("category", "%" + dictionary.getCategory() + "%");
            }
            if (dictionary.getStatus() != null) {
                criteria.andEqualTo("status", dictionary.getStatus());
            }
            dictionaryList = dictionaryDao.selectByExample(example);
        }
        return dictionaryList;
    }

    @Override
    @LogService(value = "根据ID删除数据字典")
    @Transactional(rollbackFor = DeleteBeanException.class)
    public Integer deleteOneById(Long id, User user) throws DeleteBeanException {
        Integer rows = null;
        if (id!=null && user!=null){
            Dictionary dictionary = new Dictionary();
            dictionary.setCategoryId(id);
            dictionary = dictionaryDao.selectOne(dictionary);
            dictionary.setStatus(false);
            dictionary.setUpdatedBy(user.getUserId());
            dictionary.setUpdatedTime(new Date());
            rows = dictionaryDao.updateByPrimaryKeySelective(dictionary);
            if (rows == 0){
                throw new DeleteBeanException();
            }
        }
        return rows;
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return null;
    }
}
