package emergon.service;

import emergon.entity.MyUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    
    MyUser findByUsername(String username);
    
    MyUser saveUser(MyUser myuser);
}
