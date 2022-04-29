<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <title>Создание аккаунта</title>

    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
</head>

<body >


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="form-signin text-center">


    <form:form method="POST" modelAttribute="recruiterForm" enctype="multipart/form-data">

        <img class="mb-4 mx-auto d-block" src="${contextPath}/resources/images/logo.png" alt="" width="100" height="100">
        <h2 class="form-signin-heading">Регистрация рекрутера</h2>

        <spring:bind path="user">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select id="user" path="user" class="form-control">
                    <form:option value="0" label="Пользователь"/>
                    <form:options items="${users}"
                                  itemLabel="username"
                                  itemValue="id"/>
                </form:select>
                <form:errors path="user"/>
            </div>
        </spring:bind>
        <spring:bind path="company">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select id="company" path="company" class="form-control">
                    <form:option value="0" label="Компания"/>
                    <form:options items="${companies}"
                                  itemLabel="name"
                                  itemValue="id"/>
                </form:select>
                <form:errors path="company"/>
            </div>
        </spring:bind>
        <h3>
                ${error}
        </h3>

        <button class="btn btn-warning  btn-block " type="submit">Зарегистрировать</button>

    </form:form>

</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>
</html>
