<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        ${Компании}
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
    <div style="margin-left: 300px">
        <br>
        <c:forEach var="company" items="${companies}">
            <p><a href="${company.website}">${company.name}</a></p>
        </c:forEach>

    </div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>