<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Статистика</title>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>


    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {
            'packages':['geochart'],
            // Note: you will need to get a mapsApiKey for your project.
            // See: https://developers.google.com/chart/interactive/docs/basic_load_libs#load-settings
            'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
        });
        google.charts.setOnLoadCallback(drawRegionsMap);

        function drawRegionsMap() {

            var countriesArr = [];
            countriesArr.push(['Страна', 'Количество заказанных посылок']);
            <c:forEach items="${countriesMap}" var="country" >
                var arr = [];
                arr.push("<c:out value="${country.key.code}" />");
                arr.push(<c:out value="${country.value}" />);

                countriesArr.push(arr);
            </c:forEach>

            var data = google.visualization.arrayToDataTable(countriesArr);

            var options = {};

            var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

            chart.draw(data, options);
        }
    </script>


    <script type="text/javascript">
        google.charts.load("current", {packages:["corechart"]});
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            var typesArr = [];
            typesArr.push(['Страна', 'Количество заказанных посылок']);
            <c:forEach items="${parcelTypesMap}" var="type" >
            var arr = [];
            arr.push("<c:out value="${type.key.type}" />");
            arr.push(<c:out value="${type.value}" />);

            typesArr.push(arr);
            </c:forEach>


            var data = google.visualization.arrayToDataTable(typesArr);

            var options = {
                height:500,
                width: 900,
                title: 'Типы посылок',
                is3D: true,
            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
            chart.draw(data, options);
        }
    </script>



</head>
<body>
<script type="text/javascript">
    google.charts.load("current", {packages:["timeline"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
        var container = document.getElementById('example2.1');
        var chart = new google.visualization.Timeline(container);
        var dataTable = new google.visualization.DataTable();

        dataTable.addColumn({ type: 'string', id: 'Term' });
        dataTable.addColumn({ type: 'string', id: 'Track' });
        dataTable.addColumn({ type: 'date', id: 'Start' });
        dataTable.addColumn({ type: 'date', id: 'End' });

        var typesArr = [];
        var counter=0;
        <c:forEach items="${parcels}" var="parcel" >
        var arr = [];
        counter+=1;
        arr.push(counter.toString());

        arr.push("<c:out value="${parcel.trackNumber}" />");
        arr.push(new Date(${parcel.dateCreated.year},${parcel.dateCreated.monthValue-1},${parcel.dateCreated.dayOfMonth}));
        arr.push(new Date(${parcel.lastUpdated.year},${parcel.lastUpdated.monthValue-1},${parcel.lastUpdated.dayOfMonth}));
        typesArr.push(arr);
        </c:forEach>

        dataTable.addRows(typesArr);

        var options = {
            height:500,
            width: 900,
        };

        chart.draw(dataTable,options);
    }
</script>

<%@ include file="/WEB-INF/jsp/util/header.jsp" %>

<sec:authorize access="hasAuthority('ROLE_ADMIN')">
<div class="row " >
    <div class="col-2">
        <a type="button" style="margin: 10px"  href="${requestScope['javax.servlet.forward.request_uri']}?report=1" class="btn btn-warning">Скачать отчет о посылках</a>
    </div>
    <div class="col-4">
        <form:form modelAttribute="email" class="form-inline" method="post">
            <input style="margin-top: 10px; margin-right: 5px" type="email" class="form-control" id="email" name="email" aria-describedby="trackHelp" placeholder="Email">
            <button style="margin-top: 10px" type="submit"  class="btn btn-warning">Отправить отчет на почту</button>
        </form:form>
    </div>
</div>
</sec:authorize>

<ul class="nav nav-tabs" style="margin-left: 20px" id="myTab" role="tablist">
    <li class="nav-item" role="presentation">
        <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#countriesDiagram" type="button" role="tab" aria-controls="home" aria-selected="true">Карта популярности стран</button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#parcelTypesDiagram" type="button" role="tab" aria-controls="profile" aria-selected="false">Диаграмма типов посылок</button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#deliveryDurationDiagram" type="button" role="tab" aria-controls="contact" aria-selected="false">Диаграмма длительности доставки посылок</button>
    </li>
</ul>
<div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="countriesDiagram" role="tabpanel" aria-labelledby="home-tab">
        <div id="regions_div" style="width: 900px; height: 500px; margin-left: 400px; margin-top: 20px"></div>
    </div>

    <div class="tab-pane fade" id="parcelTypesDiagram" role="tabpanel" aria-labelledby="profile-tab">
        <div id="piechart_3d" style="width: 900px; height: 500px; margin-left: 400px; margin-top: 20px"></div>
    </div>

    <div class="tab-pane fade" id="deliveryDurationDiagram" role="tabpanel" aria-labelledby="contact-tab">
        <div id="example2.1" style="width: 900px; height: 500px; margin-left: 400px; margin-top: 20px"></div>
    </div>
</div>











<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>
</body>
</html>
