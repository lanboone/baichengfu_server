package com.yihukurama.sysbase.common.enums;

/**
 * 功能描述: 图片类型
 *
 */
public enum ImageEnum {

    OTHER_IMG(10, "common", "未分类图片"),
    DESIGNER_IMG(20, "remark", "设计师简介图片"),
    ;

    //类型
    private int type;
    //标识
    private String tag;
    //说明
    private String explain;

    ImageEnum(int type, String tag, String explain) {
        this.type = type;
        this.tag = tag;
        this.explain = explain;
    }

    public int getType() {
        return type;
    }

    public String getTag() {
        return tag;
    }

    public String getExplain() {
        return explain;
    }

    public static ImageEnum buildByType(Integer type) {
        if (type == null) {
            return null;
        }
        for (ImageEnum imageEnum : ImageEnum.values()) {
            if (imageEnum.getType() == type) {
                return imageEnum;
            }
        }
        return null;
    }


}
