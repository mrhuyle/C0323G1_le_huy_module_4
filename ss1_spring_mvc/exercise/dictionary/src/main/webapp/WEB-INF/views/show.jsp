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
    <style>
        .frame {
            width: 70%;
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
        }
        .frame-head {
            position: relative;
            padding-top: 1rem;
        }
        .frame-form {
            position: relative;
            padding-bottom: 1rem;
        }
    </style>
</head>
<body>
<div class="frame bg-info">
    <div class="frame-head">
        <h1 class="position-relative" style="left: 3rem">Dictionary</h1>
    </div>
    <div class="frame-form">
        <form action="/find" method="post">
            <table class="table table-dark d-inline-block mx-5">
                <input type="hidden" name="type" id="type" value="en">
                <tr>
                    <th id="select1">English</th>
                    <td>
                        <input type="text" name="english" id="input1" value="${english}">
                    </td>
                </tr>
                <tr>
                    <th id="select2">
                        Vietnamese
                    </th>
                    <td id="input2">
                        ${vietnamese}
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <button type="submit" class="btn btn-dark text-light mx-5">Submit</button>
                <button type="button" class="btn btn-dark" onclick="change()">Change</button>
            </div>
        </form>
    </div>
</div>

<script>
    function change() {
        let x = document.getElementById("select1").innerText;
        console.log(x);
        if (x === "English") {
            document.getElementById("select1").innerText = "Vietnamese";
            document.getElementById("select2").innerText = "English";
            document.getElementById("input1").value = "";
            document.getElementById("input2").innerText = "";
            document.getElementById("type").value = "en";
        } else {
            document.getElementById("select1").innerText = "English";
            document.getElementById("select2").innerText = "Vietnamese";
            document.getElementById("input1").value = "";
            document.getElementById("input2").innerText = "";
            document.getElementById("type").value = "vi";
        }
    }
</script>
</body>
</html>
