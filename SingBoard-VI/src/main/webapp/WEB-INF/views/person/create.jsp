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

<div class="col-lg-12">
<div class="container">
<h3>Add new Person</h3>
						<form action="/person/save" method="post" class="form-horizontal">
						
						    <div class="form-group ">
						        <label class="col-xs-2 control-label" >Name</label>
						        <div class="col-xs-10">
						            <input type="text" id="name" name="name" class="form-control" placeholder="user full name" required="required">
						        </div>
						    </div>
						    <div class="form-group ">
						        <label class="col-xs-2 control-label" >email</label>
						        <div class="col-xs-10">
						            <input type="email" id="email" name="email" class="form-control" placeholder="user Email " required="required">
						        </div>
						    </div>
						    
						    <div class="form-group ">
						        <label class="col-xs-2 control-label" >User Type</label>
						        <div class="col-xs-10">
						            <select name="userType" class="form-control" required="required">
								        <c:forEach items="${listString}" var="item" varStatus="count"> 
								            <option value="${count.index}">${item}</option>
								        </c:forEach>
								    </select>   
						        </div>
						    </div>
						    <div class="form-group ">
						        <label class="col-xs-2 control-label" >Username</label>
						        <div class="col-xs-10">
						            <input type="text" id="username" name="username" class="form-control" placeholder="username for longin id " required="required">
						        </div>
						    </div>
						    
						     <div class="form-group ">
						        <label class="col-xs-2 control-label" >Password</label>
						        <div class="col-xs-10">
						            <input type="text" id="password" name="password" class="form-control" placeholder="temperer password" required="required">
						        </div>
						    </div>
						    
						     <div class="form-group ">
						        <label class="col-xs-2 control-label" >Mobile No.</label>
						        <div class="col-xs-10">
						            <input type="number" id="mobile" name="mobile" class="form-control" placeholder="Mobile phone number" required="required">
						        </div>
						    </div>
							<div class="form-group ">
							<div class="col-xs-10">
							<label class="col-xs-3 control-label" ></label>
								<a href="/person/personView" class="btn btn-success">Back</a>
								&nbsp;<input type="submit" value="Add Person"
									class="btn btn-primary pull-right">
									</div>
							</div>
						</form>
					</div>
				</div>

</body>
</html>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />
