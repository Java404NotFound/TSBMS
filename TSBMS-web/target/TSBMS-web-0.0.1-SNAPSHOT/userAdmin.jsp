<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="islogin.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>

<body>
<div class="menu">
<table>
<tbody>
<tr><td>
<form method="post" action="userAdmin.jsp">
<input name="flag" value="search" class="input-text" type="hidden" />
用户名称：<input name="userName" class="input-text" type="text" />&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit" />
</form>
</td></tr>
</tbody>
</table>
</div>

<div class="main">
     <div class="optitle clearfix">
     <em>
     <c:if test="${pageScope.role=='admin权限'}">
     <input value="添加数据" class="input-button" onclick="window.location='userAdd.jsp'" type="button" />
     </c:if>
     </em>
		<div class="title">用户管理&gt;&gt;</div>
	 </div>
<div class="content">
<table class="list">
  <tbody>
  <tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>
    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
  </tr>
  <c:forEach var="users" items="${pageScope.users}" varStatus="">
  <tr>
    <td height="23"><span class="STYLE1">${users.uid}</span></td>
    <td><span class="STYLE1">
    <c:if test="${pageScope.role=='admin权限'||pageScope.usname==users.username}">
    <a href="userAdd.jsp?uid=${users.uid}" >${users.username}</a>
    </c:if>
    <c:if test="${pageScope.role=='普通用户权限'&&pageScope.usname!=users.username}">
    ${users.username}
    </c:if>
    </span></td>
    <td><span class="STYLE1">${users.gender}</span></td>
    <td><span class="STYLE1">${users.age}</span></td>
    <td><span class="STYLE1">${users.phone}</span></td>
    <td><span class="STYLE1">${users.address}</span></td>
    <td><span class="STYLE1">${users.role}</span></td>
  </tr>
  </c:forEach>
  </tbody>
</table>
</div>
</div>
</body>
</html>