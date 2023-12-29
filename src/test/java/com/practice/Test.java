package com.practice;

import com.Spotify.OAuth2.Utils.FileUtils;

public class Test {
	
	public static void main(String[] args) throws Throwable {
		FileUtils f=new FileUtils();
		System.out.println(f.getPropertyData("client_id"));
		
		
	}

}
