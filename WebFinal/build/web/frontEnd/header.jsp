<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!--        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>-->

    </head>
    
    <body id="top">
        
        <div id="over"></div>
        <div id="header">
            <div class="navbar navbar-expand-lg navbar-dark">
                <div class="logo">
                    <a href="/WebFinal/danhSachSanPham">
                        <img class="pic" src="image/NA_STORE4.png" alt="logo">
                    </a>
                </div>
                <div class="search">
                    <div class="container-1">
                        <input type="search" id="filter" placeholder="Search..." />
<!--                        <div id="filter_hidden"> 
                        </div>-->
                        <button id="hello" class="icon"><i class="fa fa-search"></i></button>
                    </div>
                </div>
                
                <div class="sign">
                    <nav class="navbar navbar-expand-sm">
                        <c:if test="${login!=null}">
                            <div class="user_info">
                                <i class="fas fa-user-circle"></i>
                                <p>Xin Chao ${userTen}</p> 
                            </div>
                            <div class="logout">
                                <button><a href="logout">Logout</a></button>
                            </div>    
                        </c:if>
                        <c:if test="${login==null}" >    
                            <ul class="navbar-nav">
                              <li class="nav-item">
                                  <button id="log-in" class="nav-link" ><p>Sign in</p></button>
                              </li>
                            </ul>
                        </c:if>
                    </nav>
                    <div id="dialog1">
                        <dialog id="dialog-sign">                           
                            <div class="close-sign"><i class="fas fa-times-circle"></i></div>
                            <form id="frm-login" method="post" action="danhSachSanPham">
                                <h1><b>Đăng nhập</b></h1>
                                <div class="info">
                                    <div class="label">Tài Khoản</div>
                                    <div><input type="text" name="txtUser" id="acc"></div>
                                </div>
                                <div class="info">
                                    <div class="label">Mật khẩu</div>
                                    <div><input type="password" name="txtPass" id="pass"></div>
                                </div>
                                <div id="msg" style="color: red"></div>
                                <div class="btn-sign">
                                    <button id="sig" type="submit" class="sign-in btn-in"><p>ĐĂNG NHẬP</p></button> 
                                    <p id="resgister" class="sign-in btn-up" >ĐĂNG KÝ</p>
                                </div>
                            </form>
<!--                            <div class="btn-sign btn-res"></div>-->
                        </dialog>
                    </div>    
                    <div id="dialog2">
                        <dialog id="dialog-res">
                            <div class="close-res"><i class="fas fa-times-circle"></i></div>
                            <div class="form">
                                <div class="center">
                                    <h2><b>Đăng ký tài khoản</b></h2>
                                    <p>Chú ý các nội dung có dấu * bạn cần phải nhập</p>
                                </div>
                                <div id="registerForm">
                                    <form method="post" action="Register">
                                        <div class="form-controls">
                                            <div class="label">Tài Khoản:</div>
                                            <div class="controls"><input type="text" name="username"></div>
                                        </div>
                                        <div class="form-controls">
                                            <div class="label">Mật khẩu:</div>
                                            <div class="controls"><input type="password" name="password"></div>
                                        </div>
                                        <div class="form-controls">
                                            <div class="label">Họ và tên:</div>
                                            <div class="controls"><input type="text" name="hoTen"></div>
                                        </div>
                                        <div class="form-controls">
                                            <div class="label">Số điện thoại:</div>
                                            <div class="controls"><input type="number" name="sdt" ></div>
                                        </div>
                                        <div class="form-controls">
                                            <div class="label">Ngày sinh:</div>
                                            <div class="controls"><input type="date" name="DoB"></div>
                                        </div>
                                        <div class="form-controls">
                                            <div class="label">Địa chỉ:</div>
                                            <div class="controls"><input type="text" name="diaChi"></div>
                                        </div>
                                        <div class="submit-controls">
                                            <button class="btn-sub" type="submit">Đăng ký tài khoản</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </dialog>
                    </div>
                </div>
            </div>
            <div class="menu_head">
                <ul>
                    <li><a aria-current="page" class="active" href="danhSachSanPham">HOME</a></li>
                    <li><a href="danhSachSanPham">Laptop</a></li>
                    <li><a href="#">Smartphone</a></li>
                    <li><a href="#">Watch</a></li>
                </ul>
                <div id="cart">
                    <button class="btn-cart">
                        <a href="Cart"><i style="color: white" class="fas fa-cart-plus"> Giỏ hàng</i></a>
                    </button>
                </div>    
            </div>
        </div>
        <div id="content">
            <div class="content-left">
<!--                <div class="ads">
                    <img src="image/Ads.jpg" alt=""/>
                </div>-->
            </div>
            <div class="content-mid">
