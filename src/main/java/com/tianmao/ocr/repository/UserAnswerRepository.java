package com.tianmao.ocr.repository;

import com.tianmao.ocr.dataObject.UserAnswer;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer,Integer> {

    Page<UserAnswer> findByUserId(String userId,Pageable pageable);

    @Modifying
    @Query("delete from UserAnswer where answerId = :id")
    void deleteByUserId(@Param("id") Integer answerId);
}
