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

<%--<div class="text-center" style="display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  height: 100%;">--%>
<main role="main" >
        <%--<form method="POST" action="${contextPath}/login">
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
        </form>--%>




            <div class=" container register">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Войти</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Зарегистрироваться</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active text-align form-new" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Вход</h3>
                                <div class="row register-form">
                                    <div class="col-md-12">
                                        <form method="post" action="${contextPath}/login">
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="username" name="username" placeholder="Имя пользователя" autofocus>
<%--                                               <input type="text" name="LGform1_user" class="form-control" placeholder="Your Email *" value="" required=""/>--%>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
<%--                                                <input type="password" name="LGform1_pwd" class="form-control" placeholder="Your Password *" value="" required=""/>--%>
                                            </div>
                                            <div class="form-group">
                                                <span>${error}</span>
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                <button class="btnContactSubmit" type="submit">Войти</button>
<%--                                                <input type="submit" name="LGform1" class="btnContactSubmit" value="Login" />--%>
                                                <a href="ForgetPassword.php" class="btnForgetPwd" value="Login">Forget Password?</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade show text-align form-new" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                <h3  class="register-heading">Регистрация</h3>
                                <div class="row register-form">
                                    <div class="col-md-12">
                                        <%--<form method="post">
                                            <div class="form-group">
                                                <input type="text" name="LGform2_user" class="form-control" placeholder="Your Email *" value="" required="" />
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="LGform2_pwd" class="form-control" placeholder="Your Password *" value="" required=""/>
                                            </div>
                                            <div class="form-group">
                                                <input type="submit" name="LGform2" class="btnContactSubmit" value="Login" />
                                                <a href="ForgetPassword.php" class="btnForgetPwd" value="Login">Forget Password?</a>
                                            </div>
                                        </form>--%>

                                        <form:form method="POST" modelAttribute="userForm" enctype="multipart/form-data">
                                            <spring:bind path="username">
                                                <div class="form-group  ${status.error ? 'has-error' : ''}">
                                                    <form:input  type="text" path="username" class="form-control" placeholder="Имя пользователя"
                                                                 autofocus="true"/>
                                                    <form:errors path="username"/>
<%--                                                    <label for="username">Имя пользователя</label>--%>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="password">
                                                <div class="form-group  ${status.error ? 'has-error' : ''}">
                                                    <form:input type="password" path="password" class="form-control" placeholder="Пароль"/>
                                                    <form:errors path="password"/>
<%--                                                    <label for="password">Пароль</label>--%>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="passwordConfirm">
                                                <div class="form-group  ${status.error ? 'has-error' : ''}">
                                                    <form:input type="password" path="passwordConfirm" class="form-control"
                                                                placeholder="Подтвердите ваш пароль"/>
                                                    <form:errors path="passwordConfirm"/>
<%--                                                    <label for="passwordConfirm">Подтвердите ваш пароль</label>--%>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="firstName">
                                                <div class="form-group  ${status.error ? 'has-error' : ''}">
                                                    <form:input type="text" path="firstName" class="form-control" placeholder="Имя"
                                                                autofocus="true"/>
                                                    <form:errors path="firstName"/>
<%--                                                    <label for="firstName">Имя</label>--%>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="lastName">
                                                <div class="form-group  ${status.error ? 'has-error' : ''}">
                                                    <form:input type="text" path="lastName" class="form-control" placeholder="Фамилия"
                                                                autofocus="true"/>
                                                    <form:errors path="lastName"/>
<%--                                                    <label for="lastName">Фамилия</label>--%>
                                                </div>
                                            </spring:bind>

                                            <spring:bind path="email">
                                                <div class="form-group  ${status.error ? 'has-error' : ''}">
                                                    <form:input type="email" path="email" class="form-control" placeholder="Email"
                                                                autofocus="true"/>
                                                    <form:errors path="email"/>
<%--                                                    <label for="email">Эл.почта</label>--%>
                                                </div>
                                            </spring:bind>

                                            <h3>
                                                    ${error}
                                            </h3>

                                            <button class="btnContactSubmit" type="submit">Зарегистрироваться</button>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</main>
<%--</div>--%>


<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>


</body>
</html>
