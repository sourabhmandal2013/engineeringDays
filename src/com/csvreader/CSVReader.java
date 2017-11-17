package com.csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.reponsemodel.Model;

public class CSVReader {

		Model model;
		List modelList;
	
	
	    public List<Model> reader() {

	        String csvFile = "C:\\Users\\Engineer.V07293D625F\\engineeringDays\\WebServiceTest\\details.csv";
	        String line = "\\";
	        String csvSplitBy = ",";
	        String buffer[];
	        
	        

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	        	modelList =  new ArrayList<Model>();
	            while ((line = br.readLine()) != null) {
	            	buffer = line.split(csvSplitBy);
	            	if(!buffer[0].equalsIgnoreCase("url"))
	            	{	
	            		model = new Model();
	            		model.setUrl(buffer[0]);
	            		model.setVariables(buffer[1]);
	            		model.setExtendeddata(buffer[2]);
	            		model.setId_type(buffer[3]);
	            		model.setExpected_accountNumber(buffer[4]);
	            		model.setExpected_realmId(buffer[5]);
	            		model.setExpected_status(buffer[6]);
	            		model.setExpected_legalname(buffer[7]);
	            		model.setExpected_businessName(buffer[8]);
	            		model.setExpected_phone(buffer[9]);
	            		
	            		modelList.add(model);
	            	}
	            }
	            
	            //return modelList;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return modelList;
	    }

	}

