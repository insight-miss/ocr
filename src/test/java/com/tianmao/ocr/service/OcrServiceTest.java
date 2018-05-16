package com.tianmao.ocr.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OcrServiceTest {

    @Autowired
    private OcrService ocrService;

    @Value("${web.upload-path}")
    private String path;

    @Test
    public void tem() {
        long startTime = System.currentTimeMillis();
        ocrService.FilePath(path);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        long tim = endTime-startTime;
        log.info("耗时为：{}",tim/1000);

    }

}