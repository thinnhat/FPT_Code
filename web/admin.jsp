<%-- 
    Document   : foodList
    Created on : 30-10-2022
    Author     : hd
--%>


<%@page import="java.util.List"%>
<%@page import="prj302.pe.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Food List Page</title>
    </head>
    <body>
        <!--your code here-->
        <%
            String search = (String) request.getAttribute("search");
            if (search == null) {
                search = "";
            }
        %>
        <a href="MainController?action=Logout">Logout</a>
        <a href="MainController?action=CreatePage">Create New User</a>
        <form action="MainController">
            Search: <input type="text" name="search" value="<%=search%>">
                           <input type="submit" name="action" value="Search">
        </form>

        <%
            List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (listUser != null) {
                if (listUser.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : listUser) {
                %>
                <tr>
            <form action="MainController">    
                    <td><%=count++%></td>
                    <td><input type="text" name="userID" value="<%=user.getUserID()%>"></td>
                    <td><input type="text" name="fullName" value="<%=user.getFullName()%>"></td>
                    <td><input type="text" name="roleID" value="<%=user.getRoleID()%>"></td>
                    <td><%= user.getPassword()%></td>
                    <td>
                        <input type="submit" name="action" value="Update">
                        <input type="hidden" name="search" value="<%=search%>"
                    </td>
                    <td>
                        <a href="MainController?action=Delete&userID=<%=user.getUserID()%>&search=<%=search%>">Delete</a>
                    </td>
            </form>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
                }
            }
        %>
    </body>
</html>
