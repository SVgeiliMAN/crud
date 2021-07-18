package com.datatang.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("com.datatang.provider.mapper")
public class ProviderApplication {



    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
