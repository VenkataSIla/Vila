<%@page import="org.springframework.web.util.WebUtils"%>
<%@page import="com.vsi.boot.domain.LoginUser"%>
<%@page import="com.vsi.boot.config.AppConstant"%>
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
     <link type="text/css" href="/css/bootstrap-4.css" rel="stylesheet" />
    <link type="text/css" href="/css/bootstrap-4.min.css" rel="stylesheet" />
    <link type="text/css" href="/css/app.css" rel="stylesheet" />
    <link type="text/css" href="/css/fine-uploader-gallery.css" rel="stylesheet" />
    
   <script type="application/javascript" src="/js/jquery.js"></script>
  <script type="application/javascript" src="/js/bootstrap.js"></script>
  <script type="application/javascript" src="/js/bootstrap-imgupload.min.js"></script>
  
</head>
<c:set var="contextPath" value="${pageContext['request'].contextPath}"/>
<body>
<% LoginUser loginUser = (LoginUser) WebUtils.getSessionAttribute(request,AppConstant.LOGIN_USER_SESSION); %>
<c:set  var="loginUser" value="<%=loginUser%>"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
 <div class="container">
    <div class="navbar-header">
     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
      <a class="navbar-brand" href="/">SignBoard Tracking & Traceability Solution</a>
    </div>
    <div class="collapse navbar-collapse">
    <c:if test="${loginUser.userType eq 'Client' }">
    <ul class="nav navbar-nav">
      <li class="active"><a href="/clientView"><strong>Client</strong></a></li>
      <li><a href="/clientNewJob/"><strong>New Job Instlation</strong></a></li>
      <li><a href="/clientView"><strong>Review Jobs</strong></a></li> 
    </ul>
    </c:if>
     <c:if test="${loginUser.userType eq 'Vendor' }">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#"><strong>Vendor</strong></a></li>
      <li><a href="#"><strong>New Job Instlation</strong></a></li>
      <li><a href="#"><strong>New Job for the client</strong></a></li> 
      <li><a href="#"><strong>Review Jobs</strong></a></li> 
    </ul>
   
    </c:if>
     <c:if test="${loginUser.userType eq 'Representative' }">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#"><strong>Representative</strong></a></li>
      <li><a href="#"><strong>Job List</strong></a></li>
    </ul>
    </c:if>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span><strong> ${loginUser.username}</strong></a></li>
      <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
    </div>
  </div>
</nav>
<br>
<div class="col-xs-3"></div>
<div class="col-xs-6">
 <div data-ng-view ></div>
 </div>
 <div class="col-xs-3"></div>
 <br>
 <div class="nav-bottom navbar-default navbar-fixed-bottom">
    <h6 class="pull-right">SignBoard vs.1.0 Sept-2016@<a href="">ilavenkata@gmail.com</a></h6>
</div>
</body>
</html>
</body>
</html>