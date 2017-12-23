<%--
  Created by IntelliJ IDEA.
  User: knight006
  Date: 12/20/2017
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
    <script type="text/javascript">
        function deleteItems() {
            //将form的action指向删除商品的地址
            document.itemsForm.action="${pageContext.request.contextPath}/deleteItems.action";

            //进行form提交
            document.itemsForm.submit();

        }
    </script>
</head>
<body>
<form name="itemsForm" action="${pageContext.request.contextPath }/editItems.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>
                <input type="submit" value="查询"/>
                <input type="button" value="批量删除" onclick="deleteItems()">
            </td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>批量删除</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemsList }" var="item">
            <tr>
                <td><input type="checkbox" name="delete_id" value="${item.id}"> </td>
                <td>${item.name }</td>
                <td>${item.price }</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.detail }</td>

                <td><a href="${pageContext.request.contextPath }/editItems.action?id=${item.id}">修改</a></td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>

</html>
