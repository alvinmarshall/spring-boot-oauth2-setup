-- Create app client default-clientId: web-app-client, default-clientSecret: 123456
INSERT INTO oauth2_registered_client (id,
                                      client_id,
                                      client_secret,
                                      scope,
                                      authorization_grant_types,
                                      redirect_uris,
                                      client_authentication_methods,
                                      client_settings,
                                      token_settings)
VALUES ('2d638127-572a-4b6a-bc37-876257511067',
        'web-app-client',
        '{bcrypt}$2a$10$9GWx0Xfl4YjzrMomdh1TzuYFg3iZ4B0DTwgWueTddmBNKYz3TPIu6',
        'openid,customers.read,customers.write',
        'password,authorization_code,refresh_token,client_credentials',
        'http://localhost:8080/login/oauth2/code/web-app-client-oidc,http://localhost:8080/authorized',
        'client_secret_basic',
        '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":true}',
        '{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.token.reuse-refresh-tokens\":true,\"settings.token.id-token-signature-algorithm\":[\"org.springframework.security.oauth2.jose.jws.SignatureAlgorithm\",\"RS256\"],\"settings.token.access-token-time-to-live\":[\"java.time.Duration\",300.000000000],\"settings.token.refresh-token-time-to-live\":[\"java.time.Duration\",3600.000000000]}"');

