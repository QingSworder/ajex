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
<button id="btn">sendRequest</button>


<script>
    (function () {
        
        function createXmlHttp() {
            var xmlHttp = null;
            if(window.ActiveXObject){
                //IE
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else{
                xmlHttp = XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#btn").onclick = function () {
            //1.获取ajex引擎
            var xmlHttp = createXmlHttp();
            //2.指定请求方式和地址
            xmlHttp.open("get","/ajex");
            //3.发出请求
            xmlHttp.send();
        }


    })();
</script>
</body>
</html>
