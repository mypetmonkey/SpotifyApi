package com.Spotify.OAuth2.test;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import com.Spotify.OAuth.API.applicationAPI.PlaylistApi;
import com.Spotify.OAuth2.pojo.PlayList;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;

@Epic("spotify oauth 2.0")
@Feature("playlist api")
public class CRUD_PlayListTest {
	   
	PlaylistApi api=new PlaylistApi();
	
	
	@Story("create a playlist story")
	@Link("https://example.org")
	@Link(name="allure",type="mylink")
	@TmsLink("12345")
	@Issue("123")
	@Description("this is the description about the test")
	@Test(description ="should be able to create a playlist" )
	public void CreatePlayList_test() throws Throwable {
	PlayList payload=playlistBuilder("MyNew PlayList2","Testing spotify",false);
    Response response = api.post(payload);
    assertStatusCode(response.statusCode(),201);
    assertPlaylist(response.as(PlayList.class),payload);
		
	}
	
	
	  
	
	
	@Test(description = "user should be able to get the playlist")
	public void getPlayList_test() throws Throwable {
		PlayList payload=playlistBuilder("MyNew PlayList2","Testing spotify",true);
	    Response response = api.get("0UrzGtrt1nDbxX1vrFh7UX");
	    assertStatusCode(response.statusCode(),200);
	    assertPlaylist(response.as(PlayList.class),payload);

	
	}
	
	
	@Test(enabled=true,description = "user should be able to update the playlist")
	public void updatePlaylistTest() throws Throwable {
		PlayList payload=playlistBuilder("MyNew PlayList2","Testing spotify",false);
		Response response = api.update("0UrzGtrt1nDbxX1vrFh7UX", payload);
	    assertStatusCode(response.statusCode(),200);


	}
	
	@Story("create a playlist story")
	@Test(description = "user should not create playist without name(playlist)")
	public void testWithoutName() throws Throwable {
		PlayList payload=playlistBuilder("","Testing spotify",false);
		Response response = api.post(payload);
	    assertStatusCode(response.statusCode(),400);

//	      Error err = response.as(Error.class);
//	      assertThat(err.getStatus(),equalTo(400));
//	      assertThat(err.getMessage(),equalTo(p.getDescription()));
	
	  //assertThat(error.ge);
		;
		
	}
	
	
	
	
	
	
	
	//@Step
	public PlayList playlistBuilder(String name,String description,boolean _public) {
		
		return PlayList.builder().
				name(name)
				.description(description)
				._public(_public).build();
	}
	
	
	//@Step
	public void assertPlaylist(PlayList respplaylist,PlayList reqPlaylist) {
		assertThat(respplaylist.getName(),equalTo(reqPlaylist.getName()));
		assertThat(respplaylist.getDescription(),equalTo(reqPlaylist.getDescription()));
		assertThat(respplaylist.get_public(),equalTo(reqPlaylist.get_public()));
	}
	

	
	//@Step
	public void assertStatusCode(int actualstcode, int expectedstcode) {
	    assertThat(actualstcode,equalTo(expectedstcode));

	}

}
