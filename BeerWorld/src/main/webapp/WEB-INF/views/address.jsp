<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="common/header.jsp" />
<html>
<head>
    <title>Add Address</title>
</head>
<body>

<h2>Address Information</h2>
<form:form method="POST" action="/beerworld/addaddress" commandName="command" >
   <table>
    <tr>
        <td><form:label path="address1">Address1</form:label></td>
        <td><form:input path="address1" /></td>
        <td><font color="red"><form:errors path="address1" cssErrorclass="error"></form:errors></font></td>
    </tr>
       <tr>
        <td><form:label path="address2">Address2</form:label></td>
        <td><form:input path="address2" /></td>
        <td><font color="red"><form:errors path="address2" cssErrorclass="error"></form:errors></font></td>
     </tr>
     <tr>
        <td><form:label path="city">city</form:label></td>
        <td><form:input path="city" /></td>
        <td><font color="red"><form:errors path="city" cssErrorclass="error"></form:errors></font></td>
    </tr>
     <tr>
        <td><form:label path="state">state</form:label></td>
        <td><form:input path="state" /></td>
        <td><font color="red"><form:errors path="state" cssErrorclass="error"></form:errors></font></td>
    </tr>
     <tr>
        <td><form:label path="zip">zip</form:label></td>
        <td><form:input path="zip" /></td>
        <td><font color="red"><form:errors path="zip" cssErrorclass="error"></form:errors></font></td>
    </tr>
        
    <tr>
        <td colspan="2">
          	<form:hidden path="distributionCenterID" value="${id}" />
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>