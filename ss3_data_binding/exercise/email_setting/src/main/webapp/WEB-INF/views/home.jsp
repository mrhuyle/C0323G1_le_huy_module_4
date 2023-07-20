<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 20/07/2023
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Setting</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            background-color: brown;
        }

        .container {
            position: relative;
            width: 50%;
            height: 500px;
            background-color: azure;
            top: 10%;
            left: 50%;
            transform: translateX(-50%);
            margin-top: 20px;
            border-radius: 10px;
            outline: none;
            box-shadow: 2px 2px 2px rgb(0, 0, 0);
        }

        .head {
            position: relative;
            width: 50%;
            left: 50%;
            transform: translateX(-50%);
            padding-top: 5px;
        }

        h1 {
            text-align: center;
            padding: 0;
            border-bottom: 5px solid rgb(111, 111, 111);
        }

        .content {
            display: grid;
            grid-template-columns: 40% auto;
            border: 0.1px solid brown;
            margin: 10px 20px 10px;
            font-size: 20px;
            border-radius: 10px;
        }

        .left {
            text-align: center;
            padding: 10px 0 10px;
        }

        .right {
            text-align: justify;
            border-left: 0.1px dashed brown;
            padding: 10px;
            display: flex;
            align-items: center;
        }

        .buttons {
            position: absolute;
            display: flex;
            justify-content: space-around;
            width: 100%;
            bottom: 5%;
        }

        button.update {
            background-color: rgb(76, 76, 239);
            outline: none;
            border-radius: 5px;
            font-size: 20px;
            color: white;
            width: 200px;
        }

        button.cancel {
            background-color: antiquewhite;
            outline: none;
            border-radius: 5px;
            font-size: 20px;
            color: black;
            width: 200px;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="head">
        <h1>Current Setting</h1>
    </div>
    <div class="content">
        <div class="left">
            Language
        </div>
        <div class="right">
            ${emailSetting.language}
        </div>
        <div class="left">
            Page Size
        </div>
        <div class="right">
            Show &nbsp; <span style="color: red">${emailSetting.pageSize}</span> &nbsp; emails per page
        </div>
        <div class="left">
            Spam filter
        </div>
        <c:choose>
            <c:when test="${emailSetting.spam}">
                <div class="right">
                    Enable
                </div>
            </c:when>
            <c:otherwise>
                <div class="right">
                    Not enable
                </div>
            </c:otherwise>
        </c:choose>
        <div class="left">
            Signature
        </div>
        <div class="right">
            ${emailSetting.signature}
        </div>
    </div>
    <div class="buttons">
        <div>
            <button class="update" onclick="update()">Update</button>
        </div>
        <div>
            <button class="cancel" onclick="cancel()">Cancel</button>
        </div>
    </div>
</div>
</body>

<form:form modelAttribute="emailSetting" action="/form" id="form" method="get">
    <form:hidden path="signature"/>
    <form:hidden path="pageSize"/>
    <form:hidden path="language"/>
    <form:hidden path="spam"/>
</form:form>

<script>
    function update() {
        document.getElementById("form").submit();
    }
</script>
</html>
