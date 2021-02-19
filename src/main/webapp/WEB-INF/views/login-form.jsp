<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <c:if test="${param.logout != null}">
            <div class="logout">
                <i>You logged out successfully</i>
            </div>
        </c:if>
        <c:if test="${param.error != null}">
            <div class="error">
                <i>Invalid credentials</i>
            </div>
        </c:if>
        <form:form action="/authenticate" method="POST">
            <p>
                Username: <input type="text" name="username"/>
            </p>
            <p>
                Password: <input type="password" name="password"/>
            </p>
            <input type="submit" value="login"/>
        </form:form>
    </body>
</html>
