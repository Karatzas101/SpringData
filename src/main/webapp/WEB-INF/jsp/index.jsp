<%-- 
    Document   : index
    Created on : Feb 1, 2023, 4:25:17 PM
    Author     : karat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Car Form</h1>
        <form action="car/insert" method="post">
            
            Plate <input type="text" name="plate"/>
            Power <input type="number" name="power"/>
            <input type="submit">
        </form>
    </body>
</html>
