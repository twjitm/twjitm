<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html lang="en" class="no-js">
<head>
    <title>js游戏人物上下左右跑步效果 </title>
    <meta charset="utf-8"/>
    <style type="text/css">
        table {
            position: absolute;
            top: 100px;
            right: 100px;
            width: 150px;
            height: 150px;
        }

        input {
            width: 40px;
            height: 30px;
            background: orange;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
        }

        img {
            position: absolute;
            top: 300px;
            left: 500px;
        }

        html, body {
            height: 100%;
        }
    </style>
</head>
<body onmousedown="mouseMove()">
<div style="height: 100%;">
    <img id="im" src="<%=path%>/img/game/down-0.png"/>
    <table>
        <tr>
            <td><input id="leftUp" type="button" value="左上"/></td>
            <td><input id="goUp" type="button" value="向上"/></td>
            <td><input id="rightUp" type="button" value="右上"/></td>
        </tr>
        <tr>
            <td><input id="goLeft" type="button" value="左"/></td>
            <td><input id="stop" type="button" value="停止"/></td>
            <td><input id="goRight" type="button" value="右"/></td>
        </tr>
        <tr>
            <td><input id="leftDown" type="button" value="左下"/></td>
            <td><input id="goDown" type="button" value="向下"/></td>
            <td><input id="rightDown" type="button" value="右下"/></td>
        </tr>
    </table>
    <script type="text/javascript">
        var maxWigh = document.body.clientWidth;
        var maxHight = document.body.clientHeight;
        var i = 0, clc = null, flage;
        var images = document.getElementById('im');

        var oGoUp = document.getElementById('goUp');
        var oGoDown = document.getElementById('goDown');
        var oGoLeft = document.getElementById('goLeft');
        var oGoRight = document.getElementById('goRight');
        var oLeftUp = document.getElementById('leftUp');
        var oLeftDown = document.getElementById('leftDown');
        var oRightUp = document.getElementById('rightUp');
        var oRightDown = document.getElementById('rightDown');
        var oStop = document.getElementById('stop');

        images.style.top = '300px';
        images.style.left = '500px';

        //监听鼠标点击位置
        function mouseMove() {
            document.onmousedown = function (event) {
                var butnum = event.button;
                stop();
                if (butnum == 2) {
                    var e = event || window.event;
                    var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
                    var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
                    var x = e.pageX || e.clientX + scrollX;
                    var y = e.pageY || e.clientY + scrollY;
                    alert("当前点击位置=" + x + ":" + y);
                    var top = images.style.top;
                    var left = images.style.left;
                    alert("当前人物所在位置" + top + "---" + left)
                    var topval = top.substring(0, top.length - 2);
                    var leftval = left.substring(0, left.length - 2);
                    //得到点击的差值
                    var xdvalue = x - topval;
                    var ydvalue = y - leftval;
                    alert("当前人物所在位置" + xdvalue + "：" + ydvalue)
                    if (ydvalue == 0 && xdvalue > 0) {//往下
                        oGoDown1();
                    }
                    if (ydvalue == 0 && xdvalue > 0) {//往上
                        oGoUp1();
                    }
                    if (xdvalue == 0 && ydvalue > 0) {//往右
                        oGoRight1();
                    }
                    if (xdvalue == 0 && ydvalue < 0) {//往左
                        oGoLeft1();

                    }
                    if (ydvalue > 0 && xdvalue > 0) {//右下
                        oRightDown1();
                    }
                    if (ydvalue > 0 && xdvalue < 0) {//左下
                        oLeftDown1();

                    }
                    if (xdvalue > 0 && ydvalue < 0) {//右上
                        oRightUp1();
                    }
                    if (xdvalue < 0 && ydvalue < 0) {//左上
                        oLeftUp1();
                    }
                }
                return false;
            }
        }


        //停止
        oStop.onclick = function () {
            switch (flage) {
                case 1:
                    images.src = '<%=path%>/img/game/up-0.png';
                    break;
                case 2:
                    images.src = '<%=path%>/img/game/down-0.png';
                    break;
                case 3:
                    images.src = '<%=path%>/img/game/left-0.png';
                    break;
                case 4:
                    images.src = '<%=path%>/img/game/right-0.png';
                    break;
                case 5:
                    images.src = '<%=path%>/img/game/rightUp-0.png';
                    break;
                case 6:
                    images.src = '<%=path%>/img/game/rd-0.png';
                    break;
                case 7:
                    images.src = '<%=path%>/img/game/ld-0.png';
                    break;
                case 8:
                    images.src = '<%=path%>/img/game/lu-0.png';
                    break;
            }
            clearInterval(clc);
        }
        function stop() {

            switch (flage) {
                case 1:
                    images.src = '<%=path%>/img/game/up-0.png';
                    break;
                case 2:
                    images.src = '<%=path%>/img/game/down-0.png';
                    break;
                case 3:
                    images.src = '<%=path%>/img/game/left-0.png';
                    break;
                case 4:
                    images.src = '<%=path%>/img/game/right-0.png';
                    break;
                case 5:
                    images.src = '<%=path%>/img/game/rightUp-0.png';
                    break;
                case 6:
                    images.src = '<%=path%>/img/game/rd-0.png';
                    break;
                case 7:
                    images.src = '<%=path%>/img/game/ld-0.png';
                    break;
                case 8:
                    images.src = '<%=path%>/img/game/lu-0.png';
                    break;
            }
            clearInterval(clc);
        }

        //-------------------------------------
        //向上
        oGoUp.onclick = function () {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goUp(i++);", 100);
        }
        function oGoUp1() {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goUp(i++);", 100);
        }
        function goUp() {
            i = i % 4;
            var name = "<%=path%>/img/game/up-" + i + "." + "png";
            images.src = name;
            images.style.top = parseInt(images.style.top) - 10 + 'px';
            flage = 1;
        }
        //---------------------------------------
        //向下
        oGoDown.onclick = function () {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goDown(i++);", 100);
        }
        function oGoDown1() {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goDown(i++);", 100);
        }
        function goDown() {
            i = i % 4;
            var name = "<%=path%>/img/game/down-" + i + "." + "png";
            images.src = name;
            images.style.top = parseInt(images.style.top) + 10 + 'px';
            flage = 2;
        }
        //------------------------------------------------------
        //向左
        oGoLeft.onclick = function () {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goLeft(i++);", 100);
        }
        function oGoLeft1() {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goLeft(i++);", 100);
        }
        function goLeft() {
            i = i % 4;
            var name = "<%=path%>/img/game/left-" + i + "." + "png";
            images.src = name;
            images.style.left = parseInt(images.style.left) - 10 + 'px';
            flage = 3;
        }
        //---------------------------------------------------------------------
        //向右
        oGoRight.onclick = function () {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goRight(i++);", 100);
        }
        function oGoRight1() {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goRight(i++);", 100);
        }
        function goRight() {
            i = i % 4;
            var name = "<%=path%>/img/game/right-" + i + "." + "png";
            images.src = name;
            images.style.left = parseInt(images.style.left) + 10 + 'px';
            flage = 4;
        }
        //---------------------------------------------
        //向右上
        oRightUp.onclick = function () {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goRightUp(i++);", 100);
        }
        function oRightUp1() {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goRightUp(i++);", 100);
        }
        function goRightUp() {
            i = i % 4;
            var name = "<%=path%>/img/game/rightUp-" + i + "." + "png";
            images.src = name;
            images.style.left = parseInt(images.style.left) + 10 + 'px';
            images.style.top = parseInt(images.style.top) - 10 + 'px';
            flage = 5;
        }
        //----------------------
        //向右下
        oRightDown.onclick = function () {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goRightDown(i++);", 100);
        }
        function oRightDown1() {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goRightDown(i++);", 100);
        }
        function goRightDown() {
            i = i % 4;
            var name = "<%=path%>/img/game/rd-" + i + "." + "png";
            images.src = name;
            images.style.left = parseInt(images.style.left) + 10 + 'px';
            images.style.top = parseInt(images.style.top) + 10 + 'px';
            flage = 6;
        }
        //--------------------------
        //向左下
        oLeftDown.onclick = function () {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goLeftDown(i++);", 100);
        }
        function oLeftDown1() {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goLeftDown(i++);", 100);
        }
        function goLeftDown() {
            i = i % 4;
            var name = "<%=path%>/img/game/ld-" + i + "." + "png";
            images.src = name;
            images.style.left = parseInt(images.style.left) - 10 + 'px';
            images.style.top = parseInt(images.style.top) + 10 + 'px';
            flage = 7;
        }
        //-----------------------------
        //向左上
        oLeftUp.onclick = function () {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goLeftUp(i++);", 100);
        }
        function oLeftUp1() {
            i = 0;
            clearInterval(clc);
            clc = setInterval("goLeftUp(i++);", 100);
        }
        function goLeftUp() {
            i = i % 4;
            var name = "<%=path%>/img/game/lu-" + i + "." + "png";
            images.src = name;
            images.style.left = parseInt(images.style.left) - 10 + 'px';
            images.style.top = parseInt(images.style.top) - 10 + 'px';
            flage = 8;
        }
    </script>
</div>
<div style="text-align:center;clear:both">
</div>
</body>
</html>
