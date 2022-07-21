<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>CATEGORY</title>

        <%@include file="../layouts/library.jsp" %>	

    </head>

    <body>

        <%@include file="../layouts/header.jsp" %>	

    

        <div class="container">
            <h1 style="margin: 1rem 0">CATEGORY<a href="./add.html" class="btn btn-primary"><i class="far fa-plus-square"></i></a></h1>
            <table border="2" cellspacing="0" cellpadding="0" class="table">
                <th>ID</th>
                <th>Name</th>                                
                    <c:forEach var="category" items="${listCategory}">
                    <tr>
                        <td> ${category.id} </td>
                        <td> ${category.name} </td>                                        
                        <td>
                            <a href="./delete.html?id=${category.id}" style="color: red"><i class="fas fa-trash-alt"></i></a> 
                            <a href="./edit.html?id=${category.id}"><i class="far fa-edit"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <%@include file="../layouts/footer.jsp" %>

        <!-- jQuery Plugins -->
        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/slick.min.js"></script>
        <script src="../js/nouislider.min.js"></script>
        <script src="../js/jquery.zoom.min.js"></script>
        <script src="../js/main.js"></script>

    </body>

</html>
