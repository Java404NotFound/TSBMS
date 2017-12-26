package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.rjxy.bean.Users;
import java.util.*;

public final class providerAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tfunction checksname(){\r\n");
      out.write("\t\tvar sname = document.getElementById(\"sname\").value;\r\n");
      out.write("\t\tvar span2 = document.getElementById(\"ssname\");\r\n");
      out.write("\t\tvar flag = false;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\t\"async\":false,\r\n");
      out.write("\t\t\t\"url\":\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/SupplierAction_isSupplierName.action\",\r\n");
      out.write("\t\t\t\"data\":{\"sname\":sname},\r\n");
      out.write("\t\t\t\"type\":\"POST\",\r\n");
      out.write("\t\t\t\"dataType\":\"json\",\r\n");
      out.write("\t\t\t\"success\":function(data){\r\n");
      out.write("\t\t\t\tflag = data.isExist;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tif(!flag){\r\n");
      out.write("\t\t\tspan2.innerHTML=\"名称重复\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(null==sname || \"\"==sname){\r\n");
      out.write("\t\t\tspan2.innerHTML=\"供应商名称不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tspan2.innerHTML=\"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t function checkform(){\r\n");
      out.write("\t   if(checksname()){\r\n");
      out.write("\t   return true;\r\n");
      out.write("\t   }\r\n");
      out.write("\t   return false;\r\n");
      out.write("\t }\r\n");
      out.write("\t\r\n");
      out.write("\tfunction deSupplier(){\r\n");
      out.write("\t\tvar r=confirm(\"是否确认删除\");\r\n");
      out.write("\t\t//确认删除\r\n");
      out.write("\t\tif(r==true){\r\n");
      out.write("\t\t    document.getElementById(\"form1\").action=\"SupplierServlet?oldsid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.supplier.sid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&button2=1\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"form1\").submit();\r\n");
      out.write("\t    }\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction updateSupplier(){\r\n");
      out.write("    \tvar ck=checkform();\r\n");
      out.write("    \tif(ck==true){\r\n");
      out.write("    \t   var rr=confirm(\"确认修改供货商信息吗？\");\r\n");
      out.write("    \t   //确认修改\r\n");
      out.write("    \t   if(rr==true){\r\n");
      out.write("    \t    document.getElementById(\"form1\").action=\"SupplierServlet?oldsid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.supplier.sid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&button1=2\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"form1\").submit();\r\n");
      out.write("\t       }\r\n");
      out.write("\t    }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("\t<div class=\"optitle clearfix\">\r\n");
      out.write("\t\t<div class=\"title\">供应商管理&gt;&gt;</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<form id=\"supplier\" name=\"supplier\" method=\"post\" action=\"SupplierAction_addSupplier.action\" onsubmit=\"return checkform();\">\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t<font color=\"red\"></font>\r\n");
      out.write("<input name=\"flag\" value=\"doAdd\" type=\"hidden\"/>\r\n");
      out.write("\t\t\t<table class=\"box\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"field\">供应商名称：</td>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"supplier.sname\" id=\"sname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.supplier.sname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\" onblur=\"return checksname();\"/><span id=\"ssname\" style=\"color: red;font-size: 12px \"></span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"field\">供应商描述：</td>\r\n");
      out.write("\t\t\t\t\t<td><textarea name=\"supplier.decription\" id=\"decription\" cols=\"45\" rows=\"5\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.supplier.decription}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"field\">供应商联系：</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td><input name=\"supplier.contacter\" id=\"contacter\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.supplier.contacter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"field\">供应商电话：</td>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"supplier.phone\" id=\"phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.supplier.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"field\">供应商传真：</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td><input name=\"supplier.fax\" id=\"fax\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.supplier.fax}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"field\">供应商地址：</td>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"supplier.address\" id=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.supplier.address}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text\" type=\"text\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"buttons\">\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"submit\" value=\"提交\" class=\"input-button\" />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"button\" name=\"button\" value=\"返回\" class=\"input-button\" onclick=\"history.back();\" />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
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
    // /providerAdd.jsp(116,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isPay eq 'yes'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("alert(\"添加成功\");\r\n");
        out.write("</script>\r\n");
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
    // /providerAdd.jsp(121,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isPay eq 'no'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("alert(\"网路故障添加失败！！,添加失败\");\r\n");
        out.write("</script>\r\n");
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
}
