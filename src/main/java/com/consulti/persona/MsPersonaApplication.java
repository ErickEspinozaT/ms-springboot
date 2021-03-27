package com.consulti.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

@ComponentScan({ "com.consulti" })
@SpringBootApplication
public class MsPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPersonaApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<DispatcherServlet> dispatcherServletServletRegistrationBean(
			DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean<DispatcherServlet> bean = new ServletRegistrationBean<DispatcherServlet>(dispatcherServlet,
				"/persona/*");
		bean.setAsyncSupported(true);
		bean.setName("persona");
		bean.setLoadOnStartup(1);
		return bean;
	}
}
