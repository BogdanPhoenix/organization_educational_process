<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
<h4>Authorization</h4>
<form action="/login" method="post">
    Email: <label>
        <input type="email" name="username">
    </label><br/><br/>
    Password: <label>
        <input type="password" name="password">
    </label><br/><br/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Login">
</form>
<#--<a href="/registration">Registration</a>-->
<a href="/api/v1/auth/registration">Registration</a>
</body>
</html>