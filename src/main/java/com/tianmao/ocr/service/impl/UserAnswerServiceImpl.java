package com.tianmao.ocr.service.impl;

import com.tianmao.ocr.dataObject.UserAnswer;
import com.tianmao.ocr.repository.UserAnswerRepository;
import com.tianmao.ocr.service.UserAnswerService;
import com.tianmao.ocr.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserAnswerRepository userAnswerRepository;
    @Override
    public Page<UserAnswer> getAnswerByUserId(String userId, Pageable pageable) {
        return userAnswerRepository.findByUserId(userId,pageable);
    }

    @Override
    public Page<UserAnswer> getAnswer(Pageable pageable) {
        return userAnswerRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void deleteAnswer(Integer answerId) {
        userAnswerRepository.deleteByUserId(answerId);
    }
}
