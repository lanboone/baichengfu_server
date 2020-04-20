/*
Navicat MySQL Data Transfer

Source Server         : 本机mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : baichengfu

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-04-20 13:45:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_topic_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic_comment`;
CREATE TABLE `tb_topic_comment` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `reply_path` text COMMENT '该评论回复的id集合，时间越早的在约前面',
  `c_parent_id` varchar(32) NOT NULL DEFAULT '' COMMENT '父评论id',
  `topic_id` varchar(32) DEFAULT NULL COMMENT '话题id',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '话题评论内容',
  `is_delete` int(11) DEFAULT '0' COMMENT '删除状态 0正常 1删除',
  `creater_id` varchar(32) DEFAULT NULL COMMENT '创建人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `operator_id` varchar(32) DEFAULT NULL COMMENT '最后修改人id',
  `operate_date` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
  `comment_head` varchar(255) DEFAULT NULL COMMENT '创建者头像',
  `comment_name` varchar(255) DEFAULT NULL COMMENT '创建者昵称',
  `reply` text,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `topic_id_index` (`topic_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='话题评论表';
