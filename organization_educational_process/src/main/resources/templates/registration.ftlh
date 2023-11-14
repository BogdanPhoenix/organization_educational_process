<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
</head>
<body>
<h4>Registration</h4>
<form action="/registration" method="post">
    Email: <label>
        <input type="email" name="userEmail">
    </label><br/><br/>
    Password: <label>
        <input type="password" name="passwordUser">
    </label><br/><br/>
    First name: <label>
        <input type="text" name="firstName">
    </label><br/><br/>
    Last name: <label>
        <input type="text" name="lastName">
    </label><br/><br/>
    Patronymic: <label>
        <input type="text" name="patronymic">
    </label><br/><br/>
    <label for="dropdown">Choose an role:</label>
    <select id="dropdown" name="role">
        <#list roles as role>
            <option value="${role.indexRole}">${role.nameRole}</option>
        </#list>
    </select>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <br/>
    <input type="submit" value="Registration">
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>