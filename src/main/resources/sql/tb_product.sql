/*
 Navicat Premium Data Transfer

 Source Server         : 8.129.180.116
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 8.129.180.116:3306
 Source Schema         : baichengfu

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 22/04/2020 17:56:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`
(
    `id`              varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `product_name`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
    `profile`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
    `categories_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '子分类id',
    `cover_images`    text CHARACTER SET utf8 COLLATE utf8_general_ci         NOT NULL COMMENT '封面图片链接列表,用;分号分割',
    `cover_video`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '封面视频链接',
    `prepaid_ratio`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预付比例',
    `favorite_number` int(30)                                                 NULL DEFAULT NULL COMMENT '收藏数',
    `sales_volume`    int(255)                                                NULL DEFAULT NULL COMMENT '销量',
    `is_recommend`    int(3)                                                  NULL DEFAULT 0 COMMENT '是否推荐到首页 0否 1是',
    `recommend_sort`  int(11)                                                 NULL DEFAULT 0 COMMENT '推荐位排序号',
    `is_delete`       int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`     datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`    datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '商品表'
  ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for tb_product_categories
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_categories`;
CREATE TABLE `tb_product_categories`
(
    `id`                 varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `parent_category_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '父类id',
    `category_name`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
    `description`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类描述',
    `picture_url`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类图片链接',
    `priority`           int(255)                                                NULL DEFAULT NULL COMMENT '排序优先级（展示顺序）',
    `is_rebated`         int(11)                                                 NULL DEFAULT 0 COMMENT '是否返积分 0不返 1返积分',
    `is_delete`          int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`        datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`       datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '商品分类表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_product_standard
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_standard`;
CREATE TABLE `tb_product_standard`
(
    `id`            varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
    `product_id`    varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci      DEFAULT NULL COMMENT '商品id',
    `standard_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci     DEFAULT NULL COMMENT '父规格名称',
    `child_list`    text CHARACTER SET utf8 COLLATE utf8_general_ci            NOT NULL COMMENT '子规格列表,用分号分割,如红色;蓝色波纹;砖红色',
    `is_delete`     int(11)                                                    NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`   datetime                                                        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`  datetime                                                        DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = latin1
  COLLATE = latin1_swedish_ci COMMENT = '商品规格表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for tb_standard_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_standard_config`;
CREATE TABLE `tb_standard_config`
(
    `id`           varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
    `product_id`   varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci      DEFAULT NULL COMMENT '商品id',
    `compose`      varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci     DEFAULT NULL COMMENT '子规格组合,分号分割，如红色;20x20;A',
    `picture_url`  text CHARACTER SET utf8 COLLATE utf8_general_ci            NOT NULL COMMENT '规格图片路径',
    `market_price` decimal(10, 2)                                                  DEFAULT NULL COMMENT '市场价',
    `price`        decimal(10, 2)                                                  DEFAULT NULL COMMENT '价格',
    `stock`        varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci     DEFAULT NULL COMMENT '库存',
    `is_delete`    int(11)                                                    NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  datetime                                                        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                        DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = latin1
  COLLATE = latin1_swedish_ci COMMENT = '商品规格配置表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;


