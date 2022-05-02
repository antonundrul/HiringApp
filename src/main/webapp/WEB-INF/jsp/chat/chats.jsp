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
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <!------ Include the above in your HEAD tag ---------->

 <%-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <!------ Include the above in your HEAD tag ---------->--%>

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

          </div>
        </div>
      </div><!--new_message_head-->

          <div class="chat_area">
            <ul class="list-unstyled">

            </ul>
          </div><!--chat_area-->
          <div class="message_write">

        </div>
      </div>
    </div> <!--message_section-->
  </div>
  </div>

</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>


</body>

</html>