<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="islogin.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	function page(val) {
		$('#currentCount').val(val);
		$('#myForm2').get(0).submit();
	}
</script>
</head>

<body>
	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td>
						<form name="myForm2" id="myForm2" method="post"
							action="${pageContext.request.contextPath}/UsersAction_findUsersList.action">
							<input name="currentCount" id="currentCount" value="1"
								class="input-text" type="hidden" /> 用户名称：<input name="userName"
								value="${userName}" class="input-text" type="text" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit" />
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="main">
		<div class="optitle clearfix">
			<em> <input value="添加数据" class="input-button"
				onclick="window.location='userAdd.jsp'" type="button" />
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
						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">地址</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
					</tr>
					<c:if test="${!empty UsersList.list}">
						<c:forEach var="users" items="${UsersList.list}" varStatus="">
							<tr>
								<td height="23"><span class="STYLE1">${users.u_id}</span></td>
								<td><span class="STYLE1">
								
								<c:if test="${ Users.username eq users.username}" >
								<a href="UsersAction_findUserById.action?users.u_id=${users.u_id}"> ${users.username}</a> 
								</c:if>
								<c:if test="${Users.username ne users.username}">
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

						<tr>
							<td colspan="8" align="right"><a
								href="javascript:page(${UsersList.currentCount-1 > 0 ? UsersList.currentCount-1 : 1})">上一页</a>${UsersList.currentCount}
								/ ${UsersList.totalPage} 页 <a
								href="javascript:page(${UsersList.currentCount+1 < UsersList.totalPage ? UsersList.currentCount+1 : UsersList.totalPage})">
									下一页</a></td>
						</tr>
					</c:if>
					<c:if test="${empty UsersList.list}">
						<tr>
							<td colspan="8">抱歉~，~ ，没有找到符合条件的数据</td>
						</tr>
					</c:if>
				</tbody>

			</table>
		</div>
	</div>
		<c:if test="${isPay eq 'yes'}">
		<script type="text/javascript">
			alert("操作成功");
		</script>
	</c:if>
	<c:if test="${isPay eq 'no'}">
		<script type="text/javascript">
			alert("网路故障添加失败！！,操作失败");
		</script>
	</c:if>
</body>
</html>