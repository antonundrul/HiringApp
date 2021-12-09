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

    <p>Должность: ${vacancy.position}</p>
    <p>Компания: ${vacancy.companyName}</p>
    <p>Заработная плата: ${vacancy.salary}${vacancy.currency.code}</p>
    <p>Тип: ${vacancy.jobType.name}</p>
    <p>Навыки:
        <c:forEach var="a" items="${vacancy.skills}">
            ${a.name}
        </c:forEach>
    </p>
    <p>Город: ${vacancy.city.name}</p>
    <p>Требуемый опыт: ${vacancy.reqExperience}</p>
    <p>Дата размещения: ${vacancy.createDate}</p>

        <sec:authorize access="isAuthenticated()">
            <div class="d-block gap-2 mt-2 ">
                <a type="button" class="btn btn-warning <c:if test="${vacancy.responses.contains(user)}">disabled</c:if>" href="${contextPath}/vacancies/vacancyDetail/${vacancy.id}/subscribe">Откликнуться</a>
                <a type="button" class="btn btn-warning <c:if test="${!vacancy.responses.contains(user)}">disabled</c:if>" href="${contextPath}/vacancies/vacancyDetail/${vacancy.id}/unsubscribe">Отменить отклик</a>
                <c:if test="${vacancy.recruiter.id.equals(user.id)}">
                    <a type="button" class="btn btn-outline-dark" href="${contextPath}/vacancies/responses/${vacancy.id}">Показать отклики</a>
                    <a type="button" class="btn btn-danger" href="${contextPath}/vacancies/delete/${vacancy.id}">Удалить</a>
                </c:if>
            </div>
        </sec:authorize>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>