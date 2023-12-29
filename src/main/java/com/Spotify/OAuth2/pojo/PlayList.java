
package com.Spotify.OAuth2.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Getter @Setter
@Builder
@Jacksonized
//@Data
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayList {

    @JsonProperty("collaborative")
     Boolean collaborative;
    @JsonProperty("external_urls")
     ExternalUrls externalUrls;
    @JsonProperty("followers")
     Followers followers;
    @JsonProperty("href")
    String href;
    @JsonProperty("id")
     String id;
    @JsonProperty("images")
     List<Object> images;
    @JsonProperty("primary_color")
     Object primaryColor;
    @JsonProperty("name")
     String name;
    @JsonProperty("description")
     String description;
    @JsonProperty("type")
     String type;
    @JsonProperty("uri")
    String uri;
    @JsonProperty("owner")
     Owner owner;
    @JsonProperty("public")
     Boolean _public;
    @JsonProperty("snapshot_id")
     String snapshotId;
    @JsonProperty("tracks")
     Tracks tracks;
	

}
