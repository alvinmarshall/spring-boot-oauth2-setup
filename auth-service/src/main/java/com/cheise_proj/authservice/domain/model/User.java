package com.cheise_proj.authservice.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class User extends BaseModel {
    private String username;
    private String email;
    private String password;
    @Column(name = "business_unit")
    private String businessUnit;
    @ManyToOne
    private Role role;


}
