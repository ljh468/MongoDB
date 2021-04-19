<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loginpage</title>
</head>
<body>

<form class="login100-form validate-form" action="/user/loginProc.do" method="post">
               
<div class="wrap-input100 validate-input m-b-23"
                  data-validate="Username is reauired">
                  <span class="label-input100">Username</span> <input
                     class="input100" type="text" name="id"
                     placeholder="Type your username" /> <span class="focus-input100"
                     data-symbol="&#xf206;"></span>
               </div>

               <div class="wrap-input100 validate-input"
                  data-validate="Password is required">
                  <span class="label-input100">Password</span> <input
                     class="input100" type="password" name="pwd"
                     placeholder="Type your password" /> <span class="focus-input100"
                     data-symbol="&#xf190;"></span>
               </div>
               
<div class="wrap-login100-form-btn">
                     <div class="login100-form-bgbtn"></div>
                     <button type="submit" class="login100-form-btn btn">Login</button>
                  </div>
</form>
</body>
</html>