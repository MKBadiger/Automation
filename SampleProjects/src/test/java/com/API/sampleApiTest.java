package com.API;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class sampleApiTest {

	public static void main(String[] args) {
		try {
			URL url = new URL(
			"http://bmtcmob.hostg.in/api/tripdetails/routestop/routeid/4732");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
		//	conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
			throw new RuntimeException(" HTTP error code : "
			+ conn.getResponseCode());
			}

			
			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
			entireResponse += scan.nextLine();

			System.out.println("Response : "+entireResponse);

			scan.close();
			
//			Var HtmlToJsonString = JSON.stringify($(entireResponse).html());
//			System.out.println("Ans : "+entireResponse);
			
//			var element = document.getElementById('TextBoxesGroup');
//			var html = entireResponse.outerHTML;       
//			var data = { html: html }; 
//
//			var json = JSON.stringify(data);
//			
			
			

			JSONObject obj = new JSONObject(entireResponse );
			String responseCode = obj.getString("entireResponse.busStopName");
			System.out.println("!------------------!");
			System.out.println("status : " + responseCode);
			System.out.println("!------------------!");
			JSONArray arr = obj.getJSONArray("results");
			for (int i = 0; i < arr.length(); i++) {
			String placeid = arr.getJSONObject(i).getString("place_id");
			System.out.println("Place id : " + placeid);
			String formatAddress = arr.getJSONObject(i).getString(
			"formatted_address");
			System.out.println("!------------------!");
			System.out.println("Address : " + formatAddress);
			System.out.println("!------------------!");
			//validating Address as per the requirement
			
			}

			conn.disconnect();
			} catch (MalformedURLException e) {
			e.printStackTrace();

			} catch (IOException e) {

			e.printStackTrace();

			}


	}
}
