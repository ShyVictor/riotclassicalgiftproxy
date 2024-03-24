package br.devshy.riotgiftproxy.service;

import br.devshy.riotgiftproxy.config.HydraAuthConfig;
import br.devshy.riotgiftproxy.domain.HydraAuthPost;
import br.devshy.riotgiftproxy.exception.HydraAuthFailedException;
import br.devshy.riotgiftproxy.rest.AuthResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HydraAuthService {
    private final RestClient client;
    private final String hydraAuthKey;
    private final String hydraAuthType;

    @Autowired
    public HydraAuthService(HydraAuthConfig hydraAuthConfig) {
        this.hydraAuthKey = hydraAuthConfig.getAuthkey();
        this.hydraAuthType = hydraAuthConfig.getType();
        this.client = RestClient
                .builder()
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public AuthResponse auth(String username, String password){
        final HydraAuthPost body = new HydraAuthPost(username, password, hydraAuthType, hydraAuthKey);
        final ResponseEntity<AuthResponse> result = this.client
                .post()
                .uri("https://api.hydranetwork.org/")
                .accept(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .onStatus(status -> status.value() != 202, (request, response) -> {
                    throw new HydraAuthFailedException("Auth failed!");
                })
                .toEntity(AuthResponse.class);
        return result.getBody();
    }
}
