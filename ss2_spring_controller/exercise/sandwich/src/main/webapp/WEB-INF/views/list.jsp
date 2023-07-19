<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 19/07/2023
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of condiments</title>
    <style>
        body {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        .outside {
            position: absolute;
            width: 60%;
            top: 10%;
            left: 50%;
            transform: translateX(-50%);
            background-color: bisque;
            border-radius: 10px;
            padding: 2rem 0 2rem;
        }

        .frame {
            display: inline-block;
            width: 70%;
            background-color: yellow;
            position: relative;
            left: 50%;
            transform: translateX(-50%);
            top: 10%;
            border-radius: 10px;
            padding: 1rem 1rem;
        }

        .frame-header h1 {
            font-size: 40px;
            font-weight: bold;
            color: brown;
            text-align: center;
        }
        .frame-body ul li {
            position: relative;
            left: 15%;
            font-size: 40px;
            color: saddlebrown;
            padding-left: 20px;
        }
        .button-submit {
            position: relative;
            display: flex;
            justify-content: center;
            top: 11%;
            margin-top: 1rem;
        }

        button {
            width: auto;
            height: 50px;
            font-size: 30px;
            background-color: burlywood;
            color: saddlebrown;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<div class="outside">
    <div class="frame">
        <div class="frame-header">
            <h1>
                Selected Condiments:
            </h1>
        </div>
        <div class="frame-body">
            <ul>
                <c:forEach items="${condiments}" var="condiment">
                    <li>${condiment}</li>
                </c:forEach>
            </ul>
            <c:if test="${msg != null}">
                <h1 style="color: red; text-align: center">${msg}</h1>
            </c:if>
        </div>
    </div>

    <div class="button-submit">
        <button type="button" onclick="submit()">Back to main menu</button>
    </div>
</div>

<script>
    function submit() {
        window.location.href = "/";
    }
</script>
</body>
</html>
