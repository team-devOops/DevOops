package com.devoops.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.DateUtils;
import utils.StringUtils;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@MappedSuperclass
@Getter
public abstract class BaseBoardVO {

    @ManyToOne //단방향 맵핑
    @JoinColumn(name = "regUserId")
    @Setter
    private CustUser regUser;

    @ManyToOne
    @JoinColumn(name = "updUserId")
    @Setter
    private CustUser updUser;

    private Date regDt;
    private Date updDt;


    BaseBoardVO(){
        this.regDt = DateUtils.getTimeStamp();

    }


    public void setRegDt(Date regDt) {
        if(regDt.equals(null)) {
            regDt = DateUtils.getTimeStamp();
        }

        this.regDt = regDt;
    }

    public void setUpdDt(Date updDt) {
        if(updDt == null) {
            updDt = DateUtils.getTimeStamp();
        }

        this.updDt = updDt;
    }
}