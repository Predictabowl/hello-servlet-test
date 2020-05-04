package com.example.helloservlet.guicesetup;

import com.example.helloservlet.HelloWorldServlet;
import com.example.helloservlet.services.HelloNameService;
import com.example.helloservlet.services.HelloNameServiceImpl;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class MyGuiceServletConfig extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {

			@Override
			protected void configureServlets() {
				bind(HelloNameService.class).to(HelloNameServiceImpl.class);
				serve("/say-hello").with(HelloWorldServlet.class);
			}
		});
	}
	
}
