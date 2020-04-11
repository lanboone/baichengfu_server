## 20200330
alter table tb_appuser
    ADD token varchar(32) Default NULL COMMENT 'app登录token';

## 20200401
alter table tb_appuser
    ADD wxapp_openid varchar(50) Default NULL COMMENT '微信登录绑定的openid';

## 20200402
alter table tb_manager
    ADD sys_phone varchar(32) Default NULL COMMENT '管理员手机号';


## 20200404
alter table tb_designer
    ADD style text Default NULL COMMENT '设计风格，使用分号隔开前面无分号，最后有分号，如北欧;中式;';
alter table tb_designer
    ADD likecount text Default NULL COMMENT '设计师列表的心统计';
alter table tb_designer
    ADD wantcount text Default NULL COMMENT '设计师里列表想让他设计统计';
alter table tb_appuser
    ADD nick_name varchar(20) Default NULL COMMENT 'app用户昵称';
alter table tb_appuser
    ADD head_url varchar(255) Default NULL COMMENT 'app用户头像';
alter table tb_designer
    ADD nick_name varchar(20) Default NULL COMMENT '设计师用户昵称';
alter table tb_designer
    ADD head_url varchar(255) Default NULL COMMENT '设计师用户头像';

## 20200406
alter table tb_appuser
    ADD type int(11) Default 0 COMMENT 'app用户类型0普通用户,10设计师,20安装师傅';

-- banner新增字段
alter table tb_banner
    ADD is_drop int(11) Default 0 COMMENT '是否投放 0否 1是';
alter table tb_banner
    ADD description varchar(255) Default NULL COMMENT 'banner描述';

-- manager新增字段
alter table tb_manager
    ADD token varchar(255) Default NULL COMMENT '登录token';
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