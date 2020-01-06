package com.devoops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devoops.domain.CustUser;
import org.springframework.data.jpa.repository.Query;

public interface CustUserDAO extends JpaRepository<CustUser, String> {

    public CustUser findByName(String name);
    public CustUser findByUserId(String userId);




}
