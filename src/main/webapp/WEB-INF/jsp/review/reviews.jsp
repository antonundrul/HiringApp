<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 29.04.2022
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Отзывы
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">

    <div class="container">
        <div class="mgb-40 padb-30 auto-invert line-b-4 align-center">
            <h4 class="font-cond-l fg-accent lts-md mgb-10" contenteditable="false">Not Yet Convinced?</h4>
            <h1 class="font-cond-b fg-text-d lts-md fs-300 fs-300-xs no-mg" contenteditable="false">Read Customer Reviews</h1>
        </div>
        <ul class="hash-list cols-3 cols-1-xs pad-30-all align-center text-sm">
            <c:forEach var="review" items="${reviews}">
                <javatime:format value="${review.dateCreated}"  pattern="dd.MM.yyyy" var="date"/>
            <li>
                <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="wpx-100 img-round mgb-20" title="" alt="" data-edit="false" data-editor="field" data-field="src[Image Path]; title[Image Title]; alt[Image Alternate Text]">
                <p class="fs-110 font-cond-l" contenteditable="false">${review.comment}</p>
                <h5 class="font-cond mgb-5 fg-text-d fs-130" contenteditable="false">${review.recruiter.user.firstName} ${review.recruiter.user.lastName} </h5>
                <small class="font-cond case-u lts-sm fs-80 fg-text-l" contenteditable="false">IT-recruiter - ${review.recruiter.company.name}</small>
                <small class="font-cond case-u lts-sm fs-80 fg-text-l" contenteditable="false">${date}</small>
            </li>
            </c:forEach>
        </ul>
    </div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>