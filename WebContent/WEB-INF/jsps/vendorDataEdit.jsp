<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<h1 align="center">Vendor Update page</h1>
<form action="updateVen" method="post">

<table align="center">
<tr> <td>ID </td> <td><input type="text" name="vendorId"  value="${venObject.vendorId}">  </td>

<td>RegId Type </td> <td>
<c:choose>
<c:when test="${venObject.vendorRegIdType eq 'pan'}">
 <select name="vendorRegIdType" > <option value="pan" selected="selected" > PAN </option>
<option value="voterId">Voter card </option>
<option value="adhar">Adhar </option>
<option value="other">Other</option>
</select> 

</c:when>


<c:when test="${venObject.vendorRegIdType eq 'voterId'}">
 <select name="vendorRegIdType"> <option value="pan"> PAN </option>
<option value="voterId" selected="selected" >Voter card </option>
<option value="adhar">Adhar </option>
<option value="other">Other</option>
</select> 

</c:when>
<c:when test="${venObject.vendorRegIdType eq 'adhar'}">
 <select name="vendorRegIdType" > <option value="pan"  > PAN </option>
<option value="voterId" >Voter card </option>
<option value="adhar"  selected="selected" >Adhar </option>
<option value="other">Other</option>
</select> 

</c:when>

<c:otherwise>
 <select name="vendorRegIdType" > <option value="pan"> PAN </option>
<option value="voterId" >Voter card </option>
<option value="adhar"  >Adhar </option>
<option value="other" selected="selected">Other</option>
</select> 

</c:otherwise>

</c:choose>


</td> </tr>

 <tr>
<td>Name </td> <td><input type="text" name="vendorName"  value="${venObject.vendorName}">    </td>
<td> Reg Number </td> <td><input type="text" name="vendorRegId"   value="${venObject.vendorRegId}">   </td>  </tr>

<tr> 
<td>Email</td> <td><input type="text" name="vendorMail"   value="${venObject.vendorMail}">   </td>

<td>Address </td> <td><textarea name="vendorAddress">${venObject.vendorAddress}</textarea>
</tr>

<tr> <td >  Vendor Type : </td>
<td> 
<c:choose>
<c:when test="${venObject.vendorType eq 'fullTime'}"> 
 <input type="radio" name="vendorType" value="fullTime" checked="checked">Full Time  <br>
  <input type="radio" name="vendorType" value="contract">Contract
</c:when>
<c:otherwise>
 <input type="radio" name="vendorType" value="fullTime">Full Time  <br>
  <input type="radio" name="vendorType" value="contract" checked="checked">Contract
</c:otherwise>
</c:choose>
 </td> 
 
 <td> Location </td>
 
 <td> <select name="location.locId">
 
 <c:choose>
 <c:when test="${venObject.location==null}">
 <option value="-1">Choose One </option>
 <c:forEach items="${loclistObj}" var="locob">
 <option value="${locob.locId}">${locob.locName}</option>
 </c:forEach>
 </c:when>

 <c:otherwise>
  <option value="-1">Choose One </option>
 <c:forEach items="${loclistObj}" var="locob">
 <option value="${locob.locId}"   
 <c:if test="${locob.locId==venObject.location.locId}">
selected='selected'</c:if>>${locob.locName}</option>
 </c:forEach>
 </c:otherwise>
  </c:choose>
 </select>

 </tr>
 <tr>
 <td colspan="4" align="center">
 
 <input type="submit" value="update"> 
  </td>  </tr>
</table>

</form>
</body>
</html>