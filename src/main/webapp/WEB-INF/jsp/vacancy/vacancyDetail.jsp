<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        ${vacancy.position}
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
<div style="margin-left: 300px">
    <javatime:format value="${vacancy.createDate}"  pattern="dd.MM.yyyy" var="createDate"/>
<br>
    <c:set var = "status" scope = "session" value = "${vacancy.status.name()}"/>

    <p>Вакансия от ${createDate}   Статус:
        <c:if test="${status.equals('OPEN')}"><strong style="color: #20c997">Открыта</strong></c:if>
        <c:if test="${status.equals('PAUSE')}"><strong style="color: orange">Приостановлена</strong></c:if>
        <c:if test="${status.equals('CANCELED')}"><strong style="color: blueviolet">Отменена</strong></c:if>
        <c:if test="${status.equals('CLOSED')}"><strong style="color: red">Закрыта</strong></c:if>

    </p>

    <h1 class="display-4 fw-bold">${vacancy.position}</h1>
    <h4> ${vacancy.salary}${vacancy.currency.code}</h4>
    <p >Описание: ${vacancy.description}</p>
    <p >Компания: <a href="${vacancy.recruiter.company.website}"> ${vacancy.recruiter.company.name}</a></p>
    <p >Вид занятости: ${vacancy.jobType.name}</p>
    <p >Навыки:
        <c:forEach var="a" items="${vacancy.skills}">
            ${a.name}
        </c:forEach>
    </p>
    <p >Город: ${vacancy.city.name}</p>
    <p >Требуемый опыт: ${vacancy.reqExperience}</p>


        <sec:authorize access="isAuthenticated()">

            <table>
                <tr>
                    <td>
                        <a type="button" class="btn btn-warning <c:if test="${vacancy.responses.contains(user)}">disabled</c:if>" href="${contextPath}/vacancies/${vacancy.id}/subscribe">Откликнуться</a>
                    </td>
                    <td>
                        <a type="button" class="btn btn-warning <c:if test="${!vacancy.responses.contains(user)}">disabled</c:if>" href="${contextPath}/vacancies   /${vacancy.id}/unsubscribe">Отменить отклик</a>
                    </td>
                    <c:if test="${vacancy.recruiter.user.id.equals(user.id)}">
                    <td>
                        <a type="button" class="btn btn-outline-dark" href="${contextPath}/vacancies/responses/${vacancy.id}">Показать отклики</a>
                    </td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                Изменить статус
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <li><a class="dropdown-item" href="${contextPath}/vacancies/${vacancy.id}/changeStatus?open=1">Открыта</a></li>
                                <li><a class="dropdown-item" href="${contextPath}/vacancies/${vacancy.id}/changeStatus?pause=1">Приостановлена</a></li>
                                <li><a class="dropdown-item" href="${contextPath}/vacancies/${vacancy.id}/changeStatus?cancel=1">Отменена</a></li>
                                <li><a class="dropdown-item" href="${contextPath}/vacancies/${vacancy.id}/changeStatus?close=1">Закрыта</a></li>
                            </ul>
                        </div>
                    </td>
                    </c:if>
                </tr>
            </table>
        </sec:authorize>
</div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>