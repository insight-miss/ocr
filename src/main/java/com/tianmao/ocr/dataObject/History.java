package com.tianmao.ocr.dataObject;

import io.swagger.models.auth.In;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class History {

    @Id
    @GeneratedValue
    private Integer historyId;

    private String userId;

    private String historyInfo;

    private String imageInfo;

    private Date createTime;

    private Date updateTime;
}
