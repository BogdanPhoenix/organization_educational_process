<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Degree</title>
</head>
<body>
<h4>Add degree</h4>
<ul>
    <#if degrees??>
        <#list degrees as degree>
            <li>
                Title in Ukrainian: ${degree.uaName}
                Title in English: ${degree.enName}
            </li>
        </#list>
    <#else>
        <h3>Not data</h3>
    </#if>
</ul>
<form action="/academic-degree" method="post">
    Title in Ukrainian: <label>
        <input type="text" name="uaName">
    </label><br/><br/>
    Title in English: <label>
        <input type="text" name="enName">
    </label><br/><br/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <br/>
    <input type="submit" value="Add">
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>