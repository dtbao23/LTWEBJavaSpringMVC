<%-- 
    Document   : header
    Created on : Jul 2, 2022, 5:49:18 AM
    Author     : ThaiBao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- HEADER -->
<header>
    <!-- top Header -->
    <div id="top-header">
        <div class="container">
            <div class="pull-left">
                <span>Welcome to E-shop!</span>
            </div>
            <div class="pull-right">
                <ul class="header-top-links">
                    <li><a href="#">Store</a></li>
                    <li><a href="#">Newsletter</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li class="dropdown default-dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">ENG <i class="fa fa-caret-down"></i></a>
                        <ul class="custom-menu">
                            <li><a href="#">English (ENG)</a></li>
                            <li><a href="#">Russian (Ru)</a></li>
                            <li><a href="#">French (FR)</a></li>
                            <li><a href="#">Spanish (Es)</a></li>
                        </ul>
                    </li>
                    <li class="dropdown default-dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">USD <i class="fa fa-caret-down"></i></a>
                        <ul class="custom-menu">
                            <li><a href="#">USD ($)</a></li>
                            <li><a href="#">EUR (€)</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!-- /top Header -->

    <!-- header -->
    <div id="header">
        <div class="container">
            <div class="pull-left">
                <!-- Logo -->
                <div class="header-logo">
                    <a class="logo" href="#">
                        <img src="../img/logo1.png" alt="">
                    </a>
                </div>
                <!-- /Logo -->

                <!-- Search -->
                <div class="header-search">
                    <form>
                        <input class="input search-input" type="text" placeholder="Enter your keyword">
                        <select class="input search-categories">
                            <option value="0">All Categories</option>
                            <option value="1">Category 01</option>
                            <option value="1">Category 02</option>
                        </select>
                        <button class="search-btn"><i class="fa fa-search"></i></button>
                    </form>
                </div>
                <!-- /Search -->
            </div>
            <div class="pull-right">
                <ul class="header-btns">
                    <!-- Account -->
                    <li class="header-account dropdown default-dropdown">
                        <div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
                            <div class="header-btns-icon">
                                <i class="fa fa-user-o"></i>
                            </div>
                            <strong class="text-uppercase">My Account <i class="fa fa-caret-down"></i></strong>
                        </div>                                                                                                                                                                        
                    <c:if test="${empty LoginInfo}">
                        <a href="../account/login.html" class="text-uppercase">Login</a> 
                        / <a href="../account/signup.html" class="text-uppercase">Signup</a>
                        <ul class="custom-menu">                                                   
                            <li><a href="#"><i class="fa fa-user-o"></i> Bạn chưa đăng nhập</a></li>								
                        </ul>
                    </c:if>
                    <c:if test="${!empty LoginInfo   }">    
                        <a href="#" class="text-uppercase">${LoginInfo.username}</a> 
                        <ul class="custom-menu">                                                                         
                            <li><a href="#"><i class="fa fa-user-o"></i>${LoginInfo.username}</a></li>
                            <c:if test="${LoginInfo.rules_id == 1}">                                              
                                <li><a href="/onlinemarket/shop/list.html"><i class="fa fa-shopping-bag"></i>Danh sách các Shop đang chờ xét duyệt</a></li>
                            </c:if>
                            <c:if test="${LoginInfo.rules_id == 2}">    
                                <li><a href="/onlinemarket/order/list.html"><i class="fa fa-credit-card"></i>Đơn hàng</a></li>        
                                <li><a href="/onlinemarket/cart/detail.html"><i class="fa fa-cart-plus"></i>Giỏ hàng</a></li>                              
                            </c:if>
                            <c:if test="${LoginInfo.rules_id == 3}">                                             
                                <li><a href="/onlinemarket/shop/signup.html"><i class="fa fa-shopping-bag"></i>Thông tin cửa hàng</a></li>
                            </c:if>
                            <li><a href="/onlinemarket/account/logout.html"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </c:if>
                    </li>
                    <!-- /Account -->

                    <!-- Cart -->
                    <li class="header-cart dropdown default-dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                            <div class="header-btns-icon">
                                <i class="fa fa-shopping-cart"></i>
                                <span class="qty">${totalQuantity}</span>
                            </div>
                            <strong class="text-uppercase">My Cart:</strong>
                            <br>
                            
                        </a>
                        <div class="custom-menu">
                            <div id="shopping-cart">
                                <div class="shopping-cart-list">
                                    <div class="product product-widget">
                                        <div class="product-thumb">
                                            <img src="../img/thumb-product01.jpg" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-price">$32.50 <span class="qty">x3</span></h3>
                                            <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                                        </div>
                                        <button class="cancel-btn"><i class="fa fa-trash"></i></button>
                                    </div>
                                    <div class="product product-widget">
                                        <div class="product-thumb">
                                            <img src="../img/thumb-product01.jpg" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-price">$32.50 <span class="qty">x3</span></h3>
                                            <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                                        </div>
                                        <button class="cancel-btn"><i class="fa fa-trash"></i></button>
                                    </div>
                                </div>
                                <div class="shopping-cart-btns">
                                    <a href="/onlinemarket/cart/detail.html" class="main-btn" role="button" aria-pressed="true">View Cart</a>                                            
                                </div>
                            </div>
                        </div>
                    </li>
                    <!-- /Cart -->

                    <!-- Mobile nav toggle-->
                    <li class="nav-toggle">
                        <button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
                    </li>
                    <!-- / Mobile nav toggle -->
                </ul>
            </div>
        </div>
        <!-- header -->
    </div>
    <!-- container -->
</header>
<!-- /HEADER -->      
<!-- NAVIGATION -->
<div id="navigation">
    <!-- container -->
    <div class="container">
        <div id="responsive-nav">				
            <!-- menu nav -->
            <div class="menu-nav">
                <span class="menu-header">Menu <i class="fa fa-bars"></i></span>
                <ul class="menu-list">
                    <li><a href="/onlinemarket/homepage.html">Home</a></li>
                    <c:if test="${!empty LoginInfo && LoginInfo.rules_id != 2}">      
                        <li><a href="/onlinemarket/category/list.html">Category</a></li>
                        <li><a href="/onlinemarket/product/list.html">Product</a></li>		
                    </c:if>

            </div>
            <!-- menu nav -->
        </div>
    </div>
    <!-- /container -->
</div>
<!-- /NAVIGATION -->