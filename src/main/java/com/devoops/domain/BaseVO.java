package com.devoops.domain;

import java.util.Date;

import org.springframework.stereotype.Component;



@Component("baseVO")
public class BaseVO {

    private String regUserId;
    private Date regDt;
    private String updUserId;
    private Date updDt;

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        if(StringUtils.isEmpty(regUserId)) {
            //여기다가 비어있으면 loginSession ID 넣어준다...
        }

        this.regUserId = regUserId;
    }

    public Date getRegDt() {
        return regDt;
    }

    public void setRegDt(Date regDt) {
        if(regDt == null) {
            regDt = DateUtils.getTimeStamp();
        }

        this.regDt = regDt;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        if(StringUtils.isEmpty(updUserId)) {
            //여기다가 비어있으면 loginSession ID 넣어준다…
        }
        this.updUserId = updUserId;
    }

    public Date getUpdDt() {
        return updDt;
    }

    public void setUpdDt(Date updDt) {
        if(updDt == null) {
            updDt = DateUtils.getTimeStamp();
        }

        this.updDt = updDt;
    }
}