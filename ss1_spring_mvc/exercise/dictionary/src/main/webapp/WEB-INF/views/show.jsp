<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 18/07/2023
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1 class="position-relative" style="left: 3rem">Dictionary</h1>
<form action="/find" method="post">
    <table class="table table-dark d-inline-block mx-5">
        <tr>
            <th>English</th>
            <td>
                <input type="text" name="english" required>
            </td>
        </tr>
        <tr>
            <th>
                Vietnamese
            </th>
            <td>
                ${vietnamese}
            </td>
        </tr>
    </table>
    <button type="submit" class="btn btn-dark text-light mx-5">Submit</button>
</form>


</body>
</html>
