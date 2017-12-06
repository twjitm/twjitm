<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../main/corepage.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="../main/newindex.jsp"></jsp:include>
    <div id="page-wrapper">
        <h3>题目录入</h3>
        <div id="page-inner">

            <div class="row">
                <div class="col-md-12">
                    <form action="<%=path%>/answer/addsubject.do" method="post" id="bookFrom"
                          enctype="multipart/form-data">
                        <div class="col-md-12">
                            <div class="col-md-12">
                                <label>题目格式：</label><select class="form-control" name="qtype" onchange="changeView(this.options[this.options.selectedIndex].value)">
                                <option value="0">选着题</option>
                                <option value="1">判断题</option>
                                <option value="2">填空题</option>
                                <option value="3">名词解释</option>
                                <option value="4">简单题</option>
                                <option value="5">主观题</option>
                            </select>
                                <label>题目类容：</label> <textarea class="form-control" rows="5"
                                                               name="title"
                                                               placeholder="题目描述"></textarea>
                                <div id="tableContext" style="display:display">
                                <label>选项A：</label> <input class="form-control" name="itemA" placeholder="选项A"
                                                          required="required"></input>
                                <label>选项B：</label> <input class="form-control" name="itemB" placeholder="选项B"
                                                           required="required"></input>
                                <label>选项C：</label> <input class="form-control" name="itemC" placeholder="选项C"
                                                           required="required"></input>
                                <label>选项D：</label> <input class="form-control" name="itemD" placeholder="选项D"
                                                           required="required"></input>
                                </div>
                                <label>答案：</label> <textarea class="form-control" rows="5"
                                                             name="answer"
                                                             placeholder="答案描述"></textarea>
                                <label>难度系数：</label><select class="form-control" name="degree">
                                <option value="0">1星</option>
                                <option value="1">2星</option>
                                <option value="2">3星</option>
                            </select>

                            </div>
                        </div>
                        <div class="col-md-12">
                            </br>
                            <div class="col-md-6">
                                <input type="submit" class="btn btn-primary btn-lg" value="提交"></input>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <jsp:include page="../main/footer.jsp"></jsp:include>
        </div>
    </div>
</div>
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

    function submitFrom() {
        layer.msg("添加图书成功")
        $("#bookFrom").submit();
    }
</script>
