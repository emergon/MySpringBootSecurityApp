<%-- 
    Document   : home
    Created on : Feb 18, 2021, 8:46:36 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Spring Security</h1>
        
        <div>
            <a href="/admin">Administrator Home Page</a>
        </div>
        <br/>
        <div>
            <a href="/teacher">Teacher Home Page</a>
        </div>
        <br/>
        <form:form action="/logout" method="POST">
            <input type="submit" value="Logout">
        </form:form>
    </body>
    
    
</html>
