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
    <div id="body">
        <div class="well with-header">
            <div class="header bg-themeprimary">
                <strong>查看日志</strong>
            </div>
            <form id="defaultForm" class="form form-horizontal bv-form" role="form" action="ckrzsj!show.do" method="post">
                <div class="form-group">
                    <div class="col-sm-1">
                        <button id="ckrqsj" type="button" onclick="javascript:tockrz();" class="btn btn-primary input-sm"><i class="fa fa-print"></i>CheckLog</button>
                    </div>
                    <div class="col-sm-1">
                        <button id="ckrqsj2" type="button" onclick="javascript:terminate();" class="btn btn-primary input-sm"
                                style="display:none;">
                            <i class="fa fa-ban"></i>Terminate</button>
                    </div>
                </div>
                <div class="form-group">
                    <div style="margin-bottom: 5px;background-color: black;color: green;font-weight: bold;font-size: 14px;'Times New Roman,Georgia,Serif'"
                    class="well bordered-left bordered-pink">
                    <div class="row">
                        <div class="col-sm-12" id="logs">
                        </div>
                    </div>
                </div>
        </div>
        </form>
    </div>
</div>
</div><!-- /container -->
<script type="application/javascript">

    var line = 1;//访问日志的当前行数
    var timeout = 0;
    var isStoping = false;
    function tockrz(){
        isStoping = !isStoping;
        if(isStoping){
            $("#ckrqsj").html("<i class='fa fa-ban'></i>Stop");
            ckrz();
            timeout =setInterval(ckrz, 10000);
            $("#ckrqsj2").show();
        }
        else {
            $("#ckrqsj").html("<i class='fa fa-print'></i>CheckLog");
            clearInterval(timeout);
            $("#ckrqsj2").hide();
        }
    }
    function ckrz(){
        $.ajax({
            url:"<%=path%>/logs/logs.do",
        type:"post",
        async: false,
            cache: false,
            dataType:"json", //这里返回的类型有：json,html,xml,text
        data:{
            line:line
        },
        beforeSend:function(){
        },
        success:function(data,textStatus){
            var datas = "";
            var lines = data.lineList;
            line = data.line;
            for(var i=0;i<lines.length;i++){
                datas += lines[i];
            }
            $('#logs').append('<p>'+datas+'</p>');
            // 滚到屏幕下方                 window.scrollTo(0,document.body.scrollHeight); 
        }
    });
    }
    function terminate(){ // 中断后重置数据
        line = 1;
        isStoping = false;
        $("#ckrqsj").html("<i class='fa fa-print'></i>CheckLog");
        clearInterval(timeout);
        $("#logs").empty();
        $("#ckrqsj2").hide();
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
