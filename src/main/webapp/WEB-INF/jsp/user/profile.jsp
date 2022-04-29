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

        <div class="d-block gap-2 mt-2 " style="margin-left: 300px">
            <a href="${contextPath}/resume/${user.id}" class="btn btn-outline-dark">Просмотреть резюме</a>
        </div>

        <div class="row ">

            <div class="col-lg-4 col-md-4 col-sm-12 justify-content-center">
                <div style="float: right">

                    <h1>Фото: </h1>

                    <img id="output"
                         width="350px"
                         height="350px"
                         alt="picture"
                         src="${imageRef}"/>

                    <%--<spring:bind path="imageUpdate">
                        <form:input id="imageUpdate" type="file" path="avatar" onchange="loadFile(event)"
                                    disabled="${formDisabled}"/>
                        <form:errors path="imageUpdate"/>
                    </spring:bind>

                    <script>
                        const loadFile = function (event) {
                            const output = document.getElementById('output');
                            output.src = URL.createObjectURL(event.target.files[0]);
                            output.onload = function () {
                                URL.revokeObjectURL(output.src)
                            }
                        };
                    </script>--%>
                </div>

            </div>


            <div class="col-lg-8 col-md-8 col-sm-12 desc">
                <br>
                <br>

                <p class="display-6">Логин: ${user.username}</p>
                <p class="display-6">Имя: ${user.firstName}</p>
                <p class="display-6">Фамилия: ${user.lastName}</p>
                <p class="display-6">E-mail: ${user.email}</p>

            </div>
        </div>
    </div>

</main>


<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>
</html>
