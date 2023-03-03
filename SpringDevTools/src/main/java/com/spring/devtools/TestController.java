package com.spring.devtools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {
		
		int a = 50;
		int b = 20;
		return "Sum of a + b is : "+(a+b);
	}

}
