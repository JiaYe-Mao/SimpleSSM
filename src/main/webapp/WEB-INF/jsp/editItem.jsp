<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: knight006
  Date: 12/21/2017
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>editItem</title>
</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath }/editItemSubmit.action" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${id}"/>
    修改商品信息：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${itemsCustom.name }"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${itemsCustom.price }"/></td>
        </tr>
        <tr>
            <td>商品生产日期</td>
            <td><input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/>"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${itemsCustom.pic}!=null">
                    <img src="/pic/${itemsCustom.pic}" width="100" height="100">
                    <br/>
                </c:if>
                <input type="file" name="pictureFile" accept="image/jpg">
            </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${itemsCustom.detail }</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
