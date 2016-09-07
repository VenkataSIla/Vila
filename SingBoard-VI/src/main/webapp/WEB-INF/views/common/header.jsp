
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
<c:set var="contextPath" value="${pageContext['request'].contextPath}"/>
