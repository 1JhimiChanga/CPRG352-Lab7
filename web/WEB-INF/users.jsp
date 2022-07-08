<%-- 
    Document   : users
    Created on : 28-Jun-2022, 6:42:54 PM
    Author     : Jimmy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="style1.css" type="text/css">
    </head>
    <body>
        
            <h2>Add Users</h2>
                <form method="POST" action="">
                <label>Email: </label>
                <input type="text" name="add_email">
                <br>
                <label>First Name:</label>
                <input type="text" name="add_first">
                <br>
                <label>Last Name: </label>
                <input type="text" name="add_last">
                <br>
                <label>Password: </label>
                <input type="password" name="add_password">
                <br>
                <label>Active?</label>
                <br>
                <input type="radio" name="c_active" value="1">
                <label>Active</label>
                <br>
                <input type="radio" name="c_active" value="0"> 
                <label>Inactive</label>
                <br>
                <label>Role</label>
                <select name="add_role">
                    <option value="1">System Admin</option>
                    <option value="2">Regular User</option>
                    <option vlaue="3">Company Admin</option>
                </select>
            </form>
            <br>
            <p>------------------------------------------------------</p>
            <h2>Manage Users</h2>
            <table>
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${UserList}" var="user">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>
                            <c:if test="${user.role == 1}">
                                <p>System Admin</p>
                            </c:if>
                            <c:if test="${user.role == 2}">
                                <p>Regular User</p>
                            </c:if>
                            <c:if test="${user.role == 3}">
                                <p>Company Admin</p>
                            </c:if>
                        </td>
                        </td>
                        </td>
                        <td>
                            <input type="submit" name="table_edit" value="EDIT">
                        </td>
                        <td>
                            <input type="submit" name="table_delete" value="DELETE">
                        </td>
                    </tr>
                </c:forEach>
            </table>
            
            <p>------------------------------------------------------</p>
            <form method="POST" action="">
                <h2>Edit User</h2>
                <label>Email: </label>
                <input type="text" name="edit_email">
                <br>
                <label>First Name:</label>
                <input type="text" name="edit_first">
                <br>
                <label>Last Name: </label>
                <input type="text" name="edit_last">
                <br>
                <label>Role</label>
                 <select name="edit_role">
                    <option value="system">System Admin</option>
                    <option value="regular">Regular User</option>
                    <option vlaue="company">Company Admin</option>
                </select>
            </form>
       
    </body>
</html>
