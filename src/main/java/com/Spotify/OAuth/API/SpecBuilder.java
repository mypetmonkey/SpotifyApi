package com.Spotify.OAuth.API;


import com.Spotify.OAuth2.Utils.Route;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
	
	
	public  RequestSpecification getRequestSpec() throws Throwable {
		return new RequestSpecBuilder()
				.setBaseUri("https://api.spotify.com")
				.setBasePath(Route.BASE_PATH)
				.setContentType(ContentType.JSON)
				.addFilter(new AllureRestAssured())
				.log(LogDetail.ALL)
				.build();
		
	}
	
	public RequestSpecification getAccountReqSpec() {
		return new RequestSpecBuilder()
				.setBaseUri("https://accounts.spotify.com")
				.setContentType(ContentType.URLENC)
				.addFilter(new AllureRestAssured())
				.log(LogDetail.ALL)
				.build();
	}
	
	
	public  ResponseSpecification getResponseSpec() {
		return new ResponseSpecBuilder()
				.log(LogDetail.ALL).build();
	}

}
