<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/header.jsp" />
<html>
<head>
    <title>Edit Brewery</title>
</head>
<body>
<h2>Edit brewery</h2>
 
    <table border="2" >
    <tr><td><b>Distribution Center name</b></td>
    	<td><b>Address</b></td>
    </tr>
   	<c:forEach var="p" items="${brewery.distributionCenters}">
   	      <tr>
	   			<td>
	            	${p.distributionCenterName}
	            </td>
	          	<c:choose>
	            <c:when test="${not empty p.address.address1 }"  > 
		            <td>
		            	${p.address.address1}<br>${p.address.address2}<br>${p.address.city}<br>${p.address.state}<br>${p.address.zip}
		            	<br><a href="/beerworld/address?id=${p.id}">Edit</a> 
		            </td>
	            </c:when>
	            <c:otherwise>
	                 <td>
	                 	<a href="/beerworld/address?id=${p.id}">Add</a>
	                 </td>
	            </c:otherwise>
	            </c:choose>
		    </tr>    
	</c:forEach>   
</table>  
 <a href="/beerworld/distributioncenter?id=${brewery.id}&name=${brewery.name}">Add Distribution Center</a>
</body>
</html>
