<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Личный кабинет
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>

<main role="main" class="flex-shrink-0">

    <div class="container">


        <form:form method="POST" class="form-signin" action="${contextPath}/update-user"
                   modelAttribute="user" enctype="multipart/form-data">
            <%@ include file="/WEB-INF/jsp/common/userDataForm.jsp" %>
<br>
<br>
            <div class="row">
                <div class="col-md-4">
            <button class="btn btn-lg btn-warning btn-block" type="submit">Изменить</button>
                </div>
                <div class="col-md-4">
                    <a href="${contextPath}/resume/add" class="btn btn-outline-dark">Добавить резюме</a>
                </div>
                <div class="col-md-4">
                    <a href="${contextPath}/resume/${user.id}" class="btn btn-outline-dark">Просмотреть резюме</a>
                </div>
                </div>
        </form:form>
    </div>

</main>


<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>
</html>
