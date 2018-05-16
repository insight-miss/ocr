package com.tianmao.ocr.service;

import com.tianmao.ocr.dataObject.UserAnswer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserAnswerService {

    /**
     * 查询指定用户记录
     * @param userId
     * @param pageable
     * @return
     */
    Page<UserAnswer> getAnswerByUserId(String userId, Pageable pageable);

    /**
     * 查询所有用户记录
     * @param pageable
     * @return
     */
    Page<UserAnswer> getAnswer(Pageable pageable);

    /**
     * 删除记录
     * @param answerId
     */
    void deleteAnswer(Integer answerId);
}
