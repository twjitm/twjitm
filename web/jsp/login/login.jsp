<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
<meta charset="utf-8">
<title>602小助手</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->


<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<!--<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>-->
<![endif]-->
<!-- Fav and touch icons -->
<link rel="shortcut icon" href="<%= path%>/img/minus.png">
</head>

<body>
<!-- Preloader -->
<div id="preloader">
    <div id="status">&nbsp;</div>
</div>

<div class="container">


    <div class="" id="login-wrapper">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div id="logo-login">
                    <h1>title
                        <span>v1.3</span>
                    </h1>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="account-box">
                    <form role="form" action="index.html">
                        <div class="form-group">
                            <!--a href="#" class="pull-right label-forgot">Forgot email?</a-->
                            <label for="inputUsernameEmail">用户名</label>
                            <input type="text" id="inputUsernameEmail" class="form-control">
                        </div>
                        <div class="form-group">
                            <!--a href="#" class="pull-right label-forgot">Forgot password?</a-->
                            <label for="inputPassword">密码</label>
                            <input type="password" id="inputPassword" class="form-control">
                        </div>
                        <div class="checkbox pull-left">
                            <label>
                                <input type="checkbox">记住用户名</label>
                        </div>
                        <button class="btn btn btn-primary pull-right" type="submit">
                            登 录
                        </button>
                    </form>
                    <a class="forgotLnk" href="index.html"></a>

                    <div class="row-block">
                        <div class="row">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <p>&nbsp;</p>
    <div style="text-align:center;margin:0 auto;">
        <h6 style="color:#fff;">Copyright(C)2014 fjcloudsoft.com All Rights Reserved<br/>
            唐文江 版权所有 闽IP备07021605号</h6>
    </div>

</div>
<div id="test1" class="gmap3"></div>


<!--  END OF PAPER WRAP -->


<!-- MAIN EFFECT -->
<%--
<script type="text/javascript" src="<%= path%>/js/assets/preloader.js"></script>
<script type="text/javascript" src="<%= path%>/js/assets/bootstrap.js"></script>
<script type="text/javascript" src="<%= path%>/js/assets/app.js"></script>
<script type="text/javascript" src="<%= path%>/js/assets/load.js"></script>
<script type="text/javascript" src="<%= path%>/js/assets/main.js"></script>
--%>

<%--<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>--%>
<%--<script type="text/javascript" src="<%= path%>/js/assets/map/gmap3.js"></script>--%>
<script type="text/javascript">
    $(function () {

        $("#test1").gmap3({
            marker: {
                latLng: [-7.782893, 110.402645],
                options: {
                    draggable: true
                },
                events: {
                    dragend: function (marker) {
                        $(this).gmap3({
                            getaddress: {
                                latLng: marker.getPosition(),
                                callback: function (results) {
                                    var map = $(this).gmap3("get"),
                                        infowindow = $(this).gmap3({
                                            get: "infowindow"
                                        }),
                                        content = results && results[1] ? results && results[1].formatted_address : "no address";
                                    if (infowindow) {
                                        infowindow.open(map, marker);
                                        infowindow.setContent(content);
                                    } else {
                                        $(this).gmap3({
                                            infowindow: {
                                                anchor: marker,
                                                options: {
                                                    content: content
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        });
                    }
                }
            },
            map: {
                options: {
                    zoom: 15
                }
            }
        });

    });
</script>
</body>
</html>
