/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.service;

import com.solutech.trackae.model.Role;
import com.solutech.trackae.model.User;
import com.solutech.trackae.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Office
 */
@Service("roleService")
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /*
        Only developer can add developer role        
     */
    public List<Role> findAllRoles(User user) {
        List<Role> roles = null;
        if (user.getRoles().stream().filter(role -> role.getRoleName().equals(Role.DEVELOPER)).findFirst().get() != null) {
            roles = roleRepository.findAll();
        } else {
            roles = roleRepository.findAll().stream()
                    .filter(role -> !role.getRoleName().equals(Role.DEVELOPER))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return roles;
    }
}
