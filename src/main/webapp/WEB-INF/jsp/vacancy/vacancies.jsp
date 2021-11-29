<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Вакансии
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0">
    <%--<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    &lt;%&ndash;<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->&ndash;%&gt;

    <script src="https://use.fontawesome.com/45e03a14ce.js"></script>


    <div class="container">
        <div class="row">
            <div class="col-lg-12 card-margin">
                <div class="card search-form">
                    <div class="card-body p-0">
                        <form id="search-form">
                            <div class="row">
                                <div class="col-12">
                                    <div class="row no-gutters">
                                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                            <select class="form-control" id="exampleFormControlSelect1">
                                                <option value="0" label="Город"></option>
                                                <option>Location</option>
                                                <optgroup label="Location">
                                                <option>London</option>
                                                <option>Boston</option>
                                                <option>Mumbai</option>
                                                <option>New York</option>
                                                <option>Toronto</option>
                                                <option>Paris</option>
                                                </optgroup>


                                            </select>
                                        </div>
                                        <div class="col-lg-8 col-md-6 col-sm-12 p-0">
                                            <input type="text" placeholder="Search..." class="form-control" id="search" name="search">
                                        </div>
                                        <div class="col-lg-1 col-md-3 col-sm-12 p-0">
                                            <button type="submit" class="btn btn-base">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card card-margin">
                    <div class="card-body">
                        <div class="row search-body">
                            <div class="col-lg-12">
                                <div class="search-result">
                                    <div class="result-header">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="records">Showing: <b>1-20</b> of <b>200</b> result</div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="result-actions">
                                                    <div class="result-sorting">
                                                        <span>Sort By:</span>
                                                        <select class="form-control border-0" id="exampleOption">
                                                            <option value="1">Relevance</option>
                                                            <option value="2">Names (A-Z)</option>
                                                            <option value="3">Names (Z-A)</option>
                                                        </select>
                                                    </div>
                                                    <div class="result-views">
                                                        <button type="button" class="btn btn-soft-base btn-icon">
                                                            <svg
                                                                    xmlns="http://www.w3.org/2000/svg"
                                                                    width="24"
                                                                    height="24"
                                                                    viewBox="0 0 24 24"
                                                                    fill="none"
                                                                    stroke="currentColor"
                                                                    stroke-width="2"
                                                                    stroke-linecap="round"
                                                                    stroke-linejoin="round"
                                                                    class="feather feather-list"
                                                            >
                                                                <line x1="8" y1="6" x2="21" y2="6"></line>
                                                                <line x1="8" y1="12" x2="21" y2="12"></line>
                                                                <line x1="8" y1="18" x2="21" y2="18"></line>
                                                                <line x1="3" y1="6" x2="3" y2="6"></line>
                                                                <line x1="3" y1="12" x2="3" y2="12"></line>
                                                                <line x1="3" y1="18" x2="3" y2="18"></line>
                                                            </svg>
                                                        </button>
                                                        <button type="button" class="btn btn-soft-base btn-icon">
                                                            <svg
                                                                    xmlns="http://www.w3.org/2000/svg"
                                                                    width="24"
                                                                    height="24"
                                                                    viewBox="0 0 24 24"
                                                                    fill="none"
                                                                    stroke="currentColor"
                                                                    stroke-width="2"
                                                                    stroke-linecap="round"
                                                                    stroke-linejoin="round"
                                                                    class="feather feather-grid"
                                                            >
                                                                <rect x="3" y="3" width="7" height="7"></rect>
                                                                <rect x="14" y="3" width="7" height="7"></rect>
                                                                <rect x="14" y="14" width="7" height="7"></rect>
                                                                <rect x="3" y="14" width="7" height="7"></rect>
                                                            </svg>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="result-body">
&lt;%&ndash;                                        <div class="table-responsive">&ndash;%&gt;
                                            &lt;%&ndash;<table id="dtBasicExample" class="table table-striped  table-bordered table-sm widget-26">

                                                <thead>

                                                </thead>&ndash;%&gt;

                                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                                    <thead>
                                                    <tr>
                                                        <th>Должность</th>
                                                        <th>Компания</th>
                                                        <th>Тип занятости</th>
                                                        <th>Город</th>
                                                        <th>Заработная плата</th>
                                                        <th>Дата создания</th>
                                                    </tr>
                                                    </thead>
                                                <tbody>
                                                <c:forEach var="vacancy" items="${vacancies}">
                                                <tr>
                                                    &lt;%&ndash;<td>
                                                        <div class="widget-26-job-emp-img">
                                                            <img src="https://bootdey.com/img/Content/avatar/avatar5.png" alt="Company" />
                                                        </div>
                                                    </td>&ndash;%&gt;
                                                    <td>
                                                        <div class="widget-26-job-title">
                                                            <a href="#">${vacancy.vacancy.position}</a>
                                                            <p class="m-0"><a href="#" class="employer-name">${vacancy.vacancy.companyName}</a>
&lt;%&ndash;                                                                <span class="text-muted time">${vacancy.vacancy.}</span></p>&ndash;%&gt;
                                                        </div>
                                                    </td>
                                                        <td>
                                                            <div class="widget-26-job-title">
                                                                <p class="m-0"><a href="#" class="employer-name">${vacancy.vacancy.companyName}</a>
&lt;%&ndash;                                                                    <span class="text-muted time">${vacancy.vacancy.}</span></p>&ndash;%&gt;&ndash;%&gt;
                                                            </div>
                                                        </td>
                                                    <td>
                                                        <div class="widget-26-job-info">
                                                            <p class="type m-0">${vacancy.vacancy.jobType.name}</p>
&lt;%&ndash;                                                            <p class="text-muted m-0">in <span class="location">${vacancy.vacancy.city.name}</span></p>&ndash;%&gt;
                                                        </div>
                                                    </td>
                                                        <td>
                                                            <div class="widget-26-job-info">
                                                                <p class="text-muted m-0"> <span class="location">${vacancy.vacancy.city.name}</span></p>
                                                            </div>
                                                        </td>
                                                    <td>
                                                        <div class="widget-26-job-salary">${vacancy.vacancy.salary} ${vacancy.vacancy.currency.code}</div>
                                                    </td>
                                                    <td>
                                                        <div class="widget-26-job-category bg-soft-base">
                                                            &lt;%&ndash;<i class="indicator bg-base"></i>
                                                            <span>Software Development</span>&ndash;%&gt;
                                                                <p class="text-muted m-0"> <span class="location">${vacancy.vacancy.createDate}</span></p>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="widget-26-job-starred">
                                                            <a href="#">
                                                                <svg
                                                                        xmlns="http://www.w3.org/2000/svg"
                                                                        width="24"
                                                                        height="24"
                                                                        viewBox="0 0 24 24"
                                                                        fill="none"
                                                                        stroke="currentColor"
                                                                        stroke-width="2"
                                                                        stroke-linecap="round"
                                                                        stroke-linejoin="round"
                                                                        class="feather feather-star"
                                                                >
                                                                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon>
                                                                </svg>
                                                            </a>
                                                        </div>
                                                    </td>
                                                </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
&lt;%&ndash;                                        </div>&ndash;%&gt;
                                    </div>
                                </div>
                            </div>
                        </div>
                        <nav class="d-flex justify-content-center">
                            <ul class="pagination pagination-base pagination-boxed pagination-square mb-0">
                                <li class="page-item">
                                    <a class="page-link no-border" href="#">
                                        <span aria-hidden="true">«</span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                </li>
                                <li class="page-item active"><a class="page-link no-border" href="#">1</a></li>
                                <li class="page-item"><a class="page-link no-border" href="#">2</a></li>
                                <li class="page-item"><a class="page-link no-border" href="#">3</a></li>
                                <li class="page-item"><a class="page-link no-border" href="#">4</a></li>
                                <li class="page-item">
                                    <a class="page-link no-border" href="#">
                                        <span aria-hidden="true">»</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>--%>

        <javatime:format value="${parcel.dateCreated}" style="SS" var="dateCreated"/>
        <javatime:format value="${parcel.lastUpdated}" style="SS" var="lastUpdated"/>

        <div class="container">

            <h2 class="display-4">
                Вакансии
            </h2>

            <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>Должность</th>
                    <th>Компания</th>
                    <th>Зарплата</th>
                    <th>Тип занятости</th>
                    <th>Навыки</th>
                    <th>Город</th>
                    <th>Дата создания</th>
                    <sec:authorize access="isAuthenticated()" >
                    <th>Откликнуться</th>
                    </sec:authorize>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="map" items="${vacancyMap}">
<%--                    <javatime:format value="${vacancy.vacancy.createDate}" style="SS" var="dateCreated"/>--%>

                    <tr>
                        <th>
                               <a href="${contextPath}/vacancies/vacancyDetail/${map.key.id}" style="color: black"> ${map.key.position}
                        </th>
                        <td>
                                ${map.key.companyName}
                        </td>
                        <td>
                                ${map.key.salary} ${map.key.currency.code}
                        </td>
                        <td>
                                ${map.key.jobType.name}
                        </td>
                        <td>
                             <c:forEach var="a" items="${map.value}">
                                 ${a.skill.name}<br>
                             </c:forEach>
                        </td>
                        <td>
                                ${map.key.city.name}
                        </td>
                        <td>
                                ${map.key.createDate}
                        </td>
                        <sec:authorize access="isAuthenticated()" >
                            <td>
                                Откликнуться
                            </td>
                        </sec:authorize>
                       <%-- <td>
                            <div class="dropdown">
                                <button class="btn btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                    Действие
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?block=1">${user.blocked == 1 ? "Разблокировать" : "Заблокировать"}</a></li>
                                    <li><a class="dropdown-item" href="${contextPath}/chats/chatWith/${user.id}">Написать</a></li>
                                    <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?seller=1">Добавить/удалить права продавца</a></li>
                                    <li><a class="dropdown-item" href="${contextPath}/users/${user.id}?admin=1">Добавить/удалить права администратора</a></li>
                                </ul>
                            </div>
                        </td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>


</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

<script>
    $(document).ready(function() {
        $('#dtBasicExample').DataTable();
    } );
</script>
</body>

</html>