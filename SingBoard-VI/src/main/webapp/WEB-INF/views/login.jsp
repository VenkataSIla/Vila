
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SignBoard</title>
    <link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
    <link type="text/css" href="/css/app.css" rel="stylesheet" />
    <script type="application/javascript" src="js/jquery.js"></script>
    <script type="application/javascript" src="js/bootstrap.js"></script>
</head>
<c:set var="contextPath" value="${pageContext['request'].contextPath}"/>
<jsp:include page="./common/unAuthHeaderNav.jsp"></jsp:include>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<div id="mainWrapper">
			<div class="login-container">
				<div class="login-card">
					<div class="login-form">
						<form action="/login" method="post" class="form-horizontal">
						  <div class="input-group input-sm">
						     <h3> ${userType} Login</h3>
							 <input type="hidden" name="userType" value="${userType}">  
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
								<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
								<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
							</div>
							<div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
                              </div>
                            </div>
							<div class="form-actions">
								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log in">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

</body>
</html>
      <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
