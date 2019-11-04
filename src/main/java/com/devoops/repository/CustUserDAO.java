package com.devoops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devoops.domain.CustUser;

public interface CustUserDAO extends JpaRepository<CustUser, String> {

}
