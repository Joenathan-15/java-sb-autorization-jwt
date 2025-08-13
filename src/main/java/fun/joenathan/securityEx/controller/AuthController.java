package fun.joenathan.securityEx.controller;

import fun.joenathan.securityEx.model.AuthenticationResponse;
import fun.joenathan.securityEx.model.LoginRequest;
import fun.joenathan.securityEx.model.RegisterRequest;
import fun.joenathan.securityEx.model.WebResponse;
import fun.joenathan.securityEx.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<WebResponse<AuthenticationResponse>> register(@RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(WebResponse.<AuthenticationResponse>builder().data(authService.register(request)).build());
    }

    @PostMapping("/login")
    public ResponseEntity<WebResponse<AuthenticationResponse>> login(@RequestBody LoginRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(WebResponse.<AuthenticationResponse>builder().data(authService.login(request)).build());
    }
}
