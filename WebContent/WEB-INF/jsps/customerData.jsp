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
<h1 style="text-align:center; ">Customers data</h1> 
<div align="center">
<label style="text-align:center;color:Crimson; font-size:25px;"> ${msg}</label>  <br>

</div>
<table border="1" align="center">
<tr> <th> CustId </th> <th> Name </th> <th > Email </th> <th > Type </th> 

<th> </th>
 <th>Action</th> </tr>


<c:forEach items="${custListObj}" var="cust">
 <tr> <td> <c:out value="${cust.custId}"></c:out> </td>
 <td> <c:out value="${cust.custName}"></c:out> </td>
 <td><c:out value="${cust.custaMail}"></c:out> </td>
 <td><c:out value="${cust.custType}"></c:out>
 
 <td> <c:choose>
 
 <c:when test="${cust.custType eq 'seller' }">
 <a href="showCustItems?cusid=${cust.custId}">ItemsList</a>
 </c:when>
 <c:otherwise>
  <a href="#">Orders</a>
 
 </c:otherwise>
 </c:choose>
 
 <td><a href="deleteCust?cusid=${cust.custId}"><img src="../images/delete.png" height="20" width="20"/></a>
 <a href="editCust?cusid=${cust.custId}"><img src="../images/edit.png" height="20" width="20"/></a>

</c:forEach>


 </table>





</body>





</html>