package com.yihukurama.sysbase.common.enums;

/**
 * 说明： 服务器存储文件类型(路径)
 * @author yihukurama
 * @date Created in 14:28 2020/1/27
 *       Modified by yihukurama in 14:28 2020/1/27
 */
public enum FilePathEnum {
    COMMON_FILE(1, "普通文件", "/common", ""),
    IMAGE_FILE(2, "图片文件", "/image", ".jpg"),
    AUDIO_FILE(3, "语音文件", "/audio", ".mp3"),
    VIDEO_FILE(4, "视频文件", "/video", ".mp4"),
    TEMP_FILE(5, "临时文件", "/temp", ""),
    ;

    //文件类型
    private int type;
    //标识
    private String tag;
    //文件夹
    private String dir;
    //后缀
    private String suffix;

    FilePathEnum(int type, String tag, String dir, String suffix) {
        this.type = type;
        this.tag = tag;
        this.dir = dir;
        this.suffix = suffix;
    }

    public int getType() {
        return type;
    }

    public FilePathEnum setType(int type) {
        this.type = type;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public FilePathEnum setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getDir() {
        return dir;
    }

    public FilePathEnum setDir(String dir) {
        this.dir = dir;
        return this;
    }

    public String getSuffix() {
        return suffix;
    }

    public FilePathEnum setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    /**
     * 根据type获取文件枚举类
     *
     * @param type
     * @return
     */
    public static FilePathEnum buildByType(Integer type) {
        if (type == null) {
            return null;
        }
        for (FilePathEnum fileEnum : FilePathEnum.values()) {
            if (fileEnum.getType() == type) {
                return fileEnum;
            }
        }
        return null;
    }
}
