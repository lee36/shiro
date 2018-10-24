package com.lee.shriotest.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public LifecycleBeanPostProcessor LifecycleBeanPostProcessor(){
       return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultWebSecurityManager sessionManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myReaml());
        return securityManager;
    }
    @Bean
    public MyReaml myReaml(){
        return new MyReaml();
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        Map<String,String> urls=new HashMap<>();
        factoryBean.setLoginUrl("http://www.baidu.com");
        urls.put("/login","anon");
        urls.put("/**","authc");
        factoryBean.setFilterChainDefinitionMap(urls);
        factoryBean.setSecurityManager(sessionManager());
        return factoryBean;
    }
}
