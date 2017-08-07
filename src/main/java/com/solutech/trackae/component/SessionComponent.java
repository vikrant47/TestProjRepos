/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.component;

import com.solutech.trackae.model.User;
import com.solutech.trackae.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Office
 */
@Component
@Scope("session")
public class SessionComponent {

    @Autowired
    private UserRepository userRepository;
    private User user;
    public User getUser() {
        if (user == null) {
            user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        }
        return user;
    }
}
