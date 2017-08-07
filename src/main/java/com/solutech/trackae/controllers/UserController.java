/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.controllers;

import com.solutech.trackae.component.SessionComponent;
import com.solutech.trackae.model.User;
import com.solutech.trackae.service.UserService;
import java.util.HashMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Office
 */
@RestController
@Scope("session")
public class UserController {

    @Autowired
    private SessionComponent sessionComponent;
    @Autowired
    private UserService userService;

    /**
     * Return user object as json Clone user object by setting password to blank
     * This would be more safe for client end
     */
    @RequestMapping(value = {"/user/info"}, method = RequestMethod.GET)
    public User getUserInfo() {
        User copy = new User();
        BeanUtils.copyProperties(sessionComponent.getUser(), copy);
        copy.setPassword("******");
        return copy;
    }
}
