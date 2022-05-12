package com.cheise_proj.authservice.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "app_client")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppClient extends BaseModel {
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_secret")
    private String clientSecret;
    @Column(name = "access_token_validity")
    private int accessTokenValidity;
    private String scope;
    private String authorities;
    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;
    @Column(name = "refresh_token_validity")
    private int refreshTokenValidity;
    @Column(name = "resource_ids")
    private String resourceIds;
    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;
    @Column(name = "auto_approve")
    private String autoApprove;
    @Column(name = "add_info")
    private String addInfo;
}
