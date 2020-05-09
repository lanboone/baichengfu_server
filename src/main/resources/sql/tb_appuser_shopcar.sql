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

 Date: 09/05/2020 23:04:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_appuser_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_shopcar`;
CREATE TABLE `tb_appuser_shopcar`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `appuser_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `count` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `price` decimal(30, 0) NULL DEFAULT NULL COMMENT '商品价格',
  `product_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `product_note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品简介',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `compose` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子规格组合,分号分割，如红色;20x20;A',
  `picture_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规格图片路径',
  `market_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '市场价',
  `stand_config_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体规格商品id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `appuser_id`(`appuser_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户购物车表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
