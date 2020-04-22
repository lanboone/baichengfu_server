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
-- Table structure for tb_product_standard
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_standard`;
CREATE TABLE `tb_product_standard`
(
    `id`           varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
    `product_id`   varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci      DEFAULT NULL COMMENT '商品id',
    `color`        varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci     DEFAULT NULL COMMENT '颜色',
    `size`         double                                                          DEFAULT NULL COMMENT '尺寸,如40*60',
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
  COLLATE = latin1_swedish_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
