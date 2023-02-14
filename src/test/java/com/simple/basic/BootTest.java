package com.simple.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO.Builder;
import com.simple.basic.command.BuilderVO2;
import com.simple.basic.command.SimpleVO;
import com.simple.basic.controller.HomeController;

@SpringBootTest
public class BootTest {
	
	@Autowired
	HomeController homeController;
	
	@Test
	public void testCode01() {
		System.out.println(homeController.home());
		
	}
	
	//빌더패턴 객체의 사용
	@Test
	public void testCode2() {
//		Builder xx = BuilderVO.builder();
//		xx= xx.setAge(10);
//		xx= xx.setName("홍길동");
//		BuilderVO vo = xx.build();
//		System.out.println(vo.toString());
		
	BuilderVO vo = BuilderVO.builder().setAge(10)
					        .setName("홍길동")
							.build();
		
	System.out.println(vo.toString());
	
	
	BuilderVO2 vo2 = BuilderVO2.builder()
			  					.age(10)
			  					.name("이순신")
			  					.build();
	
	System.out.println(vo2.toString());
	
	}

}
