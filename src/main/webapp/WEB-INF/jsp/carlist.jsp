<%-- 
    Document   : carlist
    Created on : Feb 2, 2023, 11:22:50 AM
    Author     : karat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Car List</h1>
         <table border="1">
             
        <tr>
            <td>id</td>
            <td>plate</td>
            <td>power</td>
            <td>Update</td>
            <td>Delete</td>
            <td>Download</td>
         </tr>
         <c:forEach items="${cars}" var="car">
             
         <tr>
            <td>${car.getId()}</td>
            <td>${car.getPlate()}</td>
            <td>${car.getPower()}</td>
            <td><a href="/car/update/${car.getId()}">Update</a> </td>
            <td><a href="/car/delete/${car.getId()}">Delete</a> </td>
            <td><a href="/car/download/${car.getId()}" target="_blank">${car.insurancefilename}</a> </td>
         </tr>
             
         </c:forEach>
    
         </table>
    </body>
</html>
