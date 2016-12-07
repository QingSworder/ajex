<%--
  Created by IntelliJ IDEA.
  User: wtj008
  Date: 2016/12/6
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">button</button>
<input type="text"id="username">
<span id="loading"></span>
<span id="text"></span>
<script src="/static/js/jquery-1.11.3.min.js">
    $(function () {
        $("#username").blur(function () {
            var name = $(this).val();
            $.ajax({
                url:"/ajax",
                type:"post",
                data:{"name":name,"age":23},
                timeout:15000,
                beforeSend:function () {
                //请求发送之前做的函数
                    $("#loading").text("请求中");
                },
                success:function(data){
                    $("#text").text(data);
                },
                error:function(){
                    alert("服务器异常")
                },
                complete:function () {
                    $("#loading").text("");
                }
            })


        })



    })
</script>
</body>
</html>
