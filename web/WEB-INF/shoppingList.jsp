<%-- 
    Document   : shoppingList
    Created on : 13-Oct-2017, 10:53:20 AM
    Author     : 709317
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href ="ShoppingList?action=logout" >Logout</a></p>
        <h2>List</h2>
        <div>
            <form action="ShoppingList" method="POST">
                <p>Add item:
                <input type="text" name="item">
                <input type="submit" value="Add">
                <input type="hidden" name="action" value="add"></p>               
            </form>
        </div>
        
        <div>
         
            <form action="ShoppingList" method="POST">   
                <c:forEach items="${itemlist}" var="item"  varStatus="status">
                <ul>
                <li>     
                    <input type="radio" name="itemname" value="${status.index}">${item}
                </li>
                </ul> 
                </c:forEach>
                <c:if test="${itemlist.size() > 0}">     

                        <input type="submit" value ="Delete">
                        <input type="hidden" name="action" value="delete"><br>
                </c:if>
          
            </form>

            ${message}
            
        </div>
    </body>
</html>
