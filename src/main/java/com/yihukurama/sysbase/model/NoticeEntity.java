package com.yihukurama.sysbase.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yihukurama.tkmybatisplus.framework.domain.tkmapper.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 说明： 系统通知表
 *
 * @author: yihukurama
 * @date: Created in 15:18 2018/4/4
 * @modified: by yihukurama in 15:18 2018/4/4
 */
@ApiModel(value = "系统通知表")
@Table(name = "tb_notice")
@Data
public class NoticeEntity extends BaseEntity {



    /**
     * 通知标题
     **/
    @ApiModelProperty(value = "类型  10设计师申请 20装修师申请  30退款申请")
    @Column(name = "type")
    private Integer type;

    /**
     * 通知标题
     **/
    @ApiModelProperty(value = "关联id")
    @Column(name = "relate_id")
    private String  relate_id;

    /**
     * 通知标题
     **/
    @ApiModelProperty(value = "通知标题")
    @Column(name = "notice_title")
    private String noticeTitle;
    /**
     * 最后修改人id
     **/
    @ApiModelProperty(value = "最后修改人id")
    @Column(name = "operator_id")
    private String operatorId;
    /**
     * 通知内容
     **/
    @ApiModelProperty(value = "通知内容")
    @Column(name = "notice_content")
    private String noticeContent;
    /**
     * 最后修改日期
     **/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "operate_date")
    private Date operateDate;
    /**
     * 创建人id
     **/
    @ApiModelProperty(value = "创建人id")
    @Column(name = "creater_id")
    private String createrId;
    /**
     * 通知链接
     **/
    @ApiModelProperty(value = "通知链接")
    @Column(name = "notice_link")
    private String noticeLink;
    /**
     * 通知分类
     **/
    @ApiModelProperty(value = "通知分类")
    @Column(name = "notice_type")
    private String noticeType;
    /**
     * 通知分类code
     **/
    @ApiModelProperty(value = "通知分类code（1设计师申请2装修师申请3退款申请）")
    @Column(name = "notice_type_code")
    private String noticeTypeCode;
    /**
     * 删除状态 0正常 1删除
     **/
    @ApiModelProperty(value = "删除状态 0正常 1删除")
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 是否已读 0否 1是
     **/
    @ApiModelProperty(value = "是否已读 0否 1是")
    @Column(name = "is_read")
    private Boolean isRead;
    /**
     * 管理员id
     **/
    @ApiModelProperty(value = "管理员id")
    @Column(name = "manager_id")
    private String managerId;
    /**
     * 创建时间
     **/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private Date createDate;
    /**
     * 通知时间
     **/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "notice_time")
    private Date noticeTime;

    /**
     * 申请人姓名
     **/
    @ApiModelProperty(value = "申请人姓名")
    @Column(name = "applicant_name")
    private String applicantName;

    /**
     * 描述
     **/
    @ApiModelProperty(value = "描述")
    @Column(name = "description")
    private String description;

    /**
     * 简介
     **/
    @ApiModelProperty(value = "简介")
    @Column(name = "remark")
    private String remark;

    /**
     * 价格
     **/
    @ApiModelProperty(value = "价格")
    @Column(name = "price")
    private Integer price;

    /**
     * 状态
     **/
    @ApiModelProperty(value = "状态 拒绝10 通过20 未审核30")
    @Column(name = "status")
    private String status;

    /**
     * 拒绝理由
     **/
    @ApiModelProperty(value = "拒绝理由")
    @Column(name = "reject_reason")
    private String rejectReason;

}
