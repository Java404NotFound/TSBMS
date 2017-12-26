package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.rjxy.utils.MD5Utils;
import java.util.*;
import com.rjxy.bean.Users;
import java.util.*;

public final class userUpdatepwd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("<script src=\"js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction checkoldpassword() {\r\n");
      out.write("\t\tvar oldpassword = document.getElementById(\"oldpassword\").value;\r\n");
      out.write("\t\tvar u_id = document.getElementById(\"u_id\").value;\r\n");
      out.write("\t\tvar span8 = document.getElementById(\"soldpassword\");\r\n");
      out.write("\t\tvar reg1 = /^[a-zA-z0-9]{5,20}$/;\r\n");
      out.write("\t\tvar flag = false;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\t\"async\" : false,\r\n");
      out.write("\t\t\t\"url\" : \"UsersAction_findUserPasswordById.action\",\r\n");
      out.write("\t\t\t\"data\" : {\r\n");
      out.write("\t\t\t\t\"users.u_id\" : u_id,\r\n");
      out.write("\t\t\t\t\"users.password\" : oldpassword\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\"type\" : \"POST\",\r\n");
      out.write("\t\t\t\"dataType\" : \"json\",\r\n");
      out.write("\t\t\t\"success\" : function(data) {\r\n");
      out.write("\t\t\t\tflag = data.isExist;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tif (!flag) {\r\n");
      out.write("\t\t\tspan8.innerHTML = \"密码不正确\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (oldpassword == null || oldpassword == \"\") {\r\n");
      out.write("\t\t\tspan8.innerHTML = \"密码不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (reg1.test(oldpassword) == false) {\r\n");
      out.write("\t\t\tspan8.innerHTML = \"输入的字符不合法\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan8.innerHTML = \"\";\r\n");
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
      out.write("\tfunction checkform() {\r\n");
      out.write("\t\tif (checkoldpassword() && checkpassword() && checkrepassword()) {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");

	String u_id = request.getParameter("u_id");
	request.setAttribute("u_id", u_id);

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"optitle clearfix\">\r\n");
      out.write("\t\t\t<div class=\"title\">用户管理&gt;&gt;</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form id=\"form1\" name=\"form1\" method=\"post\"\r\n");
      out.write("\t\t\taction=\"UsersAction_updateUserPassWord.action\"\r\n");
      out.write("\t\t\tonsubmit=\"return checkform();\">\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<table class=\"box\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">旧的密码：</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"hidden\" name=\"users.u_id\" id=\"u_id\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /> <input type=\"password\" name=\"oldpassword\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"text\" id=\"oldpassword\" onblur=\"return checkoldpassword();\" /><span\r\n");
      out.write("\t\t\t\t\t\t\tid=\"soldpassword\" style=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">新的密码：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" name=\"users.password\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"password\" onblur=\"return checkpassword();\" /><span\r\n");
      out.write("\t\t\t\t\t\t\tid=\"spassword\" style=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">确认密码：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" name=\"repassword\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"repassword\" onblur=\"return checkrepassword();\" /><span\r\n");
      out.write("\t\t\t\t\t\t\tid=\"srepassword\" style=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"buttons\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"button\" value=\"返回\" class=\"input-button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"history.back();\" /> <input type=\"submit\" name=\"submit\"\r\n");
      out.write("\t\t\t\t\tvalue=\"修改密码\" class=\"input-button\" />\r\n");
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
