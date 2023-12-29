package com.Spotify.OAuth.API;

import java.time.Instant;
import java.util.HashMap;

import  com.Spotify.OAuth2.Utils.FileUtils;
import com.Spotify.OAuth2.Utils.RestUtils;
import io.restassured.response.Response;

public class TokenManager {
	private static String access_token;
	private static Instant expiry_time;
	
	
	
	public static String getToken() throws Throwable {
		
		
		try {
			if(access_token==null||Instant.now().isAfter(expiry_time)) {
				System.out.println("renewing token.....");
				
				Response response=renew_Token();
				access_token=response.path("access_token");
				int expiry_time_In_Second = response.path("expires_in");
				expiry_time=Instant.now().plusSeconds(expiry_time_In_Second-300);
				
		}
			else {
				System.out.println("token is good to use");
			}

		}catch(Exception e) {
			throw new RuntimeException("ABORT!!  failed to get token");
		}
		return access_token;
	}
	
	
	private static Response renew_Token() throws Throwable {
		FileUtils flib=new FileUtils();
		HashMap<String, String> formParams=new HashMap<String, String>();
		formParams.put("client_id",flib.getPropertyData("client_id"));
	    formParams.put("client_secret",flib.getPropertyData("client_secret"));
		formParams.put("grant_type",flib.getPropertyData("grant_type"));
		formParams.put("refresh_token", flib.getPropertyData("refresh_token"));
	
		Response response=RestUtils.postAccoun(formParams);
				
		if(response.statusCode()!=200) {
			throw new RuntimeException("renew token failed");
		}
		return response;
	}
	
   
}
