<%--
  Created by IntelliJ IDEA.
  User: wtj008
  Date: 2016/12/7
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="keyword">
<button id="btn">Query</button>
<p id="result"></p>
<script>
    (function () {
        document.querySelector("#btn").onclick = function () {
            //1.拿到用户查询的关键字
            var keyword = document.querySelector("#keyword").value;
            //2.创建一个ajax引擎
            var xmlHttp = null;
            if(window.ActiveXObject){
                xmlHttp = window.ActiveXObject("Microsoft.XMLHTTP");
            }else {
                xmlHttp = new XMLHttpRequest();
            }
            //3.指定请求方式和地址
            xmlHttp.open("get","/dict?query="+keyword);
            //4.配置回调函数
            xmlHttp.onreadystatechange = function () {
                if(xmlHttp.readyState==4){
                    if(xmlHttp.status==200){
                        //6.获取服务端返回的xml文档
                        var xmlDoc = xmlHttp.responseXML;

                        var errorCode = xmlDoc.getElementsByTagName("errorCode")[0].childNodes[0].nodeValue;
                        if(errorCode==0){
                            var ex = xmlDoc.getElementsByTagName("ex")[0].childNodes[0].nodeValue;
                            document.querySelector("#result").innerText = ex ;
                        } else{
                            alert("服务器异常"+errorCode);
                        }
                    }else {
                        alert("服务器异常"+xmlHttp.status);
                    }
                }
            }
            xmlHttp.send();

        }


    })()
</script>
</body>
</html>
