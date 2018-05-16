package com.tianmao.ocr.service.impl;

import com.tianmao.ocr.dataObject.History;
import com.tianmao.ocr.repository.HistoryRepository;
import com.tianmao.ocr.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<History> getHistory(String userId) {
        return historyRepository.getById(userId);
    }

    @Override
    @Transactional
    public void deleteHistory(Integer historyId) {
        historyRepository.deleteByHistoryId(historyId);
    }
}
