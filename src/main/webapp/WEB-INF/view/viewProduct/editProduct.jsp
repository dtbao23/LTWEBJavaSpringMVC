<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>HOME</title>

        <%@include file="../layouts/library.jsp" %>	

    </head>

    <body>

        <%@include file="../layouts/header.jsp" %>	

        

        <div class="container">
            <form action="./editsave.html" method="POST" class="m-5">
                <div class="mb-3">
                    <label for="Product" class="form-label">Id Product</label>
                    <input type="text" readonly value="${data.product.id}" class="form-control" name="id">
                </div>

                <div class="mb-3">
                    <label for="Product" class="form-label">Product Name</label>
                    <input type="text" value="${data.product.name}" class="form-control" name="name">
                </div>


                <div class="mb-3">
                    <label for="price" class="form-label">Price</label>
                    <input type="text" value="${data.product.price}" class="form-control" name="price">
                </div>
                <div class="mb-3">
                    <label for="Amount" class="form-label">Price Discount</label>
                    <input type="text" value="${data.product.price_discount}" class="form-control" name="price_discount">
                </div>   
               <div class="mb-3">
                    <label for="category" class="form-label">Category</label>
                    <select class="form-select" name="category_id" >
                        <c:forEach var="category" items="${data.listCategory}">                           
                            <option value="${category.id}" ${category.id == data.product.category_id ? 'selected="selected"' : ''}>${category.name} </option>
                        </c:forEach>     
                    </select>
                </div>
                <button type="submit" class="btn btn-primary" id="btnEditSubmit">Submit</button>
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

