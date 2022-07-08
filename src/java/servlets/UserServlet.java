
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;

/**
 *
 * @author Jimmy
 */
public class UserServlet extends HttpServlet {

    

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
        UserService user = new UserService();
        
        
         try {
            HttpSession session = request.getSession();
            List<User> userList = user.getAll();
            request.setAttribute("UserList",userList);
            
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Not Working");
        }
        
        
        
        
        
      getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
        //Adding Variables 
        String addEmail = request.getParameter("add_email");
        String addFirst = request.getParameter("add_first");
        String addLast  = request.getParameter("add_last");
        String addPassword = request.getParameter("add_password");
        String active = request.getParameter("c_active");
        String role = request.getParameter("add_role");
        //Editing Variables
        String editEmail = request.getParameter("edit_email");
        String editFirst = request.getParameter("edit_first");
        String editLast = request.getParameter("edit_last");
        String editRole = request.getParameter("edit_role");
        
        UserService us = new UserService();
        try {
            us.insert(addEmail, Integer.parseInt(active), addFirst, addLast, addPassword, Integer.parseInt(role));
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("User");
       
        
    }

  

}
