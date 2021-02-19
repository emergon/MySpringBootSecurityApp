/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.MyUser;
import emergon.entity.Role;
import emergon.repo.UserRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    
    @Override
    public MyUser findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Get MyUser from DB
        MyUser myuser = findByUsername(username);
        //if user not exists then throw the exception
        if(myuser == null){
            throw new UsernameNotFoundException("Invalid username");
        }
        //else return The User Object that Spring Security needs
        List<GrantedAuthority> authorities = convertRolesToGrantedAuthorities(myuser.getRoles());
        User userOfSpringSecurity = new User(myuser.getUsername(), myuser.getPassword(), authorities);
        return userOfSpringSecurity;
    }
    
    private List<GrantedAuthority> convertRolesToGrantedAuthorities(List<Role> roles){
        List<GrantedAuthority> authorities = new ArrayList();
        for(Role r : roles){
            GrantedAuthority authority = new SimpleGrantedAuthority(r.getRname());
            authorities.add(authority);
        }
        return authorities;
    }
    
}
