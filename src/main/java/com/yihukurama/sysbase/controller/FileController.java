package com.yihukurama.sysbase.controller;

import com.yihukurama.sysbase.common.enums.FilePathEnum;
import com.yihukurama.sysbase.common.enums.ImageEnum;
import com.yihukurama.sysbase.module.archives.service.impl.FileService;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.framework.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 说明： 图片上传接口，不做任何业务操作
 *
 * @author: yihukurma
 * @date: Created in 12:01 2018/1/22
 * @modified: by autor in 12:01 2018/1/22
 */
@Api(value = "文件上传", tags = "文件上传接口")
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileController {

    @Autowired
    FileService fileService;
    /**
     * 说明： 上传文件，可返回base64
     * @author yihukurama
     * @date Created in 11:39 2018/5/24
     * @modified by autor in 11:39 2018/5/24
     */
    @ApiOperation(value = "文件上传，表单模式",notes = "表单上传模式，返回文件路径，不带域名，可返回文件base64")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "fileType", value = "文件类型:1普通文件2图片文件3语音文件4视频文件5临时文件", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "imgType", value = "图片类型:10未分类20设计师简介30app用户头像", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "base64", value = "base64", required = false, dataType = "String"),
    })
    @RequestMapping(value="/uploadPic", method= RequestMethod.POST)
    public Result uploadPic(@RequestParam(value = "file", required = true) MultipartFile file,
                            @RequestParam(value = "fileType", required = true) Integer fileType,
                            @RequestParam(value = "imgType", required = true) Integer imgType,
                            @RequestParam(value = "base64", required = false) Integer base64) throws TipsException
    {
        try {
            FilePathEnum fileEnum = FilePathEnum.buildByType(fileType);
            if (fileEnum == null) {
                return Result.failed("fileType error");
            }
            ImageEnum imageEnum = ImageEnum.buildByType(imgType);
            if (imageEnum == null) {
                return Result.failed("imgType error");
            }

            return fileService.upload(file, fileEnum, imageEnum,base64);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.failed("文件上传失败");
        }
    }


    /**
     * 说明： base64上传
     * @author yihukurama
     * @date Created in 11:39 2018/5/24
     * @modified by autor in 11:39 2018/5/24
     */
    @ApiOperation(value = "文件上传base64模式",notes = "返回文件路径，不带域名")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "dataStr", value = "文件base64数据", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "fileType", value = "文件类型:1普通文件2图片文件3语音文件4视频文件5临时文件", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "imgType", value = "图片类型:10未分类20设计师简介30app用户头像", required = true, dataType = "int"),
    })
    @RequestMapping(value="/uploadPicBase64", method= RequestMethod.POST)
    public Result uploadPicBase64(
            @RequestParam(value = "dataStr", required = true) String dataStr,
            @RequestParam(value = "fileType", required = true) Integer fileType,
            @RequestParam(value = "imgType", required = true) Integer imgType) throws TipsException
    {
        try {
            FilePathEnum fileEnum = FilePathEnum.buildByType(fileType);
            if (fileEnum == null) {
                return Result.failed("fileType error");
            }
            ImageEnum imageEnum = ImageEnum.buildByType(imgType);
            if (imageEnum == null) {
                return Result.failed("imgType error");
            }

            return fileService.upload(dataStr, fileEnum, imageEnum);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.failed("文件上传失败");
        }
    }


}

