package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SimpleVO {
	
	private int number;
	private String name;
	private String id;
	
}
