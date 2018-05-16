package com.tianmao.ocr.controller.TestController;

import com.tianmao.ocr.dto.ResultDTO;
import com.tianmao.ocr.service.OcrService;
import com.tianmao.ocr.util.WebFileUtil;
import com.tianmao.ocr.vo.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.core.support.RepositoryFragment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbiao-019 on 2018/4/12.
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadTestController {

    @Autowired
    private OcrService ocrService;
    private static final Logger logger = LoggerFactory.getLogger(FileUploadTestController.class);

    @Value("${web.upload-path}")
    private String SAVE_PATH;

    @RequestMapping("/sigin")
    public String sigin() {
        return "/file/fileupload";
    }

    @PostMapping("/filesupload")
    @ResponseBody
    public List<ResultDTO> uploadFiles(@RequestParam(value = "files", required = false)MultipartFile mpf){
        logger.info("[进入了文件上传处理方法]");
        List<ResultDTO> resultDTOList = new ArrayList<>();
        boolean flag = false;
        if(mpf != null){
            flag = WebFileUtil.saveFile(mpf, SAVE_PATH, mpf.getOriginalFilename());
        }
        resultDTOList = ocrService.FilePath(SAVE_PATH);
        return resultDTOList;
    }
}