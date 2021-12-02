<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="h-100">
<head>
    <%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>
    <title>
        Добавление вакансии
    </title>
</head>

<body class="d-flex flex-column h-100">


<%@ include file="/WEB-INF/jsp/util/header.jsp" %>


<main role="main" class="flex-shrink-0 container">
    <h2 class="display-4">
        Разместить вакансию
    </h2>

    <form id="form" method="POST" action="save_data.php">
        <input type="text" name="text_field[]">
        <button type="submit">SUBMIT</button>
    </form>
    <button onclick="add_field()">ADD FIELD</button>
    <script>
        function add_field(){

            var x = document.getElementById("form");
            // создаем новое поле ввода
            var new_field = document.createElement("input");
            // установим для поля ввода тип данных 'text'
            new_field.setAttribute("type", "text");
            // установим имя для поля ввода
            new_field.setAttribute("name", "text_field[]");
            // определим место вствки нового поля ввода (перед каким элементом его вставить)
            var pos = x.childElementCount;

            // добавим поле ввода в форму
            x.insertBefore(new_field, x.childNodes[pos]);
        }
    </script>




</main>

<%@ include file="/WEB-INF/jsp/util/footer.jsp" %>

</body>

</html>