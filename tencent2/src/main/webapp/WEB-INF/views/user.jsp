<%--
  Created by IntelliJ IDEA.
  User: wtj008
  Date: 2016/12/5
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">load xml button</button>
<table>
    <th>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>ADDRESS</th>
        </tr>
    </th>
    <tbody>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </tbody>
</table>
<script>
    (function () {
        document.querySelector("#btn").onclick=function () {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.set("get","/users.xml");
            xmlHttp.onreadystatechange=function(){
                if(xmlHttp.readyState==4){
                    if(xmlHttp.status==200){
                        //获取服务端返回的xml文档
                        var xmlDoc = xmlHttp.responseXML;
                        var userElments = xmlDoc.getElementsByTagName("user");

                        for(var i=0;i<userElments.length;i++){
                            var user = userElments[i];
                            var id = userElments[i].getAttribute("id");
                            var name = userElments.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                            var address = userElments.getElementsByTagName("address")[0].childNodes[0].nodeValue;

                            var tbody = document.querySelector("tbody");
                            //创建tr并添加到tbody
                            var tr = document.createElement("tr");
                            var idTd = document.createElement("tr");
                            var nameTd = document.createElement("tr");
                            var addressTd = document.createElement("tr");

                            var idNode = document.createTextNode(id);
                            var nameNode = document.createTextNode(name);
                            var addressNode = document.createTextNode(address);

                            idTd.appendChild(idNode);
                            nameTd.appendChild(nameNode);
                            addressTd.appendChild(addressNode);
                            tr.appendChild(idTd);
                            tr.appendChild(nameTd);
                            tr.appendChild(addressTd);
                            tbody.appendChild(tr);
                        }
                    }
                }
            };
            xmlHttp.send();

        }



    })()
</script>
</body>
</html>
