package com.bosssoft.hr.train.chp5.ssm.service;

import com.bosssoft.hr.train.chp5.ssm.dao.DictionaryDao;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.Dictionary;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author likang
 * @date 2019/7/25 15:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryServiceTest {

    @Resource
    private DictionaryService dictionaryService;
    private Long testId = 0L;

    @Before
    public void setTestId(){
        testId = 15L;
    }

    @Test
    public void insertOne() throws Exception {
        Dictionary dictionary = new Dictionary();
        dictionary.setName("123123");
        dictionary.setCategory("type");
        dictionary.setValue("test");
        dictionary.setOrgId(1L);
        dictionary.setRemark("注释，备注");
        User user = new User();
        user.setUserId(1L);
        Integer rows = dictionaryService.insertOne(null,null);
        assertNull(rows);
        rows = dictionaryService.insertOne(dictionary,user);
        assertEquals("1", String.valueOf(rows));
    }

    @Test
    public void updateOne() {
        Dictionary dictionary = new Dictionary();
        dictionary.setCategoryId(testId);
        dictionary.setName("测试test ...");
        dictionary.setCategory("types");
        dictionary.setValue("test123");
        dictionary.setOrgId(1L);
        dictionary.setRemark("注释，备注...");
        User user = new User();
        user.setUserId(2L);
        Integer rows = dictionaryService.updateOne(null,null);
        assertNull(rows);
        rows = dictionaryService.updateOne(dictionary,user);
        assertEquals(String.valueOf(rows),"1");
    }

    @Test
    public void selectOneById() {
        Dictionary dictionary = dictionaryService.selectOneById(testId);
        assertEquals(dictionary.getName(),"测试test ...");
    }

    @Test
    public void selectList() {
        List<Dictionary> dictionaryList = dictionaryService.selectList();
        assertNotNull(dictionaryList);
        assertEquals(10, dictionaryList.size());
    }

    @Test
    public void deleteOneById() {
        User user = new User();
        user.setUserId(2L);
        Integer rows = dictionaryService.deleteOneById(testId,user);
        assertEquals("1",String.valueOf(rows));
    }
}