package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction checkName(){\r\n");
      out.write("\t\tvar username=document.getElementById(\"username\").value;\r\n");
      out.write("\t\tvar span1=document.getElementById(\"name\");\r\n");
      out.write("\t\tif(username==null|| username==\"\"){\r\n");
      out.write("\t\t\tspan1.innerHTML=\"用户名不能为空\";\t\t\t\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tspan1.innerHTML=\"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("    }\r\n");
      out.write("\tfunction checkPassword(){\r\n");
      out.write("\t\tvar password=document.getElementById(\"password\").value;\r\n");
      out.write("\t\tvar span1=document.getElementById(\"pass\");\r\n");
      out.write("\t\tvar reg=/^[a-zA-z0-9]{5,20}$/;\r\n");
      out.write("\t\tif(password==null||password==\"\"){\r\n");
      out.write("\t\t\tspan1.innerHTML=\"密码不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else if(reg.test(password)==false){\r\n");
      out.write("\t\t\tspan1.innerHTML=\"输入的字符不合法\";\t\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tspan1.innerHTML=\"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction checklogin(){\r\n");
      out.write("  \t  if(checkPassword()&&checkName()){\r\n");
      out.write("  \t  return true;\r\n");
      out.write("  \t  }else{\r\n");
      out.write("  \t  return false;\r\n");
      out.write("  \t  }\r\n");
      out.write("  \t}\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>系统登录 - 超市账单管理系统</title>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"blue-style\">\r\n");
      out.write("<div id=\"login\">\r\n");
      out.write("\t<div class=\"icon\"></div>\r\n");
      out.write("\t<div class=\"login-box\">\r\n");
      out.write("\t\t<form method=\"post\" action=\"UsersAction_login.action\"  name=\"users\" onsubmit=\"return checklogin();\">\r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dt>用户名：</dt>\r\n");
      out.write("\t\t\t\t<dd><input id=\"username\" type=\"text\" name=\"users.username\" onblur=\"return checkName();\" class=\"input-text\" /><span id=\"name\" style=\"color: red\"></span></dd>\r\n");
      out.write("\t\t\t\t<dt>密　码：</dt>\r\n");
      out.write("\t\t\t\t<dd><input id=\"password\" type=\"password\" name=\"users.password\" onblur=\"return checkPassword();\" class=\"input-text\" /><span id=\"pass\" style=\"color: red\"></span></dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t\t<div class=\"buttons\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"submit\" value=\"登录系统\" class=\"input-button\" />\r\n");
      out.write("\t\t\t\t<input type=\"reset\" name=\"reset\" value=\"重　　填\" class=\"input-button\" /><br />\r\n");
      out.write("\t\t\t\t<span  id=\"show\" style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${no}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
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
