package com.ftq.webpage.config;

import com.ftq.webpage.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域，使用这种配置方法就不能在 interceptor 中再配置 header 了
        registry.addMapping("/**")
                .allowCredentials(true)
//                .allowedOrigins("http://47.104.188.61:8080")
                .allowedOrigins("http://127.0.0.1:8080")
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);
    }

    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/logout")
                .excludePathPatterns("/api/register");
    }

}
