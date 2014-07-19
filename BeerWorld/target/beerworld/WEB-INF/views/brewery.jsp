<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="common/header.jsp" />
<html>
<head>
    <title>Add Brewery</title>
</head>
<body>

<h2>Brewery Information</h2>
<form:form method="POST" action="/beerworld/addBrewery" >
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
        <td><font color="red"><form:errors path="name" cssErrorclass="error"></form:errors></font></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>