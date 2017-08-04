/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Office
 */
@Controller
public class IndexController {
    private static Logger logger = Logger.getLogger(IndexController.class.getName());
    @RequestMapping("/")
    public String helloWorld() {
        logger.info("Recieved Request");
        return "index";
    }
}
