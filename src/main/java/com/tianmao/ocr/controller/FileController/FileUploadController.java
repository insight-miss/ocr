package com.tianmao.ocr.controller.FileController;

import com.tianmao.ocr.dataObject.History;
import com.tianmao.ocr.dto.ResultDTO;
import com.tianmao.ocr.service.HistoryService;
import com.tianmao.ocr.service.OcrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.soap.Addressing;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@Slf4j
@Api(tags = "文件下载")
public class FileUploadController {

    @Autowired
    private OcrService ocrService;

    /**
     * 文件存放位置
     */
    @Value("${web.upload-path}")
    private String path;

    @ApiOperation(value="访问主页")
    @GetMapping("index")
    public ModelAndView index(Map<String,Object> map) {
        map.put("url","/image/27ccddd1-f176-4f91-b6ce-127a25968662.png");
        log.info("访问主页");
        return new ModelAndView("index",map);
    }

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="单文件下载")
    @ApiImplicitParam(name = "file", value = "文件信息", dataType = "MultipartFile")
    public List<ResultDTO> upload(@RequestParam("lemonFile") MultipartFile file) {

        List<ResultDTO> resultDTOList = new ArrayList<>();

        log.info("文件上传方法访问成功");
        if (file.isEmpty()) {
            return resultDTOList;
        }
        // 获取文件名
        String originalFilename = file.getOriginalFilename();
        log.info("上传文件的文件名是：" + originalFilename);

        // 获取文件后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        log.info("上传文件的后缀名是：" + suffixName);

        // 设置文件上传绝对路径
        String filePath = path;

        // 获取UUID名称
        String fileName = UUID.randomUUID() + suffixName;

        // 获取上传文件的File对象
        File dest = new File(filePath + fileName);

        // 开始上传
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            resultDTOList = ocrService.FilePath(path);
            log.info("上传成功");
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return resultDTOList;
    }


}
