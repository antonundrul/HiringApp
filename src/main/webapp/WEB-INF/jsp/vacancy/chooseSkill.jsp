<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Добавление вакансии
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
    <h2 class="display-4">
        Добавление навыков:
    </h2>

    <form:form method="POST" modelAttribute="vacancySkillForm" enctype="multipart/form-data">


         <spring:bind path="skill">
             <div class="form-group ${status.error ? 'has-error' : ''}">
                 <p>Навыки</p>
                 <form:select id="skill" path="skill" class="form-control">
                     <form:option value="0" label="Навыки"/>
                     <form:options items="${skills}"
                                   itemLabel="name"
                                   itemValue="id"/>
                 </form:select>
                 <form:errors path="skill"/>
             </div>
         </spring:bind>
         <spring:bind path="level">
             <div class="form-group ${status.error ? 'has-error' : ''}">

                 <form:select id="level" path="level" class="form-control">
                     <form:option value="0" label="Уровень владения"/>
                     <form:options items="${levels}"
                                   itemLabel="name"
                                   itemValue="id"/>
                 </form:select>
                 <form:errors path="level"/>
             </div>
         </spring:bind>
        <h3>
                ${error}
        </h3>

        <button class="btn btn-outline-dark" type="submit">Добавить</button>
        <a href="${contextPath}/skills/add" class="btn btn-outline-dark">Новый навык</a>

    </form:form>



</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>