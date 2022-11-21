<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Phonebook</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <security:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="/phone-list">admin page<span class="sr-only"></span></a>
                    </li>
                </security:authorize>
            </ul>
        </div>

        <security:authorize access="!isAuthenticated()">
            <a href="/login"><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button></a>
        </security:authorize>


        <security:authorize access="isAuthenticated()">
        <span class="navbar navbar-light bg-light">
            <security:authentication property="principal.username" />
        </span>
            <form action="/logout" method="post" style="margin-top: auto; margin-bottom: auto">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
            </form>
        </security:authorize>

    </div>
</nav>