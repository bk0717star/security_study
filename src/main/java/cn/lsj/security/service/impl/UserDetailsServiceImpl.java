package cn.lsj.security.service.impl;

import cn.lsj.security.domain.LoginUser;
import cn.lsj.security.domain.User;
import cn.lsj.security.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 取代 security 默认校验用户信息的实现类
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名从数据库中查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(wrapper);
        // 若用户名不存在，则抛出异常
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名获取密码错误");
        }
        // 若存在，则查询相关授权信息

        // 最后返回 UserDetails 接口的自定义实现类（内含用户对象）
        return new LoginUser(user);
    }
}
