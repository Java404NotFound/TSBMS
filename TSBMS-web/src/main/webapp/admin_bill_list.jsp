<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	function nextPage2(page) {
		$('#currentCount').val(page);
		var myform = $("#myForm2").serialize();
		$.post("BillAction_findBillList.action", myform, function(data) {
			$("#div2").empty();
			$("#div2").html(data);

		});
	}
	function deBill() {
		var r = confirm("是否确认删除");
		//确认删除
		if (r == true) {
			document.getElementById("deleteForm").submit();
		}
	}
	function nextPage(val) {
		$('#currentCount').val(val);
		$('#myForm2').get(0).submit();
	}
</script>
</head>
<%@ include file="islogin.jsp"%>
<body>
	<div id="div2">
		<div class="menu">
			<form id="myForm2" name="myForm2" method="post"
				action="BillAction_findBillList.action">
				<input type="hidden" name="currentCount" id="currentCount" value="1" />
				商品名称：<input type="text" name="productname" class="input-text"
					value="${productname}" />&nbsp;&nbsp;&nbsp;&nbsp; 是否付款：<select
					name="isPay">
					<option value="">请选择</option>
					<c:if test="${isPay eq '已付款'}">
						<option value="已付款" selected="selected">已付款</option>
					</c:if>
					<c:if test="${isPay != '已付款'}">
						<option value="已付款">已付款</option>
					</c:if>
					<c:if test="${isPay eq '未付款'}">
						<option value="未付款" selected="selected">未付款</option>
					</c:if>
					<c:if test="${isPay != '未付款'}">
						<option value="未付款">未付款</option>
					</c:if>
				</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit1"
					value="组合查询" class="button" />
			</form>
		</div>
		<div class="main">
			<div class="optitle clearfix">
				<em><input type="button" name="button" value="添加数据"
					class="input-button" onclick="location.href='billAdd.jsp'" /></em>
				<div class="title">账单管理&gt;&gt;</div>
			</div>
			<div class="content">

				<c:if test="${billList!=null}">

					<form id="deleteForm" name="deleteFrom"
						action="BillAction_deleteBillByIds.action" method="post">
						<table class="list">
							<tr>
								<!-- 复选框单击方式 -->
								<!-- 按钮方式，本质无区别 -->
								<td align="left"><input name="checkAll" id="checkAll"
									type="button" class="input_hide" value="全选" /><input
									name="reCheck" id="reCheck" type="button" class="input_hide"
									value="反选" /></td>
								<td align="left"><input type="button" onclick="deBill()"
									value="批量删除" /></td>
								<td colspan="7"></td>
							</tr>
							<tr>
								<td></td>
								<td>账单编号</td>
								<td>商品名称</td>
								<td>商品数量</td>
								<td>交易金额</td>
								<td>是否付款</td>
								<td>供应商名称</td>
								<td>商品描述</td>
								<td>账单时间</td>

							</tr>
							<c:if test="${!empty billList.list}">

								<c:forEach items="${billList.list}" var="bill" varStatus="st">
									<tr>
										<td>${st.index}<input name="detelelist[${st.index}]"
											id="groupCheckbox" type="checkbox" value="${bill.b_Id}"
											class="input_hide" /></td>
										<td align="center">${bill.b_Id}</td>
										<c:if test="${Users.role eq 'admin权限'}">
											<td align="center"><a
												href="BillAction_findBillById.action?b_id=${bill.b_Id}">${bill.productName}</a></td>
										</c:if>
										<c:if test="${Users.role eq '普通用户权限'}">
											<td align="center">${bill.productName}</td>
										</c:if>
										<td align="center">${bill.amount}</td>
										<td align="center">${bill.money}</td>
										<td align="center">${bill.isPay}</td>
										<td align="center">${bill.sname}</td>
										<td align="center">${bill.description}</td>
										<td align="center">${bill.tradeTime}</td>
									</tr>
								</c:forEach>

								<tr>
									<td colspan="9" align="right"><a
										href="javascript:nextPage2(${billList.currentCount-1 > 0 ? billList.currentCount-1 : 1})">上一页</a>${billList.currentCount}
										/ ${billList.totalPage} 页 <a
										href="javascript:nextPage2(${billList.currentCount+1 < billList.totalPage ? billList.currentCount+1 : billList.totalPage})">
											下一页</a></td>
								</tr>

							</c:if>

							<c:if test="${empty billList.list}">
								<tr>
									<td colspan="9">抱歉~，~ ，没有找到符合条件的数据</td>
								</tr>
							</c:if>

						</table>
					</form>
				</c:if>
				<c:if test="${billList==null}">
		欢迎使用该系统
		</c:if>
			</div>
		</div>
		<script type="text/javascript">
			$(function() {
				//全选
				$("#checkAll").click(function() {
					$("input[type=checkbox]").attr("checked", true);
				});
				//反选
				$("#reCheck").click(function() {
					$isChecked = $("input:checked");
					$("input[type=checkbox]").attr("checked", true);
					$isChecked.attr("checked", false);
				});

			});
		</script>
	</div>
</body>
</html>
