package com.Spotify.OAuth.API.applicationAPI;


import com.Spotify.OAuth.API.SpecBuilder;
import static com.Spotify.OAuth.API.TokenManager.*;
import com.Spotify.OAuth2.Utils.RestUtils;
import static com.Spotify.OAuth2.Utils.Route.*;

import com.Spotify.OAuth2.pojo.ErrorRoot;
import com.Spotify.OAuth2.pojo.PlayList;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PlaylistApi {
	RestUtils rlib=new RestUtils();
	SpecBuilder specBuilder=new SpecBuilder();
	
	//@Step
	public Response  post(PlayList requestPlaylist) throws Throwable {
		return rlib.post(USERS+"/31b4n7nf3rjv3x2toy3bthrfzwoi"+PLAYLISTS,getToken(), requestPlaylist);
		
	}
	
	public Response  post(String token,PlayList requestPlaylist) throws Throwable {
		return rlib.post(USERS+"/31b4n7nf3rjv3x2toy3bthrfzwoi"+PLAYLISTS, getToken(), requestPlaylist);
		
	}
 	
	
	public Response get(String playlistId) throws Throwable {
		return rlib.get(PLAYLISTS+"/"+playlistId,getToken() );
		
	}	
	
	
	
	public Response update(String playlistId, PlayList reqestPlaylist) throws Throwable {
		return rlib.update(PLAYLISTS+"/"+playlistId, getToken(), reqestPlaylist);
		
	}
	
	
}
