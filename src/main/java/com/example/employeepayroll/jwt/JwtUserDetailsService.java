package com.example.employeepayroll.jwt;

import com.example.employeepayroll.repository.UserEntityRepo;
import com.example.employeepayroll.dto.UserEntityDTO;
import com.example.employeepayroll.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityRepo userEntityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity= (UserEntity) userEntityRepo.findByUserNameEntity(username);

        if(userEntity==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(userEntity.getUserNameEntity()
                ,userEntity.getPasswordEntity(),new ArrayList<>());
    }

    public UserEntity saveUser(UserEntityDTO userEntityDTO){
//        TELL ABOUT DUPLICATE ENTRY
        UserEntity newUserEntity=new UserEntity();
        newUserEntity.setUserNameEntity(userEntityDTO.getUserNameEntity());
        newUserEntity.setPasswordEntity(passwordEncoder.encode(userEntityDTO.getPasswordEntity()));
        return userEntityRepo.save(newUserEntity);

    }


}
