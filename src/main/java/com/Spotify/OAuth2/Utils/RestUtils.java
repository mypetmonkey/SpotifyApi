package com.Spotify.OAuth2.Utils;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import com.Spotify.OAuth.API.SpecBuilder;
import io.restassured.response.Response;
import static com.Spotify.OAuth2.Utils.Route.*;

public class RestUtils {
	
	FileUtils file=new FileUtils();
	SpecBuilder specBuilder=new SpecBuilder();
	
	public Response  post(String path,String token,Object requestPlaylist) throws Throwable {
		return given(specBuilder.getRequestSpec())
				.body(requestPlaylist)
				//.header("Authorization","Bearer "+token)
				.auth().oauth2(token)
			.when()
				.post(path)
				
			.then().spec(specBuilder.getResponseSpec())
				.extract()
				.response();
	}
	
	
	
	public static Response postAccoun(HashMap<String,String> formParams) {
		
		SpecBuilder sbuild=new SpecBuilder();
		   return given(sbuild.getAccountReqSpec())
				.formParams(formParams)
				
		   .when()
		 
				.post(API+TOKEN)
				
		   .then().spec(sbuild.getResponseSpec())
				.extract()
				.response();
				
				
				
	}
	
	
	
	
	
	public Response get(String path,String token) throws Throwable {
		return given(specBuilder.getRequestSpec())
				.header("Authorization","Bearer "+token)
				.when()
					.get(path)
					
				.then().spec(specBuilder.getResponseSpec())
					.extract()
					.response();
	}
	
	
	
	
	public Response update(String path,String token,Object reqestPlaylist) throws Throwable {
	return	given(specBuilder.getRequestSpec())
		.body(reqestPlaylist)
		.auth().oauth2(token)
		.when()
		.put(path)
		
		.then().spec(specBuilder.getResponseSpec())
		.extract()
		.response();
	}
	
	public Response posterror(String token,Object body) throws Throwable {
		return given(specBuilder.getRequestSpec())
				.body(body)
				//.header("Authorization","Bearer "+token)
				.auth().oauth2(token)
				.when()
				.post("/users/31b4n7nf3rjv3x2toy3bthrfzwoi/playlists")
				
				.then().spec(specBuilder.getResponseSpec())
				.extract()
				.response();
		
	}

}
