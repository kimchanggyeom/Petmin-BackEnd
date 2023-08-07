package org.matgyeojo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.matgyeojo.dto.Users;
import org.matgyeojo.service.DolbomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dolbom")
public class DolbomController {
	
	@Autowired
	DolbomService dolbomService;
	
	//기본 선호필터 user랑 sitter정보만 + dolbom 스케쥴 날+ 돌봄옵션 뿌려주면 댐
	@GetMapping(value = "/filter")
	public List< Object> dolbomFilter(@RequestParam String userId,@RequestParam String userAddress){
		return  dolbomService.dolbomFilter(userId,userAddress);
	}
	
	
	//돌봄 클릭햇을떄 디테일
	@GetMapping(value = "/detail")
	public 	List<Object> dolbomDetail(@RequestParam String sitterId){
		return dolbomService.dolbomDetail(sitterId);
	}
}
