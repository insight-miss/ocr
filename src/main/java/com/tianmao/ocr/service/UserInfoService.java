package com.tianmao.ocr.service;

import com.tianmao.ocr.dataObject.History;
import com.tianmao.ocr.dataObject.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

public interface UserInfoService {

    /**
     * 根据id 查询用户信息
     * @param userId
     * @return
     */
    UserInfo findById(String userId);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    UserInfo save(UserInfo userInfo);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Transactional
    void deleteById(String userId);

    /**
     * 查看个人历史记录
     * @param userId
     * @param pageable
     * @return
     */
    Page<History> findHistory(String userId, Pageable pageable);
}
