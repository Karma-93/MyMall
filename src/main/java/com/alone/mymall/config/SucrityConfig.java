package com.alone.mymall.config;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringSucrityConfig配置
 */
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SucrityConfig extends WebSecurityConfigurerAdapter{
    
}   