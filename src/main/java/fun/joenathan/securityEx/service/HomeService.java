package fun.joenathan.securityEx.service;

import fun.joenathan.securityEx.entity.User;
import fun.joenathan.securityEx.model.UserResponse;
import fun.joenathan.securityEx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserResponse.builder().email(user.getEmail()).username(user.getUserName()).build();
    }
}
