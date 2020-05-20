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

 Date: 20/05/2020 23:45:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_designer
-- ----------------------------
DROP TABLE IF EXISTS `tb_designer`;
CREATE TABLE `tb_designer`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `personal_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人图片',
  `glory_value` int(255) NULL DEFAULT NULL COMMENT '荣耀值，装修案例数',
  `price_per` int(255) NULL DEFAULT NULL COMMENT '每平米平均价格',
  `works_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作品id列表',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师地址',
  `parameter2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
  `parameter3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
  `parameter4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
  `parameter5` int(255) NULL DEFAULT NULL COMMENT '预留字段5',
  `style` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '设计风格，使用分号隔开前面无分号，最后有分号，如北欧;中式;',
  `likecount` int(11) NULL DEFAULT NULL COMMENT '设计师列表的心统计',
  `wantcount` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '设计师里列表想让他设计统计',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师用户昵称',
  `head_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师用户头像',
  `status` int(11) NULL DEFAULT 10 COMMENT '设计师状态 10 待审核   20已审核',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '排序权重，心数+案例数',
  `phone_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设计师表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
