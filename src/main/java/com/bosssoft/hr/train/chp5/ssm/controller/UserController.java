package com.bosssoft.hr.train.chp5.ssm.controller;

import com.bosssoft.hr.train.chp5.ssm.annotation.LogController;
import com.bosssoft.hr.train.chp5.ssm.exception.*;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.Dictionary;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.User;
import com.bosssoft.hr.train.chp5.ssm.pojo.vo.AjaxResult;
import com.bosssoft.hr.train.chp5.ssm.service.DictionaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据字典的控制层
 * @author likang
 * @date 2019/7/25 14:58
 */
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 模拟登录
     * @param session 请求会话，用于保存登录信息
     * @return 数据的处理信息
     */
    @PostMapping("login")
    public AjaxResult login(HttpSession session){
        AjaxResult ajaxResult;
        try{
            User user = new User();
            user.setUserId(3L);
            session.setAttribute("user",user);
            Map<String,String> map = new HashMap<>();
            map.put("code","20000");
            map.put("data","admin-token");
            ajaxResult = AjaxResult.success("登录成功",map);
        }catch (Exception e){
            ajaxResult = AjaxResult.error(e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 获取用户信息
     * @param session 请求会话，用于保存登录信息
     * @return 数据的处理信息
     */
    @GetMapping("info")
    public AjaxResult getInfo(HttpSession session){
        AjaxResult ajaxResult;
        try{
            Map<String,String> map = new HashMap<>();
            map.put("code","20000");
            map.put("data","info");
            ajaxResult = AjaxResult.success("获取成功！",map);
        }catch (Exception e){
            ajaxResult = AjaxResult.error(e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 退出
     * @param session 请求会话，用于保存登录信息
     * @return 数据的处理信息
     */
    @PostMapping("logout")
    public AjaxResult logout(HttpSession session){
        AjaxResult ajaxResult;
        try{
            session.removeAttribute("user");
            ajaxResult = AjaxResult.success("获取成功！");
        }catch (Exception e){
            ajaxResult = AjaxResult.error(e.getMessage());
        }
        return ajaxResult;
    }
}
