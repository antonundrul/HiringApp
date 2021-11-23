<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Пользователи
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0">

    <div class="container">

        <h2 class="display-4">
            Пользователи
        </h2>

        <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Логин</th>
                <th>Email</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Права доступа</th>
                <th>Управление</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <th>
                            ${user.username}
                    </th>
                    <td>
                            ${user.email}
                    </td>
                    <td>
                            ${user.firstName}
                    </td>
                    <td>
                            ${user.lastName}
                    </td>
                    <td>
                        <c:forEach var="a" items="${user.roles}">
                            ${a.name}<br>
                        </c:forEach>
                    </td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                Действие
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?block=1">${user.blocked == 1 ? "Разблокировать" : "Заблокировать"}</a></li>
                                <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?seller=1">Добавить/удалить права продавца</a></li>
                                <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?admin=1">Добавить/удалить права администратора</a></li>
                            </ul>
                        </div>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>
<script>
    $(document).ready(function() {
        $('#dtBasicExample').DataTable();
    } );
</script>

</body>

</html>