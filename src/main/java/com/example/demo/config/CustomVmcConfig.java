package com.example.demo.config;

import com.example.demo.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 配置首页视图
 */
@Configuration
public class CustomVmcConfig extends WebMvcConfigurerAdapter {


    // 设置首页位置，默认访问 public/index.html 没有经过模板引擎处理
    @Bean
    public WebMvcConfigurerAdapter CustomVmcConfig() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }
        };

        return adapter;
    }

    @Bean
    public MyLocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
