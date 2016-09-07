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

<body>
<div class="container">
<div class="col-xs-2"></div>
<div class="col-xs-8">
 <div class="panel panel-default">
      <div class="panel-heading"><h3>Clinet New Job</h3></div>
      <br>
      <div class="panel-body">
<form action="/saveClient" method="post" class="form-horizontal">
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Shop Id</label>
        <div class="col-xs-10">
            <input type="number" id="shopId" name="shopId" class="form-control" placeholder="User entry/Auto gen" disabled="disabled">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Shop Name</label>
        <div class="col-xs-10">
            <input type="text" id="shopeName" name="shopName" class="form-control" placeholder="Shop Name" required="required">
        </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading"><h4>Location Details</h4></div>
      <div class="panel-body">
      
      <div class="form-group">
        <label class="col-xs-2 control-label" >State</label>
        <div class="col-xs-10">
            <input type="text" id="State" name="State" class="form-control" placeholder="State" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >City</label>
        <div class="col-xs-10">
            <input type="text" id="City" name="city" class="form-control" placeholder="City" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >District</label>
        <div class="col-xs-10">
            <input type="text" id="Distrtict" name="district" class="form-control" placeholder="Distrtrict" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Lane</label>
        <div class="col-xs-10">
            <input type="text" id="lane" name="lane" class="form-control" placeholder="Lane" required="required">
        </div>
    </div>
    
     <div class="form-group">
        <label class="col-xs-2 control-label" >Shop Number</label>
        <div class="col-xs-10">
            <input type="text" id="shopeNumber" name="shopNumber" class="form-control" placeholder="Shop Number" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Pin Code</label>
        <div class="col-xs-10">
            <input type="number" id="pincode" name="pincode" class="form-control" placeholder="pincode" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Person Name</label>
        <div class="col-xs-10">
            <input type="text" id="personName" name="personName" class="form-control" placeholder="Shop Person Name" required="required">
        </div>
    </div>
    
      <div class="form-group">
        <label class="col-xs-2 control-label" >Contact Nos.</label>
        <div class="col-xs-10">
        <div class="col-xs-3">
            <input type="text" id="contactInfo" name="contactInfo" class="form-control" placeholder="contactInfo" >
            </div>
            <div class="col-xs-3">
            <input type="text" id="contactInfo" name="contactInfo" class="form-control" placeholder="contactInfo" >
            </div>
            <div class="col-xs-3">
            <input type="text" id="contactInfo" name="contactInfo" class="form-control" placeholder="contactInfo" >
            </div>
        </div>
    </div>
    
   
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >ISB.</label>
        <div class="col-xs-10">
            <input type="checkbox" id="ISB" name="isb" placeholder="ISB" >
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >GSB.</label>
        <div class="col-xs-10">
            <input type="checkbox" id="gsb" name="gsb"  placeholder="GSB" >
        </div>
    </div>
    
     <div class="form-group">
        <label class="col-xs-2 control-label" >Client's Remark</label>
        <div class="col-xs-10">
            <textarea rows="10" cols="5" name="clientsRemark" id="clientsRemark"  class="form-control" required="required"></textarea>
        </div>
    </div>
           
      </div>
      </div>

    
      
    <div class="form-group ">
		<div class="col-xs-10">
		<label class="col-xs-3 control-label" ></label>
			<a href="/clientView" class="btn btn-success">Back</a>&nbsp;<input type="submit"  value="Save" name="actionFlag"	class="btn btn-warning"> <input type="submit" value="Client new Job" name="actionFlag"	class="btn btn-primary"> <input type="submit" name="actionFlag" value="Send to Dealer"	class="btn btn-info">
				</div>
		</div>
</form>
<div class="col-xs-2"></div>
</div>
</div>
</div>
</div>
</body>
</html>