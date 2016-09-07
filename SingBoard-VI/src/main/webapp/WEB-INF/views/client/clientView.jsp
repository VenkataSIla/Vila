<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<jsp:include page="/WEB-INF/views/common/authHeaderNav.jsp"/>
<body >

<div class="container">
<div class="panel-body" >
	<div class="table-responsive">
		<div class="panel panel-default">
			<div class="panel-heading">
			<h2>Client Jobs    <a href="/clientNewJob/" class="btn btn-success pull-right">Client New Job</a>
			</h2>
			</div>
  <div class="section">
    <div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
    <thead class="thead-inverse">
        <tr>
            <th>S.No</th>
            <th>Shop Id</th>
            <th>Shop Name</th>
            <th>Remark</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${clientJobs}" var="client" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${client.shopId}</td>
                    <td>${client.shopName}</td>
                    <td>${client.clientsRemark}</td>
                    <td><a href="/editClient/${client.shopId}" class="glyphicon glyphicon-edit">Review</a> </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>
</div>
</div>
</div>
</div>
</div>
</div>

  </body>
  
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  