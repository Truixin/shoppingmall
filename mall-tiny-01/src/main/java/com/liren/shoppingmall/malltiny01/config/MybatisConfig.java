package com.liren.shoppingmall.malltiny01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @description: @MapperScan注解只会扫描包中的接口
 * @author: tianruixin
 * @date: 2020/4/16 0:52
 */

@Configuration
@MapperScan("com.liren.shoppingmall.malltiny01.mbg.dao")
public class MybatisConfig {
}
