<html>
<body>
<h2>Hello World!</h2>
<input type="text" id="name">
<button id="btn">sendRequest</button>
<div id="result"></div>


<script>
    //创建XMLHttpRequest对象
    function createXmlHttp() {
        var xmlHttp = null;
        if(window.ActiveXObject){
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }else {
            xmlHttp = new XMLHttpRequest();
        }
        return xmlHttp;
    }
    document.querySelector("#btn").onclick = function () {
        var name = document.querySelector("#name").value;
        sendPost(name);
    };

    function sendGet(name) {
        //1.获取Ajax引擎
        var xmlHttp = createXmlHttp();
        //2.指定请求方式（post|get）和请求地址
        xmlHttp.open("get","/ajax?name="+name);
        //3.发出请求并接收服务器响应结果
        xmlHttp.onreadystatechange = function () {
            if(xmlHttp.readyState==4){
                if(xmlHttp.status==200){
                    var result = xmlHttp.responseText;
                    document.querySelector("#result").innerText = result;
                }
            }
        }
        xmlHttp.send();
    }
    function sendPost(name) {
        //1.获取Ajax引擎
        var xmlHttp = createXmlHttp();
        //2.指定请求方式和地址
        xmlHttp.open("post","/ajax");
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        //3.配置回掉函数
        xmlHttp.onreadystatechange = function () {
            if(xmlHttp.readyState==4){
                if(xmlHttp.status==200){
                    var result = xmlHttp.responseText;
                    if(result=="能用"){
                        document.querySelector("#result").innerText = "该账号可用";
                    }else{
                        document.querySelector("#result").innerText = "该账号已被占用";
                    }

                } else {
                    document.querySelector("#result").innerText = "服务器异常"+xmlHttp.status;
                }
            } else{
                document.querySelector("#result").innerText = "服务器异常"+xmlHttp.readyState;
            }
        }
        //4.发出post请求
        xmlHttp.send("name="+name+"&age="+23);
    }
</script>
</body>
</html>
