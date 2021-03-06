package cn.lsj.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lsj.security")
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
        System.out.println("master change");

        System.out.println("修改代码");
        System.out.println("....");
        System.out.println("*****");

        System.out.println("本地推送到远程");
        System.out.println("远程推送到本地");
    }


}
