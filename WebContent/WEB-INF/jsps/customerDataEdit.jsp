<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer Reg</title>
<%@include file="includes.jsp" %>
</head>
<body > 
<%@include file="menu.jsp" %>
<h1 align="center">Welcome to customer update page</h1> 
<form action="updateCust" method="post">
<table align="center"> <tr>
<td>Id  </td> <td> :<input type="text" name="custId" value="${custObj.custId}"> </td> </tr>
<tr> <td> Name  </td> <td> :<input type="text" name="custName" value="${custObj.custName}">  </td> </tr>
<tr> <td>Email </td> <td> :  <input type="text" name="custaMail" value="${custObj.custaMail}"> </td> </tr>
<tr> <td> Type </td> <td> :  
<c:choose>

<c:when test="${custObj.custType} eg 'consumer'">
<select  name="custType"> 
<option value="consumer" selected="selected">consumer</option>
<option value="seller">seller </option>  
</select>
</c:when>

<c:otherwise>
<select  name="custType"> 
<option value="consumer" >consumer</option>
<option value="seller" selected="selected" >seller </option>  
</select>

</c:otherwise>
</c:choose>

 </td> </tr>
<tr> <td align="center" colspan="2"> <input type="submit" value="Update" /> </td>
</table>

</form>


</body>
</html>