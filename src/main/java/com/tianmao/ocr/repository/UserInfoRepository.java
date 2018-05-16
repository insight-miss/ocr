package com.tianmao.ocr.repository;

import com.tianmao.ocr.dataObject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    @Query("SELECT o from UserInfo o where o.userId = :id")
    UserInfo getById(@Param("id") String userId);

    @Modifying
    @Query("delete from UserInfo where userId = :id")
    void deleteByUserId(@Param("id") String userId);
}
