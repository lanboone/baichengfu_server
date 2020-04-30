package com.yihukurama.sysbase.module.archives.domain;


import com.yihukurama.sysbase.model.SmstemplateEntity;

/**
 * 说明： SmstemplateEntity的领域对象
 * @author: ouyaokun
 * @date: Created in 17:10 2018/4/28
 * @modified: by autor in 17:10 2018/4/28
 */
public class Smstemplate extends SmstemplateEntity {

    /**
     * 短信服务模板类型
     */
    public static final Integer SMS_TEMPLATE_TYPE = 331080;

    /**
     * 短信服务模板类型:二审不通过
     * 预登记二审审核不通过 尊敬的用户，您的预登记资料有{1}项复核不通过：{2}。为了不影响您的预约业务，请于{3}前点击链接修正并提交。{4}
     */
    public static final Integer SMS_TEMPLATE_TYPE_HUMAN_CHECK_REJECT = 450329;

    /**
     * 2019-12-27 16:54:15  预录入下发补充短信  尊敬的用户，您的预登记资料有{1}项复核不通过：{2}。为了不影响您的预约业务，请于{3}前点击链接http://www.emsfs.com/preupload/h5/#/stepUpload/delay/?bizId={4}&recordId={5}&page=0&token={6} 修正并提交
     */
    public static final Integer SMS_TEMPLATE_TYPE_HUMAN_CHECK_REJECT_FORMAL = 509937;

    /**
     * 待复核
     * 尊敬的用户，您的预登记信息初审通过，等待复核，将于2个工作日内进行通知。如预约到场后仍未接收到复核通过通知，请到预受理大厅催审。
     */
    public static final Integer YST_TEMPLATE_NOTIFY_BOTCHECK_FINISH = 999001;

    /**
     * 复核通过
     * 尊敬的用户，您的预登记资料复核通过，请于%s前到场办理业务。
     */
    public static final Integer YST_TEMPLATE_NOTIFY_HUMAN_CHECK_PASS = 999002;

    /**
     * 车管业务预约二审不通过
     */
    public static final Integer YST_SEND_NOT_PASS_TEMPLATE = 506935;
}
