package com.cheise_proj.authservice.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "permission")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Permission extends BaseModel {
    private String name;
}
