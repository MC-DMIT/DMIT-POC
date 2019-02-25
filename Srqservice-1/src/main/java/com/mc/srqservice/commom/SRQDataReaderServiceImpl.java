package com.mc.srqservice.commom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.srqservice.domain.Feature;
import com.mc.srqservice.domain.SrqDomain;
import com.mc.srqservice.domain.UserStories;

@Service
public class SRQDataReaderServiceImpl {
	@Autowired
	CSVReaders csvReaders;
	
	public Map<String, List<UserStories>> getUserStoryMap() throws IOException{
		String currentFeature="";
		List<SrqDomain> srqDomainsList = csvReaders.parseCSVToBeanList();
		List<UserStories> userStoryList=new ArrayList<>();
		Map<String, List<UserStories>> userStoryMap = new HashMap<>();
		/*Map<String,List<SrqDomain>> userStoriesMap=srqDomainsList.stream().
				collect(Collectors.groupingBy(SrqDomain::getFeature,Collectors.mapping(SrqDomain::getFeature, Collectors.toList())));*/
		UserStories userStories=null;
		Feature feature=null;
		int count=0;
		if(srqDomainsList!=null && srqDomainsList.size()>0) {
		for(SrqDomain srqDomain:srqDomainsList) {
			
			if(!userStoryMap.containsKey(srqDomain.getFeature())) {
				userStories = new UserStories();
				
				userStories.setBlocked(srqDomain.getBlocked());
				userStories.setCreationDate(srqDomain.getCreationDate());
				userStories.setDisplaycolor(srqDomain.getDisplaycolor());
				userStories.setFormattedId(srqDomain.getFormattedId());
				userStories.setIteration(srqDomain.getIteration());
				userStories.setName(srqDomain.getName());
				userStories.setOwner(srqDomain.getOwner());
				userStories.setPlanEstimate(srqDomain.getPlanEstimate());
				userStories.setScheduleState(srqDomain.getScheduleState());
				currentFeature = srqDomain.getFeature();
			
			//	if(count!=0) {
				userStoryMap.put(currentFeature, userStoryList);
				currentFeature=srqDomain.getFeature();
				userStoryList= new ArrayList<UserStories>();
				userStoryList.add(userStories);
			//	}
				
				count++;
			}
			else {
				userStories = new UserStories();
				userStories.setBlocked(srqDomain.getBlocked());
				userStories.setCreationDate(srqDomain.getCreationDate());
				userStories.setDisplaycolor(srqDomain.getDisplaycolor());
				userStories.setFormattedId(srqDomain.getFormattedId());
				userStories.setIteration(srqDomain.getIteration());
				userStories.setName(srqDomain.getName());
				userStories.setOwner(srqDomain.getOwner());
				userStories.setPlanEstimate(srqDomain.getPlanEstimate());
				userStories.setScheduleState(srqDomain.getScheduleState());
				userStoryList.add(userStories);
			}
			
			
			
		}
		}
		return  userStoryMap;
	}
	
	public List<Feature> getFeatureList() throws IOException{
		Map<String, List<UserStories>> map= this.getUserStoryMap();
		List<Feature> features = new ArrayList<Feature>();
		for (Map.Entry<String, List<UserStories>> entry : map.entrySet()) {
			Feature feature = new Feature();
			feature.setFeatureId(entry.getKey());
			feature.setUserStroryList(entry.getValue());
			features.add(feature);
		}
		return features;
	}
	
	public List<Feature> getAllUserStories() throws IOException{
		List<SrqDomain> srqDomainsList = csvReaders.parseCSVToBeanList();
		List<UserStories> userStoryList=new ArrayList<>();
		List<Feature> featuresList= new ArrayList<Feature>();
		Feature feature=null;
		String currentFeature="";
		UserStories userStories = null;
		int count=0;
		if(srqDomainsList!=null && srqDomainsList.size()>0) {
			for(SrqDomain srqDomain:srqDomainsList) {
				if(!srqDomain.getFeature().equalsIgnoreCase(currentFeature)) {
					
					if(count!=0 ) {
					feature = new Feature();
					feature.setFeatureId(currentFeature);
					//userStoryList.add(userStories);
					feature.setUserStroryList(userStoryList);
					featuresList.add(feature);
					userStoryList  = new ArrayList<UserStories>();
					}
					
					userStories = new UserStories();
					
					userStories.setCreationDate(srqDomain.getCreationDate());
					userStories.setDisplaycolor(srqDomain.getDisplaycolor());
					userStories.setFormattedId(srqDomain.getFormattedId());
					userStories.setIteration(srqDomain.getIteration());
					userStories.setName(srqDomain.getName());
					userStories.setOwner(srqDomain.getOwner());
					userStories.setPlanEstimate(srqDomain.getPlanEstimate());
					userStories.setScheduleState(srqDomain.getScheduleState());
					userStories.setBlocked(srqDomain.getBlocked());
					userStoryList.add(userStories);
					
					currentFeature=srqDomain.getFeature();
				}else {
					
					
					
					 userStories = new UserStories();
					userStories.setBlocked(srqDomain.getBlocked());
					userStories.setCreationDate(srqDomain.getCreationDate());
					userStories.setDisplaycolor(srqDomain.getDisplaycolor());
					userStories.setFormattedId(srqDomain.getFormattedId());
					userStories.setIteration(srqDomain.getIteration());
					userStories.setName(srqDomain.getName());
					userStories.setOwner(srqDomain.getOwner());
					userStories.setPlanEstimate(srqDomain.getPlanEstimate());
					userStories.setScheduleState(srqDomain.getScheduleState());
					userStoryList.add(userStories);
					
					
				}
				count++;
			}
			
		}
		
		return featuresList;
	}
}
