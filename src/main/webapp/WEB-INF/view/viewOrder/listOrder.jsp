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
            <h1 style="margin: 1rem 0">ORDER</h1>
            <table border="2" cellspacing="0" cellpadding="0" class="table">
                <th>ID</th>
                <th>Số lượng loại sản phẩm</th>
                <th>Tổng hoá đơn</th>                
                <th>Trạng thái giao hàng</th>    
                <th>Xem chi tiết đơn hàng</th>
                    <c:forEach var="order" items="${listOrder}">
                    <tr>
                        <td> ${order.id} </td>
                        <td> ${order.quantity} </td>
                        <td> ${order.totalPrice} </td>
                        <td> Đang giao hàng </td>    
                        <td>
                            <a href="./detail.html?id=${order.id}" style="color: red"><i class="fa fa-list"></i></a>                            
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

