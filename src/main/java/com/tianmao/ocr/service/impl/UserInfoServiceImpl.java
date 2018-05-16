package com.tianmao.ocr.service.impl;

import com.tianmao.ocr.dataObject.History;
import com.tianmao.ocr.dataObject.UserInfo;
import com.tianmao.ocr.repository.HistoryRepository;
import com.tianmao.ocr.repository.UserInfoRepository;
import com.tianmao.ocr.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public UserInfo findById(String userId) {
        return repository.getById(userId);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return repository.save(userInfo);
    }

    @Override
    @Transactional
    public void deleteById(String userId) {
         repository.deleteByUserId(userId);
    }

    @Override
    public Page<History> findHistory(String userId, Pageable pageable) {
        Page<History> historyPage = historyRepository.findByUserId(userId,pageable);
        return historyPage;
    }
}
