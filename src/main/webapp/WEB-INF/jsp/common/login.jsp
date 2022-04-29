<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <title>Вход</title>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <script src="Styles/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="Styles/bootstrap-4.1.0.min.js" type="text/javascript"></script>
    <link href="Styles/bootstrap-4.1.0.min.css" rel="stylesheet" type="text/css"/>
    <link href="Styles/MainStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%@ include file="/WEB-INF/jsp/util/header.jsp" %>

<div class="text-center" style="display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  height: 100%;">
    <main role="main" class="form-signin">
        <form method="POST" action="${contextPath}/login">
            <br><br>
            <img class="mb-4 mx-auto d-block" src="${contextPath}/resources/images/logo.png" alt="" width="100" height="100">
            <h1 class="h3 mb-3 fw-normal">Вход</h1>
            <div class="form-floating">
                <input type="text" class="form-control" id="username" name="username" placeholder="Имя пользователя" autofocus>
                <label for="username">Имя пользователя</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
                <label for="password">Пароль</label>
            </div>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="w-100 btn btn-lg btn-warning" type="submit">Войти</button>
        </form>
    </main>
</div>


<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>


</body>
</html>
