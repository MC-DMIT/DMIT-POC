package com.mc.srqservice.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.Gson;
import com.mc.srqservice.commom.SRQDataReaderServiceImpl;
import com.mc.srqservice.domain.Feature;

@RequestMapping("/srqs")
@RestControllerAdvice
@RestController
public class SRQController {

	@Autowired
	SRQDataReaderServiceImpl service;
	
	@GetMapping("show/all/SRQ")
	public String getAllSRQs(){
		String srqData="";
		try {
			List<Feature> featureList= service.getAllUserStories().stream().filter(p->p.getFeatureId()!=null && !p.getFeatureId().equalsIgnoreCase("")).collect(Collectors.toList());
			 srqData= new Gson().toJson(featureList);
			 System.out.println("************** in controller ************");
			System.out.println(srqData);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return srqData;
	}
	
}
