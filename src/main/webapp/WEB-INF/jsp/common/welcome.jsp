<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome</title>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
</head>


<body class="d-flex flex-column h-100">

<%@ include file="/WEB-INF/jsp/util/header.jsp"  %>

<main role="main" class="container">
    <h2 class="display-4">
        Быстрый и удобный поиск вакансий
    </h2>

    <p class="lead text-justify">
        Можно по старинке позвонить по объявлению в газете, расспросить знакомых,
        а можно открыть вкладку браузера, набрать поисковой запрос – и искать работу мечты.
    </p>

    <h5>
        Ищете работу? Здесь Вы найдете огромное количество свежих вакансий от прямых работодателей.
    </h5>
    <br>
    <p class="lead text-justify">
        Плюсов в онлайн-поиске много:
        не надо подстраиваться и соглашаться на сомнительные условия, которые предлагает мамина подруга,
        есть время грамотно построить цепляющий отклик,
        база вакансий каждый день обновляется,
        можно листать предложения когда угодно и откуда угодно, даже лежа на диване или сидя в надоевшем офисе.
    </p>

    <div id="myCarousel" class="carousel slide  container" data-bs-ride="carousel" >
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2" class="active" aria-current="true"></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3" class=""></button>
<%--            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="3" aria-label="Slide 4" class=""></button>--%>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="/resources/images/carousel1.jpg" alt="user" width="1000" height="400" >
               <%-- <div class="container">
                    <div class="carousel-caption text-start">
                        <h1 style="color: black">
                            Хочешь найти работу, но не знаешь где это сделать?
                        </h1>
                    </div>
                </div>--%>
            </div>
            <div class="carousel-item ">
                <img src="/resources/images/carousel2.jpg" alt="user" width="1000" height="400" >
                <%--<div class="container">
                    <div class="carousel-caption  ">
                        <h2 style="color: black">
                            Чтобы покупатели не переживали и всегда могли знать местоположение своих посылок - мы запустили сервис Post-tracker.
                        </h2>
                    </div>
                </div>--%>
            </div>
            <div class="carousel-item">
                <img src="/resources/images/carousel3.jpg" alt="user" width="1000" height="400" >
               <%-- <div class="container">
                    <div class="carousel-caption text-start">
                        <h1 style="color: black">
                            Больше не нужно проверять посылки на разных сайтах почтовых служб.
                        </h1>
                    </div>
                </div>--%>
            </div>
           <%-- <div class="carousel-item">
                <img src="/resources/images/carouselImg4.png" alt="user" width="1000" height="400" >
                &lt;%&ndash;<div class="container">
                    <div class="carousel-caption text-end">
                        <h1 >
                            Post-tracker делает отслеживание посылок простым и комфортным!
                        </h1>
                    </div>
                </div>&ndash;%&gt;
            </div>--%>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <br>
    <h2 class="display-4">
        Как отследить посылку по трек-коду?
    </h2>
    <p class="lead text-justify">
        Если обьяснить совсем просто, как говорится - на пальцах, то это работает следующим образом:
    </p>
    <ul class="lead text-justify">
        <li>
            находите и приобратаете нужный Вам товар;
        </li>
        <li>
            узнаете в личном кабинете или на странице заказа трек-код;
        </li>
        <li>
            вводите в форму трек номер Вашей посылки;
        </li>
        <li>
            получаете всю необходимую информацию о перемещении отправления, месте и сроках доставки.
        </li>
    </ul>

    <div class="row ">
        <div class="col-lg-6">
            <img src="/resources/images/vacancy.jpg" alt="user" width="200" height="170" class="rounded-circle mx-auto d-block">
            <h3 class=" text-center">Вакансии</h3>
            <p class="lead text-justify">
                Размещайте вакансии и находите сотрудников среди тех, кто хочет у вас работать
            </p>
            <p><a class="btn btn-warning mx-auto d-block" href="${contextPath}/vacancies">Перейти</a></p>
        </div>
        <div class="col-lg-6">
            <img src="/resources/images/resume.png" alt="user" width="200" height="170" class="rounded-circle mx-auto d-block">
            <h3 class=" text-center">Резюме</h3>
            <p class="lead text-justify">
                Размещайте резюме, откликайтесь на вакансии и вы обязательно найдете работу мечты.
            </p>
            <p><a class="btn btn-warning mx-auto d-block" href="${contextPath}/resumes">Перейти</a></p>
        </div>
       <%-- <div class="col-lg-4">
            <img src="/resources/images/paymentSystem.jpg" alt="user" width="200" height="170" class="rounded-circle mx-auto d-block">
            <h3 class=" text-center">Платежные системы</h3>
            <p class="lead text-justify">
                Можем отследить посылку, купленную с использованием любой платежной системы.
            </p>
            <p><a  class="btn btn-warning mx-auto d-block" href="${contextPath}/systems">Перейти</a></p>
        </div>--%>
    </div>

</main>


<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>
</html>
