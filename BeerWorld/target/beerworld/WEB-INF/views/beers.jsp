<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/header.jsp" />
<html>
<head>
    <title>Beer list for ${brewery.name}  </title>
</head>
<body>
<h2>Beer list for ${brewery.name} </h2>

 <br>
  <a href="/beerworld/addbeer?id=${brewery.id} ">Add Beer</a>
 <br>
 
    <table border="2" >
   
   <c:forEach var="p" items="${brewery.beers}">
   			<tr>
   			<td>
            	${p.name} 
            </td>
            <td>
            	${p.isLightBeer} 
            </td>
            <td>
            	${p.alcoholPercentage} 
            </td>
            <td>
				 <a href="/beerworld/editbeer?id=${brewery.id} ">Edit Beer</a>
            </td>
            <td>
				 <a href="/beerworld/deletebeer?id=${brewery.id} ">Delete Beer</a>
            </td>
           
            </tr>
        </c:forEach>
    
</table>  
 <br>
 <a href="/beerworld/addbeer?id=${brewery.id} ">Add Beer</a>

</body>
</html>
