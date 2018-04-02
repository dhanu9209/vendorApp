<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
<%@include file="includes.jsp" %>
</head>
  <script type="text/javascript">
  $(document).ready(function() {
	  $('#register_form').bootstrapValidator({
	        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            userName: {
	                validators: {
	                        stringLength: {
	                        min: 4,
	                        max: 25,
	                    },
	                        notEmpty: {
	                        message: 'Please supply username'
	                    }
	                }
	            },


	            email: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please supply your email address'
	                    },
	                    emailAddress: {
	                        message: 'Please supply a valid email address'
	                    }
	                }
	            },
	            mobileNumber: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please supply your mobile number'
	                    },
	                    phone: {
	                        message: 'Please enter proper mobile number'
	                    }
	                }
	            },
	            address: {
	                validators: {
	                     stringLength: {
	                        min: 8,
	                    },
	                    notEmpty: {
	                        message: 'Please supply your  address'
	                    }
	                }
	            },






	            }
	        })

	});
  
  
  
  </script>


<body>

<!-- <img class="img-rounded" src="../images/logo.png" height="150px" width="99%" /> -->

<%@include file="menu1.jsp" %>
<div class="well container">
  <h2 style="text-align:center;"> User Registration page</h2>
  
  
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
  <form class="form-horizontal" action="registerUser" method="post" id="register_form" >


 <div class="form-group">
      <label class="control-label col-sm-2" for="firstName">User Name</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="userName" placeholder="Enter user Name" name="userName" required>
      </div>
      </div>
       <div class="form-group">
       <label class="control-label col-sm-2" for="mobileNumber">Mobile Number</label>
      <div class="col-sm-10">
       <input type="text" name="mobileNumber" id="mobileNumber" placeholder="Enter Mobile Number"   class="form-control" required>
      </div>
    </div>


 <div class="form-group">
      <label class="control-label col-sm-2" for="email">User Email</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" required>
      </div>
      </div>
       <div class="form-group">
       <label class="control-label col-sm-2" for="userAddress">User Address </label>
      <div class="col-sm-10">
       <textarea name="address" id="userAddress" class="form-control"  placeholder="Enter  User Address" ></textarea>
      </div>
    </div>


<div class="form-group">
     
      <div class="col-sm-12" align="center">
  <button type="submit" class="btn btn-primary" >Register</button>
        <button type="reset" class="btn btn-warning">Clear</button>
      </div>
    </div>



	</form>
	</div>

</body>
</html>