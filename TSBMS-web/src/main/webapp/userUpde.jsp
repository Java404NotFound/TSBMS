<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="islogin.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	function checkusername() {
		var username = document.getElementById("username").value;
		var span2 = document.getElementById("susername");
		var flag = false;
		if (null == username || "" == username) {
			span2.innerHTML = "用户名不能为空";
			return false;
		} else {
			span2.innerHTML = "";
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
	function checkage() {
		var age = document.getElementById("age").value;
		var span3 = document.getElementById("sage");
		var reg5 = /^[1-9]\d{0,2}$/;
		if (null == age || "" == age) {
			span3.innerHTML = "年龄不能为空";
			return false;
		} else if (reg5.test(age) == false) {
			span3.innerHTML = "年龄不合法";
			return false;
		} else {
			span3.innerHTML = "";
			return true;
		}
	}
	function checkphone() {
		var phone = document.getElementById("phone").value;
		var span5 = document.getElementById("sphone");
		if (null == phone || "" == phone) {
			span5.innerHTML = "电话不能为空";
			return false;
		} else {
			span5.innerHTML = "";
			return true;
		}
	}

	function checkform() {
		if (checkphone() && checkage() && checkrepassword() && checkpassword()
				&& checkusername() && checkuid()) {
			return true;
		}
		return false;
	}

	function deUser() {
		var r = confirm("是否确认删除");
		//确认删除
		if (r == true) {
			document.getElementById("form1").action = "UsersAction_deleteUser.action";
			document.getElementById("form1").submit();
		}
	}
	function updateUser() {

		if (checkphone() && checkage() && checkusername() ) {
			var rr = confirm("确认修改用户信息吗？");
			//确认修改
			if (rr == true) {
				document.getElementById("form1").action = "UsersAction_updateUser.action";
				document.getElementById("form1").submit();
			}
		}
	}
	function updatepwd() {
		location.href = "userUpdatepwd.jsp?u_id=${user.u_id}&password=${user.password}";
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post"
			action="UsersAction_addUser.action" onsubmit="return checkform();">
			<input type="hidden" name="flag" value="doAdd" />
			<div class="content">
				<table class="box">
				<tr>
			<td class="field">用户ID：</td>
						<td><input type="text" name="users.u_id" class="text"
							id="users.u_id" onblur="return checkusername();"
							value="${user.u_id}" readonly="readonly" /><span id="u_id"
							style="color: red; font-size: 12px"></span></td>
				</tr>
					<tr>
						<td class="field">用户名称：</td>
						<td><input type="text" name="users.username" class="text"
							id="username" onblur="return checkusername();"
							value="${user.username}" /><span id="susername"
							style="color: red; font-size: 12px"></span></td>
					</tr>
					<tr>
						<td class="field">用户性别：</td>
						<td><select name="users.gender" id="gender">
								<option value="女">女</option>
								<option value="男">男</option>
						</select></td>
					</tr>
					<tr>
						<td class="field">用户年龄：</td>
						<td><input type="text" name="users.age" class="text" id="age"
							onblur="return checkage();" value="${user.age}" /><span
							id="sage" style="color: red; font-size: 12px"></span></td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td><input type="text" name="users.phone" class="text"
							id="phone" onblur="return checkphone();" value="${user.phone}" /><span
							id="sphone" style="color: red; font-size: 12px"></span></td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td><textarea name="users.address" id="address" class="text"
								cols="45" rows="5">${user.address}</textarea></td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td><input type="text" name="users.role" id="role1"
							value="${user.role }" readonly="readonly" /></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" /> <input type="button" name="ubutton"
					value="修改" class="input-button" onclick="updateUser();" /> <input
					type="button" name="dbutton" value="删除" class="input-button"
					onclick="deUser();" /> <input type="button" name="uubutton"
					value="修改密码" class="input-button" onclick="updatepwd();" />

			</div>
		</form>
	</div>
</body>
</html>
