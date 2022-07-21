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
        <c:if test="${shop.enabled == 0}">    
            <h1 style="text-align: center">Đang chờ xét duyệt</h1>
        </c:if>
        <c:if test="${shop.enabled == 1}">               
            <div class="signup-form" style="text-align-last: center">
                <form action="./signup/add.html" method="post" >
                    <h1 style="margin: 1rem 0">INFOMATION SHOP</h1>
                    <div class="form-group" >
                        <div class="row">
                            <div class="col"><input type="text" class="form-control" name="name" placeholder="Name Shop" value="${shop.name}" required="required"></div>
                        </div>        	
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="phone_number" placeholder="Phone Number" value="${shop.phone_number}" required="required">
                    </div>      
                    <div class="form-group">
                        <input type="text" class="form-control" name="address" placeholder="Address" value="${shop.address}" required="required">
                    </div>                           
                </form>          
            </div>
        </div>
    </div>
</c:if>


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
