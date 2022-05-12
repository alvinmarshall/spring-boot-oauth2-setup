package com.cheise_proj.authservice.domain.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;

public class CustomClientDetail implements ClientDetails {
    private AppClient appClient;

    public CustomClientDetail(AppClient appClient) {
        this.appClient = appClient;
    }

    @Override
    public String getClientId() {
        return appClient.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return Arrays.stream(appClient.getResourceIds().split(",")).collect(Collectors.toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return appClient.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return Arrays.stream(appClient.getScope().split(",")).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return Arrays.stream(appClient.getAuthorizedGrantTypes().split(",")).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return Arrays.stream(appClient.getClientId().split(",")).collect(Collectors.toSet());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return appClient.getAccessTokenValidity();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return appClient.getRefreshTokenValidity();
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
