package com.lhyzp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//tomcat部署.. extends SpringBootServletInitializer
//	@Override
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//      return application.sources(Application.class);
//  }
}
