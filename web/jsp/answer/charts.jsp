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

<link type="text/css" rel="stylesheet" href="<%=path%>/css/books/reset.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/books/1024_768.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/pager/pagination.css"/>
<link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)"
      href="<%=path%>/css/books/pad_heng.css"/>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<jsp:include page="../main/corepage.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="../main/newindex.jsp"></jsp:include>
    <div id="page-wrapper">

        <h3 class="">题库数据分析</h3>
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="panel panel-default">
                                  <div style="text-align: center">
                                <h3 class="">题型数量分部图</h3></div>
                                <canvas id="answerNumChart" width="400" height="400"></canvas>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div style="text-align: center">
                                    <h3 class="">选择题难度分部图</h3></div>
                                <canvas id="choicesDegres" width="400" height="400"></canvas>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div style="text-align: center">
                                    <h3 class="">判断题难度分部图</h3></div>
                                <canvas id="judgeDegres" width="400" height="400"></canvas>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div style="text-align: center">
                                    <h3 class="">填空题难度分部图</h3></div>
                                <canvas id="gapDegres" width="400" height="400"></canvas>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div style="text-align: center">
                                    <h3 class="">名词解释题难度分部图</h3></div>
                                <canvas id="shortsDegres" width="400" height="400"></canvas>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div style="text-align: center">
                                    <h3 class="">简答题难度分部图</h3></div>
                                <canvas id="nuomDegres" width="400" height="400"></canvas>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="panel panel-default">
                                <div style="text-align: center"><h3 class="">主观题难度分部图</h3></div>
                                <canvas id="subDegres" width="400" height="400"></canvas>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>
        <jsp:include page="../main/footer.jsp"></jsp:include>
    </div>
</div>
</div>
<script type="text/javascript" src="<%=path%>/js/pager/jquery.pagination.js"></script>
<script type="text/javascript">

    window.onload = function () {
        var ctx = document.getElementById("answerNumChart").getContext("2d");
        $.ajax({
            type: 'POSt',
            url: '<%=path%>/answer/answerNum.do',
            date: '',
            success: function (data) {
                console.log(data)
                var dataarray = data.split(",");
                var config = {
                    type: 'pie',
                    data: {
                        datasets: [{
                            data: dataarray,
                            backgroundColor: [
                                "#F38630",
                                "#E0E4CC",
                                "#69D2E7",
                                "#00733C",
                                "#E00CA0",
                                "#3300DB"
                            ],
                        }],
                        labels: [
                            "选择题",
                            "判断题",
                            "填空题",
                            "名词解释题",
                            "简答题",
                            "主观题"
                        ]
                    },
                    options: {
                        responsive: true
                    }
                };
                window.myPie = new Chart(ctx, config);
            },
            error: function (ero) {
                alert("系统错误！");
            }
        })

        //难度系数分部图-----------------------
        //选择题
        var choicesDegres=document.getElementById("choicesDegres").getContext("2d");
        var judgeDegres=document.getElementById("judgeDegres").getContext("2d");
        var gapDegres=document.getElementById("gapDegres").getContext("2d");
        var shortsDegres=document.getElementById("shortsDegres").getContext("2d");
        var nuomDegres=document.getElementById("nuomDegres").getContext("2d");
        var subDegres=document.getElementById("subDegres").getContext("2d");
        for(var i=0;i<6;i++){
            $.ajax({
                async: false,
                type: 'POSt',
                url: '<%=path%>/answer/answerdesNum.do?type='+i,
                date: '',
                success: function (data) {
                    console.log(data)
                    var dataarray = data.split(",");
                    var config = {
                        type: 'pie',
                        data: {
                            datasets: [{
                                data: dataarray,
                                backgroundColor: [
                                    "#4f535f",
                                    "#7c506b",
                                    "#F7464a"
                                ],
                            }],
                            labels: [
                                "容易",
                                "一般",
                                "困难"
                            ]
                        },
                        options: {
                            responsive: true
                        }
                    };
                    var obj;
                    if(i==0){
                        obj=choicesDegres;
                    }
                    if(i==1){
                        obj=judgeDegres;
                    }
                    if(i==2){
                        obj=gapDegres;
                    }
                    if(i==3){
                        obj=shortsDegres;
                    }
                    if(i==4){
                        obj=nuomDegres;
                    }
                    if(i==5){
                        obj=subDegres;
                    }
                    window.myPie = new Chart(obj, config);
                },
                error: function (ero) {
                    alert("系统错误！");
                }
            })

        }
    };
</script>