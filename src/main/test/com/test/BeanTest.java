package com.test;

import java.io.File;

import org.eclipse.jdt.internal.compiler.batch.ClasspathDirectory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.appzcapple.models.Car;

public class BeanTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		File file = new File("/Users/appzcapple/Documents/workspace/WebProjectMavenized/src/main/test/com/test/Beans.xml");
		if(!file.exists()) return;
		Resource resource = new ClassPathResource(file.getPath());
		BeanFactory bf = new XmlBeanFactory(resource);
		
		Car car1 = (Car)bf.getBean("car");
		car1.introduce();
		Car car2 = (Car)bf.getBean("car");
		System.out.println("car1==car2:" + (car1==car2));
		
	}
}
