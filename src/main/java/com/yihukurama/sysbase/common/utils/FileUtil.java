package com.yihukurama.sysbase.common.utils;

import com.yihukurama.sysbase.handle.DateUtil;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.EncrUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.misc.IOUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件工具
 *
 * @author: dengshuai
 * @date: Created in 11:29 2018/1/22
 * @modified: by autor in 11:29 2018/1/22
 */
public class FileUtil {

    //文件名称格式 %s时间字符串 %s随机加密字符串 %.后缀
    public static final String FILE_NAME_FORMAT_STRING = "baichengfu_%s_%s_%s";


    public static String encodeBase64File(String path) {
        File file = new File(path);
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            return new BASE64Encoder().encode(buffer);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 生成文件名
     *
     * @param suffix 后缀
     * @return
     */
    public static String buildFileName(String suffix) {
        String dateStr = DateUtil.toString(new Date(), "yyyyMMddHHmmss");
        String fileName = String.format(FILE_NAME_FORMAT_STRING,
                dateStr,
                EncrUtil.getMd5Code(UUID.randomUUID().toString()
                ), suffix
        );
        return fileName;
    }

    /**
     * 文件写入
     *
     * @param inputStream 输入流
     * @param rootPath    根路径
     * @param fileName    文件名
     * @return
     * @author: dengshuai
     * @date: Created in 11:28 2018/1/22
     * @modified: by autor in 11:28 2018/1/22
     */
    public static String fileWrite(InputStream inputStream, String rootPath, String fileName) {

        String path = null;
        OutputStream output = null;
        if (inputStream == null) {
            return null;
        }
        // 文件写入;
        try {
            // 创建上传之后的文件路径;
            File temp = new File(rootPath, fileName);
            //文件或目录是否存在
            if (!temp.exists()) {
                temp.getParentFile().mkdirs();
            }
            temp.createNewFile();
            output = new FileOutputStream(temp);
            int byteRead = 0;
            // 1M;
            byte[] buffer = new byte[1024];
            while ((byteRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, byteRead);
            }
            output.flush();
            path = temp.getPath();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!EmptyUtil.isEmpty(path)) {
            path = path.replaceAll("\\\\", "/");
        }
        return path;
    }

    /**
     * base64字符串转输入流
     *
     * @param base64Str
     * @return
     */
    public static InputStream base64ToInputString(String base64Str) {
        ByteArrayInputStream stream = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(base64Str);
            stream = new ByteArrayInputStream(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return stream;
        }
    }

    /**
     * 输入流转base64字符串
     *
     * @param inputStream
     * @return
     */
    public static String inputToBase64(InputStream inputStream) {
        String str = null;
        try {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
            BASE64Encoder encoder = new BASE64Encoder();
            str = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return str;
        }

    }


    /**
     * <p>Title: thumbnailImage</p>
     * <p>Description: 根据图片路径生成缩略图 </p>
     *
     * @param imagePath 原图片路径
     * @param w         缩略图宽
     * @param h         缩略图高
     * @param prevfix   生成缩略图的前缀
     * @param force     是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
     */
    public static String thumbnailImage(String imagePath, int w, int h, String prevfix, boolean force) {
        File imgFile = new File(imagePath);
        if (imgFile.exists()) {
            try {
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames());
                String suffix = null;
                // 获取图片后缀
                if (imgFile.getName().indexOf(".") > -1) {
                    suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
                }// 类型和图片后缀全部小写，然后判断后缀是否合法
                if (suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0) {
                    LogUtil.errorLog(FileUtil.class, "Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                    return null;
                }
                LogUtil.debugLog(FileUtil.class, "target image's size, width:{" + w + "}, height:{" + h + "}.");
                Image img = ImageIO.read(imgFile);
                if (!force) {
                    // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if ((width * 1.0) / w < (height * 1.0) / h) {
                        if (width > w) {
                            h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w / (width * 1.0)));
                            LogUtil.debugLog(FileUtil.class, "change image's size, width:{" + w + "}, height:{" + h + "}.");
                        }
                    } else {
                        if (height > h) {
                            w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h / (height * 1.0)));
                            LogUtil.debugLog(FileUtil.class, "change image's size, width:{" + w + "}, height:{" + h + "}.");
                        }
                    }
                }
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                g.dispose();
                String p = imgFile.getPath();
                // 将图片保存在原目录并加上前缀
                ImageIO.write(bi, suffix, new File(p.substring(0, p.lastIndexOf(File.separator)) + File.separator + prevfix + imgFile.getName()));
                LogUtil.debugLog(FileUtil.class, "缩略图在原路径下生成成功");
                return p.substring(0, p.lastIndexOf(File.separator)) + File.separator + prevfix + imgFile.getName();
            } catch (IOException e) {
                LogUtil.debugLog(FileUtil.class, "generate thumbnail image failed.");
            }
        } else {
            LogUtil.debugLog(FileUtil.class, "the image is not exist.");
            return null;
        }
        return null;
    }

    /**
     * 说明： 将文件内容转为字符串
     *
     * @author: ChenPeiLong
     * @date: Created in 10:43 2019/3/12
     * @modified: by ChenPeiLong in 10:43 2019/3/12
     */
    public static String FileToString(File file) {
        StringBuffer buffer = new StringBuffer();
        try {
            InputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line; // 用来保存每行读取的内容
            line = reader.readLine(); // 读取第一行
            while (line != null) { // 如果 line 为空说明读完了
                buffer.append(line); // 将读到的内容添加到 buffer 中
                line = reader.readLine(); // 读取下一行
            }
            reader.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }


    /**
     * 说明： 将文件压缩成zip
     * @author: ChenPeiLong
     * @date: Created in 9:30 2019/4/11
     * @modified: by ChenPeiLong in 9:30 2019/4/11
     * @param filePath 待压缩的文件路径
     * @param zipPath 压缩文件存放路径
     * @return 压缩后的文件
     *
     */
    public static File toZip(String filePath,String zipPath) throws IOException {
        File target = null;
        File source = new File(filePath);
        if (source.exists()) {
            // 压缩文件名=源文件名.zip
//            String zipName = source.getName() + ".zip";
            target = new File(zipPath);
            if (target.exists()) {
                target.delete(); // 删除旧的文件
            }else{
                target.getParentFile().mkdirs();
            }
            FileOutputStream fos = null;
            ZipOutputStream zos = null;
            try {
                fos = new FileOutputStream(target);
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                // 添加对应的文件Entry
                addEntry("/", source, zos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                zos.close();
                fos.close();
            }
        }
        return target;
    }


    /**
     * 扫描添加文件Entry
     * @param base   基路径
     * @param source 源文件
     * @param zos    Zip文件输出流
     * @throws IOException
     */
    private static void addEntry(String base, File source, ZipOutputStream zos)
            throws IOException {
        // 按目录分级，形如：/aaa/bbb.txt
        String entry = base + source.getName();
        if (source.isDirectory()) {
            for (File file : source.listFiles()) {
                // 递归列出目录下的所有文件，添加文件Entry
                addEntry(entry + "/", file, zos);
            }
        } else {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                byte[] buffer = new byte[1024 * 10];
                fis = new FileInputStream(source);
                bis = new BufferedInputStream(fis, buffer.length);
                int read = 0;
                zos.putNextEntry(new ZipEntry(entry));
                while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
                    zos.write(buffer, 0, read);
                }
                zos.closeEntry();
            } finally {
                bis.close();
                fis.close();
            }
        }
    }

    /**
     * 说明：删除目录
     * @author: ChenPeiLong
     * @date: Created in 16:26 2019/4/11
     * @modified: by ChenPeiLong in 16:26 2019/4/11
     */

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        if(dir.delete()) {
            LogUtil.debugLog(dir,"删除成功:"+dir.getAbsolutePath());
            return true;
        } else {
            LogUtil.errorLog(dir,"删除失败:"+dir.getAbsolutePath());
            return false;
        }
    }
}
