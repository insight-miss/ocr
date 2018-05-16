package com.tianmao.ocr.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate

public class UserAnswer {

    @Id
    @GeneratedValue
    private Integer answerId;

    private String userId;

    /**
     * 用户问题
     */
    private String answerQuestion;

    /**
     * 管理员回答问题
     */
    private String answerInfo;

    private Date createTime;

    private Date updateTime;
}
