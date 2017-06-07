package com.dudu.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 使用springboot自带的tomcat,多个包名之间使用，隔开*/
@SpringBootApplication(scanBasePackages={"com.dudu"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
/*
 * 打成外部的war包运性
 * public class Application extends SpringBootServletInitializer {
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(Application.class, args);
	    }
}*/
