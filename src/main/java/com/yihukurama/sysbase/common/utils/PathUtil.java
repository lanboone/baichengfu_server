package com.yihukurama.sysbase.common.utils;


import com.yihukurama.sysbase.common.enums.BusinessEnum;
import com.yihukurama.sysbase.common.enums.FilePathEnum;
import com.yihukurama.sysbase.common.enums.ImageEnum;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能描述: 路径工具类
 *
 * @Author: 蔡伟浩
 * @Date: 2017/1/13 15:47
 */
public class PathUtil {

    
    /**
     * 功能描述：根据文件枚举生成路径
     * 文件存储结构为 根路径--->>业务路径--->>文件属性路径--->>文件业务分类路径--->>日期格式路径(2017.4.17)
     * @param rootPath
     * @param businessEnum
     * @param fileEnum
     * @param imageEnum
     * @return
     * @author SongBaoYu
     * @date 2017年4月17日 下午1:39:12
     */
    public static String buildRootPath(String rootPath, BusinessEnum businessEnum, FilePathEnum fileEnum, ImageEnum imageEnum) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(rootPath);

        //日期格式路径(2017.1.19)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
        sb.append("/").append(simpleDateFormat.format(new Date()));

    	//业务路径
    	sb.append(businessEnum == null ? BusinessEnum.OTHER.getDir() : businessEnum.getDir());
    	
    	//文件属性路径
    	sb.append(fileEnum == null ? FilePathEnum.COMMON_FILE.getDir() : fileEnum.getDir());
    	
    	//文件业务分类路径
    	sb.append("/");
    	sb.append(imageEnum == null ? ImageEnum.OTHER_IMG.getTag() : imageEnum.getTag());
    	

    	return sb.toString();
    }

    /**
     * 生成临时文件夹，可用于 打包下载 等操作，记得使用后删除文件夹
     *
     * @return 临时文件夹路径
     */
    public static String buildTempPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.append(BusinessEnum.OTHER.getDir()).append(System.currentTimeMillis() + RandomStringUtils.randomNumeric(6));
        return sb.toString();
    }
}
