package esprit.userservice.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/profile")
    public String getProfile(@AuthenticationPrincipal Jwt jwt) {

        String userId = jwt.getSubject();
        String username = jwt.getClaim("preferred_username");
        String email = jwt.getClaim("email");

        return "Hello " + username + " (ID: " + userId + ")";
    }

}