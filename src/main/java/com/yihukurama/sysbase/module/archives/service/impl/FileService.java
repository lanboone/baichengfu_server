package com.yihukurama.sysbase.module.archives.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.yihukurama.sysbase.bean.config.SystemConfig;
import com.yihukurama.sysbase.common.enums.BusinessEnum;
import com.yihukurama.sysbase.common.enums.FilePathEnum;
import com.yihukurama.sysbase.common.enums.ImageEnum;
import com.yihukurama.sysbase.common.utils.FileUtil;
import com.yihukurama.sysbase.common.utils.PathUtil;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 说明： 文件操作服务，上传图片等
 * @author yihukurama
 * @date Created in 10:33 2020/4/4
 *       Modified by yihukurama in 10:33 2020/4/4
 */
@Service
public class FileService {

    @Autowired
    private SystemConfig urlConfig;

    /**
     * 说明： 可放回base64
     * @author yihukurama
     * @date Created in 11:41 2018/5/24
     * @modified by autor in 11:41 2018/5/24
     */
    public Result upload(MultipartFile file, FilePathEnum fileEnum, ImageEnum imageEnum, Integer base64) throws IOException {
        String rootPath = PathUtil.buildRootPath(urlConfig.getSaveFilePath(), BusinessEnum.COMM, fileEnum, imageEnum);
        String fileName = FileUtil.buildFileName(fileEnum.getSuffix());
        String absPath = FileUtil.fileWrite(new ByteArrayInputStream(file.getBytes()), rootPath, fileName);

        FileUtil.thumbnailImage(absPath,100,150,"thumb_",false);

        if(base64!=null){
            String msg = FileUtil.encodeBase64File(absPath);
            absPath = absPath.substring(urlConfig.getSaveFilePath().length());

            if (!StringUtil.isEmpty(absPath)) {

                return Result.successed(absPath,msg);
            } else {
                return Result.failed("文件上传失败");
            }
        }



        absPath = absPath.substring(urlConfig.getSaveFilePath().length());
        if (!StringUtil.isEmpty(absPath)) {
            return Result.successed(absPath);
        } else {
            return Result.failed("文件上传失败");
        }
    }
    
    /**
     * 说明： 上传图片
     * @author yihukurama
     * @date Created in 11:41 2018/5/24
     * @modified by autor in 11:41 2018/5/24
     */
    public Result upload(String base64File, FilePathEnum fileEnum, ImageEnum imageEnum) throws IOException {
        String rootPath = PathUtil.buildRootPath(urlConfig.getSaveFilePath(), BusinessEnum.COMM, fileEnum, imageEnum);
        String fileName = FileUtil.buildFileName(fileEnum.getSuffix());
        InputStream  input = FileUtil.base64ToInputString(base64File);
        if (input == null) {
            return Result.failed("文件上传失败");
        }
        String absPath = FileUtil.fileWrite(input, rootPath, fileName);
        FileUtil.thumbnailImage(absPath,100,150,"thumb_",false);

        absPath = absPath.substring(urlConfig.getSaveFilePath().length());

        if (!StringUtil.isEmpty(absPath)) {
            return Result.successed(absPath);
        } else {
            return Result.failed("文件上传失败");
        }
    }
}
