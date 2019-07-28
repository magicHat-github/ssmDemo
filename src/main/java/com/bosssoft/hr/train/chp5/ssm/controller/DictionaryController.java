package com.bosssoft.hr.train.chp5.ssm.controller;

import com.bosssoft.hr.train.chp5.ssm.annotation.LogController;
import com.bosssoft.hr.train.chp5.ssm.exception.*;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.Dictionary;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.User;
import com.bosssoft.hr.train.chp5.ssm.pojo.vo.AjaxResult;
import com.bosssoft.hr.train.chp5.ssm.service.DictionaryService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @return 数据的处理
     */
    @LogController("保存数据字典")
    @PostMapping("save")
    public AjaxResult saveOne(@RequestBody Dictionary dictionary){
        if (dictionary==null){
            throw new ParamsException();
        }
        Integer rows = dictionaryService.insertOne(dictionary);
        return AjaxResult.success("添加成功！",rows);
    }

    /**
     * 修改数据字典
     * @param dictionary 数据字典
     * @return 数据的处理信息
     */
    @LogController("修改数据字典")
    @PutMapping("update")
    public AjaxResult updateOne(@RequestBody Dictionary dictionary){
        if (dictionary==null){
            throw new ParamsException();
        }
        Integer rows = dictionaryService.updateOne(dictionary);
        return AjaxResult.success("修改成功！",rows);
    }

    /**
     * 根据编号查询数据字典
     * @param id 编号
     * @return 结果
     */
    @LogController("根据编号查询数据字典")
    @GetMapping("id/{id}")
    public AjaxResult getById(@PathVariable("id") Long id){
        if (id==null){
            throw new ParamsException();
        }
        Dictionary dictionary = dictionaryService.selectOneById(id);
        return AjaxResult.success("查询成功！",dictionary);
    }

    /**
     * 查询数据字典的全部集合
     * @return 结果
     */
    @LogController("查询数据字典的全部集合")
    @GetMapping("list/all")
    public AjaxResult getList(){
        return AjaxResult.success("查询成功",dictionaryService.selectList());
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
                                      Dictionary dictionary){
        AjaxResult ajaxResult;
        if (dictionary ==null){
            throw new ParamsException();
        }
        PageInfo<Dictionary> pageInfo = dictionaryService.selectListByPage(dictionary, size, page);
        if (pageInfo != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("list", pageInfo.getList());
            map.put("total", pageInfo.getTotal());
            ajaxResult = AjaxResult.success("查询成功！", map);
        }else {
            ajaxResult = AjaxResult.success("查询失败！");
        }
        return ajaxResult;
    }

    /**
     * 删除数据字典
     * @param id 数据字典的编号
     * @return 数据的处理信息
     */
    @LogController("删除数据字典")
    @DeleteMapping("id/{id}")
    public AjaxResult deleteById(@PathVariable("id") Long id){
        if (id==null){
            throw new ParamsException();
        }
        Integer rows = dictionaryService.deleteOneById(id);
        return AjaxResult.success("删除成功！",rows);
    }

    /**
     * 批量删除数据字典
     * @param ids 数据字典的编号集合
     * @return 数据的处理信息
     */
    @LogController("批量删除数据字典")
    @DeleteMapping("ids")
    public AjaxResult deleteBatch(@RequestBody Long[] ids){
        if (ids==null){
            throw new ParamsException();
        }
        Integer rows = dictionaryService.deleteBatch(Arrays.asList(ids));
        return AjaxResult.success("删除成功！",rows);
    }
}
