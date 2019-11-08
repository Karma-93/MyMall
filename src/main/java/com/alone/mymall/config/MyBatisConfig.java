package com.alone.mymall.config;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Mybatis配置文件
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.alone.mymall.mbg.mapper.mapper")
public class MyBatisConfig {
}
