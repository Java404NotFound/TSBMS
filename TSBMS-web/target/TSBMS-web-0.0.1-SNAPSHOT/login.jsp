<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	function checkName(){
		var username=document.getElementById("username").value;
		var span1=document.getElementById("name");
		if(username==null|| username==""){
			span1.innerHTML="用户名不能为空";			
			return false;
		}else{
			span1.innerHTML="";
			return true;
		}
    }
	function checkPassword(){
		var password=document.getElementById("password").value;
		var span1=document.getElementById("pass");
		var reg=/^[a-zA-z0-9]{5,20}$/;
		if(password==null||password==""){
			span1.innerHTML="密码不能为空";
			return false;
		}else if(reg.test(password)==false){
			span1.innerHTML="输入的字符不合法";	
			return false;
		}else{
			span1.innerHTML="";
			return true;
		}
  	}
  	function checklogin(){
  	  if(checkPassword()&&checkName()){
  	  return true;
  	  }else{
  	  return false;
  	  }
  	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form method="post" action="UsersAction_login.action"  name="users" onsubmit="return checklogin();">
			<dl>
				<dt>用户名：</dt>
				<dd><input id="username" type="text" name="users.username" onblur="return checkName();" class="input-text" /><span id="name" style="color: red"></span></dd>
				<dt>密　码：</dt>
				<dd><input id="password" type="password" name="users.password" onblur="return checkPassword();" class="input-text" /><span id="pass" style="color: red"></span></dd>
			</dl>
			<div class="buttons">
				<input type="submit" name="submit" value="登录系统" class="input-button" />
				<input type="reset" name="reset" value="重　　填" class="input-button" /><br />
				<span  id="show" style="color: red">${no}</span>
			</div>
		</form>
	</div>
</div>
</body>
</html>
