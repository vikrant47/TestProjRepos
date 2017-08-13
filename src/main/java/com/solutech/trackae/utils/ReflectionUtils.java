/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

/**
 *
 * @author Office
 */
public class ReflectionUtils {

    public static <T> T getTargetObject(Object proxy) {
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            try {
                return (T) ((Advised) proxy).getTargetSource().getTarget();
            } catch (Exception ex) {
                Logger.getLogger(ReflectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (T) proxy;
    }
}
