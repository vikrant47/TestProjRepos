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
import com.solutech.trackae.service.MessageService;
import com.solutech.trackae.service.RoleService;
import com.solutech.trackae.service.UserService;
import com.solutech.trackae.utils.ReflectionUtils;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
    RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MessageService messageService;

    /**
     * Return user object as json Clone user object by setting password to blank
     * This would be more safe for client end
     */
    @RequestMapping(value = {"/user/info"}, method = RequestMethod.GET)
    public RestResponse getUserInfo() {
        RestResponse restResponse = new RestResponse();
        restResponse.modal(userService.memCopy(sessionComponent.getUser()));
        return (restResponse);
    }

    @RequestMapping(value = {"/user/profile/update"}, method = RequestMethod.POST)
    public RestResponse updateProfile(@RequestBody User userData) {
        RestResponse restResponse = new RestResponse();
        User user = sessionComponent.getUser();
        User findUserWithId = userRepository.findByEmpId(userData.getEmpId());
        if (findUserWithId != null && !findUserWithId.getId().equals(user.getId())) {
            restResponse.failed().flash(messageService.getMessage("user.empId.duplicate"));
        } else {
            user.setName(userData.getName());
            user.setEmail(userData.getEmail());
            user.setPhone(userData.getPhone());
            userRepository.save(user);
            restResponse.flash(messageService.getMessage("update.success"));
        }
        restResponse.modal(userService.memCopy(user)).operation(Operation.UPDATE);
        return restResponse;
    }

    @RequestMapping(value = {"/user/password/update"}, method = RequestMethod.POST)
    public RestResponse updatePassword(@RequestBody Map paramMap) {
        RestResponse restResponse = new RestResponse();
        User user = sessionComponent.getUser();
        if (bCryptPasswordEncoder.matches(paramMap.get("password") + "", user.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(paramMap.get("newPassword") + ""));
            userRepository.save(user);
        } else {
            restResponse.failed()
                    .putMessage("content", "Password doesn't matched,Please try again")
                    .putMessage("title", "Info");
        }
        restResponse.modal(user).operation(Operation.UPDATE);
        return (restResponse).flash(messageService.getMessage("default.update"));
    }

    @RequestMapping(value = {"/roles/all"}, method = RequestMethod.GET)
    public RestResponse getAllRoles() {
        RestResponse restResponse = new RestResponse();
        restResponse.modal(roleService.findAllRoles(sessionComponent.getUser()));
        return restResponse.operation(Operation.FETCH);
    }

    @RequestMapping(value = {"/user/add"}, method = RequestMethod.POST)
    public RestResponse addUser(@RequestBody User user) {
        RestResponse restResponse = new RestResponse();
        User findUserWithId = userRepository.findByEmpId(user.getEmpId());
        if (findUserWithId != null) {
            restResponse.failed().flash(messageService.getMessage("user.empId.duplicate"));
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            restResponse.flash(messageService.getMessage("default.add"));
        }
        return restResponse.operation(Operation.CREATE).modal(user);
    }

    @RequestMapping(value = {"/user/all"}, method = RequestMethod.GET)
    public RestResponse getAllUser() {
        RestResponse restResponse = new RestResponse();
        restResponse.modal(userRepository.findAll());
        return restResponse.operation(Operation.FETCH);
    }
}
