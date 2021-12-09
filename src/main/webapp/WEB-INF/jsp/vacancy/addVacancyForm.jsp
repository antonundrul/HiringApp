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
        Разместить вакансию
    </h2>

    <form:form method="POST" modelAttribute="vacancyForm" enctype="multipart/form-data">

    <spring:bind path="position">
        <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:input  type="text" path="position" class="form-control" placeholder="Должность"
                         autofocus="true"/>
            <form:errors path="position"/>
        </div>
    </spring:bind>
    <spring:bind path="description">
        <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:input  type="textarea" path="description" class="form-control" placeholder="Описание"
                         autofocus="true"/>
            <form:errors path="description"/>
        </div>
    </spring:bind>
    <spring:bind path="salary">
        <div class="form-group  ${status.error ? 'has-error' : ''}">
            <p>Заработная плата</p>
            <form:input  type="number" path="salary" class="form-control" placeholder="Заработная плата"
                         autofocus="true"/>
            <form:errors path="salary"/>
        </div>
    </spring:bind>
    <spring:bind path="currency">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="currency" path="currency" class="form-control">
                <form:option value="0" label="Валюта"/>
                <form:options items="${currencies}"
                              itemLabel="name"
                              itemValue="id"/>
            </form:select>
            <form:errors path="currency"/>
        </div>
    </spring:bind>
    <spring:bind path="companyName">
        <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:input  type="text" path="companyName" class="form-control" placeholder="Название компании"
                         autofocus="true"/>
            <form:errors path="companyName"/>
        </div>
    </spring:bind>
    <spring:bind path="reqExperience">
        <div class="form-group  ${status.error ? 'has-error' : ''}">
            <p>Требуемый опыт</p>
            <form:input  type="text" path="reqExperience" class="form-control" placeholder="Необходимый опыт"
                         autofocus="true"/>
            <form:errors path="reqExperience"/>
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
    <spring:bind path="jobType">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="jobType" path="jobType" class="form-control">
                <form:option value="0" label="Тип"/>
                <form:options items="${jobTypes}"
                              itemLabel="name"
                              itemValue="id"/>
            </form:select>
            <form:errors path="jobType"/>
        </div>
    </spring:bind>
    <spring:bind path="skills">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="skills" path="skills" class="form-control" multiple="true">
<%--                <form:option value="0" label="Навыки"/>--%>
                <form:options items="${skills}"
                              itemLabel="name"
                              itemValue="id"/>
            </form:select>
            <form:errors path="skills"/>
        </div>
    </spring:bind>

        <h3>
                ${error}
        </h3>

        <button class="btn btn-outline-dark" type="submit">Сохранить</button>
<a href="${contextPath}/skills/add" class="btn btn-outline-dark">Добавить навык</a>

    </form:form>



</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>