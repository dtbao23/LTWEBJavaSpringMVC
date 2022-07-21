<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>List Shop</title>

        <%@include file="../layouts/library.jsp" %>	

    </head>

    <body>

        <%@include file="../layouts/header.jsp" %>	



        <div class="container">
            <h1 style="margin: 1rem 0">SHOP</h1>
            <table border="2" cellspacing="0" cellpadding="0" class="table">
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>                
                <th>Phone Number</th>
                <th>Status</th>      
                    <c:forEach var="shop" items="${listShop}">
                    <tr>
                        <td> ${shop.id} </td>
                        <td> ${shop.name} </td>
                        <td> ${shop.address} </td>
                        <td> ${shop.phone_number} </td>                     
                        <td>
                            <c:if test="${shop.enabled == 0}">    
                                <a href="./editrules.html?id=${shop.id}&userid=${shop.user_id}"><button type="button" class="btn btn-success">Duyệt</button></a> 
                                <a href="./delete.html?id=${shop.id}"><button type="button" class="btn btn-secondary">Không duyệt</button></a> 
                            </c:if>
                            <c:if test="${shop.enabled == 1}">    
                                <button type="button" class="btn btn-primary">Đang hoạt động</button>
                            </c:if>

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
