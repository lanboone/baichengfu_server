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

-- tb_notice 通知表新增字段
alter table tb_notice
    ADD notice_type_code varchar(255) Default NULL COMMENT '通知分类code（1设计师申请2装修师申请3退款申请）';
alter table tb_notice
    ADD `applicant_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人姓名';
alter table tb_notice
    ADD `price` int(11) NULL DEFAULT 0 COMMENT '价格';
alter table tb_notice
    ADD `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述';
alter table tb_notice
    ADD `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介';
alter table tb_notice
    ADD `status` int(11) NULL DEFAULT 0 COMMENT '状态 拒绝0 通过1';
alter table tb_notice
    ADD `reject_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拒绝理由';

-- 20200411 设计师风格表
alter table tb_designer_style
    ADD `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风格描述';
alter table tb_designer_style
    ADD `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风格序号';