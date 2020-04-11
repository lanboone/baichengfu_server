SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner`
(
    `id`           varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `pic_url`      text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci        NULL COMMENT '图片url',
    `link_url`     text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci        NULL COMMENT '链接url',
    `ads_pictures` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci        NULL COMMENT '广告图',
    `is_delete`    int(11)                                                      NULL     DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci       NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci       NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                              DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '广告图表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_designer
-- ----------------------------
DROP TABLE IF EXISTS `tb_designer`;
CREATE TABLE `tb_designer`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `user_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '用户id',
    `introduction`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '个人介绍',
    `remark`           text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '简介',
    `personal_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '个人图片',
    `glory_value`      int(255)                                                NULL     DEFAULT NULL COMMENT '荣耀值',
    `price_per`        int(255)                                                NULL     DEFAULT NULL COMMENT '每平米平均价格',
    `works_ids`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '作品id列表',
    `is_delete`        int(11)                                                 NULL     DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`      timestamp                                               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`     datetime                                                         DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `parameter1`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '预留字段1',
    `parameter2`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '预留字段2',
    `parameter3`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '预留字段3',
    `parameter4`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '预留字段4',
    `parameter5`       int(255)                                                NULL     DEFAULT NULL COMMENT '预留字段5',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '设计师表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_designer_style
-- ----------------------------
DROP TABLE IF EXISTS `tb_designer_style`;
CREATE TABLE `tb_designer_style`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `designer_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '设计师id',
    `eg_picture`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风格示例图',
    `style`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设计师风格(欧式、日式)',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '设计师风格表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_decorator
-- ----------------------------
DROP TABLE IF EXISTS `tb_decorator`;
CREATE TABLE `tb_decorator`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `user_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '用户id',
    `introduction`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '简介',
    `personal_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '个人图片',
    `skills`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '装修师技能(布线、贴砖)',
    `is_delete`        int(11)                                                 NULL     DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`      timestamp                                               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`     datetime                                                         DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `parameter1`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '预留字段1',
    `parameter2`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '预留字段2',
    `parameter3`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '预留字段3',
    `parameter4`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '预留字段4',
    `parameter5`       int(255)                                                NULL     DEFAULT NULL COMMENT '预留字段5',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '装修师表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_sample_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample_room`;
CREATE TABLE `tb_sample_room`
(
    `id`           varchar(32)                                             NOT NULL COMMENT '主键',
    `title`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
    `quote`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报价',
    `description`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `remark`       text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '简介',
    `home_type`    varchar(32)                                             NOT NULL COMMENT '户型',
    `area`         int(255)                                                NULL DEFAULT NULL COMMENT '使用面积（m2）',
    `price`        int(13)                                                 NULL DEFAULT NULL COMMENT '费用',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `parameter1`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段1',
    `parameter2`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
    `parameter3`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
    `parameter4`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
    `parameter5`   int(255)                                                NULL DEFAULT NULL COMMENT '预留字段5',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '样板间表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_sample_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample_image`;
CREATE TABLE `tb_sample_image`
(
    `id`           varchar(32)                                             NOT NULL COMMENT '主键',
    `sample_id`    varchar(32)                                             NOT NULL COMMENT '样板间id',
    `image`        text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '图片',
    `video`        text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '视频',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `parameter1`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段1',
    `parameter2`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
    `parameter3`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
    `parameter4`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
    `parameter5`   int(255)                                                NULL DEFAULT NULL COMMENT '预留字段5',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '样板间图片表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_sample_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample_link`;
CREATE TABLE `tb_sample_link`
(
    `id`           varchar(32)                                            NOT NULL COMMENT '主键',
    `sample_id`    varchar(32)                                            NOT NULL COMMENT '样板间id',
    `product_link` text CHARACTER SET utf8 COLLATE utf8_general_ci        NULL COMMENT '商品链接',
    `is_delete`    int(11)                                                NULL     DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                        DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '样板间商品链接表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager`
(
    `id`              varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `sys_name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员名称',
    `sys_password`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
    `sys_Identity`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统身份',
    `permission_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作权限id列表',
    `distribution`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分销订单id列表',
    `sys_phone`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员手机号',
    `token`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录token',
    `is_delete`       int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`     TIMESTAMP                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`    datetime                                                     default '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `parameter1`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段1',
    `parameter2`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
    `parameter3`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
    `parameter4`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
    `parameter5`      int(255)                                                NULL DEFAULT NULL COMMENT '预留字段5',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '管理员表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `manager_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '管理员id',
    `applicant_name`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '申请人姓名',
    `price`            int(11)                                                 NULL DEFAULT 0 COMMENT '价格',
    `description`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `remark`           text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '简介',
    `notice_type`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知分类',
    `notice_type_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知分类code（1设计师申请2装修师申请3退款申请）',
    `notice_title`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知标题',
    `notice_content`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知内容',
    `notice_time`      datetime                                                NULL DEFAULT CURRENT_TIMESTAMP COMMENT '通知时间',
    `notice_link`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知链接',
    `is_delete`        int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `is_read`          int(11)                                                 NULL DEFAULT 0 COMMENT '是否已读 0否 1是',
    `creater_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`      TIMESTAMP                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`     datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `parameter1`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段1',
    `parameter2`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
    `parameter3`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
    `parameter4`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段4',
    `parameter5`       int(255)                                                NULL DEFAULT NULL COMMENT '预留字段5',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统通知表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`
(
    `id`                varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `user_id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '用户id',
    `decorator_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '装修师id',
    `product_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '商品id',
    `order_type`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态（待支付、待发货、已发货、已收货、待退款、已同意退款、已退款）',
    `paid_price`        decimal(10, 2)                                          NULL DEFAULT NULL COMMENT '实付价格（待支付状态可修改）',
    `delivery_time`     datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '发货时间',
    `is_delete`         int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`       datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`      datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `consignee_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人地址',
    `consignee_phone`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人电话',
    `return_address`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货地址',
    `returne_phone`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货人电话',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '订单表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_order_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_evaluation`;
CREATE TABLE `tb_order_evaluation`
(
    `id`             varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `order_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '订单id',
    `star_rating`    int(255)                                                NULL DEFAULT NULL COMMENT '评论星级',
    `review_type`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论类型',
    `displayability` tinyint(3)                                              NULL DEFAULT NULL COMMENT '是否可显示',
    `content`        text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '评论内容',
    `is_delete`      int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`    datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`   datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '订单评论表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`
(
    `id`                varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `product_name`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
    `profile`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
    `categories_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '分类id',
    `unit_quantity`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位数量（39扇）',
    `area`              int(255)                                                NULL DEFAULT NULL COMMENT '面积',
    `quantity`          int(255)                                                NULL DEFAULT NULL COMMENT '数量',
    `prepaid_price`     int(255)                                                NULL DEFAULT NULL COMMENT '预付价',
    `actual_paid_price` decimal(10, 2)                                          NULL DEFAULT NULL COMMENT '实付价',
    `prepaid_ratio`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预付比例',
    `favorite_number`   int(30)                                                 NULL DEFAULT NULL COMMENT '收藏数',
    `sales_volume`      int(255)                                                NULL DEFAULT NULL COMMENT '销量',
    `is_recommend`      int(3)                                                  NULL DEFAULT 0 COMMENT '是否推荐到首页 0否 1是',
    `is_delete`         int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`       datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`      datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '商品表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_product_categories
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_categories`;
CREATE TABLE `tb_product_categories`
(
    `id`                 varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `parent_category_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '父类id',
    `category_name`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
    `priority`           int(255)                                                NULL DEFAULT NULL COMMENT '优先级（展示顺序）',
    `is_delete`          int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`        datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`       datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '商品分类表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_product_permissions
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_permissions`;
CREATE TABLE `tb_product_permissions`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `manager_id`   bigint(20)                                              NULL DEFAULT NULL COMMENT '管理员id',
    `category_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拥有操作权限的商品分类id',
    `seller_id`    bigint(20)                                              NULL DEFAULT NULL COMMENT '销售员id',
    `increase_`    tinyint(255)                                            NULL DEFAULT NULL COMMENT '增',
    `delete_`      tinyint(255)                                            NULL DEFAULT NULL COMMENT '删',
    `change_`      tinyint(255)                                            NULL DEFAULT NULL COMMENT '改',
    `query_`       tinyint(255)                                            NULL DEFAULT NULL COMMENT '查',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '操作权限表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_sample_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample_room`;
CREATE TABLE `tb_sample_room`
(
    `id`                varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `manager_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '管理员id',
    `user_id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '用户id',
    `uploader_type`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传者类型（管理员或用户）',
    `sample_title`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间标题',
    `sample_area`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间面积（平方）',
    `sample_link`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间链接',
    `sample_type`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样板间分类',
    `sample_image`      text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '样板间图片',
    `s_favorite_number` int(30)                                                 NULL DEFAULT NULL COMMENT '样板间收藏数',
    `is_delete`         int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`       datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`      datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '样板间表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_seller
-- ----------------------------
DROP TABLE IF EXISTS `tb_seller`;
CREATE TABLE `tb_seller`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `seller_name`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '销售员名称',
    `seller_passwaord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '销售员密码',
    `type`             varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '类型（总售前、总售后、售前、售后）',
    `belong_manager`   bigint(255)                                             NULL     DEFAULT NULL COMMENT '所属管理员id',
    `permission_list`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '关联权限id列表',
    `is_delete`        int(11)                                                 NULL     DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`      timestamp                                               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`     datetime                                                         DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '售前售后表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_topic
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic`;
CREATE TABLE `tb_topic`
(
    `id`                varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `manager_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '管理员id',
    `user_id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '用户id',
    `creator_type`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者类型（管理员或用户）',
    `topic_content`     text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '话题内容',
    `topic_title`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题标题',
    `t_favorite_number` int(30)                                                 NULL DEFAULT NULL COMMENT '话题收藏数',
    `t_viewing_count`   int(30)                                                 NULL DEFAULT NULL COMMENT '话题浏览数',
    `is_delete`         int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`       datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`      datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '话题表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_topic_picture
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic_picture`;
CREATE TABLE `tb_topic_picture`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
    `topic_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '管理员id',
    `picture`      text CHARACTER SET utf8 COLLATE utf8_general_ci        NULL COMMENT '图片',
    `priority`     int(30)                                                NULL     DEFAULT NULL COMMENT '展示的优先级',
    `is_delete`    int(11)                                                NULL     DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                        DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '话题图片表'
  ROW_FORMAT = Compact;
-- ----------------------------
-- Table structure for tb_topic_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic_comment`;
CREATE TABLE `tb_topic_comment`
(
    `id`              varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `c_parent_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '父评论id',
    `topic_id`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '话题id',
    `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题评论内容',
    `is_delete`       int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`     datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`    datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '话题评论表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_appuser
-- ----------------------------
DROP TABLE IF EXISTS `tb_appuser`;
CREATE TABLE `tb_appuser`
(
    `id`              varchar(32)                                             NOT NULL COMMENT '主键',
    `user_name`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
    `user_password`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码（MD5）',
    `integral`        int(255)                                                NULL DEFAULT NULL COMMENT '个人积分',
    `phone_number`    varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '手机号',
    `wechat_number`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号',
    `qq`              varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq号',
    `identity_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '身份证号',
    `profession`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业（装修师、设计师）',
    `address_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '地址id',
    `gender`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
    `age`             int(11)                                                 NULL DEFAULT NULL COMMENT '年龄',
    `is_first_login`  int(3)                                                  NULL DEFAULT 0 COMMENT '是否首次登录 0否 1是',
    `is_limit_login`  int(3)                                                  NULL DEFAULT 0 COMMENT '是否限制登录 0否 1是',
    `is_delete`       int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`     datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`    datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = 'APP用户表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_user_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_address`;
CREATE TABLE `tb_user_address`
(
    `id`               varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `country`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '国家',
    `province`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '省份',
    `city`             varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '城市',
    `region`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '区',
    `street`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '街道',
    `detailed_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '详细地址',
    `code`             varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '邮政编码',
    `is_delete`        int(11)                                                 NULL     DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`      timestamp                                               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`     datetime                                                         DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户地址表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_image`;
CREATE TABLE `tb_image`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
    `relate_id`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '关联id',
    `file_path`    text CHARACTER SET utf8 COLLATE utf8_general_ci        NULL COMMENT '图片地址',
    `type`         int(11)                                                NULL     DEFAULT NULL COMMENT '图片类型',
    `is_delete`    int(11)                                                NULL     DEFAULT 0 COMMENT '是否删除 0否 1是',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                        DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_operatelog
-- ----------------------------
DROP TABLE IF EXISTS `tb_operatelog`;
CREATE TABLE `tb_operatelog`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT 'id',
    `relate_id`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '关联id',
    `type`         int(11)                                                 NULL DEFAULT 0 COMMENT '操作记录类型',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `creater_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '操作记录表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_configuration
-- ----------------------------
DROP TABLE IF EXISTS `ts_configuration`;
CREATE TABLE `ts_configuration`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT 'id',
    `code`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置数据编码',
    `value`        text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '配置数据值',
    `note`         text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '备注信息',
    `index_order`  int(11)                                                 NULL DEFAULT 0 COMMENT '排序字段',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '配置表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_func
-- ----------------------------
DROP TABLE IF EXISTS `ts_func`;
CREATE TABLE `ts_func`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '序列号',
    `subSystem_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '功能所属子系统id',
    `code`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '功能编码',
    `text`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '功能名称',
    `server_url`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能接口链接地址',
    `index_order`  int(11)                                                 NULL DEFAULT 0 COMMENT '排序字段',
    `note`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '备注信息',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '逻辑删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '保存系统菜单功能数据;'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_menu
-- ----------------------------
DROP TABLE IF EXISTS `ts_menu`;
CREATE TABLE `ts_menu`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '序列号',
    `parent_id`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT 'root' COMMENT '父级菜单id,该值为root代表菜单为一级菜单',
    `path`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/root/' COMMENT '分层路径',
    `code`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '菜单编码',
    `text`         varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
    `link_url`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'extjs链接',
    `server_url`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单接口地址',
    `icon_class`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标样式',
    `index_order`  int(11) UNSIGNED ZEROFILL                               NULL DEFAULT 00000000000 COMMENT '排序字段',
    `note`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `is_delete`    int(11)                                                 NULL DEFAULT 0,
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '保存系统菜单数据;'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_orgnization
-- ----------------------------
DROP TABLE IF EXISTS `ts_orgnization`;
CREATE TABLE `ts_orgnization`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '序列号',
    `p_id`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '父机构id',
    `path`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构路径，父机构为root',
    `text`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '机构名称',
    `code`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '机构编码',
    `address`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构所在地详细地址',
    `tel`          varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '联系电话',
    `principal_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '机构负责人id',
    `principal`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构负责人名',
    `index_order`  int(11)                                                 NULL DEFAULT 0 COMMENT '排序字段',
    `note`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `type`         int(11)                                                 NULL DEFAULT NULL COMMENT '机构类型 ',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_privilege
-- ----------------------------
DROP TABLE IF EXISTS `ts_privilege`;
CREATE TABLE `ts_privilege`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT 'id',
    `code`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '功能代码',
    `text`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '功能描述',
    `note`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '功能表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_role
-- ----------------------------
DROP TABLE IF EXISTS `ts_role`;
CREATE TABLE `ts_role`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT 'id',
    `text`         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '角色名称',
    `note`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `type`         int(11)                                                 NULL DEFAULT NULL COMMENT '1联动2交警3保险',
    `is_delete`    int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '业务配置表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_roleprivilege
-- ----------------------------
DROP TABLE IF EXISTS `ts_roleprivilege`;
CREATE TABLE `ts_roleprivilege`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `privilege_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '菜单/功能id',
    `role_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '角色id',
    `type`         int(11)                                                NULL     DEFAULT NULL COMMENT '权限类型,1系统,3菜单,4功能',
    `is_delete`    int(11)                                                NULL     DEFAULT 0,
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                        DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '地区信息表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_smsrecord
-- ----------------------------
DROP TABLE IF EXISTS `ts_smsrecord`;
CREATE TABLE `ts_smsrecord`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '序列号',
    `record_id`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '短信关联事故id',
    `receiver`     varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '接收人姓名',
    `mobile`       varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '接收人手机号码',
    `send_date`    datetime                                                      DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
    `content`      varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信内容',
    `type`         int(11)                                                  NULL DEFAULT NULL COMMENT '类型',
    `status`       int(11)                                                  NULL DEFAULT 1 COMMENT '状态,1未发送,2发送成功,3发送失败',
    `error_code`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '错误代码',
    `reason`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '失败原因',
    `is_delete`    int(11)                                                  NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                      DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '保存全系统短信发送记录;'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_smstemplate
-- ----------------------------
DROP TABLE IF EXISTS `ts_smstemplate`;
CREATE TABLE `ts_smstemplate`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '序列号',
    `type`         int(11)                                                  NULL DEFAULT 0 COMMENT '短信模板类型',
    `type_text`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '模板类型名称',
    `text`         varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '模板标题',
    `content`      varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信模板内容',
    `index_order`  int(11)                                                  NULL DEFAULT 0 COMMENT '排序字段',
    `note`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '备注信息',
    `is_delete`    int(11)                                                  NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                      DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '保存通知短信模板数据;'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_user
-- ----------------------------
DROP TABLE IF EXISTS `ts_user`;
CREATE TABLE `ts_user`
(
    `id`              varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT 'id',
    `real_name`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
    `phone`           varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '联系方式',
    `username`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
    `password`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    `status`          int(11)                                                 NULL DEFAULT 1 COMMENT '账号状态 1正常 2禁用',
    `type`            int(11)                                                 NULL DEFAULT 1 COMMENT '账号类型 1工作人员 2超级管理员',
    `last_login_date` datetime                                                     default CURRENT_TIMESTAMP COMMENT '最后登录时间',
    `login_count`     int(11)                                                 NULL DEFAULT 0 COMMENT '登录次数',
    `ip_addr`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户最后登录时的ip地址',
    `index_order`     int(7)                                                  NULL DEFAULT 0 COMMENT '排序字段',
    `note`            text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '备注信息',
    `token`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户token',
    `time_stamp`      bigint(16)                                              NULL DEFAULT 0 COMMENT '时间戳',
    `is_delete`       int(11)                                                 NULL DEFAULT 0 COMMENT '删除状态 0正常 1删除',
    `request_status`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请状态',
    `creater_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人id',
    `create_date`     datetime                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '最后修改人id',
    `operate_date`    datetime                                                     DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    `org_id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '所属机构id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ts_userrole
-- ----------------------------
DROP TABLE IF EXISTS `ts_userrole`;
CREATE TABLE `ts_userrole`
(
    `id`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
    `user_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '驾校简称',
    `role_id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '驾校名',
    `creater_id`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '创建人id',
    `create_date`  timestamp                                              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `operator_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '最后修改人id',
    `operate_date` datetime                                                        DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '驾校表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;


-- ----------------------------
-- Table structure for tb_login_prompt
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_prompt`;
CREATE TABLE `tb_login_prompt`
(
    `id`              varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
    `type`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '类型',
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
