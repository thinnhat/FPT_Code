<%-- 
    Document   : create
    Created on : Mar 15, 2024, 4:51:48 PM
    Author     : TTNHAT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create new User</h1>
        </br>User ID: <input type="text" name="userID" required="">
        </br>Full Name: <input type="text" name="fullName" required="">
        </br>Role ID: <select name="roleID">
            <option value="AD">AD</option>
            <option value="US">US</option>
        </select>
        </br>Password: <input type="password" name="password" required="">
        </br>Confirm Password: <input type="confirm" name="confirm" required="">
        <input type="submit" name="action" value="Create">
        <input type="reset" value="Reset">
    </body>
</html>
