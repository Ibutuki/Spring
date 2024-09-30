package com.edu.seiryo;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class DruidConfig {
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
	@Bean
    public ServletRegistrationBean staViewServlet() {
    	ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),
    			"/druid/*");
    	Map<String,String> initParams = new HashMap<>();
    	initParams.put("loginUsername", "123"); 
    	initParams.put("loginPassword", "123456");
    	initParams.put("allow", "");
    	bean.setInitParameters(initParams);
    	return bean;
    }
}
