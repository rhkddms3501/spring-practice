package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequestMapping 클래스 단독 매핑
 * Spring mvc 4.x 만 지원 
 *
 */
//@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GeustbookController.list()";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GeustbookController.delete()";
	}

}
