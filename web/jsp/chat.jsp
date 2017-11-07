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
    //****************************及时通讯--------------------------------
    var socket;
    if (!window.WebSocket) {
        window.WebSocket = window.MozWebSocket;
    }
    if (window.WebSocket) {
        socket = new WebSocket("ws://127.0.0.1:8088/ws");
        socket.onmessage = function (event) {
            // var ta = document.getElementById('responseText');
            console.log(event.data)
            var data = event.data;
            answers(data);
        };
        socket.onopen = function (event) {
            console.log("连接开启!");
        };
        socket.onclose = function (event) {
            console.log("连接关闭!");
        };
    } else {
        alert("你的浏览器不支持 WebSocket！");
    }

    function send(message) {
        if (!window.WebSocket) {
            return;
        }
        if (socket.readyState == WebSocket.OPEN) {
            //将消息封装成json对象发送出去，服务器判断接受方信息和消息类型，
            var messageObj = bulidMessageToJson(message);
            socket.send(messageObj);
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
            /*setTimeout(answers, 1000);*/
            $('.conLeft').find('li.bg').children('.liRight').children('.infor').text(news);
            $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight);
        }
    }

    //消息枚举类型


    /**
     * 将私聊消息封装成一个json对象
     * @param messageContext
     */
    function bulidMessageToJson(messageContext) {
        var json = "";
        json = '{"chatType":"' + 2 + '","context":"' + messageContext + '","messageType":"' + 1 + '" }';
        return json;
    }

    //---------------------------消息接受--------------------------------------
    function answers(json) {
        var chatMessage = JSON.parse(json);
        //接受到不同消息后进行处理
        if (chatMessage.messageType == 1) {//私聊消息枚举
            var messageContext = chatMessage.context;// Math.floor((Math.random() * arr.length));
            var answer = '';
            answer += '<li>' +
                '<div class="nesHead"><img src="<%=path%>/img/tou.jpg"/></div>' +
                '<div class="news"><img class="jiao" src="<%=path%>/img/jiao.jpg">' + messageContext + '</div>' +
                '</li>';
            $('.newsList').append(answer);
            $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight);
        }
        if (chatMessage.messageType == 2) {//群聊消息枚举

        }
        if (chatMessage.messageType == 3) {//玩家上线消息

        }
        if (chatMessage.messageType == 4) {//玩家掉线消息

        }
        switch (chatMessage.messageType) {

        }

    }
    //-------------------------UI操作-------------------------------------------------
    $('.conLeft li').on('click', function () {
        $(this).addClass('bg').siblings().removeClass('bg');
        var intername = $(this).children('.liRight').children('.intername').text();
        $('.headName').text(intername);
        $('.newsList').html('');
    })
    $('.sendBtn').on('click', function () {
    });

    $('.ExP').on('mouseenter', function () {
        $('.emjon').show();
    })
    $('.emjon').on('mouseleave', function () {
        $('.emjon').hide();
    })
    $('.emjon li').on('click', function () {
        var imgSrc = $(this).children('img').attr('src');
        var str = "";
        str += '<li>' +
            '<div class="nesHead"><img src="<%=path%>/img/6.jpg"/></div>' +
            '<div class="news"><img class="jiao" src="<%=path%>/img/20170926103645_03_02.jpg"><img class="Expr" src="' + imgSrc + '"></div>' +
            '</li>';
        $('.newsList').append(str);
        $('.emjon').hide();
        $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight);
    })


</script>
</body>
</html>
