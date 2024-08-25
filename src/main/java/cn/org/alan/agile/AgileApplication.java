package cn.org.alan.agile;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.org.alan.agile.mapper")
public class AgileApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgileApplication.class, args);
    }
}