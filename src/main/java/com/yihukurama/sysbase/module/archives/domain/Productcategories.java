package com.yihukurama.sysbase.module.archives.domain;

import com.yihukurama.sysbase.model.ProductCategoriesEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

/**
 * @author: liyuan
 * @date: 2020/4/25 16:09
 * @description: 商品分类对象
 */
@Data
public class Productcategories extends ProductCategoriesEntity {
    @ApiModelProperty(value = "查询列表类别", example = "ALL")
    @Enumerated(EnumType.STRING)
    ListType listType;

    public enum  ListType {
        @ApiModelProperty(value = "全部分类")
        ALL("all"),
        @ApiModelProperty(value = "父类")
        QUERY("parent"),
        @ApiModelProperty(value = "子类")
        CHILD("child");

        private String name;

        ListType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
