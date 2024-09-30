package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@SpringBootTest
class SpringbootL2ApplicationTests {
	@Autowired
	DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
    	System.out.println(dataSource.getClass());
    	Connection connection = dataSource.getConnection();
    	System.out.println(connection);
    	DruidDataSource druidDataSource = (DruidDataSource) dataSource;
    	System.out.println("druidDataSource 数据源最大连接数：" +
    			druidDataSource.getMaxActive());
		System.out.println("druidDataSource 数据源初始化连接数：" +
				druidDataSource.getInitialSize());
    	connection.close();
    }
    @Bean
    public FilterRegistrationBean webStatFilter() {
	    FilterRegistrationBean bean = new FilterRegistrationBean();
	    bean.setFilter(new WebStatFilter());
	    //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
	    Map<String, String> initParams = new HashMap<>();
	    initParams.put("exclusions", "*.js,*.css,/druid/*,/jdbc/*");
	    bean.setInitParameters(initParams);
	    //"/*" 表示过滤所有请求
	    bean.setUrlPatterns(Arrays.asList("/*"));
	    return bean;
    }
}
