package cn.lsj.security;

import cn.lsj.security.domain.User;
import cn.lsj.security.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void testPasswordEncoder() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }



}
