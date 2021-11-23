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


<form:form method="POST" modelAttribute="userForm" >

    <img class="mb-4 mx-auto d-block" src="${contextPath}/resources/images/logo.png" alt="" width="100" height="100">
    <h2 class="form-signin-heading">Создать аккаунт</h2>

            <spring:bind path="username">
                <div class="form-floating  ${status.error ? 'has-error' : ''}">
                    <form:input  type="text" path="username" class="form-control" placeholder="Имя пользователя"
                                autofocus="true"/>
                    <form:errors path="username"/>
                    <label for="username">Имя пользователя</label>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-floating  ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Пароль"/>
                    <form:errors path="password"/>
                    <label for="password">Пароль</label>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-floating  ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Подтвердите ваш пароль"/>
                    <form:errors path="passwordConfirm"/>
                    <label for="passwordConfirm">Подтвердите ваш пароль</label>
                </div>
            </spring:bind>

            <spring:bind path="firstName">
                <div class="form-floating  ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="firstName" class="form-control" placeholder="Имя"
                                autofocus="true"/>
                    <form:errors path="firstName"/>
                    <label for="firstName">Имя</label>
                </div>
            </spring:bind>

            <spring:bind path="lastName">
                <div class="form-floating  ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="lastName" class="form-control" placeholder="Фамилия"
                                autofocus="true"/>
                    <form:errors path="lastName"/>
                    <label for="lastName">Фамилия</label>
                </div>
            </spring:bind>

            <spring:bind path="email">
                <div class="form-floating  ${status.error ? 'has-error' : ''}">
                    <form:input type="email" path="email" class="form-control" placeholder="Email"
                                autofocus="true"/>
                    <form:errors path="email"/>
                    <label for="email">Эл.почта</label>
                </div>
            </spring:bind>

            <h3>
                    ${error}
            </h3>

            <button class="btn btn-warning  btn-block " type="submit">Зарегистрироваться</button>

        </form:form>

</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>
</html>
