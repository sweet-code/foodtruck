package org.bisun.controller;

import org.bisun.domain.Criteria;
import org.bisun.domain.PageMaker;
import org.bisun.service.ImageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imageboard/*")
public class ImageBoardController {
	
	@Autowired
	ImageBoardService service;
	
	@GetMapping("/list")
	public void getList(@ModelAttribute("cri") Criteria cri, Model model){
		cri.setSize(6);
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker", new PageMaker(cri, service.getTotal()));
	}
	
	@GetMapping("/register")
	public void register(){
		
	}

}
