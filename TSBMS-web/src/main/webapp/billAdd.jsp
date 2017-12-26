<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="islogin.jsp"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	function checkbid() {
		var insertInfo = document.getElementById("b_Id").value;

		var span1 = document.getElementById("sbid");
		var reg = /^[1-9]\d*$/;
		if (null == insertInfo || "" == insertInfo) {
			span1.innerHTML = "账单编号不能为空";
			return false;
		} else if (reg.test(insertInfo) == false) {
			span1.innerHTML = "账单编号必须为数字，非0开头";
			return false;
		} else {
			span1.innerHTML = "";
			return true;
		}
	}
	function checkmoney() {
		var moneys = document.getElementById("money").value;
		var span2 = document.getElementById("smoney");
		var reg1 = /^[1-9]\d*(\.\d+)*$/;
		if (null == moneys || "" == moneys) {
			span2.innerHTML = "交易金额不能为空";
			return false;
		} else if (reg1.test(moneys) == false) {
			span2.innerHTML = "交易金额不正确";
			return false;
		} else {
			span2.innerHTML = "";
			return true;
		}
	}
	function checkunit() {
		var units = document.getElementById("unit").value;
		var span3 = document.getElementById("sunit");
		if (null == units || "" == units) {
			span3.innerHTML = "商品单位不能为空";
			return false;
		} else {
			span3.innerHTML = "";
			return true;
		}
	}
	function checkamount() {
		var amount = document.getElementById("amount").value;
		var span4 = document.getElementById("samount");
		var reg2 = /^[1-9]\d*$/;
		if (null == amount || "" == amount) {
			span4.innerHTML = "商品数量不能为空";
			return false;
		} else if (reg2.test(amount) == false) {
			span4.innerHTML = "商品数量必须为数字，非0开头";
			return false;
		} else {
			span4.innerHTML = "";
			return true;
		}
	}
	function checkproductName() {
		var productName = document.getElementById("productName").value;
		var span5 = document.getElementById("sproductName");
		if (null == productName || "" == productName) {
			span5.innerHTML = "商品名称不能为空";
			return false;
		} else {
			span5.innerHTML = "";
			return true;
		}
	}
	function checksname() {
		var sname = document.getElementById("sname");
		var span6 = document.getElementById("ssname");
		var index = sname.selectedIndex; // 选中索引 
		var text = sname.options[index].text; // 选中文本
		var snvalue = sname.options[index].value; // 选中值
		if ("" == snvalue) {
			span6.innerHTML = "请选择供应商";
			return false;
		} else {
			span6.innerHTML = "";
			return true;
		}
	}
	function checkform() {
		if (checksname() && checkproductName() && checkamount() && checkunit()
				&& checkmoney() && checkbid()) {
			return true;
		}
		return false;
	}

	function deBill() {
		var r = confirm("是否确认删除");
		//确认删除
		if (r == true) {
			document.getElementById("form2").action = "BillServlet?oldbid=${pageScope.bill.bid}&button2=1";
			document.getElementById("form2").submit();
		}
	}
	function updateBill() {
		var ck = checkform();
		if (ck == true) {
			var rr = confirm("确认修改账单信息吗？");
			//确认修改
			if (rr == true) {
				document.getElementById("form2").action = "BillServlet?oldbid=${pageScope.bill.bid}&button1=2";
				document.getElementById("form2").submit();
			}
		}
	}
</script>
<script type="text/javascript">
	$(function() {
		//页面加载完毕后去异步获得分类数据
		$
				.post(
						"${pageContext.request.contextPath}/BillAction_findBillSupplierNameList.action",
						function(data) {
							//[{"cid":"xx","cname":"xxx"},{},{}]
							//拼接多个<option value=""></option>放到select中
							var content = "";
							for (var i = 0; i < data.length; i++) {
								content += "<option value='"+data[i].sname+"'>"
										+ data[i].sname + "</option>";
							}
							$("#sname").html(content);
						}, "json");

	});
</script>






<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<em></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" id="bill" name="bill"
			action="BillAction_billAdd.action" onsubmit="return checkform();">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" name="bill.productName"
							id="productName" class="text"
							value="${pageScope.bill.productName}"
							onblur="return checkproductName();" /><span id="sproductName"
							style="color: red; font-size: 12px"></span></td>
					</tr>
					<tr>
						<td class="field">交易金额：</td>
						<td><input type="text" name="bill.money" id="money"
							class="text" value="${pageScope.bill.money}"
							onblur="return checkmoney();" /><span id="smoney"
							style="color: red; font-size: 12px"></span></td>
					</tr>
					<tr>
						<td class="field">交易单位：</td>
						<td><input type="text" name="bill.unit" id="unit"
							class="text" value="${pageScope.bill.unit}"
							onblur="return checkunit();" /><span id="sunit"
							style="color: red; font-size: 12px"></span></td>
					</tr>
					<tr>
						<td class="field">交易数量：</td>
						<td><input type="text" name="bill.amount" id="amount"
							class="text" value="${pageScope.bill.amount}"
							onblur="return checkamount();" /><span id="samount"
							style="color: red; font-size: 12px"></span></td>
					</tr>

					<tr>
						<td class="field">商品描述：</td>
						<td><textarea name="bill.description">${pageScope.bill.description}</textarea></td>
					</tr>
					<tr>
						<td class="field">所属供应商：</td>
						<td><select id="sname" name="bill.sname"
							onblur="return checksname();">
						</select></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="bill.isPay">
								<option value="已付款">是</option>
								<option value="未付款">否</option>

						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">

				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
			</div>
		</form>
	</div>
	<c:if test="${addisPay eq 'yes'}">
		<script type="text/javascript">
			alert("添加成功");
		</script>
	</c:if>
	<c:if test="${addisPay eq 'no'}">
		<script type="text/javascript">
			alert("网路故障添加失败！！,添加失败");
		</script>
	</c:if>
</body>
</html>
