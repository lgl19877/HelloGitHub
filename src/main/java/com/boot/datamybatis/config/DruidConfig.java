package com.boot.datamybatis.config ;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    /**
     * 配置Druid监控
     *   1 配置一个管理后台的Servlet
     *   2 配置一个监控的Fiter
     *   进入管理后台: http://localhost:8080/druid/index.html
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // StatViewServlet
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        //只有localhost才能访问
        initParams.put("allow","localhost");
        //禁止192.168.43.17访问
        initParams.put("deny","192.168.43.17");
        servletRegistrationBean.setInitParameters(initParams);
        return  servletRegistrationBean;
    }
    //  2 配置一个监控的Fiter
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new WebStatFilter());
        Map<String, String> initParam = new HashMap<>();
        //对于静态资源放行不拦截
        initParam.put("exclusions","*.js,*.css,/druid/*");
        filterBean.setInitParameters(initParam );
        //拦截所有请求
        filterBean.setUrlPatterns(Arrays.asList("/*"));
        return  filterBean;
    }

}
