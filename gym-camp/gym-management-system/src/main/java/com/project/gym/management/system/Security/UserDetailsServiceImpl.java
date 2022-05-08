//package com.project.gym.management.system.Security;
//
//
//import com.project.gym.management.system.Models.ApplicationUser;
//import com.project.gym.management.system.Repositories.ApplicationUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    ApplicationUserRepository appUserRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        ApplicationUser applicationUser= appUserRepository.findByUsername(username);
//        if(applicationUser==null){
//            throw new UsernameNotFoundException("the user name "+username+"not found");
//        }
//        return applicationUser;
//    }
//
//}
