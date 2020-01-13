package com.devoops.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import utils.DateUtils;
import utils.StringUtils;


@NoArgsConstructor
@Getter
public class BaseVO {

    private String regUserId;
    private Date regDt;
    private String updUserId;
    private Date updDt;

    public void setRegUserId(String regUserId) {
        if(StringUtils.isEmpty(regUserId)) {
            //여기다가 비어있으면 loginSession ID 넣어준다...
        }

        this.regUserId = regUserId;
    }

    public void setRegDt(Date regDt) {
        if(regDt == null) {
            regDt = DateUtils.getTimeStamp();
        }

        this.regDt = regDt;
    }

    public void setUpdUserId(String updUserId) {
        if(StringUtils.isEmpty(updUserId)) {
            //여기다가 비어있으면 loginSession ID 넣어준다…
        }
        this.updUserId = updUserId;
    }

    public void setUpdDt(Date updDt) {
        if(updDt == null) {
            updDt = DateUtils.getTimeStamp();
        }

        this.updDt = updDt;
    }
}