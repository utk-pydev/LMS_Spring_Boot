package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.MyUser;
import com.example.LibraryManagementSystem.Repository.MyUserCacheRepository;
import com.example.LibraryManagementSystem.Repository.MyUserRepository;
import com.example.LibraryManagementSystem.Request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    MyUserCacheRepository myUserCacheRepository;

    @Autowired
    MyUserRepository myUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Value("${users.admin.authority}")
    String adminAuthority;

    @Value("${users.student.authority}")
    String studentAuthority;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserCacheRepository.get(username);
        if(myUser == null){
            myUser = myUserRepository.findByUsername(username);
            if(myUser == null){
                throw  new UsernameNotFoundException("Username is not present");
            }
            myUserCacheRepository.set(myUser);
        }
        return  myUser;
    }

    public MyUser createUser(UserCreateRequest userCreateRequest){
        MyUser.MyUserBuilder myUserBuilder = MyUser.builder()
                .username(userCreateRequest.getUsername())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()));

        if(userCreateRequest.getStudent() != null){
            myUserBuilder.authority(studentAuthority);
        }
        else{
            myUserBuilder.authority(adminAuthority);
        }

        return myUserRepository.save(myUserBuilder.build());
    }

}
