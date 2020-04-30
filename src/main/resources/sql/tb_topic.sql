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

 Date: 19/04/2020 19:14:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_topic
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic`;
CREATE TABLE `tb_topic`
(
    `id`                varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `creator_type`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '创建者类型（10管理员，20App用户）',
    `topic_content`     text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '话题内容',
    `topic_title`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '话题标题',
    `t_favorite_number` int(30)                                                 NULL     DEFAULT NULL COMMENT '话题收藏数',
    `t_viewing_count`   int(30)                                                 NULL     DEFAULT NULL COMMENT '话题浏览数',
    `comment_count`     int(30)                                                 NULL     DEFAULT NULL COMMENT '话题评论数',
    `is_delete`         int(11)                                                 NULL     DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`       timestamp                                               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`      datetime                                                         DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `topic_image`       text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '话题封面图，每个图片链接使用分号分割',
    `topic_head`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '创建者头像',
    `topic_name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '创建者昵称',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `topic_title` (`topic_title`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '话题表'
  ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;