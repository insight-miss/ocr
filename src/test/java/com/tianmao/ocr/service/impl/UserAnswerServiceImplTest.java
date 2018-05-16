package com.tianmao.ocr.service.impl;

import com.tianmao.ocr.dataObject.UserAnswer;
import com.tianmao.ocr.repository.UserAnswerRepository;
import com.tianmao.ocr.service.UserAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserAnswerServiceImplTest {

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    @Test
    public void getAnswerByUserId() {
        PageRequest request = new PageRequest(0,2);

        Page<UserAnswer> userAnswerPage =  userAnswerService.getAnswerByUserId("123456",request);
        List<UserAnswer> list = userAnswerPage.getContent();
        list.stream()
                .forEach(System.out::println);
        log.info(userAnswerPage.toString());
        Assert.assertNotEquals(0,userAnswerPage.getTotalElements());
    }

    @Test
    public void getAnswer() {
        PageRequest request = new PageRequest(0,2);

        Page<UserAnswer> userAnswerPage =  userAnswerService.getAnswer(request);

        log.info(userAnswerPage.toString());
        Assert.assertNotEquals(0,userAnswerPage.getTotalElements());
    }

    @Test
    public void deleteAnswer() {

        userAnswerService.deleteAnswer(6);
    }

    @Test
    public void saveTest() {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserId("234567");
        userAnswer.setAnswerQuestion("李翔是");
        userAnswer.setAnswerInfo("偷电瓶车");

        userAnswerRepository.save(userAnswer);
    }
}