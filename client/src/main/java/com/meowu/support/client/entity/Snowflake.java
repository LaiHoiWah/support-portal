package com.meowu.support.client.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Snowflake{

    private String  id;
    private String  applicationName;
    private String  ip;
    private Integer port;
    private Long    centerId;
    private Long    workerId;
    private Long    timeGen;
    private Date    createTime;
    private Date    updateTime;
}
