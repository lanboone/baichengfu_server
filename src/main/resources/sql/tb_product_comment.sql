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

 Date: 10/06/2020 13:12:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_product_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_comment`;
CREATE TABLE `tb_product_comment`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `reply_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '该评论回复的id集合，时间越早的在约前面',
  `c_parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父评论id',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `comment_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者头像',
  `comment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者昵称',
  `star` int(11) NULL DEFAULT NULL COMMENT '星级评价',
  `pics` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论的图片，视频访问路径，用分号隔开，用后缀区分',
  `product_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论时的商品详情',
  `reply` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `status` int(11) NULL DEFAULT NULL COMMENT '10显示  20隐藏',
  `product_standard_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `topic_id_index`(`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '话题评论表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
