<%@page import="com.rjxy.bean.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  //判断是否登陆
Users user_name=(Users)session.getAttribute("Users");
	if(user_name==null||user_name.getUsername().equals("")){
    out.print("<script>alert('您还没有登陆！请登陆！');window.open('login.jsp','_parent')</script>");
	}
%>