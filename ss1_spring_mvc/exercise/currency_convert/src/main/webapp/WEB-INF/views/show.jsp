<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 18/07/2023
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Currency Convert</title>
    <style>
        body {
            margin: 0;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<h1 class="position-relative" style="left: 3rem">Currency Convert</h1>
<form action="/convert" method="post">
    <table class="table table-light mx-5 d-inline-block">
        <tr>
            <th>Currency</th>
            <th>Input</th>
        </tr>
        <tr>
            <td>
                <select name="currency">
                    <option value="usd">USD</option>
                    <option value="vnd">VND</option>
                </select>
            </td>
            <td>
                <input type="number" name="amount" required>
            </td>
        </tr>
        <tr>
            <td class="fs-5 fw-bold">Result</td>
            <td class="fs-5 fw-bold">${result}</td>
        </tr>
    </table>
    <button type="submit" class="btn btn-dark mx-5">Submit</button>
</form>
</body>
</html>
