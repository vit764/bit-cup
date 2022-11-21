<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style><%@include file="/resources/css/style.css"%></style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="p-3">
    <hr>
    <div class="mainContainer p-3">
        <form method="get" action="/">
            <div class="form-group row">
                <div class="col-sm-4">
                    <input type="text" name="query" id="query" class="form-control" value='' />
                </div>
                <input class="btn btn-primary" type="submit" value="Search">
            </div>
        </form>
        <br>
        <table class="iksweb" aria-describedby="tabledesc">
            <thead>
            <tr>
                <th>Номер</th>
                <th>Раб. место</th>
                <th>ФИО</th>
                <th>Почта</th>
                <th>Позиция</th>
                <th>Отдел</th>
            </tr>
            </thead>
            <c:forEach var="employee_phone" items="${employee_phones}" varStatus="status">
                <tbody>
                <tr>
                    <td>
                        <c:out value="${employee_phone.getPhone().getValue()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${employee_phone.getPhone().getWorkplace().getName()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${employee_phone.getEmployee().getFirstName()}
                            ${employee_phone.getEmployee().getMiddleName()}
                            ${employee_phone.getEmployee().getLastName()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${employee_phone.getEmployee().getMail()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${employee_phone.getEmployee().getJobPosition().getName()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${employee_phone.getEmployee().getDepartment().getName()}"></c:out>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>