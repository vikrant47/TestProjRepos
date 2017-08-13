/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.controllers;

import com.solutech.trackae.repository.RoleRepository;
import com.solutech.trackae.response.Operation;
import com.solutech.trackae.response.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Office
 */
@RestController
@RequestMapping("/appAdmin")
public class AdminController {
    @Autowired
    RoleRepository roleRepository;
    
    @RequestMapping(value = {"/roles/all"}, method = RequestMethod.GET)
    public RestResponse getAllRoles() {
        RestResponse restResponse = new RestResponse();
        restResponse.data(roleRepository.findAll());
        System.out.println("com.solutech.trackae.controllers.AdminController.getUserInfo()");
        return restResponse.operation(Operation.FETCH);
    }
    @RequestMapping(value = {"/roles/all"}, method = RequestMethod.GET)
    public RestResponse getAllRoles() {
        RestResponse restResponse = new RestResponse();
        restResponse.data(roleRepository.findAll());
        System.out.println("com.solutech.trackae.controllers.AdminController.getUserInfo()");
        return restResponse.operation(Operation.FETCH);
    }
}
