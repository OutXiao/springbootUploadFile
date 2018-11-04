package com.lzit.sprintboot2test.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author:wenfan
 * @description:
 * @data: 2018/11/3
 */
@Configuration
public class MvcConfigurer extends  WebMvcConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(MvcConfigurer.class);



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/api/**").excludePathPatterns("api/path/login");
    }
}
