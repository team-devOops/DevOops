package com.devoops.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.devoops.component.BaseComponent;

import lombok.Getter;
import utils.DateUtils;
import utils.StringUtils;

@MappedSuperclass
@Getter
public abstract class BaseVO extends BaseComponent {

    private String regUserId;
    private Date regDt;
    private String updUserId;
    private Date updDt;

    public void setRegUserId(String regUserId) {
        if(StringUtils.isEmpty(regUserId)) {
        	regUserId = loginSession.getCustInfo().getUserId();
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
        	updUserId = loginSession.getCustInfo().getUserId();
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