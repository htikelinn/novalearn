package com.example.novalearn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.novalearn.dao.UserDao;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

    @Autowired   
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsernameOrEmail(username).map(SecurityUser::new)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
