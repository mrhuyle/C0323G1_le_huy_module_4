<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 19/07/2023
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
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

        .frame h1 {
            font-size: 40px;
            font-weight: bold;
            color: brown;
            text-align: center;
        }

        .frame-form form {
            display: flex;
            justify-content: space-evenly;
            align-items: center;
        }

        .frame-form input[type="checkbox"] {
            width: 20px;
            height: 20px;
        }

        label {
            font-size: 30px;
            color: #441300;
            margin-outside: 10px;
        }

        .button-submit {
            position: relative;
            display: flex;
            justify-content: center;
            top: 11%;
            margin-top: 1rem;
        }

        button {
            width: 100px;
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
                Sandwich Condiments
            </h1>
            <div class="frame-form">
                <form id="form" action="/condiment" method="post">
                    <input type="hidden" name="condiments" id="condiments">
                    <label>
                        <input type="checkbox" name="lettuce" value="Lettuce" id="lettuce">
                        Lettuce
                    </label><br>
                    <label>
                        <input type="checkbox" name="tomato" value="Tomato" id="tomato">
                        Tomato
                    </label><br>
                    <label>
                        <input type="checkbox" name="mustard" value="Mustard" id="mustard">
                        Mustard
                    </label><br>
                    <label>
                        <input type="checkbox" name="sprouts" value="Sprouts" id="sprouts">
                        Sprouts
                    </label><br>
                </form>
            </div>
        </div>
    </div>

    <div class="button-submit">
        <button type="button" onclick="submit()">Save</button>
    </div>
</div>

</body>

<script>
    function submit() {
        let lettuce = document.getElementById("lettuce").checked ? document.getElementById("lettuce").value : null;
        let tomato = document.getElementById("tomato").checked ? document.getElementById("tomato").value : null;
        let mustard = document.getElementById("mustard").checked ? document.getElementById("mustard").value : null;
        let sprouts = document.getElementById("sprouts").checked ? document.getElementById("sprouts").value : null;
        let condiments = [lettuce, tomato, mustard, sprouts].filter(Boolean); // Remove any null values
        document.getElementById("condiments").value = condiments;
        console.log(condiments)
        document.getElementById("form").submit();
    }
</script>
</html>
