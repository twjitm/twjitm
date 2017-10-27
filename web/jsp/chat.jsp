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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/qq.css"/>
<body>
<div id="wrapper">
    <jsp:include page="main/newindex.jsp"></jsp:include>
    <div id="page-wrapper">
        <%--  <div class="qqBox">--%>
        <div class="BoxHead">
            <div class="headImg">
                <img src="<%=path%>/img/6.jpg"/>
            </div>
            <div class="internetName">twjitm</div>
        </div>
        <div class="context">
            <div class="conLeft">
                <ul>
                    <li>
                        <div class="liLeft"><img src="<%=path%>/img/20170926103645_04.jpg"/></div>
                        <div class="liRight">
                            <span class="intername">平平</span>
                            <span class="infor">厉害了</span>
                        </div>
                    </li>
                    <li>
                        <div class="liLeft"><img src="<%=path%>/img/20170926103645_54.jpg"/></div>
                        <div class="liRight">
                            <span class="intername">哈哈</span>
                            <span class="infor">[流泪]</span>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="conRight">
                <div class="Righthead">
                    <div class="headName">哈哈</div>
                    <div class="headConfig">
                        <ul>
                            <li><img src="<%=path%>/img/20170926103645_06.jpg"/></li>
                            <li><img src="<%=path%>/img/20170926103645_08.jpg"/></li>
                            <li><img src="<%=path%>/img/20170926103645_10.jpg"/></li>
                            <li><img src="<%=path%>/img/20170926103645_12.jpg"/></li>
                        </ul>
                    </div>
                </div>
                <div class="RightCont">
                    <ul class="newsList">

                    </ul>
                </div>
                <div class="RightFoot">
                    <div class="emjon">
                        <ul>
                            <li><img src="<%=path%>/img/em_02.jpg"/></li>
                            <li><img src="<%=path%>/img/em_05.jpg"/></li>
                            <li><img src="<%=path%>/img/em_07.jpg"/></li>
                            <li><img src="<%=path%>/img/em_12.jpg"/></li>
                            <li><img src="<%=path%>/img/em_14.jpg"/></li>
                            <li><img src="<%=path%>/img/em_16.jpg"/></li>
                            <li><img src="<%=path%>/img/em_20.jpg"/></li>
                            <li><img src="<%=path%>/img/em_23.jpg"/></li>
                            <li><img src="<%=path%>/img/em_25.jpg"/></li>
                            <li><img src="<%=path%>/img/em_30.jpg"/></li>
                            <li><img src="<%=path%>/img/em_31.jpg"/></li>
                            <li><img src="<%=path%>/img/em_33.jpg"/></li>
                            <li><img src="<%=path%>/img/em_37.jpg"/></li>
                            <li><img src="<%=path%>/img/em_38.jpg"/></li>
                            <li><img src="<%=path%>/img/em_40.jpg"/></li>
                            <li><img src="<%=path%>/img/em_45.jpg"/></li>
                            <li><img src="<%=path%>/img/em_47.jpg"/></li>
                            <li><img src="<%=path%>/img/em_48.jpg"/></li>
                            <li><img src="<%=path%>/img/em_52.jpg"/></li>
                            <li><img src="<%=path%>/img/em_54.jpg"/></li>
                            <li><img src="<%=path%>/img/em_55.jpg"/></li>
                        </ul>
                    </div>
                    <div class="footTop">
                        <ul>
                            <li><img src="<%=path%>/img/20170926103645_31.jpg"/></li>
                            <li class="ExP"><img src="<%=path%>/img/20170926103645_33.jpg"/></li>
                            <li><img src="<%=path%>/img/20170926103645_35.jpg"/></li>
                            <li><img src="<%=path%>/img/20170926103645_37.jpg"/></li>
                            <li><img src="<%=path%>/img/20170926103645_39.jpg"/></li>
                            <li><img src="<%=path%>/img/20170926103645_41.jpg" alt=""/></li>
                            <li><img src="<%=path%>/img/20170926103645_43.jpg"/></li>
                            <li><img src="<%=path%>/img/20170926103645_45.jpg"/></li>
                        </ul>
                    </div>
                    <form onsubmit="return false;">
                        <div class="inputBox" name="inputBox">
                            <textarea id="dope" style="width: 99%;height: 75px; border: none;outline: none;"
                                      name="message"
                                      rows="" cols=""></textarea>

                        </div>
                        <button class="sendBtn" onclick="send(this.form.message.value)">发送(s)</button>
                    </form>
                </div>
            </div>
        </div>
        <%--   </div>--%>
    </div>
</div>


<script type="application/javascript">
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
            alert("服务器已经宕机，请重启.");
        }

        var news = $('#dope').val();
        if (news == '') {
            alert('不能为空');
        } else {
            $('#dope').val('');
            var str = '';
            str += '<li>' +
                '<div class="answerHead"><img src="<%=path%>/img/6.jpg"/></div>' +
                '<div class="answers"><img class="jiao" src="<%=path%>/img/20170926103645_03_02.jpg">' + news + '</div>' +
                '</li>';
            $('.newsList').append(str);
            setTimeout(answers, 1000);
            $('.conLeft').find('li.bg').children('.liRight').children('.infor').text(news);
            $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight);
        }

        //-----------------------回复----------------
        function answers() {
            var arr = ["你好", "今天天气很棒啊", "你吃饭了吗？", "我最美我最美", "我是可爱的僵小鱼", "你们忍心这样子对我吗？", "spring天下无敌，实习工资850", "我不管，我最帅，我是你们的小可爱", "段友出征，寸草不生", "一入段子深似海，从此节操是路人", "馒头：嗷", "突然想开个车", "段子界混的最惨的两个狗：拉斯，普拉达。。。"];
            var aa = Math.floor((Math.random() * arr.length));
            var answer = '';
            answer += '<li>' +
                '<div class="nesHead"><img src="<%=path%>/img/tou.jpg"/></div>' +
                '<div class="news"><img class="jiao" src="<%=path%>/img/jiao.jpg">' + arr[aa] + '</div>' +
                '</li>';
            $('.newsList').append(answer);
            $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight);
        }


    }

</script>
</body>
</html>
