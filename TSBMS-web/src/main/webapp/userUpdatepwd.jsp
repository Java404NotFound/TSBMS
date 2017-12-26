<%@page import="com.rjxy.utils.MD5Utils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="islogin.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	function checkoldpassword() {
		var oldpassword = document.getElementById("oldpassword").value;
		var u_id = document.getElementById("u_id").value;
		var span8 = document.getElementById("soldpassword");
		var reg1 = /^[a-zA-z0-9]{5,20}$/;
		var flag = false;
		$.ajax({
			"async" : false,
			"url" : "UsersAction_findUserPasswordById.action",
			"data" : {
				"users.u_id" : u_id,
				"users.password" : oldpassword
			},
			"type" : "POST",
			"dataType" : "json",
			"success" : function(data) {
				flag = data.isExist;
			}
		});
		if (!flag) {
			span8.innerHTML = "密码不正确";
			return false;
		}

		if (oldpassword == null || oldpassword == "") {
			span8.innerHTML = "密码不能为空";
			return false;
		} else if (reg1.test(oldpassword) == false) {
			span8.innerHTML = "输入的字符不合法";
			return false;
		} else {
			span8.innerHTML = "";
			return true;
		}
	}
	function checkpassword() {
		var password = document.getElementById("password").value;
		var span9 = document.getElementById("spassword");
		var reg3 = /^[a-zA-z0-9]{5,20}$/;
		if (password == null || password == "") {
			span9.innerHTML = "密码不能为空";
			return false;
		} else if (reg3.test(password) == false) {
			span9.innerHTML = "输入的字符不合法";
			return false;
		} else {
			span9.innerHTML = "";
			return true;
		}
	}
	function checkrepassword() {
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		var span10 = document.getElementById("srepassword");
		var reg4 = /^[a-zA-z0-9]{5,20}$/;
		if (password != repassword) {
			span10.innerHTML = "两次密码不一样";
			return false;
		} else if (repassword == null || repassword == "") {
			span10.innerHTML = "密码不能为空";
			return false;
		} else if (reg4.test(repassword) == false) {
			span10.innerHTML = "输入的字符不合法";
			return false;
		} else {
			span10.innerHTML = "";
			return true;
		}
	}
	function checkform() {
		if (checkoldpassword() && checkpassword() && checkrepassword()) {
			return true;
		}
		return false;
	}
</script>
</head>
<%
	String u_id = request.getParameter("u_id");
	request.setAttribute("u_id", u_id);
%>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post"
			action="UsersAction_updateUserPassWord.action"
			onsubmit="return checkform();">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">旧的密码：</td>

						<td><input type="hidden" name="users.u_id" id="u_id"
							value="${u_id}" /> <input type="password" name="oldpassword"
							class="text" id="oldpassword" onblur="return checkoldpassword();" /><span
							id="soldpassword" style="color: red; font-size: 12px"></span></td>
					</tr>
					<tr>
						<td class="field">新的密码：</td>
						<td><input type="password" name="users.password" class="text"
							id="password" onblur="return checkpassword();" /><span
							id="spassword" style="color: red; font-size: 12px"></span></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input type="password" name="repassword" class="text"
							id="repassword" onblur="return checkrepassword();" /><span
							id="srepassword" style="color: red; font-size: 12px"></span></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" /> <input type="submit" name="submit"
					value="修改密码" class="input-button" />
			</div>
		</form>
	</div>
</body>
</html>
