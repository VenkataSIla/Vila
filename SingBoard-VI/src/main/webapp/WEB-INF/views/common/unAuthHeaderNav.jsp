
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
   <script type="application/javascript" src="/js/jquery.js"></script>
  <script type="application/javascript" src="/js/bootstrap.js"></script>
</head>

<body>
<!-- Fixed navbar -->
  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">SignBoard Tracking and Traceability Solution</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li ><a href="/">Home</a></li>
          <li><a href="/about/">About</a></li>
          <li><a href="/contactUs/">Contact Us</a></li>
          <li class="dropdown">
            <a href="/" class="dropdown-toggle" data-toggle="dropdown">Login<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="/login/Vendor">Vendor</a></li>
              <li><a href="/login/Client">Client</a></li>
              <li><a href="/login/Representative">Representative</a></li>
               <li><a href="/login/Admin">Admin</a></li>
            </ul>
          </li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
</body>
