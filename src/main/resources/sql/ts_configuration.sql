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

 Date: 05/06/2020 22:16:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
-- Records of ts_configuration
-- ----------------------------
INSERT INTO `ts_configuration` VALUES ('1', 'kfyx', 'xcvfsfsfasda', '客服邮箱', 0, 0, NULL, '2020-05-28 20:47:50', NULL, '2020-05-28 21:09:37');
INSERT INTO `ts_configuration` VALUES ('2', 'kfdh', '2312312', '客服电话', 0, 0, NULL, '2020-05-28 20:47:50', NULL, '2020-05-28 21:09:24');
INSERT INTO `ts_configuration` VALUES ('3', 'kfwx', '6', '客服微信', 0, 0, NULL, '2020-05-28 20:47:50', NULL, '2020-05-28 21:11:04');
INSERT INTO `ts_configuration` VALUES ('4', 'bah', '5', '备案号', 0, 0, NULL, '2020-05-28 20:48:19', NULL, '2020-05-28 21:11:02');
INSERT INTO `ts_configuration` VALUES ('5', 'zztjdm', '4', '站长统计代码', 0, 0, NULL, '2020-05-28 20:48:21', NULL, '2020-05-28 21:11:01');
INSERT INTO `ts_configuration` VALUES ('6', 'gywm', '3', '关于我们', 0, 0, NULL, '2020-05-28 20:48:22', NULL, '2020-05-28 21:11:01');
INSERT INTO `ts_configuration` VALUES ('7', 'qt', '2', '其它配置', 0, 0, NULL, '2020-05-28 20:48:23', NULL, '2020-05-28 21:11:00');
INSERT INTO `ts_configuration` VALUES ('8', 'zfewm', 'aa', '支付二维码', 0, 0, NULL, '2020-06-05 22:16:23', NULL, '2020-06-05 22:16:23');

SET FOREIGN_KEY_CHECKS = 1;
