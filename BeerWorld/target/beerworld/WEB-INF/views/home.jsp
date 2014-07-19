<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/header.jsp" />

<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h2>Beer world</h2>

 <br>
 <a href="/beerworld/brewery">Add Brewery</a>
 <br>
 
    <table border="2" >
    
    
    
   <c:forEach var="p" items="${breweries}">
   			<tr>
   			<td>
            	<img src="/beerworld/resources/images/carona.jpg" alt="not found" height="44" width="44"></img>
            </td>
   			<td>
            	${p.name} 
            </td>
            <td>
            	<a href="/beerworld/editBrewery?id=${p.id}">Manage Distributions</a> 
            </td>
            <td>
            	<a href="/beerworld/beers?id=${p.id}">Manage Brews</a> 
            </td>
            
            <td>
            	<a href="/beerworld/deleteBrewery?id=${p.id}">Delete</a> 
            </td>
           
            </tr>
        </c:forEach>
    
</table>  
 <br>
 <a href="/beerworld/brewery">Add Brewery</a>

</body>
</html>
