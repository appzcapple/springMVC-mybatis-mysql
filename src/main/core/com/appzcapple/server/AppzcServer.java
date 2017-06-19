package com.appzcapple.server;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.eclipse.jdt.core.compiler.IProblem;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.appzcapple.models.Car;



public class AppzcServer implements ServletContextListener {
	
	private static AppzcServer instance;
	
	public static AppzcServer getInstance(){
		return instance;
	}
	
	private File webRootDirectory;
	
	private String ip;
	
	private String contextPath;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		instance = this;
		
		ServletContext servletContext = event.getServletContext();
		instance.webRootDirectory = new File(servletContext.getRealPath("/"));
		instance.contextPath = servletContext.getContextPath();
		
		try {
			InetAddress iAddress = InetAddress.getLocalHost();
			instance.ip = iAddress.getHostAddress();
		} catch (UnknownHostException e){
			instance.ip = "127.0.0.1";
		}
		
		initModules();
	} 
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void initModules(){
		final ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		Car car = (Car) applicationContext.getBean("catModel");
		
		System.out.println("cat has color:" + car.getColor());
		
	}

}
