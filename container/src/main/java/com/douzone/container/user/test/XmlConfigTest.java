package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuration(Annotation Scanning)
		// testBeanFactory01();

		// XML Bean Configuration(Explicit Configuration)
		// testBenFactory02();

		// XML Bean Configuration(Annotation Scanning)
		// testApplicationContext01();

		// XML Bean Configuration(Explicit Configuration)
		// 이게 제일 중요..
		testApplicationContext02();
	}

	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext02.xml");

		User user = null;

		// id로 빈 가져오기
		user = (User) ac.getBean("user");
		System.out.println(user.getName());

		// name으로 빈 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user.getName());

		// Type으로 빈 가져오기
		// 갑은 타입의 빈이 2개 이상 있으면 Type으로 가져오기 실패
		// 1. id + type
		// 2. name + tpye
		user = ac.getBean("user2", User.class);
		System.out.println(user);

		// parameter가 2개인 생성자로 생성된 빈 가져오기 1
		user = ac.getBean("user3", User.class);
		System.out.println(user);

		// parameter가 2개인 생성자로 생성된 빈 가져오기 2
		user = ac.getBean("user4", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기1
		user = ac.getBean("user5", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기2 (DI)
		user = ac.getBean("user6", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기3 (Collection Property)
		user = ac.getBean("user7", User.class);
		System.out.println(user);

	}

	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}

	private static void testBenFactory02() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}

	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext01.xml");

		User user = null;

		user = ac.getBean(User.class);
		System.out.println(user.getName());

		// Annotation Scan 설정에서는 Bean id가 자동으로 부여 된다.
		user = (User) ac.getBean("user");
		System.out.println(user.getName());
	}
}