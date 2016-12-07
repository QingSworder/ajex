<%--
  Created by IntelliJ IDEA.
  User: wtj008
  Date: 2016/12/6
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">read json</button>
</body>
<script>
    (function () {
        document.querySelector("#btn").onclick = function () {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open("get","/data.json");
            xmlHttp.onreadystatechange = function () {
                if(xmlHttp.readyState==4){
                    if(xmlHttp.status==200){
                        var result = xmlHttp.responseText;
                        var json = JSON.parse(result);
                        alert(json.length);
                    }
                }
            }
            xmlHttp.send();

        }

    })()
</script>
</html>

