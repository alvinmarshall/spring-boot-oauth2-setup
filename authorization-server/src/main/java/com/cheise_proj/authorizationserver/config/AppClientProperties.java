package com.cheise_proj.authorizationserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.HashSet;
import java.util.Set;

@Configuration
@ConfigurationProperties(prefix = "client")
@Data
public class AppClientProperties {
    private Set<ClientProperties> registeredClients = new HashSet<>();

    @Data
    public static class ClientProperties {
        private String id;
        private String clientId;
        private String clientSecret;
        private Set<String> redirectUris;
        private Set<String> scopes;
        private Set<ClientAuthenticationMethod> clientAuthenticationMethods = new HashSet<>();
        private Set<AuthorizationGrantType> authorizationGrantTypes = new HashSet<>();
    }
}
