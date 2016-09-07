
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignBoard</title>
<link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
<link type="text/css" href="/css/app.css" rel="stylesheet" />
<script type="application/javascript" src="js/jquery.js"></script>
<script type="application/javascript" src="js/bootstrap.js"></script>
</head>
<c:set var="contextPath" value="${pageContext['request'].contextPath}" />
<jsp:include page="./common/unAuthHeaderNav.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="jumbotron jumbotron-sm">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<h2 class="h2">
						Contact us <small>Feel free to contact us</small>
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="well well-sm">
					<form>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="name"> Name</label> <input type="text"
										class="form-control" id="name" placeholder="Enter name"
										required="required" />
								</div>
								<div class="form-group">
									<label for="email"> Email Address</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-envelope"></span> </span> <input
											type="email" class="form-control" id="email"
											placeholder="Enter email" required="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="subject"> Subject</label> <select id="subject"
										name="subject" class="form-control" required="required">
										<option value="service">General Customer Service</option>
										<option value="suggestions">Suggestions</option>
										<option value="product">Product Support</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="name"> Message</label>
									<textarea name="message" id="message" class="form-control"
										rows="9" cols="25" required="required" placeholder="Message"></textarea>
								</div>
							</div>
							<div class="col-md-12">
								<button type="submit" class="btn btn-primary pull-right"
									id="btnContactUs">Send Message</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-4">
				<form>
					<legend>
						<span class="glyphicon glyphicon-globe"></span> Our office
					</legend>
					<address>
						<strong><h3>IVS IT Pvt. Ltd.</h3></strong><br>**
						Floor, '********',<br> Land mark
						'*********************',<br> Bangalore -
						560093<br> Phone: +91 ** *** *** ***<br> E-mail: <a
							href="mailto:#">contact@ivs.com</a>
					</address>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
      <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
