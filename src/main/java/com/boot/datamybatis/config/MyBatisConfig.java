package com.boot.datamybatis.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 数据库字段和Model字段映射不上(注解版)
 *    自定义MyBatis配置规则
 *    开启驼峰命名
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
      return  new ConfigurationCustomizer(){
           @Override
           public void customize(org.apache.ibatis.session.Configuration configuration) {
               configuration.setMapUnderscoreToCamelCase(true);
           }
       };
    }
}
