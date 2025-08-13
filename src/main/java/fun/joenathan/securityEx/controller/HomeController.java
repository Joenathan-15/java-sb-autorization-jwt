package fun.joenathan.securityEx.controller;

import fun.joenathan.securityEx.model.UserResponse;
import fun.joenathan.securityEx.model.WebResponse;
import fun.joenathan.securityEx.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/user")
    public ResponseEntity<WebResponse<UserResponse>> home(){
        return ResponseEntity.status(HttpStatus.OK).body(WebResponse.<UserResponse>builder().data(homeService.getUserInfo()).build());
    }
}
