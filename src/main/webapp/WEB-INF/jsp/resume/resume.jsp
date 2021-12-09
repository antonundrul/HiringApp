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

   <div style="margin-left: 300px">
       <br>
    <h2 class="display-4">
        ${user.firstName} ${user.lastName}
    </h2>
    <h4 class="display-4 fw-bold">${resume.position}</h4>

    <h6 class="display-6">Ключевые навыки:</h6>
    <c:forEach var="skill" items="${resume.skills}">
        ${skill.name}
    </c:forEach>

    <h6 class="display-6">Опыт работы:</h6>
    <c:forEach var="experience" items="${resume.experiences}">
        <javatime:format value="${experience.startDate}"  pattern="dd.MM.yyyy" var="startDate"/>
        <javatime:format value="${experience.endDate}" pattern="dd.MM.yyyy" var="endDate"/>
        <p <c:if test="${experience.currentJob}">style="color: blue" </c:if>> ${experience.position} в компании ${experience.companyName}
                г.${experience.city.name} с ${startDate} по <c:if test="${experience.currentJob}">настоящее время</c:if> ${endDate} </p>
    </c:forEach>

        <c:if test="${isCurrentUser}">
            <a class="btn btn-outline-dark" href="${contextPath}/experiences/add/${resume.id}">Добавить опыт работы</a>
        </c:if>
   </div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>