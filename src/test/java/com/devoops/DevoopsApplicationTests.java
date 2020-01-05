package com.devoops;

import com.devoops.domain.CustUser;
import com.devoops.repository.CustUserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest

class DevoopsApplicationTests {

    @Autowired
    CustUserDAO custUserDAO;

    @Test
    void contextLoads() {

        CustUser custUser = CustUser.builder().userId("zinzo").userPw("aaa").build();




    }

}
