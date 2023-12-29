
package com.Spotify.OAuth2.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;
@Builder
@Jacksonized
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;


}
