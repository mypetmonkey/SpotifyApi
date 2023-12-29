package com.Spotify.OAuth2.Utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.Spotify.OAuth2.Utils.IPathConstantUtility.ipathconstants;

public class FileUtils {
	
	public FileUtils() {
		
	}
	
	public  String getPropertyData(String key) throws Throwable {
		FileInputStream fis =new FileInputStream(ipathconstants.property_path);
		Properties p=new Properties();
		p.load(fis);
	String value = p.getProperty(key);
	return value;
	}

}
