<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Registration | VDMS</title>
<%@include file="includes.jsp" %>
</head>
<body >

<%@include file="menu.jsp" %>

<div class="well container">
  <h2 style="text-align:center;">Welcome to Location Registration page</h2>
  
  
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
  <form class="form-horizontal" action="insert" method="post">
   


 <div class="form-group">
      <label class="control-label col-sm-2" for="locationId">location Id:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="locId" placeholder="Enter location Id" name="locId">
      </div>
    </div>

 <div class="form-group">
      <label class="control-label col-sm-2" for="locationName">location Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="locName" placeholder="Enter location Name" name="locName">
      </div>
    </div>

 <div class="form-group">
      <label class="control-label col-sm-2" for="locationType">location Type:</label>
      <div class="col-sm-10">
        <input type="radio"   name="locType" value="Urban" />Urban 
                                    <input type="radio" name="locType" value="Rural" /> Rural
      </div>
    </div>


  <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Register</button>
        <button type="reset" class="btn btn-warning">Clear</button>
      </div>
    </div>
</form>
</div>

</body>
</html>