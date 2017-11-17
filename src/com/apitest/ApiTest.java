package com.apitest;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.csvreader.CSVReader;
import com.reponsemodel.Model;



@SuppressWarnings("deprecation")
public class ApiTest {

	private WebDriver driver;
	private String baseUrl;
	private JSONObject json;
	private String url; 
	private String header;
	private List <Model> fileOps = new ArrayList();
	
	
	@Before
	public void setUp() throws Exception {
        	System.setProperty("webdriver.ie.driver", "C:\\Users\\Engineer.V07293D625F\\engineeringDays\\WebServiceTest\\IEDriverServer.exe");
        	//System.out.println(System.getProperty("webdriver.ie.driver"));
        	driver = new InternetExplorerDriver();
        	baseUrl = "about:blank";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
	

	@After
	public void tearDown() throws Exception {
		 driver.close();
		 driver.quit();
	}
	
	private List <Model> filePopulation()
	{
		List <Model> fileProps = new ArrayList();
		CSVReader csvReader = new CSVReader();
		fileProps = csvReader.reader();
		return fileProps;
	}

	//Test Case For ResponseCode
	@Test
	public void test1() throws ClientProtocolException, IOException {
		driver.get(baseUrl);
	 ApiResponse apiResponse=new ApiResponse();
	 
	 if(fileOps.isEmpty())
		 fileOps = filePopulation();
	 //System.out.println(fileOps.toString());
	 for(Model m : fileOps)
	 {
		 url = m.getUrl()+m.getVariables()+"?" + "id_type="+ m.getId_type() +"&extendeddata=" + m.getExtendeddata().toLowerCase();
		 json = apiResponse.GetResponse(url.trim());
		 JSONArray statusCode = (JSONArray) json.get("statusCode");
		 Assert.assertTrue("200".equals(statusCode.get(0).toString()));
	 }
	}
	
	//Test Case For AccountNumber
	@Test
	public void test2() throws ClientProtocolException, IOException {
		driver.get(baseUrl);
	 ApiResponse apiResponse=new ApiResponse();
	 
	 if(fileOps.isEmpty())
		 fileOps = filePopulation();
	
	 for(Model m : fileOps)
	 {
		 url = m.getUrl()+m.getVariables()+"?" + "id_type="+ m.getId_type() +"&extendeddata=" + m.getExtendeddata().toLowerCase();
		 json = apiResponse.GetResponse(url.trim());
		 Assert.assertTrue(m.getExpected_accountNumber().equalsIgnoreCase(json.getString("accountNumber")));
	 }
	}
	//Test Case for Account Status 
	@Test
	public void test3() throws ClientProtocolException, IOException {
		driver.get(baseUrl);
	 ApiResponse apiResponse=new ApiResponse();

	 if(fileOps.isEmpty())
		 fileOps = filePopulation();
	
	 for(Model m : fileOps)
	 {
		 url = m.getUrl()+m.getVariables()+"?" + "id_type="+ m.getId_type() +"&extendeddata=" + m.getExtendeddata().toLowerCase();
		 json = apiResponse.GetResponse(url.trim());
		 
		 System.out.println(json.getString("status"));
		 if(!m.getExpected_status().isEmpty())
			 Assert.assertTrue(m.getExpected_status().equalsIgnoreCase(json.getString("status")));
	 }
	}
	//Test Case for RealmId
	@Test
	public void test4() throws ClientProtocolException, IOException {
		driver.get(baseUrl);
	 ApiResponse apiResponse=new ApiResponse();

	 if(fileOps.isEmpty())
		 fileOps = filePopulation();
	 
	 for(Model m : fileOps)
	 {
		 url = m.getUrl()+m.getVariables()+"?" + "id_type="+ m.getId_type() +"&extendeddata=" + m.getExtendeddata().toLowerCase();
		 json = apiResponse.GetResponse(url.trim());
		 if(!m.getExpected_realmId().isEmpty())
			 Assert.assertTrue(m.getExpected_realmId().equalsIgnoreCase(json.getString("realmId")));
	 }
	}
	
	//Test Case for Business Name

	@Test
	public void test5() throws ClientProtocolException, IOException {
		driver.get(baseUrl);
	 ApiResponse apiResponse=new ApiResponse();

	 if(fileOps.isEmpty())
		 fileOps = filePopulation();
	 
	 for(Model m : fileOps)
	 {
		 url = m.getUrl()+m.getVariables()+"?" + "id_type="+ m.getId_type() +"&extendeddata=" + m.getExtendeddata().toLowerCase();
		 json = apiResponse.GetResponse(url.trim());
		 JSONObject jObj = json.getJSONObject("BusinessInfo");
		 if(!m.getExpected_businessName().isEmpty())
			 Assert.assertTrue(m.getExpected_businessName().equalsIgnoreCase(jObj.get("businessName").toString()));
	 }
	}

	//Test Case for Legal Name
	
	@Test
	public void test6() throws ClientProtocolException, IOException {
		driver.get(baseUrl);
	 ApiResponse apiResponse=new ApiResponse();

	 if(fileOps.isEmpty())
		 fileOps = filePopulation();
	 
	 for(Model m : fileOps)
	 {
		 url = m.getUrl()+m.getVariables()+"?" + "id_type="+ m.getId_type() +"&extendeddata=" + m.getExtendeddata().toLowerCase();
		 json = apiResponse.GetResponse(url.trim());
		 JSONObject jObj = json.getJSONObject("BusinessInfo");
		 if(!m.getExpected_legalname().isEmpty())
			 Assert.assertTrue(m.getExpected_legalname().substring(0,3).equalsIgnoreCase(jObj.get("legalName").toString().substring(0,3)));
	 }
	}
	
	//Test Case for Business Phone
	@Test
	public void test7() throws ClientProtocolException, IOException {
		driver.get(baseUrl);
	 ApiResponse apiResponse=new ApiResponse();

	 if(fileOps.isEmpty())
		 fileOps = filePopulation();
	 
	 for(Model m : fileOps)
	 {
		 url = m.getUrl()+m.getVariables()+"?" + "id_type="+ m.getId_type() +"&extendeddata=" + m.getExtendeddata().toLowerCase();
		 json = apiResponse.GetResponse(url.trim());
		 JSONObject jObj = json.getJSONObject("BusinessInfo");
		 if(!m.getExpected_phone().isEmpty())
			 Assert.assertTrue(m.getExpected_phone().equalsIgnoreCase(jObj.get("phone").toString()));
	 }
	}
}