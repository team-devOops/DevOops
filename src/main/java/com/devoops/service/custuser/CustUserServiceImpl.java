package com.devoops.service.custuser;

import com.devoops.domain.CustUser;
import com.devoops.repository.CustUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustUserServiceImpl implements CustUserService {

    @Autowired
    CustUserDAO custUserDAO;

    public void userSave(CustUser custuser) {
        custUserDAO.save(custuser);
    }
}

