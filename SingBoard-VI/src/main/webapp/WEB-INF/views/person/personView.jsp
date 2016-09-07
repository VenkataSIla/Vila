<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<jsp:include page="/WEB-INF/views/common/authHeaderNav.jsp" />
<body>
	<div class="container">
		<div class="main-content">
			<h2>Person<a href="/person/create"  class="btn btn-success pull-right">Add Person</a></h2>
			<div class="section">
				<table class="table table-bordered">
				<thead class="thead-inverse">
					<tr>
						<th>S.No</th>
						<th>Name</th>
						<th>Email</th>
						<th>Username</th>
						<th>Mobile</th>
						<th>Action</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${persons}" var="person" varStatus="itr">
							<tr>
								<td>${itr.index+1}</td>
								<td>${person.name}</td>
								<td>${person.email}</td>
								<td>${person.username}</td>
								<td>${person.mobile}</td>
								<td><a href="/person/edit/${person.id}"
									class="glyphicon glyphicon-edit"></a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				
			</div>
		</div>
	</div>
</body>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
