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

    ${vacancy.position}<br>
    ${vacancy.companyName}<br>
    ${vacancy.salary}<br>
    ${vacancy.currency.code}<br>
    ${vacancy.jobType.name}<br>
        <c:forEach var="a" items="${vacancy.skills}">
            ${a.name}
        </c:forEach><br>
    ${vacancy.city.name}<br>
    ${vacancy.reqExperience}<br>
    ${vacancy.createDate}<br>

        <sec:authorize access="isAuthenticated()">
            <div class="d-block gap-2 mt-2 ">
                <a type="button" class="btn btn-warning <c:if test="${vacancy.responses.contains(user)}">disabled</c:if>" href="${contextPath}/vacancies/vacancyDetail/${vacancy.id}/subscribe">Откликнуться</a>
                <a type="button" class="btn btn-warning <c:if test="${!vacancy.responses.contains(user)}">disabled</c:if>" href="${contextPath}/vacancies/vacancyDetail/${vacancy.id}/unsubscribe">Отменить отклик</a>
            </div>
        </sec:authorize>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>