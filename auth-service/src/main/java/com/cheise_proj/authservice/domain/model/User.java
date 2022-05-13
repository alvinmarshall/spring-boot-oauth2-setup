package com.cheise_proj.authservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

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
    @JsonIgnore
    private String password;
    @Column(name = "business_unit")
    private String businessUnit;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
