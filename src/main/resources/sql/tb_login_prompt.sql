-- 登录提示表
-- ----------------------------
-- Table structure for tb_login_prompt
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_prompt`;
CREATE TABLE `tb_login_prompt`
(
    `id`              varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
    `type`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '类型',
    `type_code`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '类型code（10全屋定制20板材定制30了解定制）',
    `add_person_id`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT 'app用户id',
    `add_person_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '添加人名称(app用户名)',
    `remark`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '备注',
    `is_delete`       int(11)                                                         DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '创建人id(管理员id)',
    `create_date`     timestamp                                              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`    datetime                                                        DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = 'app用户登录提示表'
  ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;