<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="common/header.jsp" />
<html>
<head>
    <title>Add Beer</title>
</head>
<body>

<h2>Beer Information</h2>
<form:form method="POST" action="/beerworld/savebeer" commandName="command" >
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
        <td><font color="red"><form:errors path="name" cssErrorclass="error"></form:errors></font></td>
    </tr>
       <tr>
        <td><form:label path="isLightBeer">Is Light Beer?</form:label></td>
        <td><form:checkbox path="isLightBeer"  /></td>
        <td><font color="red"><form:errors path="isLightBeer" cssErrorclass="error"></form:errors></font></td>
     </tr>
     <tr>
        <td><form:label path="alcoholPercentage">alcoholPercentage</form:label></td>
        <td><form:input path="alcoholPercentage" /></td>
        <td><font color="red"><form:errors path="alcoholPercentage" cssErrorclass="error"></form:errors></font></td>
        <form:hidden path="breweryId" value="${id.id}" />
    </tr>     
    
    <tr>
        <td colspan="2">
          	<form:hidden path="breweryId" value="${id}" />
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>