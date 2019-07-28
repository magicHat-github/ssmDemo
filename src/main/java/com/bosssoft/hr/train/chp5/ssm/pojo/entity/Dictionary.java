package com.bosssoft.hr.train.chp5.ssm.pojo.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 字典类
 * @author likang
 * @date 2019/7/24 13:52
 */
@Table(name = "t_dictionary")
public class Dictionary extends BaseEntity{

    /**
     * 数据字典编号
     */
    private Long categoryId;
    /**
     * 字典名
     */
    private String name;
    /**
     * 字典类型
     */
    private String category;
    /**
     * 字典值
     */
    private String value;
    /**
     * 备注
     */
    private String remark;
    /**
     * 组织编号
     */
    private Long orgId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", remark='" + remark + '\'' +
                ", orgId=" + orgId +
                '}';
    }
}
