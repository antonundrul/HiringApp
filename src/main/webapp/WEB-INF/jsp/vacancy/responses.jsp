<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        ${vacancy.position}
    </title>
    <link href="${contextPath}/resources/css/responses.css" rel="stylesheet">
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">

    <div class="container bootdey">
        <div class="row">
            <div class="col-md-11 ">
                <div class="row">

                    <c:forEach var="user" items="${users}">

                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar2.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="${contextPath}/profile/${user.id}">${user.firstName} ${user.lastName}</a></h5>
                                <span>Designer</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">Photoshop</span>
                                    <span class="badge badge-default">Illustrator</span>
                                    <span class="badge badge-default">Animation</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">

                                <div class="d-block gap-2 mt-2 ">
                                    <a type="button" class="btn btn-outline-dark" href="${contextPath}/profile/${user.id}">Просмотр резюме</a>
                                    <a type="button" class="btn btn-outline-dark" href="${contextPath}/chats/chatWith/${user.id}">Написать</a>
                                </div>


                                    <%--
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Blackwood, NJ</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$55 / hour</span>
                                </div>
--%>
                            </footer>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>