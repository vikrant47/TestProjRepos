package com.solutech.trackae.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

    public static String DEVELOPER = "DEVELOPER";
    public static String ADMIN = "ADMIN";

    public Role() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "role_name")
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role) {
        this.roleName = role;
    }

}
