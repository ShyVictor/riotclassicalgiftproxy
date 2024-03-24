package br.devshy.riotgiftproxy.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record HydraAuthPost(String login, String pass, @JsonProperty("client_id") String type, @JsonProperty("hnkey") String authkey) {

}
