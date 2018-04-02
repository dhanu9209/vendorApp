<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="includes.jsp" %>
</head>
<body>

<%@include file="menu.jsp" %>
<h1 style="text-align:center; ">Welcome to Location Update page</h1>



<form action="updateLoc" method="post">

<table align="center">
<tr>  <td> locId</td> <td> :<input type="text" name="locId"  value="${locObj.locId}" />  </td> </tr>
 <tr>     <td> locName </td> <td> :<input type="text" name="locName" value="${locObj.locName}" />  </td> </tr>


<!--  locObj -->
  <tr>    <td> locType </td> <td> 
  
   <c:choose>
 <c:when test="${locObj.locType} eg 'Urban' ">
 
  : <input type="radio" name="locType" value="Urban" checked="checked" />Urban 
    <input type="radio" name="locType" value="Rural" /> Rural   
 
 </c:when>
 <c:otherwise>
 
  <input type="radio" name="locType" value="Urban"  />Urban 
    <input type="radio" name="locType" value="Rural" checked="checked" /> Rural 

 </c:otherwise>
 </c:choose> </td> 
 
 </tr>


 
  <tr> <td colspan="2" align="center"> <input type="submit" value="update"  align="middle" /> </td> 
  
 
</table>


</form>
 

</body>
</html>