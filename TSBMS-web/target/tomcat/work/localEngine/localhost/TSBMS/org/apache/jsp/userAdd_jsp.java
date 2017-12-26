package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.rjxy.bean.Users;
import java.util.*;

public final class userAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/islogin.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\t\"async\":false,\r\n");
      out.write("\t\t\t\"url\":\"UsersAction_isUserName.action\",\r\n");
      out.write("\t\t\t\"data\":{\"userName\":username},\r\n");
      out.write("\t\t\t\"type\":\"POST\",\r\n");
      out.write("\t\t\t\"dataType\":\"json\",\r\n");
      out.write("\t\t\t\"success\":function(data){\r\n");
      out.write("\t\t\t\tflag = data.isExist;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tif(!flag){\r\n");
      out.write("\t\t\tspan2.innerHTML = \"用户名重复\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
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
      out.write("\t\t\tdocument.getElementById(\"form1\").action = \"UserServlet?olduid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.user.uid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&button2=1\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"form1\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction updateUser() {\r\n");
      out.write("\r\n");
      out.write("\t\tif (checkphone() && checkage() && checkusername() && checkuid()) {\r\n");
      out.write("\t\t\tvar rr = confirm(\"确认修改用户信息吗？\");\r\n");
      out.write("\t\t\t//确认修改\r\n");
      out.write("\t\t\tif (rr == true) {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"form1\").action = \"UserServlet?olduid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.user.uid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&button1=2\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"form1\").submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction updatepwd() {\r\n");
      out.write("\t\tlocation.href = \"userUpdatepwd.jsp?olduid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.user.uid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
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
      out.write("\t\t<form id=\"form1\" name=\"form1\" method=\"post\" action=\"UsersAction_addUser.action\"\r\n");
      out.write("\t\t\tonsubmit=\"return checkform();\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"flag\" value=\"doAdd\" />\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<table class=\"box\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户名称：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"users.username\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"username\" onblur=\"return checkusername();\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /><span id=\"susername\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户密码：</td>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户性别：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><select name=\"users.gender\" id=\"gender\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"女\">女</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"男\">男</option>\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户年龄：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"users.age\" class=\"text\" id=\"age\"\r\n");
      out.write("\t\t\t\t\t\t\tonblur=\"return checkage();\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.user.age}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /><span\r\n");
      out.write("\t\t\t\t\t\t\tid=\"sage\" style=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户电话：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"users.phone\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"phone\" onblur=\"return checkphone();\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.user.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /><span id=\"sphone\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户地址：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><textarea name=\"users.address\" id=\"address\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tcols=\"45\" rows=\"5\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.user.address}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">用户权限：</td>\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"buttons\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"submit\" value=\"数据提交\" class=\"input-button\" />\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"button\" value=\"返回\" class=\"input-button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"history.back();\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /userAdd.jsp(194,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Users.role eq '普通用户权限'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<td><input type=\"radio\" name=\"users.role\" id=\"role1\" value=\"普通用户权限\" />普通用户\r\n");
        out.write("\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /userAdd.jsp(198,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Users.role eq 'admin权限'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<td><input type=\"radio\" name=\"users.role\" id=\"role1\" value=\"普通用户权限\" />普通用户\r\n");
        out.write("\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"users.role\" id=\"role2\" value=\"admin权限\"\r\n");
        out.write("\t\t\t\t\t\t\t\tchecked=\"checked\" />admin权限</td>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /userAdd.jsp(213,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isPay eq 'yes'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("alert(\"添加成功\");\r\n");
        out.write("</script>\r\n");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /userAdd.jsp(218,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isPay eq 'no'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("alert(\"网路故障添加失败！！,添加失败\");\r\n");
        out.write("</script>\r\n");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }
}
