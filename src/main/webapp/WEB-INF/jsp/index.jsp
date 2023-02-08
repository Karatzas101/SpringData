<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Car Form</h1>
        <form enctype="multipart/form-data" action="car/insert" method="post">
            
            Plate <input type="text" name="plate"/><br>
            Power <input type="number" name="power"/><br>
            Insurance <input type="file" name="insurance"/><br>
            <input type="submit">
        </form>
    </body>
</html>
