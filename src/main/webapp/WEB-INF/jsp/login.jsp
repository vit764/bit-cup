<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div class="col-sm-4">
    <form method="POST" action="/login">
        <!-- Email input -->
        <div class="form-outline mb-4">
            <input name="username" id="username" class="form-control" />
            <label class="form-label" for="username">логин</label>
        </div>
        <!-- Password input -->
        <div class="form-outline mb-4">
            <input name="password" type="password" id="password" class="form-control" />
            <label class="form-label" for="password">пароль</label>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Войти</button>
    </form>
</div>
</body>
</html>