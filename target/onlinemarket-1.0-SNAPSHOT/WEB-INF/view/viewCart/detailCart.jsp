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

        <!-- section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <form id="checkout-form" class="clearfix" acction="/onlinemarket/order/add.html" method="POST">                       
                        <div class="col-md-12">
                            <div class="order-summary clearfix">
                                <div class="section-title">
                                    <h3 class="title">Order Review</h3>
                                </div>
                                <table class="shopping-cart-table table">
                                    <thead>
                                        <tr>
                                            <th>Product</th>
                                            <th></th>   
                                            <th class="text-center">Price</th>
                                            <th class="text-center">Quantity</th>
                                            <th class="text-center">Total</th>
                                            <th class="text-right"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cart" items="${myCart}">
                                            <tr>
                                                <td class="thumb"><img src="../img/thumb-product01.jpg" alt=""></td>
                                                <td class="details">
                                                    <a href="#">${cart.value.product.name}</a>
                                                    <ul>
                                                        <li><span>Size: XL</span></li>
                                                        <li><span>Color: Camelot</span></li>
                                                    </ul>
                                                </td>
                                                <td class="price text-center"><strong>${cart.value.product.price_discount}</strong><br><del class="font-weak"><small>${cart.value.product.price}</small></del></td>
                                                <td class="qty text-center"><input class="input" type="number" min="1" value="${cart.value.qty}"></td>
                                                <td class="total text-center"><strong class="primary-color">${cart.value.price}</strong></td>
                                                <td class="text-right" ><a href="/onlinemarket/cart/delete.html?id=${cart.value.product.id}" class="main-btn icon-btn" role="button" aria-pressed="true"><span class="fa fa-close"></span></a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot>                                    
                                        <tr>
                                            <th class="empty" colspan="3"></th>
                                            <th>TOTAL</th>
                                            <th colspan="2" class="total">${totalPrice}</th>
                                        </tr>
                                    </tfoot>
                                </table>
                                <div class="pull-right">
                                    <a href="/onlinemarket/order/add.html" class="primary-btn" role="button" aria-pressed="true">Place Order</a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /section -->

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



