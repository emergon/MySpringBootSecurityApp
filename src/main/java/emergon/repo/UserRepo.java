/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repo;

import emergon.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer>{
    
    @Query(value = "SELECT u FROM MyUser u WHERE u.username = ?1")
    MyUser findByUsername(String username);
    
}
