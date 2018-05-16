package com.tianmao.ocr.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class UserInfo {
    @Id
    private String userId;

    private String userName;

    private String userSex;

    private Integer userAge;

    private String userImage;

    private Date userBirth;

    private String userAdmin;

    private String userSignature;

    private Date createTime;

    private Date updateTime;
}
