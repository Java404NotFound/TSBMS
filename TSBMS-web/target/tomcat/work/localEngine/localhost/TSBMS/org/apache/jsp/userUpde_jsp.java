package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.rjxy.bean.Users;
import java.util.*;

public final class userUpde_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/islogin.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
  //判断是否登陆
Users user_name=(Users)session.getAttribute("Users");
	if(user_name==null||user_name.getUsername().equals("")){
    out.print("<script>alert('您还没有登陆！请登陆！');window.open('login.jsp','_parent')</script>");
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction checkusername() {\r\n");
      out.write("\t\tvar username = document.getElementById(\"username\").value;\r\n");
      out.write("\t\tvar span2 = document.getElementById(\"susername\");\r\n");
      out.write("\t\tvar flag = false;\r\n");
      out.write("\t\tif (null == username || \"\" == username) {\r\n");
      out.write("\t\t\tspan2.innerHTML = \"用户名不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan2.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkpassword() {\r\n");
      out.write("\t\tvar password = document.getElementById(\"password\").value;\r\n");
      out.write("\t\tvar span9 = document.getElementById(\"spassword\");\r\n");
      out.write("\t\tvar reg3 = /^[a-zA-z0-9]{5,20}$/;\r\n");
      out.write("\t\tif (password == null || password == \"\") {\r\n");
      out.write("\t\t\tspan9.innerHTML = \"密码不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (reg3.test(password) == false) {\r\n");
      out.write("\t\t\tspan9.innerHTML = \"输入的字符不合法\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan9.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkrepassword() {\r\n");
      out.write("\t\tvar password = document.getElementById(\"password\").value;\r\n");
      out.write("\t\tvar repassword = document.getElementById(\"repassword\").value;\r\n");
      out.write("\t\tvar span10 = document.getElementById(\"srepassword\");\r\n");
      out.write("\t\tvar reg4 = /^[a-zA-z0-9]{5,20}$/;\r\n");
      out.write("\t\tif (password != repassword) {\r\n");
      out.write("\t\t\tspan10.innerHTML = \"两次密码不一样\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (repassword == null || repassword == \"\") {\r\n");
      out.write("\t\t\tspan10.innerHTML = \"密码不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (reg4.test(repassword) == false) {\r\n");
      out.write("\t\t\tspan10.innerHTML = \"输入的字符不合法\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan10.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkage() {\r\n");
      out.write("\t\tvar age = document.getElementById(\"age\").value;\r\n");
      out.write("\t\tvar span3 = document.getElementById(\"sage\");\r\n");
      out.write("\t\tvar reg5 = /^[1-9]\\d{0,2}$/;\r\n");
      out.write("\t\tif (null == age || \"\" == age) {\r\n");
      out.write("\t\t\tspan3.innerHTML = \"年龄不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (reg5.test(age) == false) {\r\n");
      out.write("\t\t\tspan3.innerHTML = \"年龄不合法\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan3.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkphone() {\r\n");
      out.write("\t\tvar phone = document.getElementById(\"phone\").value;\r\n");
      out.write("\t\tvar span5 = document.getElementById(\"sphone\");\r\n");
      out.write("\t\tif (null == phone || \"\" == phone) {\r\n");
      out.write("\t\t\tspan5.innerHTML = \"电话不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan5.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction checkform() {\r\n");
      out.write("\t\tif (checkphone() && checkage() && checkrepassword() && checkpassword()\r\n");
      out.write("\t\t\t\t&& checkusername() && checkuid()) {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction deUser() {\r\n");
      out.write("\t\tvar r = confirm(\"是否确认删除\");\r\n");
      out.write("\t\t//确认删除\r\n");
      out.write("\t\tif (r == true) {\r\n");
      out.write("\t\t\tdocument.getElementById(\"form1\").action = \"UsersAction_deleteUser.action\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"form1\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction updateUser() {\r\n");
      out.write("\r\n");
      out.write("\t\tif (checkphone() && checkage() && checkusername() ) {\r\n");
      out.write("\t\t\tvar rr = confirm(\"确认修改用户信息吗？\");\r\n");
      out.write("\t\t\t//确认修改\r\n");
      out.write("\t\t\tif (rr == true) {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"form1\").action = \"UsersAction_updateUser.action\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"form1\").submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction updatepwd() {\r\n");
      out.write("\t\tlocation.href = \"userUpdatepwd.jsp?u_id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.u_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&password=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.password}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"optitle clearfix\">\r\n");
      out.write("\t\t\t<div class=\"title\">用户管理&gt;&gt;</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form id=\"form1\" name=\"form1\" method=\"post\"\r\n");
      out.write("\t\t\taction=\"UsersAction_addUser.action\" onsubmit=\"return checkform();\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"flag\" value=\"doAdd\" />\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<table class=\"box\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"field\">用户ID：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"users.u_id\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"users.u_id\" onblur=\"return checkusername();\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.u_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" readonly=\"readonly\" /><span id=\"u_id\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户名称：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"users.username\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"username\" onblur=\"return checkusername();\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /><span id=\"susername\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户性别：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><select name=\"users.gender\" id=\"gender\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"女\">女</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"男\">男</option>\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户年龄：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"users.age\" class=\"text\" id=\"age\"\r\n");
      out.write("\t\t\t\t\t\t\tonblur=\"return checkage();\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.age}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /><span\r\n");
      out.write("\t\t\t\t\t\t\tid=\"sage\" style=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户电话：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"users.phone\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"phone\" onblur=\"return checkphone();\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /><span\r\n");
      out.write("\t\t\t\t\t\t\tid=\"sphone\" style=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户地址：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><textarea name=\"users.address\" id=\"address\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tcols=\"45\" rows=\"5\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.address}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户权限：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"users.role\" id=\"role1\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" readonly=\"readonly\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"buttons\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"button\" value=\"返回\" class=\"input-button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"history.back();\" /> <input type=\"button\" name=\"ubutton\"\r\n");
      out.write("\t\t\t\t\tvalue=\"修改\" class=\"input-button\" onclick=\"updateUser();\" /> <input\r\n");
      out.write("\t\t\t\t\ttype=\"button\" name=\"dbutton\" value=\"删除\" class=\"input-button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"deUser();\" /> <input type=\"button\" name=\"uubutton\"\r\n");
      out.write("\t\t\t\t\tvalue=\"修改密码\" class=\"input-button\" onclick=\"updatepwd();\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
