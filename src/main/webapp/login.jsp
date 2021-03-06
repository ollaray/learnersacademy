<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	
	<base href="<%=basePath%>">
	<meta charset="ISO-8859-1">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Learner's Academy:: Login</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="asset/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="asset/vendors/iconfonts/ionicons/dist/css/ionicons.css">
    <link rel="stylesheet" href="asset/vendors/iconfonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="asset/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="asset/vendors/css/vendor.bundle.addons.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/shared/style.css" />
    
    <!-- endinject -->
    <link rel="shortcut icon" href="asset/images/favicon.icoxxx" />
</head>
  <body>
  
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
       
        <div class="content-wrapper d-flex align-items-center auth auth-bg-1 theme-one">
      
          <div class="row w-100">
        
            <div class="col-lg-4 mx-auto">
      			<h4 class="mx-auto" style="color:#FFF;font-weight:bold;text-align:center">LEARNER'S ACADEMY ADMIN PORTAL</h4>
              <div class="auto-form-wrapper">
              	<span style="color:red">${message}</span>
                <form method="post" action="login">
                  <div class="form-group">
                    <label class="label">Email</label>
                    <div class="input-group">
                      <input type="email"  name="email" class="form-control" value="admin@gmail.com" placeholder="Input your email">
                      <div class="input-group-append">
                        <span class="input-group-text">
                          <i class="mdi mdi-check-circle-outline"></i>
                        </span>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="label">Password</label>
                    <div class="input-group">
                      <input type="password" name="pass" value="admin1234" class="form-control" >
                      <div class="input-group-append">
                        <span class="input-group-text">
                          <i class="mdi mdi-check-circle-outline"></i>
                        </span>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <button name="action" class="btn btn-primary submit-btn btn-block">Login</button>
                  </div>
                  <!-- 
                  <div class="form-group d-flex justify-content-between">
                    <div class="form-check form-check-flat mt-0">
                      <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" checked> Keep me signed in </label>
                    </div>
                    <a href="#" class="text-small forgot-password text-black">Forgot Password</a>
                  </div>
                  <div class="form-group">
                    <button class="btn btn-block g-login">
                      <img class="mr-3" src="../asset/images/file-icons/icon-google.svg" alt="">Log in with Google</button>
                  </div>
                  <div class="text-block text-center my-3">
                    <span class="text-small font-weight-semibold">Not a member ?</span>
                    <a href="register.html" class="text-black text-small">Create new account</a>
                  </div>
                  -->
                </form>
              </div>
              <ul class="auth-footer">
              <!--  
                <li>
                  <a href="#">Conditions</a>
                </li>
                <li>
                  <a href="#">Help</a>
                </li>
                <li>
                  <a href="#">Terms</a>
                </li>
                -->
              </ul>
              <p class="footer-text text-center">copyright ? 2021 Learner's Academy. All rights reserved.</p>
              <!-- 
              <p class="footer-text text-center text-center">
              <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank"> Free Bootstrap template </a> from BootstrapDash templates
              </p>
              -->
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="../asset/vendors/js/vendor.bundle.base.js"></script>
    <script src="../asset/vendors/js/vendor.bundle.addons.js"></script>
    <!-- endinject -->
    <!-- inject:js -->
    <script src="../asset/js/shared/off-canvas.js"></script>
    <script src="../asset/js/shared/misc.js"></script>
    <!-- endinject -->
    <script src="asset/js/shared/jquery.cookie.js" type="text/javascript"></script>
  </body>
</html>