package com.cheise_proj.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GatewayController {
    @GetMapping
    public ResponseEntity<?> home(Principal principal) {
        return ResponseEntity.ok(principal.getName());
    }
}
