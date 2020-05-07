/*
 Navicat Premium Data Transfer

 Source Server         : baichengfucloudsit
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 8.129.180.116:3306
 Source Schema         : baichengfu

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 07/05/2020 23:21:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_order_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_product`;
CREATE TABLE `tb_order_product`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `appuser_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `count` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `price` decimal(30, 0) NULL DEFAULT NULL COMMENT '商品价格',
  `product_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `product_note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品简介',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `ems_cod` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递单号',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态 10待发货  20待收货  30待退款  40已退款  50已确认',
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `com` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递100要求存入的快递公司编码',
  `picture_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '规格图片路径',
  `compose` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子规格组合,分号分割，如红色;20x20;A',
  `market_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '市场价',
  `stock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'APP用户表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
