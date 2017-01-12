<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.baba.utils.Constants" %>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>babasport-list</title>
    <script type="text/javascript">
        function checkBox(name,state) {
            $("input[name='"+name+"']").attr("checked",state);
        }
        function optDelete(name) {
            var length = $("input[name='"+name+"']").size();
            if(length <= 0){
                alert("请至少选择一个！");
                return;
            }
            if(!confirm("你确定要删除吗？")){
                return;
            }
            $("#jvForm").attr("action","/brand/deletes.do");
            $("#jvForm").attr("method","post").submit();
        }
    </script>
</head>
<body>
<div class="box-positon">
    <div class="rpos">当前位置: 品牌管理 - 列表</div>
    <form class="ropt">
        <input class="add" type="button" value="添加"
               onclick="javascript:window.location.href='${pageContext.request.contextPath}/back.do?url=brand/add'"/>
    </form>
    <div class="clear"></div>
</div>
<div class="body-box">
    <form action="${pageContext.request.contextPath}/brand/list.do" method="post" style="padding-top:5px;">
        品牌名称: <input type="text" name="name" value="${name}"/>
        <select name="isDisplay">
            <option value="1" <c:if test="${isDisplay==true}"> selected="selected" </c:if> >是</option>
            <option value="0"  <c:if test="${isDisplay==false}"> selected="selected" </c:if> >不是</option>
        </select>
        <input type="submit" class="query" value="查询"/>
    </form>
    <form id="jvForm">
        <table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
            <thead class="pn-lthead">
            <tr>
                <th width="20"><input type="checkbox" onclick="checkBox('ids',this.checked)"/></th>
                <th>品牌ID</th>
                <th>品牌名称</th>
                <th>品牌图片</th>
                <th>品牌描述</th>
                <th>排序</th>
                <th>是否可用</th>
                <th>操作选项</th>
            </tr>
            </thead>
            <tbody class="pn-ltbody">
            <c:forEach items="${pageBean.data}" var="item">
                <tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
                    <td><input type="checkbox" value="${item.id }" name="ids"/></td>
                    <td align="center">${item.id }</td>
                    <td align="center">${item.name }</td>
                    <td align="center"><img width="40" height="40" src="${item.imageServerImgUrl}"/></td>
                    <td align="center">${item.description }</td>
                    <td align="center">${item.sort }</td>
                    <td align="center"><c:if test="${item.isDisplay == true }">是</c:if><c:if
                            test="${item.isDisplay == false }">不是</c:if></td>
                    <td align="center">
                        <a class="pn-opt" href="${pageContext.request.contextPath}/brand/toEdit.do?id=${item.id}">修改</a> | <a class="pn-opt"
                                                               href="/brand/delete.do?id=${item.id}&name=${item.name}&isDisplay=${item.isDisplay}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input type="hidden" name="name" value="${item.name }"/>
        <input type="hidden" name="isDisplay" value="${item.isDisplay }"/>
    </form>
    <div class="page pb15">
		<span class="r inb_a page_b">
			<c:forEach items="${pageBean.pageView}" var="page">
                ${page}
            </c:forEach>
		</span>
    </div>
    <div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete('ids');"/></div>
</div>
</body>
</html>