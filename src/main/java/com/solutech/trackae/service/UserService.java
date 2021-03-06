package com.solutech.trackae.service;

import com.solutech.trackae.model.Role;
import com.solutech.trackae.model.User;
import com.solutech.trackae.repository.RoleRepository;
import com.solutech.trackae.repository.UserRepository;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        userRepository.save(user);
    }
    public User memCopy(User user) {
        User copy = new User();
        BeanUtils.copyProperties(user, copy);
        copy.setPassword("");
        return copy;
    }


}
