package com.liucccc.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liucccc
 * @date 2019/11/9 23:47
 */
@Configuration
@MapperScan({"com.liucccc.mall.mbg.mapper","com.liucccc.mall.mapper"})
public class MyBatisConfig {
}
