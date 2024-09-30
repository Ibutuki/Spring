package com.edu.seiryo.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.edu.seiryo.interceptor.LoginHandlerInterceptor;

public class MyConfig implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/index.html","/","/user/login","/js/**","/css/**","/img/**");
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	 // 获取 properties 传递过来的值进行判断
	@Bean
	 public MessageSource messageSource(MessageSourceProperties properties) {
	 ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	 if (StringUtils.hasText(properties.getBasename())) {
	 // 设置国际化文件的基础名（去掉语言国家代码的）
	messageSource.setBasenames(
	 StringUtils.commaDelimitedListToStringArray(
	 StringUtils.trimAllWhitespace(properties.getBasename())));
	 }
	 if (properties.getEncoding() != null) {
	 messageSource.setDefaultEncoding(properties.getEncoding().name());
	 }
	 messageSource.setFallbackToSystemLocale(properties.isFallbackToSystemLocale
	 ());
	 Duration cacheDuration = properties.getCacheDuration();
	 if (cacheDuration != null) {
	 }
	 messageSource.setCacheMillis(cacheDuration.toMillis());
	 messageSource.setAlwaysUseMessageFormat(properties.isAlwaysUseMessageFormat
	 ());
	 messageSource.setUseCodeAsDefaultMessage(properties.isUseCodeAsDefaultMessage());
	 return messageSource;
	 }
	
}
