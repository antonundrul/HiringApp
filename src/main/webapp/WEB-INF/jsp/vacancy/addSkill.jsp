
<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>Новый навык</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/util/header.jsp" %>

<main role="main" class="container">
    <h2 class="display-6 text-center">
        Добавление навыка
    </h2>
    <form:form method="POST" modelAttribute="skillForm" class="form-signin">
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Навык"
                            autofocus="true"/>
                <form:errors path="name"/>
            </div>
            <span style="color:red" >
                    ${message}
            </span>
        </spring:bind>
        <button class="btn btn-lg btn-warning btn-block" type="submit">Сохранить</button>
    </form:form>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>
</body>
</html>
