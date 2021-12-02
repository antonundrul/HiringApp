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
                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar2.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Maryam Amiri</a></h5>
                                <span>Designer</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">Photoshop</span>
                                    <span class="badge badge-default">Illustrator</span>
                                    <span class="badge badge-default">Animation</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Blackwood, NJ</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$55 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>



                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">
                            <div class="flexbox align-items-center px-20 pt-20">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" href="#" aria-expanded="false"><i class="ti-more-alt rotate-90 text-muted"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-comments"></i> Messages</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-phone"></i> Call</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-download"></i> Download Resume</a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Hossein Shams</a></h5>
                                <span>Full Stack Developer</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">PHP</span>
                                    <span class="badge badge-default">HTML</span>
                                    <span class="badge badge-default">CSS</span>
                                    <span class="badge badge-default">jQuery</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Stockbridge, GA</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$65 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>



                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">
                            <div class="flexbox align-items-center px-20 pt-20">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" href="#" aria-expanded="false"><i class="ti-more-alt rotate-90 text-muted"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-comments"></i> Messages</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-phone"></i> Call</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-download"></i> Download Resume</a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar4.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Sarah Conner</a></h5>
                                <span>Developer</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">C++</span>
                                    <span class="badge badge-default">C#</span>
                                    <span class="badge badge-default">SQL Server</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Miami, FL</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$30 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">
                            <div class="flexbox align-items-center px-20 pt-20">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" href="#" aria-expanded="false"><i class="ti-more-alt rotate-90 text-muted"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-comments"></i> Messages</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-phone"></i> Call</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-download"></i> Download Resume</a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar6.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Frank Camly</a></h5>
                                <span>Web Developer</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">ASP.Net</span>
                                    <span class="badge badge-default">MVC.Net</span>
                                    <span class="badge badge-default">HTML/CSS</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Lehigh Acres, FL</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$40 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">
                            <div class="flexbox align-items-center px-20 pt-20">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" href="#" aria-expanded="false"><i class="ti-more-alt rotate-90 text-muted"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-comments"></i> Messages</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-phone"></i> Call</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-download"></i> Download Resume</a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Freddie Arendes</a></h5>
                                <span>Marketer Guy</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">MBA</span>
                                    <span class="badge badge-default">Persuasive</span>
                                    <span class="badge badge-default">Team plating</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Akron, OH</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$50 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">
                            <div class="flexbox align-items-center px-20 pt-20">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" href="#" aria-expanded="false"><i class="ti-more-alt rotate-90 text-muted"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-comments"></i> Messages</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-phone"></i> Call</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-download"></i> Download Resume</a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar3.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Gary Camara</a></h5>
                                <span>Marketing</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">Good writing</span>
                                    <span class="badge badge-default">Creativity</span>
                                    <span class="badge badge-default">Influencer</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Seekonk, MA</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$50 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">
                            <div class="flexbox align-items-center px-20 pt-20">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" href="#" aria-expanded="false"><i class="ti-more-alt rotate-90 text-muted"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-comments"></i> Messages</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-phone"></i> Call</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-download"></i> Download Resume</a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Tim Hank</a></h5>
                                <span>Marketing Department</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">Negotiation</span>
                                    <span class="badge badge-default">Expression</span>
                                    <span class="badge badge-default">Writing</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Fremont, CA</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$55 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">
                            <div class="flexbox align-items-center px-20 pt-20">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" href="#" aria-expanded="false"><i class="ti-more-alt rotate-90 text-muted"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-comments"></i> Messages</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-phone"></i> Call</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-download"></i> Download Resume</a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar6.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Fidel Tonn</a></h5>
                                <span>Android Developer</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">Android</span>
                                    <span class="badge badge-default">Java</span>
                                    <span class="badge badge-default">Perl</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Columbus, OH</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$45 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4">
                        <div class="card hover-shadow">
                            <div class="flexbox align-items-center px-20 pt-20">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" href="#" aria-expanded="false"><i class="ti-more-alt rotate-90 text-muted"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-comments"></i> Messages</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-phone"></i> Call</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-fw fa-download"></i> Download Resume</a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body text-center pt-1 pb-20">
                                <a href="#">
                                    <img class="avatar avatar-xxl" src="https://bootdey.com/img/Content/avatar/avatar1.png">
                                </a>
                                <h5 class="mt-2 mb-0"><a class="hover-primary" href="#">Mark Owto</a></h5>
                                <span>iOS Developer</span>
                                <div class="mt-20">
                                    <span class="badge badge-default">Swift</span>
                                    <span class="badge badge-default">Xcode</span>
                                    <span class="badge badge-default">Objective-C</span>
                                </div>
                            </div>

                            <footer class="card-footer flexbox">
                                <div>
                                    <i class="fa fa-map-marker pr-1"></i>
                                    <span>Seattle, WA</span>
                                </div>
                                <div>
                                    <i class="fa fa-money pr-1"></i>
                                    <span>$35 / hour</span>
                                </div>
                            </footer>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>