package com.cheise_proj.authservice.controller;

import com.cheise_proj.authservice.domain.model.CustomUserDetail;
import com.cheise_proj.authservice.domain.service.UserService;
import com.cheise_proj.authservice.dto.APIResponseData;
import com.cheise_proj.authservice.dto.CreateUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> whoami(Principal principal) {
        if (ObjectUtils.isEmpty(principal)) throw new UnauthorizedUserException("authorization required");
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
        CustomUserDetail userDetail = (CustomUserDetail) oAuth2Authentication.getPrincipal();
        APIResponseData<?> apiResponseData = APIResponseData
                .builder()
                .data(userService.getUserByUsername(userDetail.getUsername()))
                .build();
        return new ResponseEntity<>(apiResponseData, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> index() {
        APIResponseData<?> apiResponseData = APIResponseData
                .builder()
                .data(userService.getAll())
                .build();
        return new ResponseEntity<>(apiResponseData, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {
        APIResponseData<?> apiResponseData = APIResponseData.builder()
                .data(userService.getUserByUsername(username))
                .build();
        return new ResponseEntity<>(apiResponseData, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto input) {
        userService.createUser(input);
        APIResponseData<?> apiResponseData = APIResponseData.builder().build();
        return new ResponseEntity<>(apiResponseData, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@PathVariable("id") String userId) {
        userService.deleteUser(userId);
        APIResponseData<?> apiResponseData = APIResponseData.builder().build();
        return new ResponseEntity<>(apiResponseData, HttpStatus.OK);
    }
}
