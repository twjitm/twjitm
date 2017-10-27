<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="main/corepage.jsp"></jsp:include>
<html>
<head>
    <title>twjitm</title>
    <meta charset="UTF-8">
</head>
<body>
<div id="wrapper">
    <jsp:include page="main/newindex.jsp"></jsp:include>
    <div id="page-wrapper">
        <script type="text/javascript">
            var socket;
            if (!window.WebSocket) {
                window.WebSocket = window.MozWebSocket;
            }
            if (window.WebSocket) {
                socket = new WebSocket("ws://127.0.0.1:8088/ws");
                socket.onmessage = function (event) {
                    var ta = document.getElementById('responseText');
                    ta.value = ta.value + '\n' + event.data
                };
                socket.onopen = function (event) {
                    var ta = document.getElementById('responseText');
                    ta.value = "连接开启!";
                };
                socket.onclose = function (event) {
                    var ta = document.getElementById('responseText');
                    ta.value = ta.value + "连接被关闭";
                };
            } else {
                alert("你的浏览器不支持 WebSocket！");
            }

            function send(message) {
                if (!window.WebSocket) {
                    return;
                }
                if (socket.readyState == WebSocket.OPEN) {
                    socket.send(message);
                } else {
                    alert("连接没有开启.");
                }
            }
        </script>
        <form onsubmit="return false;">
            <h3>WebSocket 聊天室：</h3>
            <div><textarea id="responseText" style="width: 500px; height: 300px;"></textarea>
                <%-- <a onclick="send()">111111111111111</a>--%>
            </div>
            <br>
            <input type="text" name="message" style="width: 300px" placeholder="输入聊天内容">
            <input type="button" value="发送消息" onclick="send(this.form.message.value)">
            <input type="button" onclick="javascript:document.getElementById('responseText').value=''" value="清空聊天记录">
        </form>
        <br>
        <br>
    </div>
</div>
</body>
</html>
