//package com.project.gym.management.system.Models;
//
////import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//public class ApplicationUser implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(unique = true)
//    private String username;
//    private String password;
//    private String firstName;
//    private String lastName;
//    private String dob;
//    private String email;
//    private String type;
//
//    public ApplicationUser(String username, String encode, String firstName, String lastName, String dob, String type) {
//    }
//
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public ApplicationUser(){
//
//    }
//
//
//    public ApplicationUser(String username, String password, String firstName, String lastName, String dob, String email, String type) {
//        this.username = username;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dob = dob;
//        this.email = email;
//        this.type = type;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
////        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
////        grantedAuthorities.add(simpleGrantedAuthority);
////        return grantedAuthorities;
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//
//    //    public String getAuthority() {
////        return authority;
////    }
//
////    public void setAuthority(String authority) {
////        this.authority = authority;
////    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//
//    @Override
//    public String toString() {
//        return "ApplicationUser{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", dob='" + dob + '\'' +
//                '}';
//    }
//}
