package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.rjxy.bean.Users;
import java.util.*;

public final class providerUpde_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction checksname() {\r\n");
      out.write("\t\tvar sname = document.getElementById(\"sname\").value;\r\n");
      out.write("\t\tvar span2 = document.getElementById(\"ssname\");\r\n");
      out.write("\t\tif (null == sname || \"\" == sname) {\r\n");
      out.write("\t\t\tspan2.innerHTML = \"供应商名称不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan2.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkform() {\r\n");
      out.write("\t\tif (checksname()) {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction deSupplier() {\r\n");
      out.write("\t\tvar r = confirm(\"是否确认删除\");\r\n");
      out.write("\t\t//确认删除\r\n");
      out.write("\t\tif (r == true) {\r\n");
      out.write("\t\t\tdocument.getElementById(\"supplier\").action = \"SupplierAction_deleteSupplier.action\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"supplier\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction updateSupplier() {\r\n");
      out.write("\t\tvar ck = checkform();\r\n");
      out.write("\t\tif (ck == true) {\r\n");
      out.write("\t\t\tvar rr = confirm(\"确认修改供货商信息吗？\");\r\n");
      out.write("\t\t\t//确认修改\r\n");
      out.write("\t\t\tif (rr == true) {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"supplier\").action = \"SupplierAction_updateSupplier.action\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"supplier\").submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"optitle clearfix\">\r\n");
      out.write("\t\t\t<div class=\"title\">供应商管理&gt;&gt;</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form id=\"supplier\" name=\"supplier\" method=\"post\"\r\n");
      out.write("\t\t\taction=\"SupplierAction_addSupplier.action\"\r\n");
      out.write("\t\t\tonsubmit=\"return checkform();\">\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<font color=\"red\"></font> <input name=\"flag\" value=\"doAdd\"\r\n");
      out.write("\t\t\t\t\ttype=\"hidden\" />\r\n");
      out.write("\t\t\t\t<table class=\"box\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"field\">供应商编号：</td>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"supplier.s_id\" id=\"sid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Supplier.s_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\" onblur=\"return checksid();\"  readonly=\"readonly\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"field\">供应商名称：</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"supplier.sname\" id=\"sname\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Supplier.sname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tonblur=\"return checksname();\" /><span id=\"ssname\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"field\">供应商描述：</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><textarea name=\"supplier.decription\" id=\"decription\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tcols=\"45\" rows=\"5\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Supplier.decription}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"field\">供应商联系：</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"supplier.contacter\" id=\"contacter\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Supplier.contacter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\" /></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"field\">供应商电话：</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"supplier.phone\" id=\"phone\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Supplier.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\" /></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"field\">供应商传真：</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"supplier.fax\" id=\"fax\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Supplier.fax}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\" /></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"field\">供应商地址：</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"supplier.address\" id=\"address\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Supplier.address}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\" /></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"buttons\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"button\" value=\"返回\" class=\"input-button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"history.back();\" /> <input type=\"button\" name=\"ubutton\"\r\n");
      out.write("\t\t\t\t\tvalue=\"修改\" class=\"input-button\" onclick=\"updateSupplier();\" /> <input\r\n");
      out.write("\t\t\t\t\ttype=\"button\" name=\"dbutton\" value=\"删除\" class=\"input-button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"deSupplier();\" />\r\n");
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
