/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author rosen
 */
@Entity
@Table(name = "roles")

public class Role implements GrantedAuthority {

    @Id
    @javax.persistence.Id
    private String nomeRole;

    @ManyToMany
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
