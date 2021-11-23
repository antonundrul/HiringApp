<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>500</title>
</head>

<body class="d-flex flex-column h-100">

<%@ include file="/WEB-INF/jsp/util/header.jsp" %>

<main role="main" class="flex-shrink-0">

    <div class="container">

        <div class="row">

            <h2>
                Что то пошло не так
                <a href="${pageContext.request.contextPath}/flights">
                    Назад
                </a>
            </h2>

        </div>
    </div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>


</body>

</html>
