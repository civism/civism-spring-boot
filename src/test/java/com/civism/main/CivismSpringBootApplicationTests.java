package com.civism.main;

import com.civism.model.UserDo;
import com.civism.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CivismSpringBootApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
        UserDo load = userService.load(1046);
        System.out.println(load);
        if (load != null) {
            System.out.println(load.getId());
            System.out.println(load.getUserName());
            System.out.println(load.getPassword());
        }
    }

}

