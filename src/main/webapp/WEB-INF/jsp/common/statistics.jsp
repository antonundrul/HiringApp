<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Статистика</title>
  <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>


  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

</head>
<body>

<%@ include file="/WEB-INF/jsp/util/header.jsp" %>
<script type="text/javascript">
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
    var typesArr = [];
    typesArr.push(['Компания', 'Количество вакансий']);
    <c:forEach items="${companiesMap}" var="type" >
    var arr = [];
    arr.push("<c:out value="${type.key.name}" />");
    arr.push(<c:out value="${type.value}" />);

    typesArr.push(arr);
    </c:forEach>


    var data = google.visualization.arrayToDataTable(typesArr);

    var options = {
      height:500,
      width: 900,
      title: 'Вакансии компаний',
      is3D: true,
    };

    var chart = new google.visualization.PieChart(document.getElementById('companyStatistics'));
    chart.draw(data, options);
  }
</script>

<script type="text/javascript">
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
    var typesArr = [];
    typesArr.push(['Вид занятости', 'Количество вакансий']);
    <c:forEach items="${jobTypesMap}" var="type" >
    var arr = [];
    arr.push("<c:out value="${type.key.name}" />");
    arr.push(<c:out value="${type.value}" />);

    typesArr.push(arr);
    </c:forEach>


    var data = google.visualization.arrayToDataTable(typesArr);

    var options = {
      height:500,
      width: 900,
      title: 'Виды занятости',
      is3D: true,
    };

    var chart = new google.visualization.PieChart(document.getElementById('jobTypeStatistics'));
    chart.draw(data, options);
  }
</script>



<ul class="nav nav-tabs" style="margin-left: 20px" id="myTab" role="tablist">
  <li class="nav-item" role="presentation">
    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#cmpaniesDiagram" type="button" role="tab" aria-controls="home" aria-selected="true" style="color: black">Диаграмма компаний</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#jobTypesDiagram" type="button" role="tab" aria-controls="profile" aria-selected="false" style="color: black">Диаграмма видов занятости</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#deliveryDurationDiagram" type="button" role="tab" aria-controls="contact" aria-selected="false" style="color: black">Диаграмма навыков</button>
  </li>
</ul>
<div class="tab-content" id="myTabContent">
  <div class="tab-pane fade show active" id="companiesDiagram" role="tabpanel" aria-labelledby="home-tab">
    <div id="companyStatistics" style="width: 900px; height: 500px; margin-left: 400px; margin-top: 20px"></div>
  </div>

  <div class="tab-pane fade" id="jobTypesDiagram" role="tabpanel" aria-labelledby="profile-tab">
    <div id="jobTypeStatistics" style="width: 900px; height: 500px; margin-left: 400px; margin-top: 20px"></div>
  </div>

  <div class="tab-pane fade" id="deliveryDurationDiagram" role="tabpanel" aria-labelledby="contact-tab">
    <div id="example2.1" style="width: 900px; height: 500px; margin-left: 400px; margin-top: 20px"></div>
  </div>
</div>











<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>
</body>
</html>
