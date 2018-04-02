<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="includes.jsp" %>
<style type="text/css">
table tr th{
color: white;
background-color: black;
}


</style>
</head>
<body >
<%@ include file="menu.jsp" %>
<h1 style="text-align:center; ">Customer Items data</h1> 
<div align="center">
<label style="text-align:center;color:Crimson; font-size:25px;"> ${msg}</label>  <br>

</div>
<table border="1" align="center">
<tr> <th> ItemId </th> <th> ItemName </th> <th > ItemCost </th>  </tr>


<c:forEach items="${itemListObj}" var="item">
 <tr> <td> <c:out value="${item.itemId}"></c:out> </td>
 <td> <c:out value="${item.itemName}"></c:out> </td>
 <td><c:out value="${item.itemost}"></c:out> </td>
 </tr>
 </c:forEach>


 </table>





</body>





</html>