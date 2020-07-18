package com.book.config;
import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@EnableWebSecurity
@Configuration
@EntityScan("com.book.*")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(etagFilter());
	    registration.addUrlPatterns("/api/*");
	    registration.setName("ETag");
	    registration.setOrder(1);
	    return registration;
	}
	@Bean(name = "ETag")
	    public Filter etagFilter() {
	    return new ShallowEtagHeaderFilter();
	}
}
