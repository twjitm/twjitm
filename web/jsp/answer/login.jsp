<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/answer/style.css"/>
<script type="text/javascript" src="<%=path%>/js/chat/jquery.min.js"></script>
<body>
<div class="app-location">
    <h2>欢迎使用C++题库管理系统</h2>
    <div class="line"><span></span></div>
    <div class="location"><img src="<%=path%>/images/location.png" class="img-responsive" alt=""/></div>
    <form >
        <input type="text" class="text"  name="userName"  placeholder="用户账号" required="required">
        <input type="password"  name="userPsd"  placeholder="密码" required="required">
        <div class="submit"><input type="button" value="登录" onclick="login()"></div>
        <div class="clear"></div>
        <div class="new">
            <%--<h3><a href="#">Forgot password ?</a></h3>
            <h4><a href="#">New here ? Sign Up</a></h4>--%>
            <div class="clear"></div>
        </div>
    </form>
</div>
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
            url: '<%=path%>/users/login.do?userName=' + userName + "&userPsd=" + psd,
            date: '',
            success: function (data) {
                console.log(typeof data)
                if (data == "success") {
                    window.location.href = "<%=path%>/answer/plist.do";
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
</body>