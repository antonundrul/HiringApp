<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Пользователи
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css1">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <script src="https://use.fontawesome.com/45e03a14ce.js"></script>
    <div class="main_section">
<%--        <div class="container">--%>
            <div class="chat_container">
                <div class="col-sm-3 chat_sidebar">
                    <div class="row">
                        <div id="custom-search-input">
                            <div class="input-group col-md-12">
                                <input type="text" class="  search-query form-control" placeholder="Conversation" />
                                <button class="btn btn-danger" type="button">
                                    <span class=" glyphicon glyphicon-search"></span>
                                </button>
                            </div>
                        </div>
                        <div class="dropdown all_conversation">
                            <button class="dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-weixin" aria-hidden="true"></i>
                                All Conversations
                                <span class="caret pull-right"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <li><a href="#"> All Conversation </a>  <ul class="sub_menu_ list-unstyled">
                                    <li><a href="#"> All Conversation </a> </li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                                </li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                        <div class="member_list">
                            <ul class="list-unstyled">
                                <c:forEach var="chat" items="${chats}">
                                    <c:set var="lastMessage" scope = "session" value="${chat.value.messages.get(chat.value.messages.size()-1)}"/>

                                    <li class="left clearfix">

                                        <a href="${contextPath}/chats/chatWith/${chat.key.id}" style="color: black">
                     <span class="chat-img pull-left">
<%--                     <img src="${contextPath}/resources/images/${chat.key.avatar}" alt="User Avatar" class="img-circle">--%>
                     </span>
                                        <div class="chat-body clearfix">
                                            <div class="header_sec">

                                                <strong class="primary-font">${chat.key.firstName} ${chat.key.lastName}</strong>

                                               <c:if test="${lastMessage.sendDateTime.toLocalDate().equals(now.toLocalDate())}">
                                                   <p class="pull-right">${lastMessage.sendDateTime.hour}:${lastMessage.sendDateTime.minute}</p>
                                               </c:if>
                                               <c:if test="${!lastMessage.sendDateTime.toLocalDate().equals(now.toLocalDate())}">
                                                   <p class="pull-right">${lastMessage.sendDateTime.month.name().toLowerCase().substring(0,3)} ${lastMessage.sendDateTime.dayOfMonth}</p>
                                               </c:if>

                                            </div>
                                            <div class="contact_sec">
                                                <p class="primary-font">${lastMessage.message}</p> <%--<span class="badge pull-right">3</span>--%>
                                            </div>
                                        </div>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div></div>
                </div>
                <!--chat_sidebar-->


                <div class="col-sm-9 message_section">
                    <div class="row">
                        <div class="new_message_head">
                            <div class="pull-left">
                                 <span class="chat-img pull-left">
<%--                                <img src="${contextPath}/resources/images/${toUser.avatar}" alt="User Avatar" class="img-circle">--%>
                                 </span>
                                     <h3> ${toUser.firstName} ${toUser.lastName}</h3>
                            </div>
                            <div class="pull-right"><div class="dropdown">
                            <button class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-cogs" aria-hidden="true"></i>  Setting
<%--                                <span class="caret"></span>--%>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                                <li><a href="#">Action</a></li>
                                <li><a href="${contextPath}/profile/${toUser.id}">Профиль</a></li>
                                <li><a href="${contextPath}/chats/delete/${toUser.id}">Удалить диалог</a></li>
                            </ul>
                        </div></div>
                        </div><!--new_message_head-->

                        <div class="chat_area">
                            <ul class="list-unstyled">









                                <div class="px-0">
                                    <div class="px-4 py-5 chat-box bg-white">

                                        <c:forEach var="message" items="${messages}">

                                            <!-- Sender Message-->
                                        <c:if test="${message.sender.id.equals(toUser.id)}">
                                            <div class="media w-50 mb-3"><img src="https://bootstrapious.com/i/snippets/sn-chat/avatar.svg" alt="user" width="50" class="rounded-circle">
                                                <div class="media-body ml-3">
                                                    <div class="bg-light rounded py-2 px-3 mb-2">
                                                        <p class="text-small mb-0 text-muted">${message.message}</p>
                                                    </div>
                                                    <p class="small text-muted">${message.sendDateTime.hour}:${message.sendDateTime.minute} | ${message.sendDateTime.month.name().toLowerCase().substring(0,3)} ${message.sendDateTime.dayOfMonth}</p>
                                                </div>
                                            </div>
                                        </c:if>

                                        <!-- Reciever Message-->
                                            <c:if test="${!message.sender.id.equals(toUser.id)}">
                                                <div class="media w-50 ml-auto mb-3">
                                                    <div class="media-body">
                                                        <div class="bg-primary rounded py-2 px-3 mb-2">
                                                            <p class="text-small mb-0 text-white">${message.message}</p>
                                                        </div>
                                                        <p class="small text-muted">${message.sendDateTime.hour}:${message.sendDateTime.minute} | ${message.sendDateTime.month.name().toLowerCase().substring(0,3)} ${message.sendDateTime.dayOfMonth}</p>
                                                    </div>
                                                </div>

                                            </c:if>
                                        </c:forEach>

                                    </div>
                                </div>




                
              <%--  <c:choose>
                    <c:when test="${message.sender.id}==${toUser.id}">
                                <li class="left clearfix">
                     <span class="chat-img1 pull-left">
&lt;%&ndash;                     <img src="${contextPath}/resources/images/${message.sender.avatar}" alt="User Avatar" class="img-circle">&ndash;%&gt;
                     </span>
                                    <div class="chat-body1 clearfix">
                                        <p>${message.message}</p>
                                        <div class="chat_time pull-right">${message.sendDateTime.toLocalTime()}</div>
                                    </div>
                                </li>
                    </c:when>
                    <c:otherwise>
                                <li class="left clearfix admin_chat">
                     <span class="chat-img1 pull-right">
&lt;%&ndash;                     <img src="${contextPath}/resources/images/${message.sender.avatar}" alt="User Avatar" class="img-circle">&ndash;%&gt;
                     </span>
                                    <div class="chat-body1 clearfix">
                                        <p>${message.message}</p>
                                        <div class="chat_time pull-left">${message.sendDateTime.toLocalTime()}</div>
                                    </div>
                                </li>
                    </c:otherwise>
                </c:choose>--%>

                            </ul>
                        </div><!--chat_area-->
                        <div class="message_write">
                            <form:form method="post" modelAttribute="messageForm">
                            <spring:bind path="message">
                                <form:textarea id="message" path="message" class="form-control" placeholder="type a message"></form:textarea>
                            </spring:bind>
                                    <div class="clearfix"></div>
                                    <div class="chat_bottom">
                                        <a href="#" class="pull-left upload_btn"><i class="fa fa-cloud-upload" aria-hidden="true"></i>Add Files</a>
                                        <button type="submit" class="pull-right btn btn-success">Отправить</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div> <!--message_section-->
            </div>
    </div>

</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>


</body>

</html>