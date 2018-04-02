<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
table tr th{
color: white;
background-color: black;
}


</style>
<%@include file="includes.jsp" %>
</head>
<body>
<%@include file="menu.jsp" %>

<h1 align="center">Welcome to Document Upload Page</h1>
<div align="center">
<label style="text-align:center;color:Crimson; font-size:25px;"> ${msg}</label>  <br>

</div>
<form action="uploadDoc" method="post" enctype="multipart/form-data">
<table align="center">
<tr>
<td> Document Id </td>
<td> <input type="text" name="fileId"> </td>
 </tr>
<tr>
<td> Document  </td>
<td> <input type="file" name="fileobj"> </td>
 </tr>

<tr> 
<td colspan="2">
<input type="submit" value="Upload" />
<input type="reset" value="clear"> 
</tr>
</table>


<table border="1px" align="center">
<tr> <th> Document Id </th>
<th>Document Name </th>
<th>Action </th>
 </tr>
<c:forEach items="${doclistobj}" var="doclist">
<tr>
<td> <c:out value="${doclist[0]}"></c:out> </td>
<td> <c:out value="${doclist[1]}"></c:out> </td>
<td> <a href="downloadDoc?docid=${doclist[0]}">download</a>
</tr>
</c:forEach>
 </table>


</form>

</body>
</html>