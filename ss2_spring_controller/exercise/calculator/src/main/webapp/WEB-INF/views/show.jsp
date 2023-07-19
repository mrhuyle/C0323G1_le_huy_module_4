<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 19/07/2023
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/resources/style.css">
    <title>Calculator</title>
</head>
<body>
<div class="container">
    <div class="calculator">
        <input type="text" placeholder="0" id="onScreen" value="${resultStr}">
        <button onclick="clear()">CL</button>
        <button onclick="del()">DEL</button>
        <button onclick="display('%')">%</button>
        <button onclick="display('/')">/</button>
        <button onclick="display('7')">7</button>
        <button onclick="display('8')">8</button>
        <button onclick="display('9')">9</button>
        <button onclick="display('*')">*</button>
        <button onclick="display('4')">4</button>
        <button onclick="display('5')">5</button>
        <button onclick="display('6')">6</button>
        <button onclick="display('-')">-</button>
        <button onclick="display('1')">1</button>
        <button onclick="display('2')">2</button>
        <button onclick="display('3')">3</button>
        <button onclick="display('+')">+</button>
        <button onclick="display('.')">.</button>
        <button onclick="display('0')">0</button>
        <button onclick="calculate()" class="equal">=</button>
    </div>
</div>

<form action="/calculator/" method="post" id="form">
    <input type="hidden" id="expression" name="expression">
</form>
</body>

<script>
    let onScreen = document.getElementById("onScreen");
    function display(symbol) {
        onScreen.value += symbol;
    }

    function clear() {
        onScreen.value = "";
    }

    function del() {
        onScreen.value = onScreen.value.slice(0,-1);
    }

    function calculate() {
        let expression = onScreen.value;
        document.getElementById("expression").value = expression;
        document.getElementById("form").submit();
    }

</script>
</html>
