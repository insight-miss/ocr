package com.tianmao.ocr.service.impl;

import com.tianmao.ocr.dataObject.History;
import com.tianmao.ocr.service.HistoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HistoryServiceImplTest {

    @Autowired
    private HistoryService historyService;

    @Test
    public void getHistory() {
        List<History> historyList = historyService.getHistory("123456");
        log.info(historyList.toString());
    }

    @Test
    public void deleteHistory() {
        historyService.deleteHistory(4);
    }
}