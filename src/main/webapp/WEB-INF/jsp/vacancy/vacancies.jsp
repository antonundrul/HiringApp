<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Вакансии
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
            <h2 class="display-4">
                Вакансии
            </h2>

            <div class="d-block gap-2 mt-2 ">
                <a type="button" class="btn btn-outline-dark" href="${contextPath}/vacancies">Все вакансии</a>
                <sec:authorize access="isAuthenticated()">
                <a type="button" class="btn btn-outline-dark" href="${contextPath}/vacancies/myResponses">Мои отклики</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated() && hasAuthority('ROLE_HR')">
                <a type="button" class="btn btn-outline-dark" href="${contextPath}/vacancies/myVacancies">Мои вакансии</a>
                <a type="button" class="btn btn-outline-dark" href="${contextPath}/vacancies/addVacancy">Разместить вакансию</a>
                </sec:authorize>
            </div>
            <br>
            <br>
            <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Должность</th>
                    <th>Компания</th>
                    <th>Зарплата</th>
                    <th>Тип занятости</th>
                    <th>Навыки</th>
                    <th>Город</th>
                    <th>Дата создания</th>
                    <sec:authorize access="isAuthenticated()" >
                    <th>Откликнуться</th>
                    </sec:authorize>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="vacancy" items="${vacancies}">
<%--                    <javatime:format value="${vacancy.vacancy.createDate}" style="SS" var="dateCreated"/>--%>

                    <tr>
                        <th>
                               <a href="${contextPath}/vacancies/vacancyDetail/${vacancy.id}" style="color: black"> ${vacancy.position}
                        </th>
                        <td>
                               <a href="${vacancy.recruiter.company.website}"> ${vacancy.recruiter.company.name}</a>
                        </td>
                        <td>
                                ${vacancy.salary} ${vacancy.currency.code}
                        </td>
                        <td>
                                ${vacancy.jobType.name}
                        </td>
                        <td>
                             <c:forEach var="a" items="${vacancy.skills}">
                                 ${a.name}<br>
                             </c:forEach>
                        </td>
                        <td>
                                ${vacancy.city.name}
                        </td>
                        <td>
                            <javatime:format value="${vacancy.createDate}"  pattern="dd.MM.yyyy" var="createDate"/>
                                ${createDate}
                        </td>
                        <sec:authorize access="isAuthenticated()" >
                            <td>
                                <c:if test="${!vacancy.responses.contains(user)}">
                                    <a type="button" class="btn btn-warning" href="${contextPath}/vacancies/vacancyDetail/${vacancy.id}/subscribe">Откликнуться</a>
                                </c:if>
                                <c:if test="${vacancy.responses.contains(user)}">
                                    <a type="button" class="btn btn-outline-dark" href="${contextPath}/vacancies/vacancyDetail/${vacancy.id}/unsubscribe">Отменить отклик</a>
                                </c:if>
                            </td>
                        </sec:authorize>
                       <%-- <td>
                            <div class="dropdown">
                                <button class="btn btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                    Действие
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?block=1">${user.blocked == 1 ? "Разблокировать" : "Заблокировать"}</a></li>
                                    <li><a class="dropdown-item" href="${contextPath}/chats/chatWith/${user.id}">Написать</a></li>
                                    <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?seller=1">Добавить/удалить права продавца</a></li>
                                    <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?admin=1">Добавить/удалить права администратора</a></li>
                                </ul>
                            </div>
                        </td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
<%--        </div>--%>


</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

<script>
    $(document).ready(function() {
        $('#dtBasicExample').DataTable();
    } );
</script>
</body>

</html>