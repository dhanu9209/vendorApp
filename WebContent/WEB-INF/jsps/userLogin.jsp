<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<%@include file="includes.jsp" %>
  <script type="text/javascript">
  $(document).ready(function() {
	  $('#login_form').bootstrapValidator({
	        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	userName: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please supply your user Name'
	                    },
	                    emailAddress: {
	                        message: 'Please supply a valid email '
	                    }
	                }
	            },

	            password: {
	                validators: {
	                        stringLength: {
	                        min: 6,
	                        max: 12,
	                    },
	                        notEmpty: {
	                        message: 'Please supply username'
	                    }
	                }
	            },

	          
	           
	           






	            }
	        })

	});
  
  
  
  </script>

</head>



<body>

<!-- <img class="img-rounded" src="../images/logo.png" height="150px" width="99%" /> -->
<%@include file="menu1.jsp" %>

<div  class="well container">

  <h2 style="text-align:center;">Login process</h2>
    <c:choose>
  <c:when test="${msgId eq 'success'}">
  <div class="alert alert-success alert-dismissable  fade in"> 
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> <c:out value="${msg}"></c:out>  
</div>
</c:when>
 <c:when test="${msgId eq 'error'}">
  <div class="alert alert-danger alert-dismissable fade in">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Danger!</strong> <c:out value="${msg}"></c:out>
</div>
   
  
  </c:when>
   <c:when test="${msgId eq 'warning'}">
  <div class="alert alert-warning alert-dismissable fade in">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Warning!</strong> <c:out value="${msg}"></c:out>
</div>
   
  
  </c:when>
   <c:when test="${msgId eq 'info'}">
  <div class="alert alert-info alert-dismissable  fade in">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Info!</strong> <c:out value="${msg}"></c:out>
</div>
   
  
  </c:when>
   </c:choose>
  <form class="form-horizontal" action="loginUser" method="post"  id="login_form">
    <div class="form-group">
      <label class="control-label col-sm-2" for="userName">User Name:</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="email" placeholder="Enter userName" name="userName">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
      </div>
    </div>
   
    <div class="form-group">        
      <div class=" col-sm-12" style="text-align:center;   ">
        <button type="submit" class="btn btn-primary">Login</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>