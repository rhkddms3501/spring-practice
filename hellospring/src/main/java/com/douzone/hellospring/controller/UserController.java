package com.douzone.hellospring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @RequestMapping 메소드 단독 매핑
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 주소창에 
	 * http://localhost:8080/hellospring/user/join
	 * 입력 시 GET방식으로 넘어옴. 
	 */
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	/**
	 * 객체를 파라미터로 받는 경우
	 * 안에 변수가 빈것(null)은 있을수 있어도
	 * 객체 자체는 절대 null이면 안됨.
	 */
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/";
	}
	
	/**
	 *http://localhost:8080/hellospring/user/list  ->  p없이 하면 그냥 1 세팅 
	 *http://localhost:8080/hellospring/user/list?p=1 
	 */
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int pageNo) {
		return "UserController.list(" + pageNo + ")";
	}
	
	/**
	 * 만일 n이라는 이름의 URL 파라미터가 없으면
	 * 400 Bad request 에러 발생
	 * 
	 *  http://localhost:8080/hellospring/user/update?n=이름
	 */
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam(value="n") String name) {
		return "UserController.list(" + name + ")";
	}
	
	/**
	 *http://localhost:8080/hellospring/user/update2 -> 해도 에러 안남. 
	 */
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required = true, defaultValue = "") String name) {
		return "UserController.list(" + name + ")";
	}


}
