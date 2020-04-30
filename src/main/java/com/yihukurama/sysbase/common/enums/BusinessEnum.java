package com.yihukurama.sysbase.common.enums;

/**
 * 功能描述: 业务类型枚举
 *
 * @Author: 蔡伟浩
 * @Date: 2017/1/18 14:12
 */
public enum BusinessEnum {
    COMM(1,"/comm","普通业务"),
    OTHER(2,"/other","其他业务"),

    ;

    private int type;
    private String dir;
    private String tag;

    BusinessEnum(int type, String dir, String tag) {
        this.type = type;
        this.dir = dir;
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public BusinessEnum setType(int type) {
        this.type = type;
        return this;
    }

    public String getDir() {
        return dir;
    }

    public BusinessEnum setDir(String dir) {
        this.dir = dir;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public BusinessEnum setTag(String tag) {
        this.tag = tag;
        return this;
    }
}
