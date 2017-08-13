/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.controllers;

import com.solutech.trackae.component.SessionComponent;
import com.solutech.trackae.model.User;
import com.solutech.trackae.repository.UserRepository;
import com.solutech.trackae.response.ErrorType;
import com.solutech.trackae.response.Operation;
import com.solutech.trackae.response.RestResponse;
import com.solutech.trackae.service.UserService;
import com.solutech.trackae.utils.ReflectionUtils;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Return user object as json Clone user object by setting password to blank
     * This would be more safe for client end
     */
    @RequestMapping(value = {"/user/info"}, method = RequestMethod.GET)
    public RestResponse getUserInfo() {
        RestResponse restResponse = new RestResponse();
        restResponse.data(userService.memCopy(sessionComponent.getUser()));
        return (restResponse);
    }

    @RequestMapping(value = {"/user/profile/update"}, method = RequestMethod.POST)
    public RestResponse updateProfile(@RequestBody User userData) {
        RestResponse restResponse = new RestResponse();
        User user = sessionComponent.getUser();
        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        user.setPhone(userData.getPhone());
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            restResponse.failed().putMessage("exception", ex.toString()).errorType(ErrorType.EXCEPTION);
        }
        restResponse.data(userService.memCopy(user)).operation(Operation.UPDATE);
        return (restResponse);
    }

    @RequestMapping(value = {"/user/password/update"}, method = RequestMethod.POST)
    public RestResponse updatePassword(@RequestBody Map paramMap) {
        RestResponse restResponse = new RestResponse();
        User user = sessionComponent.getUser();        
        if (bCryptPasswordEncoder.matches(paramMap.get("password")+"",user.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(paramMap.get("newPassword")+""));
            userRepository.save(user);
        } else {
            restResponse.failed()
                    .putMessage("content", "Password doesn't matched,Please try again")
                    .putMessage("title", "Info");
        }
        restResponse.data(user).operation(Operation.UPDATE);
        return (restResponse);
    }
}
