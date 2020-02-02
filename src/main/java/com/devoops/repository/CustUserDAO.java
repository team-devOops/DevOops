package com.devoops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devoops.domain.CustUser;

public interface CustUserDAO extends JpaRepository<CustUser, String> {

    public CustUser findByName(String name);
    public CustUser findByUserId(String userId);

    public CustUser findByUserIdAndUserPwOrderByRegDtDesc(String userId, String userPw);
}
