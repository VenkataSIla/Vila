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
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<jsp:include page="/WEB-INF/views/common/authHeaderNav.jsp" />

<html>

<body>
	<div class="col-lg-12">
		<div aria-labelledby="myModalLabel" aria-hidden="true"
			data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true" data-backdrop="static">&times;</button>
						<h4 class="modal-title" id="H4">
							Edit Person
						</h4>
					</div>
					<div class="modal-body">
						<div id="collapseOne" class="accordion-body collapse in body">
							<form action="/person/update" method="post" class="form-horizontal">
								<input type="hidden" name="id" value="${person.id}">
								
							    <input class="form-control" type="text" name="name"
								placeholder="Name" required="required" value="${person.name}"> 
								<input
								class="form-control" type="email" name="email"
								placeholder="Email abc@in.com" required="required" value="${person.email}">
								 <select
								class="form-control" id="sel1" name="userType" value="${person.userType}">
								<option>Client</option>
								<option>Vendor</option>
								<option>Representative</option>
							</select> 
							<input class="form-control" type="text" name="username"
								placeholder="username" required="required" value="${person.username}"> <input
								class="form-control" type="password" name="password"
								placeholder="password" required="required">
								 <input
								class="form-control" type="number" name="mobile"
								placeholder="Cell #+91 9999999999" required="required" value="${person.mobile}">
							<a href="/person/personView" class="btn btn-success">Back</a>
							&nbsp;<input type="submit" value="Edit Person"
								class="btn btn-primary pull-right">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
