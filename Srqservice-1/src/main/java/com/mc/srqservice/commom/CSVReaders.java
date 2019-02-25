package com.mc.srqservice.commom;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mc.srqservice.domain.SrqDomain;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Component
public class CSVReaders {


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
	
public static List<SrqDomain> parseCSVToBeanList() throws IOException {
		
		HeaderColumnNameTranslateMappingStrategy<SrqDomain> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<SrqDomain>();
		beanStrategy.setType(SrqDomain.class);
		
		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("Formatted ID", "formattedId");
		columnMapping.put("Name", "Name");
		columnMapping.put("Schedule State", "scheduleState");
		columnMapping.put("Blocked", "Blocked");
		columnMapping.put("Display Color", "displaycolor");
		columnMapping.put("Owner", "Owner");
		columnMapping.put("Creation Date", "creationDate");
		columnMapping.put("Iteration", "Iteration");
		columnMapping.put("Plan Estimate", "planEstimate");
		
		columnMapping.put("Feature", "Feature");
		
		beanStrategy.setColumnMapping(columnMapping);
		
		CsvToBean<SrqDomain> csvToBean = new CsvToBean<SrqDomain>();
		CSVReader reader = new CSVReader(new FileReader("D:\\srq1.csv"));
		List<SrqDomain> emps = csvToBean.parse(beanStrategy, reader);
		System.out.println(emps);
		return emps;
	}


/*public static void main(String[] args) throws IOException{
	parseCSVToBeanList();
}*/
	
}
