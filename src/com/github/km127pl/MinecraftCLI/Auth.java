package com.github.km127pl.MinecraftCLI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;

public class Auth {
	public static String getAuthToken(String email, String password) throws IOException, ParseException {
		
		HttpPost post = new HttpPost("https://authserver.mojang.com/authenticate");

        // add request parameter, form parameters
        String json = "{\"agent\": {\"name\": \"Minecraft\",\"version\": 1},\"username\":\""+ email +"\",\"password\":\""+ password +"\",\"requestUser\": false}";
        System.out.println(email);
        System.out.println(json);
        post.setEntity(new StringEntity(json));
        post.addHeader("User-Agent", "");
        post.addHeader("Content-Type", "application/json");
        
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
        	CloseableHttpResponse response = httpClient.execute(post)) {
        	
        	BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        	
        	String inputLine;
    		StringBuffer responseBuffer = new StringBuffer();
    		
    		while ((inputLine = reader.readLine()) != null) {
    			responseBuffer.append(inputLine);
    		}
    		reader.close();    	
    		
            JSONObject obj = new JSONObject(responseBuffer.toString());
            System.out.println(obj.toString());
            response.close();
            return obj.getString("accessToken");
        }
	}
}
