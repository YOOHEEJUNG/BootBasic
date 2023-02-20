package com.simple.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoVO;
import com.simple.basic.command.UsersVO;

@Mapper // 디스 이즈 마이바티스 매퍼라는 표시(스프링 부트에서는 매퍼 인터페이스 꼭 붙여야 함)
public interface TestMapper {

	public String getTime();
	//N:1조인의 모형 글 - 회원정보
	public List<MemoVO>joinOne();
	//1:N 조인의 모형 회원정보 - 글
	public UsersVO<MemoVO> joinTwo();
}






