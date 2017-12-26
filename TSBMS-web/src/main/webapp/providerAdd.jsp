<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="islogin.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	function checksname(){
		var sname = document.getElementById("sname").value;
		var span2 = document.getElementById("ssname");
		var flag = false;
		$.ajax({
			"async":false,
			"url":"${pageContext.request.contextPath}/SupplierAction_isSupplierName.action",
			"data":{"sname":sname},
			"type":"POST",
			"dataType":"json",
			"success":function(data){
				flag = data.isExist;
			}
		});
		if(!flag){
			span2.innerHTML="名称重复";
			return false;
		}
		if(null==sname || ""==sname){
			span2.innerHTML="供应商名称不能为空";
			return false;
		}else{
			span2.innerHTML="";
			return true;
		}
	}
	 function checkform(){
	   if(checksname()){
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
	<form id="supplier" name="supplier" method="post" action="SupplierAction_addSupplier.action" onsubmit="return checkform();">
		<div class="content">
		<font color="red"></font>
<input name="flag" value="doAdd" type="hidden"/>
			<table class="box">

			<tbody>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input name="supplier.sname" id="sname" value="${pageScope.supplier.sname}" class="text" type="text" onblur="return checksname();"/><span id="ssname" style="color: red;font-size: 12px "></span></td>
				</tr>
			    <tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="supplier.decription" id="decription" cols="45" rows="5">${pageScope.supplier.decription}</textarea></td>
				</tr>
				<tr>
					<td class="field">供应商联系：</td>

					<td><input name="supplier.contacter" id="contacter" value="${pageScope.supplier.contacter}" class="text" type="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name="supplier.phone" id="phone" value="${pageScope.supplier.phone}" class="text" type="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商传真：</td>

					<td><input name="supplier.fax" id="fax" value="${pageScope.supplier.fax}" class="text" type="text"/></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="supplier.address" id="address" value="${pageScope.supplier.address}" class="text" type="text"/></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input type="submit" name="submit" value="提交" class="input-button" />
			
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		
		</div>
	</form>
</div>
<c:if test="${isPay eq 'yes'}">
<script type="text/javascript">
alert("添加成功");
</script>
</c:if>
<c:if test="${isPay eq 'no'}">
<script type="text/javascript">
alert("网路故障添加失败！！,添加失败");
</script>
</c:if>
</body>
</html>
