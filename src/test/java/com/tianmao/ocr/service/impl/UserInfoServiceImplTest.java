package com.tianmao.ocr.service.impl;

import com.tianmao.ocr.dataObject.History;
import com.tianmao.ocr.dataObject.UserInfo;
import com.tianmao.ocr.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void findById() {

        UserInfo userInfo = userInfoService.findById("123456");
        log.info(userInfo.toString());
    }

    @Test
    public void save() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("234567");
        userInfo.setUserAge(12);
        userInfo.setUserName("lx");
        userInfo.setUserSignature("");
        userInfo.setUserAdmin("adim");
        userInfo.setUserSex("男");

        UserInfo result = userInfoService.save(userInfo);

    }

    @Test
    public void delteTest() {
        userInfoService.deleteById("123456");
    }

    @Test
    public void historyTest() {
        PageRequest request = new PageRequest(0,2);

        Page<History> orderDTOPage =  userInfoService.findHistory("123456",request);
        log.info(orderDTOPage.toString());
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }
}