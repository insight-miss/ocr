package com.tianmao.ocr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultDTO {

    @JsonProperty("企业名称")
    private String name;

    @JsonProperty("企业注册号")
    private String number;
}
