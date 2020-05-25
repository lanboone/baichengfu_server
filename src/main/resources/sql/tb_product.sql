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

 Date: 25/05/2020 21:35:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
  `profile` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `categories_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子分类id',
  `cover_images` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '封面图片链接列表,用;分号分割',
  `cover_video` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面视频链接',
  `prepaid_ratio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预付比例',
  `favorite_number` int(30) NULL DEFAULT NULL COMMENT '收藏数',
  `sales_volume` int(255) NULL DEFAULT NULL COMMENT '销量',
  `is_recommend` int(3) NULL DEFAULT 0 COMMENT '是否推荐到首页 0否 1是',
  `recommend_sort` int(11) NULL DEFAULT 0 COMMENT '推荐位排序号',
  `status` int(11) NULL DEFAULT 0 COMMENT '是否上下架 0下架 1上架',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改日期',
  `ref_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '参考价',
  `categorie_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '综合排序字段',
  `hot_count` int(11) NULL DEFAULT NULL COMMENT '热门排序字段',
  `categorie_full` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类信息',
  `point` int(11) NULL DEFAULT NULL COMMENT '商品积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
