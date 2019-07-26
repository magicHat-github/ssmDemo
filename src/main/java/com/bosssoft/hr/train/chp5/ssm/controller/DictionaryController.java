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
import java.util.List;

/**
 * 数据字典的控制层
 * @author likang
 * @date 2019/7/25 14:58
 */
@RestController
@RequestMapping("dictionary")
public class DictionaryController {

    @Resource
    private DictionaryService dictionaryService;

    /**
     * 保存数据字典
     * @param dictionary 数据字典
     * @param session 请求，用于获取登录信息
     * @return 数据的处理
     */
    @LogController("保存数据字典")
    @PostMapping("save")
    public AjaxResult saveOne(@RequestBody Dictionary dictionary, HttpSession session){
        AjaxResult ajaxResult;
        try {
            User user = (User) session.getAttribute("user");
            if(user==null){
                throw new NoLoginException();
            }
            if (dictionary==null){
                throw new ParamsException();
            }
            Integer rows = dictionaryService.insertOne(dictionary, user);
            ajaxResult = AjaxResult.success("添加成功！",rows);
        }catch (NoLoginException | ParamsException | SaveBeanException e){
            ajaxResult = AjaxResult.error(e.getCode(),e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 修改数据字典
     * @param dictionary 数据字典
     * @param session 请求会话，用于获取登录信息
     * @return 数据的处理信息
     */
    @LogController("修改数据字典")
    @PutMapping("update")
    public AjaxResult updateOne(@RequestBody Dictionary dictionary, HttpSession session){
        AjaxResult ajaxResult;
        try{
            User user = (User) session.getAttribute("user");
            if(user==null){
                throw new NoLoginException();
            }
            if (dictionary==null){
                throw new ParamsException();
            }
            Integer rows = dictionaryService.updateOne(dictionary,user);
            ajaxResult = AjaxResult.success("修改成功！",rows);
        }catch (NoLoginException | ParamsException | UpdateBeanException e){
            ajaxResult = AjaxResult.error(e.getCode(),e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 根据编号查询数据字典
     * @param id 编号
     * @return 结果
     */
    @LogController("根据编号查询数据字典")
    @GetMapping("id/{id}")
    public AjaxResult getById(@PathVariable("id") Long id){
        AjaxResult ajaxResult;
        try{
            if (id==null){
                throw new ParamsException();
            }
            Dictionary dictionary = dictionaryService.selectOneById(id);
            ajaxResult = AjaxResult.success("查询成功！",dictionary);
        }catch (ParamsException e){
            ajaxResult = AjaxResult.error(e.getCode(),e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 查询数据字典的全部集合
     * @return 结果
     */
    @LogController("查询数据字典的全部集合")
    @GetMapping("list/all")
    public AjaxResult getList(){
        AjaxResult ajaxResult;
        try{
            List<Dictionary> list = dictionaryService.selectList();
            ajaxResult = AjaxResult.success("查询成功",list);
        }catch (Exception e){
            ajaxResult = AjaxResult.error(e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 根据参数分页查询数据字典
     * @param dictionary 数据参数
     * @param size 查询页面的数据大小
     * @param page 目标查询的页面
     * @return 查询集合
     */
    @LogController("根据参数查询数据字典")
    @GetMapping("list")
    public AjaxResult getByDictionary(@RequestParam(value = "size",defaultValue = "4")Integer size,
                                      @RequestParam(value = "page", defaultValue = "1")Integer page,
                                      @RequestBody Dictionary dictionary){
        AjaxResult ajaxResult;
        try{
            if (dictionary ==null){
                throw new ParamsException();
            }
            List<Dictionary> list = dictionaryService.selectListByPage(dictionary, size, page);
            ajaxResult = AjaxResult.success("查询成功！",list);
        }catch (ParamsException e){
            ajaxResult = AjaxResult.error(e.getCode(),e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 删除数据字典
     * @param id 数据字典的编号
     * @param session 请求会话，用于获取登录信息
     * @return 数据的处理信息
     */
    @LogController("删除数据字典")
    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable("id") Long id, HttpSession session){
        AjaxResult ajaxResult;
        try{
            User user = (User) session.getAttribute("user");
            if(user==null){
                throw new NoLoginException();
            }
            if (id==null){
                throw new ParamsException();
            }
            Integer rows = dictionaryService.deleteOneById(id, user);
            ajaxResult = AjaxResult.success("删除成功！",rows);
        }catch (NoLoginException | ParamsException | DeleteBeanException e){
            ajaxResult = AjaxResult.error(e.getCode(),e.getMessage());
        }
        return ajaxResult;
    }

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
            ajaxResult = AjaxResult.success("登录成功", user);
        }catch (Exception e){
            ajaxResult = AjaxResult.error(e.getMessage());
        }
        return ajaxResult;
    }
}
