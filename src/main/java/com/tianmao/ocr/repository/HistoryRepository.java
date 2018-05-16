package com.tianmao.ocr.repository;

import com.tianmao.ocr.dataObject.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Integer> {

    @Query("SELECT o from History o where o.userId = :id")
    List<History> getById(@Param("id") String orderId);

    @Modifying
    @Query("delete from History where historyId=:id")
    void deleteByHistoryId(@Param("id") Integer historyId);

    Page<History> findByUserId(String userId, Pageable pageable);
}
