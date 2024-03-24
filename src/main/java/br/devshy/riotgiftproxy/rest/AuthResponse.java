package br.devshy.riotgiftproxy.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize @JsonIgnoreProperties(ignoreUnknown = true)
public record AuthResponse(String token, String puuid, String region) {

}
