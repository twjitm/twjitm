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
        <h3>组卷系统</h3>
        <div id="page-inner">

            <div class="row">
                <div class="col-md-6">
                    <input type="text" class="form-control" name="titles" placeholder="试卷标题">
                    <div class="col-md-5">
                        <label>选择题</label><input type="text" class="form-control" name="choice" placeholder="数量">
                        <label>判断题</label><input type="text" class="form-control" name="judge" placeholder="数量">
                        <label>填空题</label><input type="text" class="form-control" name="gap" placeholder="数量">
                        <label>名词解释题</label><input type="text" class="form-control" name="expl" placeholder="数量">
                        <label>简答题</label><input type="text" class="form-control" name="answer" placeholder="数量">
                        <label>主观题</label><input type="text" class="form-control" name="subjectivity" placeholder="数量">
                        <a onclick="saveSnswer()" class="btn btn-success">提 交</a>
                    </div>
                    <div class="col-md-6">
                        <label>&nbsp;</label><input type="text" class="form-control" name="choiceValue"
                                                    placeholder="每题分数">
                        <label>&nbsp;</label><input type="text" class="form-control" name="judgeValue"
                                                    placeholder="每题分数">
                        <label>&nbsp;</label><input type="text" class="form-control" name="gapValue" placeholder="每题分数">
                        <label>&nbsp;</label><input type="text" class="form-control" name="explValue"
                                                    placeholder="每题分数">
                        <label>&nbsp;</label><input type="text" class="form-control" name="answerValue"
                                                    placeholder="每题分数">
                        <label>&nbsp;</label><input type="text" class="form-control" name="subjectValue"
                                                    placeholder="每题分数">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function saveSnswer() {

        var choice = $("input[name='choice']").val();
        var choiceValue = $("input[name='choiceValue']").val();

        var judge = $("input[name='judge']").val();
        var judgeValue = $("input[name='judgeValue']").val();

        var gap = $("input[name='gap']").val();
        var gapValue = $("input[name='gapValue']").val();

        var expl = $("input[name='expl']").val();
        var explValue = $("input[name='explValue']").val();

        var answer = $("input[name='answer']").val();
        var answerValue = $("input[name='answerValue']").val();

        var subjectivity = $("input[name='subjectivity']").val();
        var subjectValue = $("input[name='subjectValue']").val();
        var data="";
        var allvalue;
        if(isNOtNUll(choice)&&isNOtNUll(choiceValue)){
            allvalue=choice*choiceValue;
            data="0:"+choice+","+choiceValue+";";
        }
        if(isNOtNUll(judge)&&isNOtNUll(judgeValue)){
            allvalue=allvalue+judge*judgeValue;
            data=data+"1:"+judge+","+judgeValue+";";
        }
        if(isNOtNUll(gap)&&isNOtNUll(gapValue)){
            allvalue=allvalue+gap*gapValue;
            data=data+"2:"+gap+","+gapValue+";";
        }
        if(isNOtNUll(expl)&&isNOtNUll(explValue)){
            allvalue=allvalue+expl*explValue;
            data=data+"3:"+expl+","+explValue+";";
        }
        if(isNOtNUll(answer)&&isNOtNUll(answerValue)){
            allvalue=allvalue+answer*answerValue;
            data=data+"4:"+answer+","+answerValue+";";

        }
        if(isNOtNUll(subjectivity)&&isNOtNUll(subjectValue)){
            allvalue=allvalue+subjectivity*subjectValue;
            data=data+"5:"+subjectivity+","+subjectValue+";";
        }
        if(allvalue!=100){
            layer.msg("分数分布不正确!");
            return;
        }
        var titles= $("input[name='titles']").val();
        if(!isNOtNUll(titles)){
            layer.msg("标题不能为空");
            return;
        }
       /* var index =  parent.layer.load(2, {shade: false} ); //0代表加载的风格，支持0-2*/
        $.ajax({
            type: 'POSt',
            url: '<%=path%>/answer/combination.do?title='+titles +"&data="+data,
            date: '',
            success: function (data) {
                console.log(typeof data)
                if (data == "success") {
                    window.location.href = "<%=path%>/answer/plist.do";
                } else {
                    alert("组卷失败！");
                }
            },
            error: function (ero) {
                alert("系统错误！");
            }
        })

    }
    function  isNOtNUll(val) {
        if(val==null||val==""){
            return false;
        }
        return true;
    }

</script>