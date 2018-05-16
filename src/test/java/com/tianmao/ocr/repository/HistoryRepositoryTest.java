package com.tianmao.ocr.repository;

import com.tianmao.ocr.dataObject.History;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PrivateKey;
import java.util.PrimitiveIterator;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryRepositoryTest {

    @Autowired
    private HistoryRepository historyRepository;
    @Test
    public void getById() {
        History history = new History();
        history.setUserId("123456");
        history.setHistoryInfo("ts");
        history.setImageInfo("localhost:/image/test.jpg");
        historyRepository.save(history);
    }

    @Test
    public void deleteByHistoryId() {
    }

    @Test
    public void findByUserId() {
    }
}