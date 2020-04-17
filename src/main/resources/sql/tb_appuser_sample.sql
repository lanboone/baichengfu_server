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

 Date: 11/04/2020 15:25:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_appuser_sample
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser_sample`;
CREATE TABLE `tb_appuser_sample`
(
    `id`           varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
    `sample_id`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci       NULL DEFAULT NULL COMMENT '样板间id',
    `appuser_id`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app用户id',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci       NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  TIMESTAMP                                                    NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci       NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = 'app用户关注设计师的关联表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
