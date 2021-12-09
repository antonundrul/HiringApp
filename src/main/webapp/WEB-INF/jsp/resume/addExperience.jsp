<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Добавление опыта
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
    <h2 class="display-4">
        Добавить опыт
    </h2>
<div class="container">
    <form:form method="POST" modelAttribute="experienceForm" enctype="multipart/form-data">

        <spring:bind path="companyName">
            <div class="form-group  ${status.error ? 'has-error' : ''}">
                <form:input  type="text" path="companyName" class="form-control" placeholder="Компания"
                             autofocus="true"/>
                <form:errors path="companyName"/>
            </div>
        </spring:bind>

        <spring:bind path="position">
            <div class="form-group  ${status.error ? 'has-error' : ''}">
                <form:input  type="text" path="position" class="form-control" placeholder="Должность"
                             autofocus="true"/>
                <form:errors path="position"/>
            </div>
        </spring:bind>

        <spring:bind path="description">
            <div class="form-group  ${status.error ? 'has-error' : ''}">
                <form:textarea  type="text" path="description" class="form-control" placeholder="Описание"
                             autofocus="true"/>
                <form:errors path="description"/>
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

        <spring:bind path="startDate">
            <div class="form-group  ${status.error ? 'has-error' : ''}">
                <p>C</p>
                <form:input  type="date" path="startDate" class="form-control" autofocus="true"/>
                <form:errors path="startDate"/>
            </div>
        </spring:bind>

        <spring:bind path="endDate">
            <p>По</p>
            <div class="form-group  ${status.error ? 'has-error' : ''}">
                <form:input  type="date" path="endDate" class="form-control" autofocus="true"/>
                <form:errors path="endDate"/>
            </div>
        </spring:bind>

        <h3>
                ${error}
        </h3>

        <button class="btnContactSubmit" type="submit">Сохранить</button>

    </form:form>
</div>


</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>