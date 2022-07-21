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
            <form action="./addsave.html" method="POST" class="m-5">               
                <div class="mb-3">
                    <label for="Category" class="form-label">Category Name</label>
                    <input type="text" class="form-control" name="name">
                </div>                              
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
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


