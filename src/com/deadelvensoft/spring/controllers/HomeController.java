package com.deadelvensoft.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
	@RequestMapping("/")
	public String showHome()
	{
		return "/UcgWeb/home";
	}

}