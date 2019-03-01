package com.mc.srqservice.commom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.srqservice.domain.Feature;
import com.mc.srqservice.domain.SrqDomain;
import com.mc.srqservice.domain.SrqStatus;
import com.mc.srqservice.domain.StroryFeature;
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
	
	public Predicate<SrqDomain> getSRQList(String feature){
		return p->p.getFeature().equalsIgnoreCase(feature) ;
	}
	
	public List<StroryFeature> getStrucutredFeatureList() throws IOException{
		List<SrqDomain> srqDomainsListFromCSV = csvReaders.parseCSVToBeanList();
		//List<SrqDomain> list1 = new ArrayList<SrqDomain>();
		List<StroryFeature> featuresList = new ArrayList<StroryFeature>();
		//List<StroryFeature> featuresList1 = new ArrayList<StroryFeature>();
		
		for(SrqDomain srqDomain:srqDomainsListFromCSV) {
			StroryFeature feature = new StroryFeature();
			
			List<SrqDomain> srqDomainList=srqDomainsListFromCSV.stream().distinct().filter(this.getSRQList(srqDomain.getFeature() ))
					.collect(Collectors.<SrqDomain> toList());
			
			/*Set<SrqDomain> deptSet = srqDomainList.stream()
	                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(SrqDomain::getFeature))));
			deptSet.forEach(dept -> list1.add(dept));*/
			
			//srqDomainList = srqDomainList.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
			feature.setFeatureId(srqDomain.getFeature());
			//srqDomainList = srqDomainList.subList(0, 1);
			feature.setSrqList(srqDomainList);
			//feature.setSrqList(list1);
			featuresList.add(feature);
		}
		
		return featuresList;
	}
	
	
	public List<SrqStatus> getStoryStatus() throws IOException{
		
		List<SrqStatus> statusList = new ArrayList<SrqStatus>();
		List<SrqDomain> srqDomainsListFromCSV = csvReaders.parseCSVToBeanList();
		for(SrqDomain srqDomain:srqDomainsListFromCSV) {
			SrqStatus srqStatus  = new SrqStatus();
			Map<String, Integer> statusMap = new HashMap<String, Integer>();
		List<SrqDomain> srqDomainList=srqDomainsListFromCSV.stream().distinct().filter(this.getSRQList(srqDomain.getFeature() ))
					.collect(Collectors.<SrqDomain> toList());
			
			
			/*List<SrqDomain> srqDomainList=srqDomainsListFromCSV.stream().distinct().filter(k->k.getFeature().equalsIgnoreCase(srqDomain.getFeature()) )
					.collect(Collectors.<SrqDomain> toList());*/
			
			/*List<SrqDomain> srqDomainList=srqDomainsListFromCSV.stream().distinct()
					.collect(Collectors.<SrqDomain> toList());*/
			
			List<SrqDomain> readytoShipList = srqDomainList.stream().distinct().
					filter(x->x.getScheduleState().equalsIgnoreCase("Ready to Ship")).collect(Collectors.<SrqDomain> toList());
			
			
			
			/*List<SrqDomain> unique = readytoShipList.stream()
                    .collect(Collectors.toCollection(ArrayList::new));*/
                    
                    
                    
                   /* new TreeSet<>(comparingInt(SrqDomain::))),
                                               ArrayList::new));*/
			
			statusMap.put("Ready to Ship", readytoShipList.size());
			
			List<SrqDomain> completedList = srqDomainList.stream().distinct().
					filter(q->q.getScheduleState().equalsIgnoreCase("Completed")).collect(Collectors.<SrqDomain> toList());
			statusMap.put("Completed", completedList.size());
			
			List<SrqDomain> AcceptedList = srqDomainList.stream().distinct().
					filter(w->w.getScheduleState().equalsIgnoreCase("Accepted")).collect(Collectors.<SrqDomain> toList());
			statusMap.put("Accepted", AcceptedList.size());
			
			List<SrqDomain> DefinedList = srqDomainList.stream().distinct().
					filter(e->e.getScheduleState().equalsIgnoreCase("Defined")).collect(Collectors.<SrqDomain> toList());
			statusMap.put("Defined", DefinedList.size());
			
			List<SrqDomain> inprogressList = srqDomainList.stream().distinct().
					filter(r->r.getScheduleState().equalsIgnoreCase("In-Progress")).collect(Collectors.<SrqDomain> toList());
			statusMap.put("In-Progress", inprogressList.size());
			
			List<SrqDomain> UnelaboratedList = srqDomainList.stream().distinct().
					filter(t->t.getScheduleState().equalsIgnoreCase("Unelaborated")).collect(Collectors.<SrqDomain> toList());
			statusMap.put("Unelaborated", UnelaboratedList.size());
			
			srqStatus.setName(srqDomain.getFeature());
			srqStatus.setCount(statusMap);
			statusList.add(srqStatus);
		}
		
		/*Set<SrqStatus> deptSet = statusList.stream().distinct()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(SrqStatus::getName))));
		deptSet.forEach(dept -> statusList.add(dept));*/
		
		Set deptSet = new HashSet<>();
		 
		statusList.removeIf(p -> !deptSet.add(p.getName()));
		
		return statusList;
	}
}
