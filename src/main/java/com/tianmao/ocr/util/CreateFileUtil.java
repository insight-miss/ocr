package com.tianmao.ocr.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangbiao-019 on 2018/4/8.
 */
public class CreateFileUtil {
    private final static Logger logger = LoggerFactory.getLogger(CreateFileUtil.class);
    public static String KEY_FLAG = "flag";
    public static String KEY_TEXT = "text";
    public static String KEY_NAME = "name";

    //1.创建文件
    public static Map<String, Object> createFile(String destFileName) {
        logger.info("文件路径为=" + destFileName);
        Map<String, Object> map = new HashMap<String, Object>();
        File file = new File(destFileName);
        if(file.exists()) {
            map.put(KEY_FLAG, true);
            map.put(KEY_NAME, file.getName());
            map.put(KEY_TEXT,"创建单个文件" + destFileName + "失败，目标文件已经存在！");
            return map;
        }
        if (destFileName.endsWith(File.separator)) {
            logger.info("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
            map.put(KEY_FLAG, false);
            map.put(KEY_NAME, null);
            map.put(KEY_TEXT,"创建单个文件" + destFileName + "失败，目标文件不能为目录！");
            return map;
        }
        //判断目标文件所在的目录是否存在
        if(!file.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            logger.info("目标文件所在目录不存在，准备创建它！");
            if(!file.getParentFile().mkdirs()) {
                logger.info("创建目标文件所在目录失败！");
                map.put(KEY_FLAG, false);
                map.put(KEY_NAME, null);
                map.put(KEY_TEXT,"创建目标文件所在目录失败！");
                return map;
            }
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                logger.info("创建单个文件" + destFileName + "成功！");
                map.put(KEY_FLAG, true);
                map.put(KEY_NAME, file);
                map.put(KEY_TEXT,"创建单个文件" + destFileName + "成功！");
                return map;
            } else {
                logger.info("创建单个文件" + destFileName + "失败！");
                map.put(KEY_FLAG, false);
                map.put(KEY_NAME, null);
                map.put(KEY_TEXT,"创建单个文件" + destFileName + "失败！");
                return map;
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("创建单个文件" + destFileName + "失败！" + e.getMessage());
            map.put(KEY_FLAG, false);
            map.put(KEY_NAME, null);
            map.put(KEY_TEXT,"创建单个文件" + destFileName + "失败！" + e.getMessage());
            return map;
        }
    }

    //2.创建目录
    public static Map<String, Object> createDir(String destDirName) {
        Map<String, Object> map = new HashMap<String, Object>();
        File dir = new File(destDirName);
        if (dir.exists()) {
            map.put(KEY_FLAG, true);
            map.put(KEY_NAME, dir);
            map.put(KEY_TEXT,"目录已存在！");
            return map;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            logger.info("创建目录" + destDirName + "成功！");
            map.put(KEY_FLAG, true);
            map.put(KEY_NAME, dir);
            map.put(KEY_TEXT,"创建目录" + destDirName + "成功！");
            return map;
        } else {
            logger.info("创建目录" + destDirName + "失败！");
            map.put(KEY_FLAG, false);
            map.put(KEY_NAME, dir);
            map.put(KEY_TEXT,"创建目录" + destDirName + "失败！");
            return map;
        }
    }

    //3.创建临时文件
    public static String createTempFile(String prefix, String suffix, String dirName) {
        File tempFile = null;
        if (dirName == null || "".endsWith(dirName)) {
            try{
                //在默认文件夹下创建临时文件
                tempFile = File.createTempFile(prefix, suffix);
                logger.error("在默认创建临时文件成功！");
                //返回临时文件的路径
                return tempFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("创建临时文件失败！" + e.getMessage());
                return null;
            }
        } else {
            File dir = new File(dirName);
            //如果临时文件所在目录不存在，首先创建
            if (!dir.exists()) {
                if (!(boolean)CreateFileUtil.createDir(dirName).get(KEY_FLAG)) {
                    logger.info("创建临时文件失败，不能创建临时文件所在的目录！");
                    return null;
                }
            }
            try {
                //在指定目录下创建临时文件
                tempFile = File.createTempFile(prefix, suffix, dir);
                return tempFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("创建临时文件失败！" + e.getMessage());
                return null;
            }
        }
    }
}