
<%-- 
    Document   : register
    Created on : 13-Oct-2017, 10:59:35 AM
    Author     : 709317
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
        <form action="ShoppingList" method="POST">
            Username: 
            <input type="text" name="username">
            <input type ="submit" value="Register name">
            <input type="hidden" name="action" value="register"><br>
        </form>
        </div>
        
        ${message}
        
    </body>
</html>
