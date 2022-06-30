/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author Jimmy
 */
public class UserDB {
    
    
    //REMEMBER YOU DIDNT DO THE "GET" METHOD
    public List<User> getAll(String first) throws SQLException{
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE firstname=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, first);
            rs = ps.executeQuery();
            while(rs.next()){
                String email = rs.getString(1);
                int active = rs.getInt(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String password = rs.getString(5);
                int role = rs.getInt(6);
                User user = new User(email, active, firstName, lastName, password, role);
                users.add(user);
                 
            }
        } finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return users;
        
    }
    
    public void insert(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO user (email, active, first_name, last_name, password, role) VALUES(?,?,?,?,?,?) ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setInt(2, user.getActive());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole());
            
        } finally{
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void update(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE user SET email=?, first_name=?, last_name=?, role=? WHERE email=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
        } finally{
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void delete(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM user WHERE email=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.executeQuery();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
                
             
        
    }
    
}
