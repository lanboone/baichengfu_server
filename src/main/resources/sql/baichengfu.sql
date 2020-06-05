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

 Date: 05/06/2020 22:18:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_appuser
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser`;
CREATE TABLE `tb_appuser`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码（MD5）',
  `integral` int(255) NULL DEFAULT NULL COMMENT '个人积分',
  `phone_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `wechat_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq号',
  `identity_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业（装修师、设计师）',
  `address_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址字符串',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `is_first_login` int(3) NULL DEFAULT 0 COMMENT '是否首次登录 0否 1是',
  `is_limit_login` int(3) NULL DEFAULT 0 COMMENT '是否限制登录 0否 1是',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `token` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app登录token',
  `wxapp_openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信登录绑定的openid',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户昵称',
  `head_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户头像',
  `type` int(11) NULL DEFAULT 0 COMMENT 'app用户类型0普通用户,10设计师,20安装师傅',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上线id',
  `personal_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人专属邀请码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'APP用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_appuser_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_address`;
CREATE TABLE `tb_appuser_address`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `country` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国家',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `region` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `street` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '街道',
  `detailed_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `appuser_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联的app用户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人手机',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `type` int(11) NULL DEFAULT 20 COMMENT '地址类型  10默认  20普通 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户地址表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_appuser_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_comment`;
CREATE TABLE `tb_appuser_comment`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `topic_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '话题id',
  `comment_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论id',
  `appuser_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'app用户id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `topic_id_index`(`topic_id`) USING BTREE,
  INDEX `topic_user_id_index`(`topic_id`, `appuser_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'app用户点赞的评论关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_appuser_designer
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_designer`;
CREATE TABLE `tb_appuser_designer`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `designer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师id',
  `glory_value` int(255) NULL DEFAULT NULL COMMENT '荣耀值',
  `appuser_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `style` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '设计风格，使用分号隔开前面无分号，最后有分号，如北欧;中式;',
  `nick_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设计师昵称',
  `head_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设计师头像',
  `status` int(11) NOT NULL DEFAULT 10 COMMENT '10待审，20已审核',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'app用户关注设计师的关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_appuser_master
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_master`;
CREATE TABLE `tb_appuser_master`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `master_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修师id',
  `glory_value` int(255) NULL DEFAULT NULL COMMENT '荣耀值',
  `appuser_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `style` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '装修技能',
  `nick_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '装修师昵称',
  `head_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '装修师头像',
  `status` int(11) NOT NULL DEFAULT 10 COMMENT '10待审，20已审核',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'app用户关注装修师傅的关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_appuser_msg
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_msg`;
CREATE TABLE `tb_appuser_msg`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `sender_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者id',
  `receiver_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收者id',
  `sender_type` int(11) NULL DEFAULT NULL COMMENT '10APP用户  20后台客服',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '聊天内容',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `sender_head` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '发送者头像',
  `receiver_head` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '接收者头像',
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sender_id`(`sender_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户消息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_appuser_notify
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_notify`;
CREATE TABLE `tb_appuser_notify`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `sender_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者id',
  `receiver_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收者id',
  `sender_type` int(11) NULL DEFAULT NULL COMMENT '10APP用户  20后台客服',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '聊天内容',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `sender_head` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '发送者头像',
  `receiver_head` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '接收者头像',
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sender_id`(`sender_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户消息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_appuser_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_product`;
CREATE TABLE `tb_appuser_product`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间id',
  `appuser_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'app用户收藏商品关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_appuser_product_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_product_comment`;
CREATE TABLE `tb_appuser_product_comment`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `product_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品id',
  `comment_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论id',
  `appuser_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'app用户id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `topic_id_index`(`product_id`) USING BTREE,
  INDEX `topic_user_id_index`(`product_id`, `appuser_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'app用户点赞商品评论关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_appuser_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_room`;
CREATE TABLE `tb_appuser_room`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `appuser_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面积（平方）',
  `sample_image` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '样板间封面图，每个图片链接使用分号分割',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地',
  `address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '预算',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `pics` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片',
  `design_pics` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '设计效果图',
  `design_note` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '系统设计富文本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '样板间表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_appuser_sample
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_sample`;
CREATE TABLE `tb_appuser_sample`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `sample_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间id',
  `appuser_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'app用户关注设计师的关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_appuser_sell
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_sell`;
CREATE TABLE `tb_appuser_sell`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `appuser_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单商品id',
  `buyer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下单用户id',
  `buyer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下单用户昵称',
  `price` decimal(30, 0) NULL DEFAULT NULL COMMENT '商品价格',
  `product_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分销单单号',
  `order_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '付款方订单号',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `pay_type` int(11) NULL DEFAULT NULL COMMENT '付款方式',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态 10待发货  20待收货  30待退款  40已退款  50已确认',
  `order_product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联的订单商品id',
  `point` int(11) NULL DEFAULT NULL COMMENT '分销获得的积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户分销表' ROW_FORMAT = Compact;

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
  `freight` decimal(11, 0) NULL DEFAULT NULL COMMENT '运费',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `appuser_id`(`appuser_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户购物车表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_appuser_topic
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_topic`;
CREATE TABLE `tb_appuser_topic`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `topic_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题id',
  `appuser_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_index`(`appuser_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'APP用户收藏的话题关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pic_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '图片url',
  `link_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '链接url',
  `ads_pictures` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '广告图',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `is_drop` int(11) NULL DEFAULT 0 COMMENT '是否投放 0否 1是',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'banner描述',
  `type` int(11) NULL DEFAULT NULL COMMENT '10-80  8种类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '广告图表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_comm_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_comm_config`;
CREATE TABLE `tb_comm_config`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置名称',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `type` int(11) NULL DEFAULT NULL COMMENT '配置类型 10风格  20 固装  30材质',
  `index_order` int(11) NULL DEFAULT NULL COMMENT '排序字段，越大越前',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '业务基础配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_custom_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_custom_order`;
CREATE TABLE `tb_custom_order`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '10' COMMENT '主键id',
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `appuser_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `master_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修师id',
  `status` int(11) NOT NULL DEFAULT 10 COMMENT '订单状态（10待确认、20已确认）',
  `is_delete` int(11) NOT NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'system' COMMENT '创建人id',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `com` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递100要求存入的快递公司编码',
  `ems_cod` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递单号',
  `receive_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人姓名',
  `receive_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人电话',
  `receive_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件地址',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `pic` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容步骤富文本',
  `feature` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '特色',
  `exclusive` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专享',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定制订单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_custom_step
-- ----------------------------
DROP TABLE IF EXISTS `tb_custom_step`;
CREATE TABLE `tb_custom_step`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '10' COMMENT '主键id',
  `custom_order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '定制订单id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'system' COMMENT '创建人id',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容步骤富文本',
  `index_order` int(11) NULL DEFAULT NULL COMMENT '步骤编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定制订单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_decorator
-- ----------------------------
DROP TABLE IF EXISTS `tb_decorator`;
CREATE TABLE `tb_decorator`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `personal_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人图片',
  `skills` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修师技能(布线、贴砖)',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `parameter1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段1',
  `parameter2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
  `parameter3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
  `parameter4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
  `parameter5` int(255) NULL DEFAULT NULL COMMENT '预留字段5',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装修师表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_designer
-- ----------------------------
DROP TABLE IF EXISTS `tb_designer`;
CREATE TABLE `tb_designer`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
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

-- ----------------------------
-- Table structure for tb_designer_style
-- ----------------------------
DROP TABLE IF EXISTS `tb_designer_style`;
CREATE TABLE `tb_designer_style`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `designer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师id',
  `eg_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风格示例图',
  `style` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师风格(欧式、日式)',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设计师风格表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_help
-- ----------------------------
DROP TABLE IF EXISTS `tb_help`;
CREATE TABLE `tb_help`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `images` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '封面图片链接列表,用;分号分割',
  `index_order` int(11) NULL DEFAULT NULL COMMENT '排序',
  `creater_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `status` int(11) NULL DEFAULT 0 COMMENT '是否上下架 0下架 1上架',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_image`;
CREATE TABLE `tb_image`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `relate_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联id',
  `file_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片地址',
  `type` int(11) NULL DEFAULT NULL COMMENT '图片类型',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '是否删除 0否 1是',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_login_prompt
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_prompt`;
CREATE TABLE `tb_login_prompt`  (
  `id` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `type_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型code（10全屋定制20板材定制30了解定制）',
  `add_person_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `add_person_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加人名称(app用户名)',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id(管理员id)',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'app用户登录提示表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `sys_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名称',
  `sys_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `sys_Identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统身份',
  `permission_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作权限id列表',
  `distribution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分销订单id列表',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改日期',
  `head_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像url',
  `parameter2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
  `parameter3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
  `parameter4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
  `parameter5` int(255) NULL DEFAULT NULL COMMENT '预留字段5',
  `sys_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员手机号',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录token',
  PRIMARY KEY (`id`, `sys_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_managerprivilege
-- ----------------------------
DROP TABLE IF EXISTS `tb_managerprivilege`;
CREATE TABLE `tb_managerprivilege`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `privilege_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单/功能id',
  `manager_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `type` int(11) NULL DEFAULT NULL COMMENT '权限类型,10菜单,20商品分类',
  `is_delete` int(11) NULL DEFAULT 0,
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地区信息表' ROW_FORMAT = Dynamic;

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
  `star` int(255) NULL DEFAULT NULL COMMENT '星评价',
  `style` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '装修技能，使用分号隔开前面无分号，最后有分号;',
  `likecount` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '列表的心统计',
  `wantcount` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '列表想让他设计统计',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '师傅用户昵称',
  `head_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '师傅用户头像',
  `status` int(11) NULL DEFAULT NULL COMMENT '师傅状态 10 待审核   20已审核',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '排序权重，装修数',
  `phone_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装修师傅表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_master_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_master_comment`;
CREATE TABLE `tb_master_comment`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `reply_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '该评论回复的id集合，时间越早的在约前面',
  `c_parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父评论id',
  `master_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
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
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联的订单id',
  `order_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联的订单号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `topic_id_index`(`master_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '话题评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_master_skill
-- ----------------------------
DROP TABLE IF EXISTS `tb_master_skill`;
CREATE TABLE `tb_master_skill`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `master_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修师傅id',
  `eg_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技能示例图',
  `skill` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修师傅技能名称',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `index_order` int(11) NULL DEFAULT NULL COMMENT '排序字段，越大越前',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装修师傅技能表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `manager_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员id',
  `notice_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知分类',
  `notice_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知标题',
  `notice_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知内容',
  `notice_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '通知时间',
  `notice_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知链接',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `is_read` int(11) NULL DEFAULT 0 COMMENT '是否已读 0否 1是',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型  10设计师申请 20装修师申请  30退款申请',
  `relate_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联id',
  `parameter3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
  `parameter4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
  `parameter5` int(255) NULL DEFAULT NULL COMMENT '预留字段5',
  `notice_type_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知分类code（1设计师申请2装修师申请3退款申请）',
  `applicant_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人姓名',
  `price` int(11) NULL DEFAULT 0 COMMENT '价格',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态 拒绝0 通过1',
  `reject_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拒绝理由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统通知表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_operatelog
-- ----------------------------
DROP TABLE IF EXISTS `tb_operatelog`;
CREATE TABLE `tb_operatelog`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `type` int(11) NULL DEFAULT 0 COMMENT '操作记录类型',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `creater_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '10' COMMENT '主键id',
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `appuser_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `address_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修师id',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `status` int(11) NOT NULL DEFAULT 10 COMMENT '订单状态（10待支付、20待发货、30待收货、40待评价、50待退款、60已退款）',
  `paid_price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '实付价格（待支付状态可修改）',
  `is_delete` int(11) NOT NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'system' COMMENT '创建人id',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `pay_type` int(11) NULL DEFAULT NULL COMMENT '支付方式 10微信 20支付宝 30二维码',
  `order_price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '订单金额',
  `origin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '百城福订单' COMMENT '来源',
  `trade_no` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付宝或者微信的订单号',
  `com` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递100要求存入的快递公司编码',
  `ems_cod` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递单号',
  `receive_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人姓名',
  `receive_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人电话',
  `receive_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件地址',
  `appuser_parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该订单用户的上线id',
  `freight` decimal(10, 0) NULL DEFAULT NULL COMMENT '运费',
  `gen_point` int(11) NULL DEFAULT NULL COMMENT '积分产生',
  `consum_point` int(11) NULL DEFAULT NULL COMMENT '抵扣积分',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `master_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安装师傅id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Compact;

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
  `stand_config_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体规格商品id',
  `appuser_parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该订单用户的上线id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'APP用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_privilege
-- ----------------------------
DROP TABLE IF EXISTS `tb_privilege`;
CREATE TABLE `tb_privilege`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能代码',
  `text` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能描述',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `type` int(11) NOT NULL DEFAULT 10 COMMENT '10菜单权限  20商品分类权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '功能表' ROW_FORMAT = Dynamic;

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
  `ref_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参考价',
  `categorie_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '综合排序字段',
  `hot_count` int(11) NULL DEFAULT NULL COMMENT '热门排序字段',
  `categorie_full` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类信息',
  `point` int(11) NULL DEFAULT NULL COMMENT '商品积分',
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `stock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存',
  `freight` decimal(10, 0) NULL DEFAULT NULL COMMENT '运费',
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市场价',
  `send_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_product_categories
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_categories`;
CREATE TABLE `tb_product_categories`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `parent_category_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父类id',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类描述',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类图片链接',
  `priority` int(255) NULL DEFAULT NULL COMMENT '排序优先级（展示顺序）',
  `is_rebated` int(11) NULL DEFAULT 0 COMMENT '是否返积分 0不返 1返积分',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改日期',
  `point` int(11) NULL DEFAULT NULL COMMENT '分销积分',
  `creater_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人昵称',
  `index_order` int(11) NULL DEFAULT 0 COMMENT '排序字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `topic_id_index`(`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '话题评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_product_permissions
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_permissions`;
CREATE TABLE `tb_product_permissions`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `manager_id` bigint(20) NULL DEFAULT NULL COMMENT '管理员id',
  `category_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拥有操作权限的商品分类id',
  `seller_id` bigint(20) NULL DEFAULT NULL COMMENT '销售员id',
  `increase_` tinyint(255) NULL DEFAULT NULL COMMENT '增',
  `delete_` tinyint(255) NULL DEFAULT NULL COMMENT '删',
  `change_` tinyint(255) NULL DEFAULT NULL COMMENT '改',
  `query_` tinyint(255) NULL DEFAULT NULL COMMENT '查',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_product_standard
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_standard`;
CREATE TABLE `tb_product_standard`  (
  `id` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
  `product_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `standard_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父规格名称',
  `child_list` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子规格列表,用分号分割,如红色;蓝色波纹;砖红色',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '商品规格表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_push_notify
-- ----------------------------
DROP TABLE IF EXISTS `tb_push_notify`;
CREATE TABLE `tb_push_notify`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `receiver_tag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收者tag',
  `sender_type` int(11) NULL DEFAULT NULL COMMENT '10广播  20组播',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '推送内容',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `type` int(11) NULL DEFAULT NULL COMMENT '10广告消息  20活动消息',
  `show_date` datetime(0) NULL DEFAULT NULL COMMENT '显示时间',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户消息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_sample_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample_image`;
CREATE TABLE `tb_sample_image`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `sample_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '样板间id',
  `image` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片',
  `video` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '视频',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `parameter1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段1',
  `parameter2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
  `parameter3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
  `parameter4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
  `parameter5` int(255) NULL DEFAULT NULL COMMENT '预留字段5',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '样板间图片表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_sample_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample_link`;
CREATE TABLE `tb_sample_link`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `sample_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '样板间id',
  `product_link` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品链接',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '样板间商品链接表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_sample_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample_product`;
CREATE TABLE `tb_sample_product`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sample_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '样板间id',
  `product_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品id',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_sp`(`sample_id`, `product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '样板间商品关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_sample_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample_room`;
CREATE TABLE `tb_sample_room`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `manager_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员id',
  `appuser_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
  `uploader_type` int(11) NULL DEFAULT NULL COMMENT '上传者类型10管理员20用户）',
  `sample_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间标题',
  `sample_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间面积（平方）',
  `sample_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间链接',
  `sample_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间风格',
  `sample_image` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '样板间封面图，每个图片链接使用分号分割',
  `s_favorite_number` int(30) NULL DEFAULT 0 COMMENT '样板间浏览',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '排序权重，收藏数+浏览数',
  `focus_count` int(30) NULL DEFAULT 0 COMMENT '样板间收藏',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `furniture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定制家具',
  `material` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材质',
  `cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '费用',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `tips` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '摘要',
  `designer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师id',
  `designer_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师头像',
  `designer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师昵称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '样板间表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_search_condition
-- ----------------------------
DROP TABLE IF EXISTS `tb_search_condition`;
CREATE TABLE `tb_search_condition`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` int(11) NULL DEFAULT NULL COMMENT '10家具定制  20 材质  30风格',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '搜索条件名称',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '搜索条件分类表\r\n家具定制、材质、风格' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_seller
-- ----------------------------
DROP TABLE IF EXISTS `tb_seller`;
CREATE TABLE `tb_seller`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `seller_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售员名称',
  `seller_passwaord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售员密码',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型（总售前、总售后、售前、售后）',
  `belong_manager` bigint(255) NULL DEFAULT NULL COMMENT '所属管理员id',
  `permission_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联权限id列表',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '售前售后表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_standard_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_standard_config`;
CREATE TABLE `tb_standard_config`  (
  `id` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
  `product_id` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '商品id',
  `compose` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子规格组合,分号分割，如红色;20x20;A',
  `picture_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规格图片路径',
  `market_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '市场价',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `stock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改日期',
  `point` int(11) NULL DEFAULT NULL COMMENT '分销积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '商品规格配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_topic
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic`;
CREATE TABLE `tb_topic`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `creator_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者类型（10管理员，20App用户）',
  `topic_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '话题内容',
  `topic_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题标题',
  `t_favorite_number` int(30) NULL DEFAULT NULL COMMENT '话题收藏数',
  `t_viewing_count` int(30) NULL DEFAULT NULL COMMENT '话题浏览数',
  `comment_count` int(30) NULL DEFAULT NULL COMMENT '话题评论数',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `topic_image` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '话题封面图，每个图片链接使用分号分割',
  `topic_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者头像',
  `topic_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者昵称',
  `status` int(11) NULL DEFAULT 10 COMMENT '10显示  20 隐藏',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `topic_title`(`topic_title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '话题表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_topic_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic_comment`;
CREATE TABLE `tb_topic_comment`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `reply_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '该评论回复的id集合，时间越早的在约前面',
  `c_parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '父评论id',
  `topic_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题标题',
  `topic_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题id',
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题评论内容',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL COMMENT '最后修改日期',
  `comment_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者头像',
  `comment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者昵称',
  `reply` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `status` int(11) NULL DEFAULT 10 COMMENT '10显示  20 隐藏',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `topic_id_index`(`topic_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '话题评论表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ts_configuration
-- ----------------------------
DROP TABLE IF EXISTS `ts_configuration`;
CREATE TABLE `ts_configuration`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置数据编码',
  `value` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '配置数据值',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注信息',
  `index_order` int(11) NULL DEFAULT 0 COMMENT '排序字段',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_func
-- ----------------------------
DROP TABLE IF EXISTS `ts_func`;
CREATE TABLE `ts_func`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列号',
  `subSystem_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能所属子系统id',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能编码',
  `text` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能名称',
  `server_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能接口链接地址',
  `index_order` int(11) NULL DEFAULT 0 COMMENT '排序字段',
  `note` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '逻辑删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '保存系统菜单功能数据;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_menu
-- ----------------------------
DROP TABLE IF EXISTS `ts_menu`;
CREATE TABLE `ts_menu`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列号',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'root' COMMENT '父级菜单id,该值为root代表菜单为一级菜单',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/root/' COMMENT '分层路径',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单编码',
  `text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `link_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `server_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单接口地址',
  `icon_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标样式',
  `index_order` int(11) UNSIGNED ZEROFILL NULL DEFAULT 00000000000 COMMENT '排序字段',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `is_delete` int(11) NULL DEFAULT 0,
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '保存系统菜单数据;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_orgnization
-- ----------------------------
DROP TABLE IF EXISTS `ts_orgnization`;
CREATE TABLE `ts_orgnization`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列号',
  `p_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父机构id',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构路径，父机构为root',
  `text` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构所在地详细地址',
  `tel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `principal_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构负责人id',
  `principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构负责人名',
  `index_order` int(11) NULL DEFAULT 0 COMMENT '排序字段',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `type` int(11) NULL DEFAULT NULL COMMENT '机构类型 ',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_role
-- ----------------------------
DROP TABLE IF EXISTS `ts_role`;
CREATE TABLE `ts_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `text` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `type` int(11) NULL DEFAULT NULL COMMENT '1联动2交警3保险',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '业务配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_smsrecord
-- ----------------------------
DROP TABLE IF EXISTS `ts_smsrecord`;
CREATE TABLE `ts_smsrecord`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列号',
  `record_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信关联事故id',
  `receiver` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收人姓名',
  `mobile` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收人手机号码',
  `send_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发送时间',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型',
  `status` int(11) NULL DEFAULT 1 COMMENT '状态,1未发送,2发送成功,3发送失败',
  `error_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '错误代码',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败原因',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '保存全系统短信发送记录;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_smstemplate
-- ----------------------------
DROP TABLE IF EXISTS `ts_smstemplate`;
CREATE TABLE `ts_smstemplate`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列号',
  `type` int(11) NULL DEFAULT 0 COMMENT '短信模板类型',
  `type_text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板类型名称',
  `text` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板标题',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信模板内容',
  `index_order` int(11) NULL DEFAULT 0 COMMENT '排序字段',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '保存通知短信模板数据;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_user
-- ----------------------------
DROP TABLE IF EXISTS `ts_user`;
CREATE TABLE `ts_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `status` int(11) NULL DEFAULT 1 COMMENT '账号状态 1正常 2禁用',
  `type` int(11) NULL DEFAULT 1 COMMENT '账号类型 1工作人员 2超级管理员',
  `last_login_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后登录时间',
  `login_count` int(11) NULL DEFAULT 0 COMMENT '登录次数',
  `ip_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户最后登录时的ip地址',
  `index_order` int(7) NULL DEFAULT 0 COMMENT '排序字段',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注信息',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户token',
  `time_stamp` bigint(16) NULL DEFAULT 0 COMMENT '时间戳',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
  `request_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请状态',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  `org_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属机构id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_userrole
-- ----------------------------
DROP TABLE IF EXISTS `ts_userrole`;
CREATE TABLE `ts_userrole`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '驾校简称',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '驾校名',
  `creater_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '驾校表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
