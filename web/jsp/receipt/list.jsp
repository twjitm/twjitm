<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link type="text/css" rel="stylesheet"
      href="<%=path%>/css/books/reset.css"/>
<link type="text/css" rel="stylesheet"
      href="<%=path%>/css/books/1024_768.css"/>
<link type="text/css" rel="stylesheet"
      href="<%=path%>/css/pager/pagination.css"/>
<link type="text/css" rel="stylesheet"
      media="screen and (min-width:861px) and (max-width:960px)"
      href="<%=path%>/css/books/pad_heng.css"/>

<html>
<jsp:include page="../main/corepage.jsp"></jsp:include>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>账单管理</title>
</head>
<body>
<div id="wrapper">
    <jsp:include page="../main/newindex.jsp"></jsp:include>
    <div id="page-wrapper">
        <h3 class="">欢迎使用C++题库系统</h3>
        <div id="page-inner">
            <div class="row">

                <div id="tableContext">
                    <div class="panel panel-default">
                        <div class="table-responsive">
                        </div>
                    </div>
                </div>
                <!--弹框-->
            </div>
            <jsp:include page="../main/footer.jsp"></jsp:include>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function changeView(type) {
        if (type == 0) {
            $("#tableContext").show();
            $("#detailed").hide();
        } else {
            $("#tableContext").hide();
            $("#detailed").show();
        }
    }
    $(document).ready(function () {
        $('#dataTables-example').dataTable({
            "sPaginationType": "full_numbers",
            "oLanguage": {
                "sProcessing": "<img src='/images/datatable_loading.gif'>  努力加载数据中.",
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "sZeroRecords": "没有检索到数据",
                "sSearch": "模糊查询:  ",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"

                }
            }
        });
    });


</script>
</html>