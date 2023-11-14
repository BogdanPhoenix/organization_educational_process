<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>List of roles : </h1>
<ul>
    <#if roles??>
        <#list roles as role>
            <li>${role.nameRole}</li>
        </#list>
    <#else>
        <h3>Not data</h3>
    </#if>
</ul>
<h2>To add new role press "Add role" button</h2>
<form method="post" action="/role/add">
    <p><label for="nameRole">Name role</label></p>
    <p><input type="text" name="nameRole" id="nameRole"/></p>
    <p><input type="submit" value="Add role"></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <br/>
</form>
</body>
</html>