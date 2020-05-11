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

 Date: 11/05/2020 22:55:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_master
-- ----------------------------
DROP TABLE IF EXISTS `tb_master`;
CREATE TABLE `tb_master`  (
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
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修师傅地址',
  `certificate_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书路径',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型  10 个人  20公司',
  `service_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务价位',
  `parameter5` int(255) NULL DEFAULT NULL COMMENT '预留字段5',
  `style` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '装修技能，使用分号隔开前面无分号，最后有分号;',
  `likecount` int(11) NULL DEFAULT NULL COMMENT '列表的心统计',
  `wantcount` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '列表想让他设计统计',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '师傅用户昵称',
  `head_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '师傅用户头像',
  `status` int(11) NULL DEFAULT NULL COMMENT '师傅状态 10 待审核   20已审核',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '排序权重，装修数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装修师傅表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
