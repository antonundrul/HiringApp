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


<form:form method="POST"  action="${contextPath}/update-user"
           modelAttribute="user" enctype="multipart/form-data">
            <%@ include file="/WEB-INF/jsp/common/userDataForm.jsp" %>
            <button class="btn btn-lg btn-warning btn-block" type="submit">Изменить</button>
</form:form>
          <%--  <div class="rounded bg-white mt-5 mb-5">
                <div class="row">
                    <div class="col-md-3 border-right">
                        <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="https://i.imgur.com/O1RmJXT.jpg" width="90"><br>
                            &lt;%&ndash;<span class="font-weight-bold">Логин: <span class="font-weight-normal">${user.username}</span></span>
                            <span class="font-weight-bold">Имя: <span class="font-weight-normal">${user.firstName}</span></span>
                            <span class="font-weight-bold">Фамилия: <span class="font-weight-normal">${user.lastName}</span></span>
                            <span class="font-weight-bold">E-mail: <span class="font-weight-normal">${user.email}</span></span>&ndash;%&gt;
<form:form method="POST"  action="${contextPath}/update-user"
           modelAttribute="user" enctype="multipart/form-data">
                          <div class="row">
                              <div class="col-md-4">
                                  <span class="font-weight-normal">Логин:</span>
                                  <br/>
                                  <br/>
                                  <span class="font-weight-normal">Имя:</span><br/>
                                  <br/>
                                  <span class="font-weight-normal">Фамилия:</span><br/>
                                  <br/>
                                  <span class="font-weight-normal">E-mail:</span>
                              </div>
                              <div class="col-md-8">
                                  <spring:bind path="username">
                                      <div style="margin-bottom: 10px" class="col-md-12 ${status.error ? 'has-error' : ''}">
&lt;%&ndash;                                          <label for="username">Логин: </label>&ndash;%&gt;
                                          <form:input id="username" type="text" path="username" class="form-control" placeholder="Username"
                                                      autofocus="true" disabled="true"/>
                                          <form:errors path="username"/>
                                      </div>
                                  </spring:bind>
                                  <spring:bind path="firstName">
                                      <div style="margin-bottom: 10px" class="col-md-12 ${status.error ? 'has-error' : ''}">
&lt;%&ndash;                                          <label for="username">Имя: </label>&ndash;%&gt;
                                          <form:input id="firstName" type="text" path="firstName" class="form-control" placeholder="Имя"
                                                      autofocus="true" disabled="true"/>
                                          <form:errors path="firstName"/>
                                      </div>
                                  </spring:bind>
                                  <spring:bind path="lastName">
                                      <div style="margin-bottom: 10px" class="col-md-12 ${status.error ? 'has-error' : ''}">
                                              &lt;%&ndash;                                          <label for="username">Имя: </label>&ndash;%&gt;
                                          <form:input id="lastName" type="text" path="lastName" class="form-control" placeholder="Фамилия"
                                                      autofocus="true" disabled="true"/>
                                          <form:errors path="lastName"/>
                                      </div>
                                  </spring:bind>
                                  <spring:bind path="email">
                                      <div style="margin-bottom: 10px" class=" ${status.error ? 'has-error' : ''}">
                                              &lt;%&ndash;                                          <label for="username">Имя: </label>&ndash;%&gt;
                                          <form:input id="email" type="text" path="email" class="form-control" placeholder="E-mail"
                                                      autofocus="true" disabled="true"/>
                                          <form:errors path="email"/>
                                      </div>
                                  </spring:bind>
                                  <button class="btn btn-lg btn-warning btn-block" type="submit">Изменить</button>
                              </div>
                          </div>
</form:form>
                        </div>
                    </div>
                    <div class="col-md-5 border-right">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h6 class="text-right">Профиль</h6>
                            </div>
                            <div class="row mt-2">
                                &lt;%&ndash;<spring:bind path="username">
                                    <div class="col-md-6 ${status.error ? 'has-error' : ''}">
                                        <label for="username">Имя пользователя: </label>
                                        <form:input id="username" type="text" path="username" class="form-control" placeholder="Username"
                                                    autofocus="true" disabled="true"/>
                                        <form:errors path="username"/>
                                    </div>
                                </spring:bind>
                                <spring:bind path="username">
                                    <div class="col-md-6 ${status.error ? 'has-error' : ''}">
                                        <label for="username">Имя пользователя: </label>
                                        <form:input id="username" type="text" path="username" class="form-control" placeholder="Username"
                                                    autofocus="true" disabled="true"/>
                                        <form:errors path="username"/>
                                    </div>
                                </spring:bind>&ndash;%&gt;
                                    &lt;%&ndash;<div class="col-md-6"><label class="labels">Имя</label><input type="text" class="form-control" placeholder="first name" value="John"></div>&ndash;%&gt;
                                    &lt;%&ndash;<div class="col-md-6"><label class="labels">Фамилия</label><input type="text" class="form-control" value="Doe" placeholder="Doe"></div>&ndash;%&gt;
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12"><label class="labels">Headline</label><input type="text" class="form-control" placeholder="headline" value="UI/UX Developer"></div>
                                <div class="col-md-12"><label class="labels">Current position</label><input type="text" class="form-control" placeholder="headline" value="UI/UX Developer at Boston"></div>
                                <div class="col-md-12"><label class="labels">Education</label><input type="text" class="form-control" placeholder="education" value="Boston University"></div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-6"><label class="labels">Country</label><input type="text" class="form-control" placeholder="country" value="USA"></div>
                                <div class="col-md-6"><label class="labels">State/Region</label><input type="text" class="form-control" value="Boston" placeholder="state"></div>
                            </div>
                            <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Save Profile</button></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center experience"><span>Edit Experience</span><span class="border px-3 p-1 add-experience"><i class="fa fa-plus"></i>&nbsp;Experience</span></div>
                            <div class="d-flex flex-row mt-3 exp-container"><img src="https://i.imgur.com/azSfBM3.png" width="45" height="45">
                                <div class="work-experience ml-1"><span class="font-weight-bold d-block">Senior UI/UX Designer</span><span class="d-block text-black-50 labels">Twitter Inc.</span><span class="d-block text-black-50 labels">March,2017 - May 2020</span></div>
                            </div>
                            <hr>
                            <div class="d-flex flex-row mt-3 exp-container"><img src="https://img.icons8.com/color/100/000000/facebook.png" width="45" height="45">
                                <div class="work-experience ml-1"><span class="font-weight-bold d-block">Senior UI/UX Designer</span><span class="d-block text-black-50 labels">Facebook Inc.</span><span class="d-block text-black-50 labels">March,2017 - May 2020</span></div>
                            </div>
                            <hr>
                            <div class="d-flex flex-row mt-3 exp-container"><img src="https://img.icons8.com/color/50/000000/google-logo.png" width="45" height="45">
                                <div class="work-experience ml-1"><span class="font-weight-bold d-block">UI/UX Designer</span><span class="d-block text-black-50 labels">Google Inc.</span><span class="d-block text-black-50 labels">March,2017 - May 2020</span></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

--%>
    </div>

</main>


<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>
</html>
