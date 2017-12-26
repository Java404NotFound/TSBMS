<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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
					<td><form name="myForm2" id="myForm2" method="post"
							action="SupplierAction_findSupplierList.action">
							<input type="hidden" name="currentCount" id="currentCount"
								value="1" /> <input name="flag" value="search" type="hidden" />
							供应商名称：<input name="providerName" class="input-text" type="text"
								value="${providerName}" /> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input
								name="decription" class="input-text" type="text"
								value="${decription}" />&nbsp;&nbsp;&nbsp;&nbsp;<input
								value="组 合 查 询" type="submit" />
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='providerAdd.jsp'" type="button" /></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
						<td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
						<td width="100"><div class="STYLE1" align="center">联系人</div></td>
						<td width="100"><div class="STYLE1" align="center">电话</div></td>
						<td width="100"><div class="STYLE1" align="center">地址</div></td>
					</tr>
					<c:if test="${!empty SupplierList.list}">
						<c:forEach var="suppliers" items="${SupplierList.list}">
							<tr>
								<td width="70" height="29"><div class="STYLE1"
										align="center">${suppliers.s_id}</div></td>
								<td width="80"><div class="STYLE1" align="center">
										<c:if test="${Users.role eq 'admin权限' }">
											<a
												href="SupplierAction_findSupplierById.action?s_id=${suppliers.s_id}">${suppliers.sname}</a>
										</c:if>
										<c:if test="${Users.role eq '普通用户权限' }">
									${suppliers.sname}
									</c:if>
									</div></td>
								<td width="100"><div class="STYLE1" align="center">${suppliers.decription}</div></td>
								<td width="100"><div class="STYLE1" align="center">${suppliers.contacter}</div></td>
								<td width="100"><div class="STYLE1" align="center">${suppliers.phone}</div></td>
								<td width="100"><div class="STYLE1" align="center">${suppliers.address}</div></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="8" align="right"><a
								href="javascript:page(${SupplierList.currentCount-1 > 0 ? SupplierList.currentCount-1 : 1})">上一页</a>${SupplierList.currentCount}
								/ ${SupplierList.totalPage} 页 <a
								href="javascript:page(${SupplierList.currentCount+1 < SupplierList.totalPage ? SupplierList.currentCount+1 : SupplierList.totalPage})">
									下一页</a></td>
						</tr>
					</c:if>
					<c:if test="${empty SupplierList.list}">
						<tr>
							<td colspan="8">抱歉~，~ ，没有找到符合条件的数据</td>
						</tr>
					</c:if>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>