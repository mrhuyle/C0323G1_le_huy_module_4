<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        .form-element-language {
            width: 100%;
            font-size: 18px;
        }

        .form-element-signature {
            width: 100%;
            height: 190px;
            font-size: 20px;
        }
        .form-element-size {
            font-size: 18px;
            width: auto;
            margin: 0 3px 0;
        }

        .form-element-checkbox {
            height: 20px;
            width: 20px;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="head">
        <h1>Email Setting</h1>
    </div>
    <form:form method="post" action="/update" modelAttribute="emailSetting" id="form">
    <div class="content">
        <div class="left">
            Language
        </div>
        <div class="right">
            <form:select path="language" items="${languageOptions}" cssClass="form-element-language"/>
        </div>
        <div class="left">
            Page Size
        </div>
        <div class="right">
            Show <form:select path="pageSize" items="${sizeOptions}" cssClass="form-element-size"/> emails per page
        </div>
        <div class="left">
            Spam filter
        </div>
        <div class="right">
            <form:checkbox path="spam" cssClass="form-element-checkbox"/> Enable spam filter
        </div>
        <div class="left">
            Signature
        </div>
        <div class="right">
            <form:textarea path="signature" cssClass="form-element-signature"/>
        </div>
    </div>
    </form:form>
    <div class="buttons">
        <div>
            <button class="update" onclick="submitForm()">Update</button>
        </div>
        <div>
            <button class="cancel" onclick="cancel()">Cancel</button>
        </div>
    </div>
</body>

<script>
    function submitForm() {
        document.getElementById("form").submit();
    }
    function cancel() {
        history.back();
    }
</script>
</html>
