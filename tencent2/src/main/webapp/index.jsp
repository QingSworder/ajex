<%--
  Created by IntelliJ IDEA.
  User: wtj008
  Date: 2016/12/5
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="name">
<button id="btn">sendRequest</button>


<script>
    (function () {

        function createXmlHttp() {
            var xmlHttp = null;
            if(window.ActiveXObject){
                //IE
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else{
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#btn").onclick = function () {
            var name = document.querySelector("#name").value;
            sendGet(name);

        };
        function sendGet(name) {
            //1.获取ajex引擎
            var xmlHttp = createXmlHttp();
            //2.指定请求方式和地址
            xmlHttp.open("get","/ajex?name="+name);
            //3.发出请求
            xmlHttp.send(name);
        }
        function sendPost(name) {
            //1.获取ajex引擎
            var xmlHttp = createXmlHttp();
            //2.指定请求方式和地址
            xmlHttp.open("post","/ajex");
            xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            //3.
            //4.发送请求
            xmlHttp.send("name="+name);
        }

    })();
</script>
</body>
</html>
