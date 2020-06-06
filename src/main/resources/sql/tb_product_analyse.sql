/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : baichengfu

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 06/06/2020 17:36:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_product_analyse
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_analyse`;
CREATE TABLE `tb_product_analyse`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
  `sold_num_count` int(11) NULL DEFAULT NULL COMMENT '销售总数量',
  `sold_price_count` decimal(50, 0) NULL DEFAULT NULL COMMENT '销售总额',
  `avg` decimal(50, 0) NOT NULL COMMENT '平均额',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `standard_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细分类id',
  `standard_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细分类名',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分析' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
