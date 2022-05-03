<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Добавление резюме
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
    <h2 class="display-4">
        Разместить резюме
    </h2>

    <form:form method="POST" modelAttribute="resumeForm" enctype="multipart/form-data">

        <spring:bind path="position">
            <div class="form-group  ${status.error ? 'has-error' : ''}">
                <form:input  type="text" path="position" class="form-control" placeholder="Должность"
                             autofocus="true"/>
                <form:errors path="position"/>
            </div>
        </spring:bind>

        <spring:bind path="city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select id="city" path="city" class="form-control">
                    <form:option value="0" label="Город"/>
                    <form:options items="${cities}"
                                  itemLabel="name"
                                  itemValue="id"/>
                </form:select>
                <form:errors path="city"/>
            </div>
        </spring:bind>
      <%--  <spring:bind path="skills">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select id="skills" path="skills" class="form-control" multiple="true">
                    &lt;%&ndash;                <form:option value="0" label="Навыки"/>&ndash;%&gt;
                    <form:options items="${skills}"
                                  itemLabel="name"
                                  itemValue="id"/>
                </form:select>
                <form:errors path="skills"/>
            </div>
        </spring:bind>--%>

        <h3>
                ${error}
        </h3>

        <button class="btn btn-outline-dark" type="submit">Сохранить</button>
        <a href="${contextPath}/skills/add" class="btn btn-outline-dark">Добавить навык</a>
        <a href="${contextPath}/cities/add" class="btn btn-outline-dark">Добавить Город</a>

    </form:form>



</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>