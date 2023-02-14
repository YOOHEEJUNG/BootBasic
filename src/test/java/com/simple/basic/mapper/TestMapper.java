package com.simple.basic.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper // 디스 이즈 마이바티스 매퍼라는 표시(스프링 부트에서는 매퍼 인터페이스 꼭 붙여야 함)
public interface TestMapper {

	public String getTime();
	
}
