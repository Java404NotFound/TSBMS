<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="islogin.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
  function exitsys(){
  	var r=confirm("你要退出系统吗");
  	if(r==true){
  		window.location.href="UsersAction_logoutUser.action";
  	}
  }
</script>
</head>
<%
	String role=(String)session.getAttribute("role");
 %>
<body class="frame-bd">
<ul class="left-menu">
    <li><a href="BillAction_findBillList.action" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
	<li><a href="SupplierAction_findSupplierList.action" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
	<li><a href="UsersAction_findUsersList.action" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
	<li><a href="#"  onclick="exitsys()" ><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
