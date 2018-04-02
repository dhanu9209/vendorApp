<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>location data | VDMS</title>
<script type="text/javascript">
function selectall(source){
	 checkboxces=document.getElementsByName("multi");
	var n=checkboxces.length;
 	for(var i=0;i<n;i++){
 		checkboxces[i].checked=source.checked;
 	}
}
</script>
<%@include file="includes.jsp" %>
</head>
<body>
<form action="deletelLoc" method="post">
<%@include file="menu.jsp" %>


<div class="well container">
  <h2 align="center"> Location Data Page</h2>
  <div align="center">
 <label  style="color:Crimson; font-size:25px;"> ${msg}</label>  <br>
</div>
  <p align="center"><a href="locExportExcel">Export Excel</a> <a href="locExportPDF">Export PDF</a> </p>    
          
  <table class="well table table-striped">
    <thead>


<tr> 
<th> 
 <input type="checkbox" onclick="selectall(this)">  </th>
<th>Location  Id </th> <th>Location Name </th> <th>Location Type </th> <th> Action </th> </tr>
</thead>
 <tbody>
<c:forEach items="${listObj}" var="loc" >
<tr>
<td> <input type="checkbox" value="${loc.locId}" name="multi" > </td>
<td> <c:out value="${loc.locId}"></c:out> </td>
<td> <c:out value="${loc.locName}"></c:out> </td>
<td> <c:out value="${loc.locType}"></c:out>
<td><a href="deleteLoc?locid=${loc.locId}"><img alt="" src="../images/delete.png" height="20" width="20"></a> 
      <a href="editLoc?locid=${loc.locId}"><img alt="" src="../images/edit.png" height="20" width="20"></a>   </td>
</tr> 
</c:forEach>

<tr> <td colspan="5" align="center">

 <div class="form-group">        
      <div class="col-sm-12">
        <button type="submit" class="btn btn-primary">Delete(selected)</button>

</div> </div>
 </td> </tr>
</tbody>
</table>
</div>
</form>
</body>
</html>