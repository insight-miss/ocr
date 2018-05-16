package com.tianmao.ocr.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by wangbiao-019 on 2018/4/8.
 */
public class WebFileUtil {
    private final static Logger logger = LoggerFactory.getLogger(WebFileUtil.class);

    /**
     * 保存上传的文件
     * @param uploadFile 上传的文件
     * @param destPath 路径
     * @param fileName 文件名称
     * @return true|false
     */
    public static boolean saveFile(MultipartFile uploadFile, String destPath, String fileName) {
        logger.info(fileName);
        String trueFileName = KeyUtil.genUniqueKey()+fileName;
        Map<String, Object> map = CreateFileUtil.createFile(destPath + File.separator  + trueFileName);

        logger.info("[创建文件目录成功/保存至服务器]");
        //保存文件
        try {
            uploadFile.transferTo((File)map.get(CreateFileUtil.KEY_NAME));
            logger.info("[保存成功/保存至服务器]");
            return true;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return false;
        }
    }
}