package com.devoops;

<<<<<<< HEAD
=======
import com.devoops.domain.CustUser;
import com.devoops.repository.CustUserDAO;
>>>>>>> branch 'master' of https://github.com/kbh0581/OopsProject.git
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest

class DevoopsApplicationTests {

    @Autowired
    CustUserDAO custUserDAO;

    @Test
    void contextLoads() {
<<<<<<< HEAD
=======

        CustUser custUser = CustUser.builder().userId("zinzo").userPw("aaa").build();




>>>>>>> branch 'master' of https://github.com/kbh0581/OopsProject.git
    }

}
