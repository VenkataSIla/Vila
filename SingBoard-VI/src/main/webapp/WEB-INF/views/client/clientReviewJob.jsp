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
 <script type="application/javascript" src="/js/bootstrap-imgupload.js"></script>
 <script type="application/javascript" src="/js/bootstrap-imgupload.min.js"></script>

<body>
<div class="container">
<div class="col-xs-1"></div>
<div class="col-xs-10">
<div class="panel-body" >
	<div class="table-responsive">
		<div class="panel panel-default">
			<div class="panel-heading">
			<h2>Client Review Job    <a href="/exportFile/" class="btn btn-success pull-right">Export File</a>	
			</h2>
			</div>
  <div class="section">
    <div class="panel-body">
    <form action="/updateClient" method="post" class="form-horizontal" enctype="multipart/form-data">
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Shop Id</label>
        <div class="col-xs-10">
           <input type="hidden" id="shopId" name="shopId" class="form-control" placeholder="User entry/Auto gen"  value="${client.shopId}" required="required"> ${client.shopId}
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Shop Name</label>
        <div class="col-xs-10">
            <input type="text" id="shopeName" name="shopName" class="form-control" placeholder="Shop Name" value="${client.shopName}" required="required">
        </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading"><h4>Location Details</h4></div>
      <div class="panel-body">
      
      <div class="form-group">
        <label class="col-xs-2 control-label" >State</label>
        <div class="col-xs-10">
            <input type="text" id="State" name="State" class="form-control" placeholder="State" value="${client.state}" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >City</label>
        <div class="col-xs-10">
            <input type="text" id="City" name="city" class="form-control" placeholder="City" value="${client.city}" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >District</label>
        <div class="col-xs-10">
            <input type="text" id="Distrtict" name="district" class="form-control" placeholder="Distrtrict" value="${client.district}" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Lane</label>
        <div class="col-xs-10">
            <input type="text" id="lane" name="lane" class="form-control" placeholder="Lane"  value="${client.lane}" required="required">
        </div>
    </div>
    
     <div class="form-group">
        <label class="col-xs-2 control-label" >Shop Number</label>
        <div class="col-xs-10">
            <input type="text" id="shopeNumber" name="shopNumber" class="form-control" placeholder="Shop Number"  value="${client.shopNumber}" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Pin Code</label>
        <div class="col-xs-10">
            <input type="number" id="pincode" name="pincode" class="form-control" placeholder="pincode"  value="${client.pincode}" required="required">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >Person Name</label>
        <div class="col-xs-10">
            <input type="text" id="personName" name="personName" class="form-control" placeholder="Shop Person Name"  value="${client.personName}"  required="required">
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-2 control-label" >Contact Nos.</label>
        <div class="col-xs-10">
        <div class="col-xs-3">
            <input type="text" id="contactInfo" name="contactInfo" class="form-control" value="${client.contactInfo}" placeholder="contactInfo" >
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
            <input type="checkbox" id="ISB" name="isb" placeholder="ISB"  value="${client.isb}"  >
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-2 control-label" >GSB.</label>
        <div class="col-xs-10">
            <input type="checkbox" id="gsb" name="gsb"  placeholder="GSB"  value="${client.gsb}"  >
        </div>
    </div>
    
     <div class="form-group">
        <label class="col-xs-2 control-label" >Client's Remark</label>
        <div class="col-xs-10">
            <textarea rows="6" cols="5" name="clientsRemark" id="clientsRemark"  class="form-control"  required="required" >${client.clientsRemark}</textarea>
        </div>
    </div>
    
         <div class="form-group">
        <label class="col-xs-2 control-label" >Dealer's Remark</label>
        <div class="col-xs-10">
            <textarea rows="6" cols="5" name="dealersRemark" id="dealersRemark"  class="form-control"   >${client.dealersRemark}</textarea>
        </div>
    </div>
      </div>
      </div>
       <div class="panel panel-default">
      <div class="panel-heading"><h4>Dimension Details</h4></div>
      <div class="panel-body">
      
      <div class="form-group ">
	        <label class="col-xs-2 control-label" >ISB Clarification</label>
	        <div class="col-xs-10">
	            <select name="isbClarification" class="form-control" >
			        <c:forEach items="${isbClarification}" var="item" varStatus="count"> 
			            <option value="${count.index}">${item}</option>
			        </c:forEach>
			    </select>   
	        </div>
	    </div>
	    
	    <div class="form-group">
        <label class="col-xs-2 control-label" >IBS Board Size</label>
        <div class="col-xs-10">
         <label class="col-xs-2 control-label" >Length</label>
         <div class="col-xs-3">
            <input type="text" id="isbBoardSizeLength" name="isbBoardSizeLength" class="form-control" placeholder="Length"  value="${client.isbBoardSizeLength}"  >Inches
            </div>
            <label class="col-xs-2 control-label" >Height</label>
         <div class="col-xs-3">
            <input type="text" id="isbBoardSizeHeight" name="isbBoardSizeHeight" class="form-control" placeholder="Length"  value="${client.isbBoardSizeHeight}"  >Inches
            </div>
        </div>
    </div>
    <c:if test="${fn:length(isbFileNames) lt 4}">
     <div class="form-group">
        <label class="col-xs-2 control-label" >Photo Upload</label>
        <div class="col-xs-10">
		 <div id="mydiv">
		 <span class="btn btn-primary btn-file">
			  Browse   <input type="file" id="files" name="isbFiles" multiple>
			</span>
			
             <br><output id="list"></output>
		</div>
    </div>
    </div>
    </c:if>

<div class="col-xs-12">
     <div class="col-xs-2"></div>
     <div class="col-xs-10">
	<c:choose>
		<c:when test="${fn:length(isbFileNames) gt 0}">
			<c:forEach items="${isbFileNames}" var="record"	varStatus="status">
				<spring:url var="imagePath" value="/img/shopImg/${record}" htmlEscape="true" />
				<img src="${imagePath}" class="photo-size-sm" alt="${record}" /><a data-toggle="modal" data-id="${record}" style="color: red;" id="removeImg" onclick="return ConfirmDelete();"  href="/deleteImage/${record}/${client.shopId}"><span class="glyphicon glyphicon-trash"></span></a> &nbsp;
				
	   </c:forEach>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	</div>
	</div>
	
	<div class="form-group ">
	        <label class="col-xs-2 control-label" >GBS Clarification</label>
	        <div class="col-xs-10">
	            <select name="gbsClarifications" class="form-control" required="required">
			        <c:forEach items="${gbsClarifications}" var="item" varStatus="count"> 
			            <option value="${count.index}">${item}</option>
			        </c:forEach>
			    </select>   
	        </div>
	    </div>
	    
	    
	    <div class="form-group">
        <label class="col-xs-2 control-label" >GBS Board Size</label>
        <div class="col-xs-10">
         <label class="col-xs-2 control-label" >Length</label>
         <div class="col-xs-3">
            <input type="text" id="gbsBoardSizeLength" name="gbsBoardSizeLength" class="form-control" placeholder="Length"  value="${client.gbsBoardSizeLength}"  >Inches
            </div>
            <label class="col-xs-2 control-label" >Height</label>
         <div class="col-xs-3">
            <input type="text" id="gbsBoardSizeHeight" name="gbsBoardSizeHeight" class="form-control" placeholder="Length"  value="${client.gbsBoardSizeHeight}"  >Inches
            </div>
        </div>
    </div>
    <c:if test="${fn:length(gsbFileNames) lt 4}">
     <div class="form-group">
        <label class="col-xs-2 control-label" >Photo Upload</label>
        <div class="col-xs-10">
		 <span class="btn btn-primary btn-file">
			  Browse  <input  type="file" id="gbsfiles" name="gsbFiles" multiple>
			</span>
             <br><output id="listgbs"></output>
    </div>
    </div>
    </c:if>
     <div class="col-xs-12">
     <div class="col-xs-2"></div>
     <div class="col-xs-10">
	    <c:choose>
		<c:when test="${fn:length(gsbFileNames) gt 0}">
			<c:forEach items="${gsbFileNames}" var="record"	varStatus="status">
				<spring:url var="imagePath" value="/img/shopImg/${record}"	htmlEscape="true" />
				<img src="${imagePath}" class="photo-size-sm" alt="${record}" /><a data-toggle="modal" style="color: red;"  data-id="${record}" id="removeImg" onclick="return ConfirmDelete();"  href="/deleteImage/${record}/${client.shopId}"><span class="glyphicon glyphicon-trash"></span></a> &nbsp;
				
			</c:forEach>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	</div>
	</div>
	  <div class="form-group">
        <label class="col-xs-2 control-label" >Representative's Remark</label>
        <div class="col-xs-10">
            ${client.clientsRemark}
        </div>
    </div>
    
         <div class="form-group">
        <label class="col-xs-2 control-label" >Dealer'reviews Remark</label>
        <div class="col-xs-10">
           ${client.dealersRemark}
        </div>
    </div>
    
     <div class="form-group">
        <label class="col-xs-2 control-label" >Client'reviews Remark</label>
        <div class="col-xs-10">
            <textarea rows="6" cols="5" name="dealersRemark" id="dealersRemark"  class="form-control"   >${client.dealersRemark}</textarea>
        </div>
    </div>
	    
      </div>
      </div>
      
      
    <div class="form-group ">
		<div class="col-xs-10">
			<a href="/clientView" class="btn btn-success">Back</a>	&nbsp;<input type="submit" value="Save" class="btn btn-info"> &nbsp;<input type="submit" value="Approved" class="btn btn-primary"> &nbsp;<input type="submit" value="Reject" class="btn btn-danger">  &nbsp;<input type="submit" value="Respond for Correction" class="btn btn-warning"> 
				</div>
		</div>
</form>

</div>
<div class="col-xs-1"></div>
    </div>
    </div>
    </div>
    </div>
    </div>
    </div>
    
    		
    
</body>
</html>

 <script type="text/javascript">

 var count=${fn:length(isbFileNames)};
	function handleFileSelect(evt) {
		var $fileUpload = $("input#files[type='file']");
		count=count+parseInt($fileUpload.get(0).files.length);
		
		if (parseInt($fileUpload.get(0).files.length) > 6 || count>5) {
			alert("You can only upload a maximum of 5 files");
			count=count-parseInt($fileUpload.get(0).files.length);
			evt.preventDefault();
			evt.stopPropagation();
			return false;
		}
		var files = evt.target.files;
		for (var i = 0, f; f = files[i]; i++) {
			if (!f.type.match('image.*')) {
				continue;
			}
			var reader = new FileReader();

			reader.onload = (function (theFile) {
				return function (e) {
					var span = document.createElement('span');
					span.innerHTML = ['<img class="thumb" src="', e.target.result, '" title="', escape(theFile.name), '"/><span class="remove_img_preview"></span>'].join('');
					document.getElementById('list').insertBefore(span, null);
				};
			})(f);

			reader.readAsDataURL(f);
		}
	}
	
	$('#files').change(function(evt){
		handleFileSelect(evt);
	});	 

	$('#list').on('click', '.remove_img_preview',function () {
		$(this).parent('span').remove();
     count--;
	});
	
	
	
	
	
	
	
	

	 var countgbs=${fn:length(gsbFileNames)};
		function handleFileSelect2(evtgbs) {
			var $fileUploadgbs = $("input#gbsfiles[type='file']");
			countgbs=countgbs+parseInt($fileUploadgbs.get(0).files.length);
			
			if (parseInt($fileUploadgbs.get(0).files.length) > 6 || countgbs>5) {
				alert("You can only upload a maximum of 5 files");
				countgbs=countgbs-parseInt($fileUploadgbs.get(0).files.length);
				evtgbs.preventDefault();
				evtgbs.stopPropagation();
				return false;
			}
			var filesgbs = evtgbs.target.files;
			for (var i = 0, f; f = filesgbs[i]; i++) {
				if (!f.type.match('image.*')) {
					continue;
				}
				var reader = new FileReader();

				reader.onload = (function (theFile) {
					return function (e) {
						var span = document.createElement('span');
						span.innerHTML = ['<img class="thumb" src="', e.target.result, '" title="', escape(theFile.name), '"/><span class="remove_img_preview"></span>'].join('');
						document.getElementById('listgbs').insertBefore(span, null);
					};
				})(f);

				reader.readAsDataURL(f);
			}
		}

		
		$('#gbsfiles').change(function(evtgbs){
			handleFileSelect2(evtgbs);
		});	

	
		$('#listgbs').on('click', '.remove_img_preview',function () {
			$(this).parent('span').remove();
			countgbs--;
		});
		
		function ConfirmDelete()
		{
		    var Delet_Confirm= confirm("Are you sure delete this Image?");
		 if (Delet_Confirm== true)
		 {
		   return true;
		 }
		 else
		 {
		  return false;
		  }
		}
		
		
		

</script> 