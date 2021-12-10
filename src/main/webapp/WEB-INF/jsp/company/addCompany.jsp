
<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>Новый город</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/util/header.jsp" %>

<main role="main" class="container">
    <h2 class="display-6 text-center">
        Регистрация компании
    </h2>
    <form:form method="POST" modelAttribute="companyForm" class="form-signin">
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Название"
                            autofocus="true"/>
                <form:errors path="name"/>
            </div>
        </spring:bind>
        <spring:bind path="website">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="website" class="form-control" placeholder="Сайт"
                            autofocus="true"/>
                <form:errors path="website"/>
            </div>
        </spring:bind>
            <span style="color:red" >
                    ${message}
            </span>

        <button class="btn btn-lg btn-warning btn-block" type="submit">Сохранить</button>
    </form:form>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>
</body>
</html>
