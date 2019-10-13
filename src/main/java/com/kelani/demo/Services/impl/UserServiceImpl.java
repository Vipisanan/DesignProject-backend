package com.kelani.demo.Services.impl;

import com.kelani.demo.Models.VoterModel;
import com.kelani.demo.Repository.VoterRepository;
import com.kelani.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private VoterRepository voterRepository;

    @Override
    public VoterModel save(VoterModel user) {
        return null;
    }

    @Override
    public List<VoterModel> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String voterId) throws UsernameNotFoundException {
        VoterModel user = voterRepository.findFirstByVoterId(voterId);
        System.out.println("**********************************");
        System.out.println(voterId);
        System.out.println("**********************************");
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getVoterId(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
