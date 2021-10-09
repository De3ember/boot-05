package com.zwy.boot05;

import com.zwy.boot05.bean.User;
import com.zwy.boot05.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
@Slf4j
@SpringBootTest
class Boot05ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserMapper userMapper;


    @Test
    void contextLoads() {
//        Long aslong=jdbcTemplate.queryForObject("select count(*) from orders",Long.class);
//        log.info("总数{}",aslong);


    }
    @Test
    void testUserMapper(){
        User user=userMapper.selectById(1L);
        log.info("用户信息{}",user);

    }

}
