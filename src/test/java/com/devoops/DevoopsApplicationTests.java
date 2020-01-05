package com.devoops;

import com.devoops.domain.CustUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class DevoopsApplicationTests {

    @Test
    void contextLoads() {
        CustUser custUser = new CustUser();
        custUser.setEmail("a");

    }

}
