package com.ryoua.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author ryoua Created on 2019-04-22
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {
    public final static String SESSION_KEY = "user";
}
