package com.simple.basic.command;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersVO<T> {

	private String id;
	private String pw;
	private String name;
	private String email;
	
	//1:N 조인에서
	private List<T> memoList;
	
}
