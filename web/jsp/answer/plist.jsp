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

        <h3 class="">题目列表</h3>
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">

                                <div id="tableContext">
                                    <div class="panel panel-default">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover"
                                                   id="dataTables-example">
                                                <thead>
                                                <tr>
                                                    <td>id</td>
                                                    <td>试卷标题</td>
                                                    <td>操作</td>
                                                </tr>
                                                </thead>
                                                <tbody id="booksList">
                                                <c:forEach items="${plist}" var="list">
                                                    <tr class="odd gradeX">
                                                        <td>${list.id}</td>
                                                        <td>${list.title}</td>
                                                        <td>
                                                            <a href="<%=path%>/answer/updateSubject.do?id=${list.id}">下载</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>


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
<%-- <script type="text/javascript" src="<%=path%>/js/pager/jquery.min.js"> </script>
 --%>
<script>

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

    function pageselectCallback(page_index, jq) {
        console.log(page_index);
        var concurrcp = "${page}"
        if (page_index != concurrcp) {
            window.location = 'http://localhost:8080/sj/books/newall.do?cp=' + page_index
        }
    }

    //图书详细信息
    function bookInfor(id, type, storageNum) {
        if (storageNum == 0) {

        }
        <%--  $.ajax({
                url:'<%=path%>/books/bookInfor.do?bookId='+id+'&type='+type,
                 type : "POST",
                data : '',
                success : function(data) {

                    },
                    }); --%>
    }


</script>

<script>
</script>