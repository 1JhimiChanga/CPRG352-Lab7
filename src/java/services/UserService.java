/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;

/**
 *
 * @author Jimmy
 */
public class UserService {
    //REMEMBER YOU DIDNT DO THE "GET" METHOD
    public List<User> getAll(String email) throws Exception{
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll(email);
        return users;
    }
    
    public void insert(String email, int active, String firstName, String lastName, String password, int role) throws Exception{
        User user = new User(email, active, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email,int active, String firstName, String lastName, String password, int role) throws Exception{
        User user = new User(email, active, firstName, lastName, password, role);
        
        
    }
    
    
    
}
