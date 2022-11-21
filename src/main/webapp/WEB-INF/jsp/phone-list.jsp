<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Editor</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style><%@include file="/resources/css/style.css"%></style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="p-3">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/add-phone">Добавить</a>
    </div>
    <div class="mainContainer p-3">
        <table class="iksweb" aria-describedby="tabledesc">
            <thead>
            <tr>
                <th>Номер</th>
                <th>Раб. место</th>
                <th>Тип</th>
                <th>ФИО</th>
                <th>Действия</th>

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
                        <c:out value="${employee_phone.getPhone().getType()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${employee_phone.getEmployee().getFirstName()}
                            ${employee_phone.getEmployee().getMiddleName()}
                            ${employee_phone.getEmployee().getLastName()}"></c:out>
                    </td>
                    <td>
                        <div style="flex-direction: row">
                            <a type="button" class="btn btn-primary btn-block"
                           href="/update?id=${employee_phone.id}">обновить</a>
                            <a type="button" class="btn btn-primary btn-block"
                           href="/delete-phone?id=${employee_phone.id}">удалить</a>
                        </div>
                    </td>
                </tr>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>