<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>



<div class="well container">
  <h2 style="text-align:center;"> Vendor Registration page</h2>
  
  
  <c:choose>
  <c:when test="${msgId eq 'success'}">
  <div class="alert alert-success">
  <strong>Success!</strong> <c:out value="${msg}"></c:out>  
</div>
</c:when>
 <c:when test="${msgId eq 'warning'}">
  
  
  <div class="alert alert-warning">
  <strong>Warning!</strong> <c:out value="${msg}"></c:out>
</div>
   
  
  </c:when>
   </c:choose>
  <form class="form-horizontal" action="insertVendor" method="post" enctype="multipart/form-data">

   <div class="form-group">
      <label class="control-label col-sm-2" for="vendorId">Vendor Id:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="vendorId" placeholder="Enter vendorId Id" name="vendorId">
      </div>
       <label class="control-label col-sm-2" for="RegIdType">RegId Type :</label>
      <div class="col-sm-4">
       
       <select name="vendorRegIdType" class="form-control" id="vendorRegIdType" > <option value="pan"> PAN </option>
<option value="voterId">Voter card </option>
<option value="adhar">Adhar </option>
<option value="other">Other</option>
</select> 

      </div>
    </div>


 <div class="form-group">
      <label class="control-label col-sm-2" for="vendorName">Vendor Name:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="vendorName" placeholder="Enter vendor Name" name="vendorName">
      </div>
       <label class="control-label col-sm-2" for="regNumber">Reg Number:</label>
      <div class="col-sm-4">
       <input type="text" name="vendorRegId" id="vendorRegId"  class="form-control">
      </div>
    </div>

 <div class="form-group">
      <label class="control-label col-sm-2" for="vendorEmail">Vendor Email :</label>
      <div class="col-sm-4">
       <input type="email" name="vendorMail" id="vendorMail"  class="form-control">
      </div>
       <label class="control-label col-sm-2" for="vendorAddress">Vendor Address :</label>
      <div class="col-sm-4">
       <textarea name="vendorAddress" id="vendorAddress" class="form-control">  </textarea>
      </div>
    </div>


<div class="form-group">
      <label class="control-label col-sm-2" for="vendorType">Vendor Type  :</label>
      <div class="col-sm-4">
<input type="radio" name="vendorType" value="fullTime" >Full Time  <br>
  <input type="radio" name="vendorType" value="contract" >Contract <br>

      </div>
       <label class="control-label col-sm-2" for="vendorEmail">Vendor Location :</label>
      <div class="col-sm-4">
 <select name="location.locId" class="form-control" id="location.locId" >
 <option value="-1">Choose One</option>
 <c:forEach items="${loclistObj}" var="locliObj">
 <option value="${locliObj.locId}">${locliObj.locName}</option>
 </c:forEach>
 </select>

      </div>
    </div>



<div class="form-group">
      <label class="control-label col-sm-2" for="vendorFile">Vendor File  :</label>
      <div class="col-sm-4">
 File <input type="file" name="document" class="form-contol"> 
      </div>
      <div class="col-sm-6">
  <button type="submit" class="btn btn-primary">Register</button>
        <button type="reset" class="btn btn-warning">Clear</button>
      </div>
    </div>



	</form>
	</div>
</body>
</html>