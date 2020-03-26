package com.yihukurama.sysbase.common.enums;

/**
 * 说明： 接口错误枚举类
 * @author yihukurama
 * @date Created in 14:28 2020/1/27
 *       Modified by yihukurama in 14:28 2020/1/27
 */
public enum ResponseEnum {
    /**
     * 4000段为通用错误码
     */
    ERROR_CODE_4003(4003, "用户未登录或登录过期"),
    ERROR_CODE_4004(4004, "用户token校验失败"),
    ERROR_CODE_4005(4005, "参数错误"),
    ERROR_CODE_200(200, "操作成功");

    /**
     * 5000段为机动车业务错误码
     */

    /**
     * 6000段为驾驶证业务错误码
     */

    private Integer code;
    private String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ResponseEnum buildByType(String code) {
        if (code == null) {
            return null;
        }
        for (ResponseEnum socketCmdEnum : ResponseEnum.values()) {
            if (socketCmdEnum.getCode().equals(code)) {
                return socketCmdEnum;
            }
        }
        return null;
    }
}
