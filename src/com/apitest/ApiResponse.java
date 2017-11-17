package com.apitest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;


@SuppressWarnings("deprecation")
public class ApiResponse 
{
	JSONObject json;

	private final String USER_AGENT="Mozilla/5.0";
	public JSONObject GetResponse(String url) throws ClientProtocolException, IOException
	{
		StringBuffer result=new StringBuffer();
		HttpClient client=new DefaultHttpClient();
		
		HttpGet request=new HttpGet(url);
		
		//request.addHeader(User-Agent);
		
		//request.addHeader("User-Agent",USER_AGENT);
		request.addHeader("Accept","application/json");
		//request.addHeader("Authorization", header.toString());
		request.addHeader("Authorization","Intuit_IAM_Authentication intuit_appid=Intuit.smallbusiness.asc.ascservices,intuit_app_secret=preprdPFIfunicNnEH5sXTyE20VNheckeX8W8bYb");
		request.addHeader("Content-Type","application/json");
		request.addHeader("intuit_locale","en_US");
		
		
		HttpResponse response=client.execute(request);
		int responseCode=response.getStatusLine().getStatusCode();
		try{
		if(responseCode==200)
			
		{
			//System.out.println("Get Response is Successfull");
			BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line;//=reader.readLine();
			String output = "";
			while((line=reader.readLine())!=null)
			{
				output = output + line; 
			}
			json = new JSONObject(output);
			json.append("statusCode", ""+responseCode);
			//System.out.println(json.toString());
		}
		return json;
		}
		catch(Exception ex)
		{
			json.append("message","Get Response Failed");
			json.append("statusCode",""+responseCode);
			return json;
		}

	}
}