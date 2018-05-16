package com.tianmao.ocr.service;

import com.tianmao.ocr.dataObject.History;

import java.util.List;

public interface HistoryService {

    /**
     * 通过用户id获取历史记录
     * @param userId
     * @return
     */
    List<History> getHistory(String userId);

    /**
     * 删除历史记录
     * @param historyId
     */
    void deleteHistory(Integer historyId);
}
