<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="common/header.jsp" />
<html>
<head>
    <title>Add Distribution</title>
</head>
<body>

<h2>Distribution Center Information for ${id.breweryName}</h2>
<form:form method="POST" action="/beerworld/adddistributioncenter" commandName="command1" >
   <table>
    <tr>
        <td><form:label path="distributionCenterName">Name</form:label></td>
        <td><form:input path="distributionCenterName" /></td>
        <td><font color="red"><form:errors path="distributionCenterName" cssErrorclass="error"></form:errors></font></td>
        <form:hidden path="breweryId" value="${id.id}" />
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