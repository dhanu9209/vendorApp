<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer Reg</title>
<%@include file="includes.jsp" %>
</head>
<body >
<%@include file="menu.jsp" %>
<h1 align="center">Welcome to customer Register page</h1>
<div align="center">
 <label  style="color:Crimson; font-size:25px;"> ${msg}</label>  <br>
</div>
<form action="insertust" method="post">
<table align="center" > <tr>
<td>Id  </td> <td> :<input type="text" name="custId"> </td> </tr>
<tr> <td> Name  </td> <td> :<input type="text" name="custName">  </td> </tr>
<tr> <td>Email </td> <td> :  <input type="text" name="custaMail" > </td> </tr>
<tr> <td> Type </td> <td> : <select  name="custType"> 
<option value="consumer">consumer</option>
<option value="seller">seller </option> 
</select> </td> </tr>
<tr> 
<td>Address </td>  <td>
<textarea rows="" cols="" name="custAddress"></textarea>
 </td>
<tr> <td> <input type="submit" value="Register" /> </td>
<td> <input type="reset" value="clear" />
</table>

</form>

</body>
</html>