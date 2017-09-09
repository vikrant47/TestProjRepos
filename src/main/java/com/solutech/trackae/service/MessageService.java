/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.service;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Office
 */
@Service
public class MessageService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) {
        return messageSource.getMessage(key, null, Locale.US);
    }
}
