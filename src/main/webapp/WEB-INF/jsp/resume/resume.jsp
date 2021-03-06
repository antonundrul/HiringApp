<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Резюме
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
<div class="row">
   <div class="col-sm-8" >
       <br>
    <h2 class="display-4">
        ${user.firstName} ${user.lastName}
    </h2>
    <h4 class="display-4 fw-bold">${resume.position}</h4>

    <h6 class="display-6">Ключевые навыки:</h6>
    <c:forEach var="a" items="${resumeSkillsList}">
        ${a.skill.name}(${a.level.name})
    </c:forEach>

    <h6 class="display-6">Опыт работы:</h6>
    <c:forEach var="experience" items="${resume.experiences}">
        <javatime:format value="${experience.startDate}"  pattern="dd.MM.yyyy" var="startDate"/>
        <javatime:format value="${experience.endDate}" pattern="dd.MM.yyyy" var="endDate"/>
        <p <c:if test="${experience.currentJob}">style="color: blue" </c:if>> ${experience.position} в компании ${experience.companyName}
                г.${experience.city.name} с ${startDate} по <c:if test="${experience.currentJob}">настоящее время</c:if> ${endDate} </p>
    </c:forEach>

        <c:if test="${isCurrentUser}">
            <a class="btn btn-outline-dark" href="${contextPath}/experiences/add/${resume.user.id}">Добавить опыт работы</a>
            <a class="btn btn-outline-dark" href="${contextPath}/resume/${resume.user.id}/addSkill">Добавить навык</a>
        </c:if>


   </div>
    <sec:authorize access="isAuthenticated() && hasAuthority('ROLE_HR')">
    <div class="col-sm-4" style="border-left-width: medium">
        <br>
        <h6 class="display-6">Если вы уже общались с данным кандидатом <strong class="fw-bold">оставьте свой отзыв о нём</strong></h6>
        <br>
        <form:form method="POST" modelAttribute="reviewForm" >
            <spring:bind path="comment">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:textarea cssStyle="height: 150px; width: 400px" path="comment" class="form-control" placeholder="Комментарий:"
                                   autofocus="true"/>
                    <form:errors path="comment"/>
                </div>
            </spring:bind>
            <span style="color:red" >
                    ${message}
            </span>

            <button class="btn  btn-outline-dark" type="submit">Сохранить</button>
            <a class="btn btn-outline-dark" href="${contextPath}/reviews/${resume.user.id}">Отзывы</a>
        </form:form>
    </div>
    </sec:authorize>
</div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>