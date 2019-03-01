package com.mc.srqservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.Gson;
import com.mc.srqservice.commom.SRQDataReaderServiceImpl;
import com.mc.srqservice.domain.Feature;
import com.mc.srqservice.domain.SrqStatus;
import com.mc.srqservice.domain.StroryFeature;

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
	
	
	@GetMapping("featureWise/SRQ")
	public List<StroryFeature>  getFeaturewiseList(){
		
		List<StroryFeature> features = null;
		List<StroryFeature> features1 = new ArrayList<StroryFeature>();
		try {
			features =service.getStrucutredFeatureList().stream().filter(p->p.getFeatureId()!=null && !p.getFeatureId().equalsIgnoreCase("")).distinct().collect(Collectors.toList());
			features = features.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
			Set<StroryFeature> deptSet = features.stream()
	                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(StroryFeature::getFeatureId))));
			deptSet.forEach(dept -> features1.add(dept));
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  features1;
	}
	
	
	@GetMapping("featureWise/story/status")
	public List<SrqStatus> getFeaturWiseStoryStatus(){
		List<SrqStatus> statusList =null;
		try {
			 statusList = service.getStoryStatus();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusList;
	}
}
