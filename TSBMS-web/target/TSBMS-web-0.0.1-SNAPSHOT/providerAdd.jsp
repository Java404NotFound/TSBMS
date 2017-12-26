<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="islogin.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
function checksid(){
		var sid= document.getElementById("sid").value;
		var span1 = document.getElementById("ssid");
		var reg=/^[1-9]\d*$/;
		if(null == sid || ""==sid){
			span1.innerHTML="供应商编号不能为空";  
			return false;
		}else if(reg.test(sid)==false){
			span1.innerHTML="供应商编号必须为数字，非0开头";
			return false;
		}else{
			span1.innerHTML="";
			return true;
		}
	}
	function checksname(){
		var sname = document.getElementById("sname").value;
		var span2 = document.getElementById("ssname");
		if(null==sname || ""==sname){
			span2.innerHTML="供应商名称不能为空";
			return false;
		}else{
			span2.innerHTML="";
			return true;
		}
	}
	 function checkform(){
	   if(checksname()&&checksid()){
	   return true;
	   }
	   return false;
	 }
	
	function deSupplier(){
		var r=confirm("是否确认删除");
		//确认删除
		if(r==true){
		    document.getElementById("form1").action="SupplierServlet?oldsid=${pageScope.supplier.sid}&button2=1";
			document.getElementById("form1").submit();
	    }
	}
	function updateSupplier(){
    	var ck=checkform();
    	if(ck==true){
    	   var rr=confirm("确认修改供货商信息吗？");
    	   //确认修改
    	   if(rr==true){
    	    document.getElementById("form1").action="SupplierServlet?oldsid=${pageScope.supplier.sid}&button1=2";
			document.getElementById("form1").submit();
	       }
	    }
    }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="SupplierServlet" onsubmit="return checkform();">
		<div class="content">
		<font color="red"></font>
<input name="flag" value="doAdd" type="hidden"/>
			<table class="box">

			<tbody><tr>
					<td class="field">供应商编号：</td>
					<td><input name="sid" id="sid" value="${pageScope.supplier.sid}" class="text" type="text" onblur="return checksid();" /><span id="ssid" style="color: red;font-size: 12px "></span></td>
				</tr>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input name="sname" id="sname" value="${pageScope.supplier.sname}" class="text" type="text" onblur="return checksname();"/><span id="ssname" style="color: red;font-size: 12px "></span></td>
				</tr>
			    <tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="decription" id="decription" cols="45" rows="5">${pageScope.supplier.decription}</textarea></td>
				</tr>
				<tr>
					<td class="field">供应商联系：</td>

					<td><input name="contacter" id="contacter" value="${pageScope.supplier.contacter}" class="text" type="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name="phone" id="phone" value="${pageScope.supplier.phone}" class="text" type="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商传真：</td>

					<td><input name="fax" id="fax" value="${pageScope.supplier.fax}" class="text" type="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="address" id="address" value="${pageScope.supplier.address}" class="text" type="text"/></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
		    <c:if test="${pageScope.act!=1}">
			<input type="submit" name="submit" value="提交" class="input-button" />
			</c:if>
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
			<c:if test="${pageScope.act==1}">
			<input type="button" name="ubutton" value="修改" class="input-button" onclick="updateSupplier();"/>
			<input type="button" name="dbutton" value="删除" class="input-button" onclick="deSupplier();" />
			</c:if>
		</div>
	</form>
</div>
</body>
</html>
