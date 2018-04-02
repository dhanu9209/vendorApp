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

<script type="text/javascript">
function selectAll(source){
	checkboxs=document.getElementsByName("multi")
	for(var i=0;i<checkboxs.length;i++){
		checkboxs.checked=source.checked;
	}
}

</script>



</head>
<body >
<%@ include file="menu.jsp" %>
<h1 style="text-align:center; ">Vendor data</h1> 
<form action="" method="post">
<div align="center">

<label style="text-align:center;color:Crimson; font-size:25px;"> ${msg}</label>  <br>

</div>
<table border="1" align="center">
<tr> <th> <input type="checkbox" onclick="selectAll(this)" /> </th>  <th> Vendor Id </th> <th> Vendor Name </th> <th > Vendor Mail </th> <th > Vendor Address </th>  <th>VendorType</th> 

<th> VendorReg Id Type </th> <th> vendorRegId  </th>
<th> Location Name </th> <th>Location Type </th>
 <th> Action </th> </tr> 

<c:forEach items="${venList}" var="ven">

 <tr> 
 <td> <input type="checkbox" name="multi" value="${ven.vendorId}"> </td>
 <td> <c:out value="${ven.vendorId}"></c:out> </td>
 <td> <c:out value="${ven.vendorName}"></c:out> </td>
 <td><c:out value="${ven.vendorMail}"></c:out> </td>
 <td><c:out value="${ven.vendorAddress}"></c:out> </td>
 
 <td> <c:out value="${ven.vendorType}"></c:out> </td>
 <td> <c:out value="${ven.vendorRegIdType}"></c:out> </td>
 <td><c:out value="${ven.vendorRegId}"></c:out> </td> 
 <td><c:out value="${ven.location.locName}"></c:out> </td>
 <td><c:out value="${ven.location.locType}"></c:out> </td>
  <td>   <a href="deleteVen?venid=${ven.vendorId}"><img src="../images/delete.png" height="20" width="20"/></a>
 <a href="editVen?venid=${ven.vendorId}"><img src="../images/edit.png" height="20" width="20"/></a>
</td>  </tr>
</c:forEach>


 </table>

</form>



</body>





</html>