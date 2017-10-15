<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/demo.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/component.css"/>

    <script src="<%=path %>/js/html5.js"></script>
    <script src="<%=path%>/js/pager/jquery.min.js"></script>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎你</h3>
                <form action="<%=path%>/user/login.do" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="userName" class="text" style="color: #FFFFFF !important" type="text"
                               autocomplete="off" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="userPsd" class="text"
                               style="color: #FFFFFF !important; position:absolute; z-index:100;"
                               autocomplete="off" type="password" placeholder="请输入密码">
                    </div>
                    <a class="act-but submit" href="javascript:void(0);" onclick="javascript:login()"
                       style="color: #FFFFFF">登录</a>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script type="application/javascript">
    function login() {
        var userName = $("input[name='userName']").val();
        var psd = $("input[name='userPsd']").val();
        console.log("userName=" + userName + "psd=" + psd)
        if (userName == null || userName == "" || psd == null || psd == "") {
            return;
        }
        $.ajax({
            type: 'POSt',
            url: '<%=path%>/user/login.do?userName=' + userName + "&userPsd=" + psd,
            date: '',
            success: function (data) {
                console.log(typeof data)
                if (data == "success") {
                    window.location.href = "<%=path%>/user/index.do";
                } else {
                    alert("用户名或者密码有问题！");
                }
            },
            error: function (ero) {
                alert("系统错误！");
            }
        })
    }
</script>
<script src="<%=path %>/js/TweenLite.min.js"></script>
<script src="<%=path %>/js/EasePack.min.js"></script>
<script src="<%=path %>/js/rAF.js"></script>
<script src="<%=path %>/js/demo-1.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>
