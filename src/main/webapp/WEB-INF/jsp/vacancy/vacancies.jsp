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
                    <th>Статус</th>
                    <sec:authorize access="isAuthenticated()" >
                    <th>Откликнуться</th>
                    </sec:authorize>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="vacancy" items="${vacancies}">
                    <tr>
                        <th>
                               <a href="${contextPath}/vacancies/vacancyDetail/${vacancy.key.id}" style="color: black"> ${vacancy.key.position}
                        </th>
                        <td>
                               <a href="${vacancy.key.recruiter.company.website}"> ${vacancy.key.recruiter.company.name}</a>
                        </td>
                        <td>
                                ${vacancy.key.salary} ${vacancy.key.currency.code}
                        </td>
                        <td>
                                ${vacancy.key.jobType.name}
                        </td>
                        <td>
                             <c:forEach var="a" items="${vacancy.value}">
                                 ${a.skill.name}(${a.level.name})<br>
                             </c:forEach>
                        </td>
                        <td>
                                ${vacancy.key.city.name}
                        </td>
                        <td>
                            <javatime:format value="${vacancy.key.createDate}"  pattern="dd.MM.yyyy" var="createDate"/>
                                ${createDate}
                        </td>
                        <c:set var = "status" scope = "session" value = "${vacancy.key.status.name()}"/>
                        <c:if test="${status.equals('OPEN')}"><td style="background-color: #b1dfbb">Открыта</td></c:if>
                        <c:if test="${status.equals('PAUSE')}"><td style="background-color: #ffdf7e ">Приостановлена</td></c:if>
                        <c:if test="${status.equals('CANCELED')}"><td style="background-color: #b6d4fe">Отменена</td></c:if>
                        <c:if test="${status.equals('CLOSED')}"><td style="background-color: #ed969e">Закрыта</td></c:if>
                        <sec:authorize access="isAuthenticated()" >
                            <td>
                                <c:if test="${!vacancy.key.responses.contains(user)}">
                                    <a type="button" class="btn btn-warning" href="${contextPath}/vacancies/${vacancy.key.id}/subscribe">Откликнуться</a>
                                </c:if>
                                <c:if test="${vacancy.key.responses.contains(user)}">
                                    <a type="button" class="btn btn-outline-dark" href="${contextPath}/vacancies/${vacancy.key.id}/unsubscribe">Отменить отклик</a>
                                </c:if>
                            </td>
                        </sec:authorize>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

<script>
    $(document).ready(function() {
        $('#dtBasicExample').DataTable();
    } );
</script>
</body>

</html>