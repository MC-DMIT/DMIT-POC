package com.mc.srqservice.commom;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mc.srqservice.domain.SrqDomain;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Component
public class CSVReaders {

	@Value("${filePath}")
	private String filePath;

/*public  List<SrqDomain> processInputFile(String inputFilePath) {
	  List<SrqDomain> inputList = new ArrayList<SrqDomain>();
	  try{
	      File inputF = new File(inputFilePath);
	      InputStream inputFS = new FileInputStream(inputF);
	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	      // skip the header of the csv
	      inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	      br.close();
	    } catch (IOException e) {
	      
	    }
}
	*/
	
public  List<SrqDomain> parseCSVToBeanList() throws IOException {
		
		HeaderColumnNameTranslateMappingStrategy<SrqDomain> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<SrqDomain>();
		beanStrategy.setType(SrqDomain.class);
		
		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("Formatted ID", "formattedId");
		columnMapping.put("Name", "Name");
		columnMapping.put("Schedule State", "scheduleState");
		columnMapping.put("Blocked", "Blocked");
		columnMapping.put("Display Color", "displaycolor");
		columnMapping.put("Created By", "createdBy");
		columnMapping.put("Owner", "Owner");
		columnMapping.put("Creation Date", "creationDate");
		columnMapping.put("Iteration", "Iteration");
		columnMapping.put("Plan Estimate", "planEstimate");
		
		columnMapping.put("Feature", "Feature");
		
		
		beanStrategy.setColumnMapping(columnMapping);
		
		CsvToBean<SrqDomain> csvToBean = new CsvToBean<SrqDomain>();
		//CSVReader reader = new CSVReader(new FileReader("D:\\srq1.csv"));
		CSVReader reader = new CSVReader(new FileReader(filePath));
		
		List<SrqDomain> emps = csvToBean.parse(beanStrategy, reader);
		
		 Set deptSet = new HashSet<>();
		 
		 emps.removeIf(p -> !deptSet.add(p.getFormattedId()));
		 
	/*	LinkedList<SrqDomain> mylist = emps.stream().distinct().filter(p->p.getFormattedId()!=null && !p.getFormattedId().equalsIgnoreCase(""))
				.collect(Collectors.toCollection(LinkedList::new));*/
		
	/*	Set<SrqDomain> deptSet = emps.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(SrqDomain::getFeature))));*/
		
       // deptSet.forEach(dept -> System.out.println("DeptId (" + dept.getFeature() + ") Name :" + dept.getFeature()));
		
	/*	HashSet<SrqDomain> SrqDomainHashSet = emps
			      .stream().filter(p->p.getFormattedId()!=null && !p.getFormattedId().equalsIgnoreCase(""))
			      .collect(Collectors.toCollection(HashSet::new));*/
		
		System.out.println(emps);
		return emps;
	}



	
}
