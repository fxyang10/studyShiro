package com.dudu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * webmvc常用的配置
 * @author fxyang 
 *
 */
@Configuration
public class ResoucesConfigAdapt  extends WebMvcConfigurerAdapter {
	
	/* 自定义资源映射addResourceHandlers，静态资源的访问路径默认的为。/static下面的
	 * 
	 * */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");;
		super.addResourceHandlers(registry);
	}
	/**
	 * 自定义不需要经过controller直接可以访问的页面
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		String path = "toLogin";
		String viewName = "login.html";
		registry.addViewController(path).setViewName(viewName);
		super.addViewControllers(registry);
	}
	
}
