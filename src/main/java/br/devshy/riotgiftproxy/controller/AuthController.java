package br.devshy.riotgiftproxy.controller;


import br.devshy.riotgiftproxy.rest.AuthRequest;
import br.devshy.riotgiftproxy.service.HydraAuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthController {
    private final HydraAuthService hydraAuthService;

    @Autowired
    public AuthController(HydraAuthService hydraAuthService){
        this.hydraAuthService = hydraAuthService;

    }

    @PostMapping("/auth")
    public ResponseEntity<Response> auth(@RequestBody AuthRequest request){
        if (request.username() == null || request.username().isEmpty() ||
                request.password() == null || request.password().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        hydraAuthService.auth(request.username(), request.password());
        return ResponseEntity.ok().build();
    }


}
