<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />

</head>
<%@ include file="islogin.jsp"%>
<body>
	<div class="menu">
		<form method="post" action="admin_bill_list.jsp">
			商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
			是否付款：<select name="payStatus">
				<option value="">请选择</option>
				<option value="已付款">已付款</option>
				<option value="未付款">未付款</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="submit"
				value="组合查询" class="button" />
		</form>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" name="button" value="添加数据"
				class="input-button" onclick="location.href='modify.jsp'" /></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<c:if test="${billList!=null}">
				<table class="list">
					<tr>
						<td>账单编号</td>
						<td>商品名称</td>
						<td>商品数量</td>
						<td>交易金额</td>
						<td>是否付款</td>
						<td>供应商名称</td>
						<td>商品描述</td>
						<td>账单时间</td>
					</tr>
					<c:forEach items="${billList.list}" var="bill">
						<tr>
							<td align="center">${bill.b_Id}</td>
							<td align="center"><a href="modify.jsp?bid=${bill.b_Id}">${bill.productName}</a></td>
							<td align="center">${bill.amount}</td>
							<td align="center">${bill.money}</td>
							<td align="center">${bill.isPay}</td>
							<td align="center">${bill.sname}</td>
							<td align="center">${bill.description}</td>
							<td align="center">${bill.tradeTime}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="8" align="right"><a
							href="BillAction_findBillList.action?currentCount=${billList.currentCount-1>0 ? billList.currentCount-1 : 1}">上一页</a>${billList.currentCount}
							/ ${billList.totalPage} 页 <a
							href="BillAction_findBillList.action?currentCount=${billList.currentCount+1>billList.totalPage? billList.totalPage : billList.currentCount+1}">
								下一页</a></td>
					</tr>
				</table>
			</c:if>
			<c:if test="${billList==null}">
		欢迎使用该系统
		</c:if>
		</div>
	</div>
</body>
</html>
