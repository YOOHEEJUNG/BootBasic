package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.SimpleVO;


import oracle.jdbc.proxy.annotation.Post;

@RestController //Controller + ResponseBody의 합성어
public class RestBasicController {
	
	/*
	 * 1.Responsebody는 return값이 뷰리졸버가 아니고, 요청이 들어온 곳으로 반환
	 *
	 *
	 */

	@GetMapping("/getText")
	public String getText() {
		return "hello world";
	}
	
	
	//객체를 담게 되면 application/json 형식으로 반환하게 됨
	/*
	 * produces - 보내는 데이터에 대한 타입 (생략 가능)
	 * consumes - 받는 데이터에 대한 타입
	*/
	
	@GetMapping(value="/getObject", produces = "application/json")
	public SimpleVO getObject() {
		
		SimpleVO vo = new SimpleVO(123546, "홍길동", "1");
				
		return vo ;
	}
	
	//map형식의 반환 (map에 리스트도 담을 수 있음)
	@GetMapping("/getObject2")
	public Map<String, Object> getObject2(){
		
		Map<String, Object> map = new HashMap<>();
		SimpleVO vo = new SimpleVO(123546, "홍길동", "1");
		
		map.put("total", 100);
		map.put("data", vo);
		
		return map;
		
	}
	
	
	//리스트 형식의 반환
	@GetMapping("/getObject3")
	public List<SimpleVO> getObject3(){
		
		List<SimpleVO> list = new ArrayList<>();

		for(int i = 1; i <= 10; i++) {
			list.add(new SimpleVO(1235 + i, "홍순자" + i, "1"));
		}
		
		return list;
	}
	
	
	//get형식 값을 받는 방법1 - 쿼리스트링 ? 키=값
	//http://localhost:8383/getKey?id=aaaa&name=홍길자
	@GetMapping("/getKey")
	public String getKey(@RequestParam("id") String id, 
						 @RequestParam("name") String name) {
		
		System.out.println(id);
		System.out.println(name);
		
		return "success";
	}
	
	//get형식 값을 받는 방법2 - 쿼리파람 URL/키/키
	@GetMapping("/getPath/{sort}/{apiKey}")
	public String getPath(@PathVariable("sort") String sort,
						  @PathVariable("apiKey") String key) {
		
		System.out.println(sort);
		System.out.println(key);
		
		return "success";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////Post형식의 처리////////////////////////////////////////
	
	//값을 받는 방법1 - VO로 맵핑
	//json형식의 데이터를 자바의 객체로 맵핑 -> @RequestBody
	//cors - 기본적으로 서버가 다르면 요청을 거절(특정 서버에 대해서만 허용)
	//그럴 때 @CrossOrigin(경로)
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/getJson")
	public String getJson(@RequestBody SimpleVO vo) {
		
		System.out.println(vo.toString());
		return "success";
	}
	
	//값을 받는 방법2 - Map으로 맵핑
	@PostMapping("/getMap")
	public String getMap(@RequestBody Map<String, Object> map) {
		
		System.out.println(map.toString());
		return "success";
	}
	
	
	//consumer를 통한 데이터제한
	//consumer는 특정타입의 데이터를 받도록 처리하는 옵션(기본값 json)
	//클라이언트에는 Content-type을 이용해서 보내는 데이터에 대한 타입을 명시 (무조건 명시해야 함)

	@PostMapping(value="/getResult", consumes = "text/plain")
	public String getResult(@RequestBody String data) {
		
		System.out.println(data);
		
		return "success";
	}
	
	
	//응답문서의 형태를 직접 선언 - ResponseEntity
	@PostMapping("/createRes")
	public ResponseEntity createRes() {
		
		SimpleVO vo = new SimpleVO(1234, "황길순", "1"); //데이터
		
		HttpHeaders header = new HttpHeaders();
		header.add("Authroization", "token");
		
		HttpStatus status = HttpStatus.ACCEPTED;
		
		
		new ResponseEntity<>(vo, header, status);
		ResponseEntity<SimpleVO> entity = new ResponseEntity<>(vo, header, status);	
		
		return entity;
	}
	
	//jquery - ajax에서
	@CrossOrigin({"http://127.0.0.1:5500",
				  "http://localhost:5500"})
	@PostMapping("/getAjax")
	public Map<String, Object> getAjax(@RequestBody SimpleVO simpleVo){
		System.out.println(simpleVo.toString());

			//받을 데이터
			Map<String, Object> map = new HashMap<>();
			
			//보내는 데이터
			SimpleVO vo = new SimpleVO(123546, "홍길동", "1");			
			map.put("total", 100);
			map.put("data", vo);
	
			return map;
	}
	
//	@CrossOrigin("*")//전부 허용
	@CrossOrigin({"http://127.0.0.1:5500",
				"http://localhost:5500"})
	@GetMapping("/getAjax2/{topic}")
	public String getAjax2(@PathVariable("topic") String topic) {
	
		System.out.println(topic);
		return "success";
	}


























}
