package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.rjxy.bean.Users;
import java.util.*;

public final class billAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=utf-8");
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
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction checkbid() {\r\n");
      out.write("\t\tvar insertInfo = document.getElementById(\"b_Id\").value;\r\n");
      out.write("\r\n");
      out.write("\t\tvar span1 = document.getElementById(\"sbid\");\r\n");
      out.write("\t\tvar reg = /^[1-9]\\d*$/;\r\n");
      out.write("\t\tif (null == insertInfo || \"\" == insertInfo) {\r\n");
      out.write("\t\t\tspan1.innerHTML = \"账单编号不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (reg.test(insertInfo) == false) {\r\n");
      out.write("\t\t\tspan1.innerHTML = \"账单编号必须为数字，非0开头\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan1.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkmoney() {\r\n");
      out.write("\t\tvar moneys = document.getElementById(\"money\").value;\r\n");
      out.write("\t\tvar span2 = document.getElementById(\"smoney\");\r\n");
      out.write("\t\tvar reg1 = /^[1-9]\\d*(\\.\\d+)*$/;\r\n");
      out.write("\t\tif (null == moneys || \"\" == moneys) {\r\n");
      out.write("\t\t\tspan2.innerHTML = \"交易金额不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (reg1.test(moneys) == false) {\r\n");
      out.write("\t\t\tspan2.innerHTML = \"交易金额不正确\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan2.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkunit() {\r\n");
      out.write("\t\tvar units = document.getElementById(\"unit\").value;\r\n");
      out.write("\t\tvar span3 = document.getElementById(\"sunit\");\r\n");
      out.write("\t\tif (null == units || \"\" == units) {\r\n");
      out.write("\t\t\tspan3.innerHTML = \"商品单位不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan3.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkamount() {\r\n");
      out.write("\t\tvar amount = document.getElementById(\"amount\").value;\r\n");
      out.write("\t\tvar span4 = document.getElementById(\"samount\");\r\n");
      out.write("\t\tvar reg2 = /^[1-9]\\d*$/;\r\n");
      out.write("\t\tif (null == amount || \"\" == amount) {\r\n");
      out.write("\t\t\tspan4.innerHTML = \"商品数量不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (reg2.test(amount) == false) {\r\n");
      out.write("\t\t\tspan4.innerHTML = \"商品数量必须为数字，非0开头\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan4.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkproductName() {\r\n");
      out.write("\t\tvar productName = document.getElementById(\"productName\").value;\r\n");
      out.write("\t\tvar span5 = document.getElementById(\"sproductName\");\r\n");
      out.write("\t\tif (null == productName || \"\" == productName) {\r\n");
      out.write("\t\t\tspan5.innerHTML = \"商品名称不能为空\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan5.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checksname() {\r\n");
      out.write("\t\tvar sname = document.getElementById(\"sname\");\r\n");
      out.write("\t\tvar span6 = document.getElementById(\"ssname\");\r\n");
      out.write("\t\tvar index = sname.selectedIndex; // 选中索引 \r\n");
      out.write("\t\tvar text = sname.options[index].text; // 选中文本\r\n");
      out.write("\t\tvar snvalue = sname.options[index].value; // 选中值\r\n");
      out.write("\t\tif (\"\" == snvalue) {\r\n");
      out.write("\t\t\tspan6.innerHTML = \"请选择供应商\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tspan6.innerHTML = \"\";\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkform() {\r\n");
      out.write("\t\tif (checksname() && checkproductName() && checkamount() && checkunit()\r\n");
      out.write("\t\t\t\t&& checkmoney() && checkbid()) {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction deBill() {\r\n");
      out.write("\t\tvar r = confirm(\"是否确认删除\");\r\n");
      out.write("\t\t//确认删除\r\n");
      out.write("\t\tif (r == true) {\r\n");
      out.write("\t\t\tdocument.getElementById(\"form2\").action = \"BillServlet?oldbid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.bill.bid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&button2=1\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"form2\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction updateBill() {\r\n");
      out.write("\t\tvar ck = checkform();\r\n");
      out.write("\t\tif (ck == true) {\r\n");
      out.write("\t\t\tvar rr = confirm(\"确认修改账单信息吗？\");\r\n");
      out.write("\t\t\t//确认修改\r\n");
      out.write("\t\t\tif (rr == true) {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"form2\").action = \"BillServlet?oldbid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.bill.bid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&button1=2\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"form2\").submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t//页面加载完毕后去异步获得分类数据\r\n");
      out.write("\t\t$\r\n");
      out.write("\t\t\t\t.post(\r\n");
      out.write("\t\t\t\t\t\t\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/BillAction_findBillSupplierNameList.action\",\r\n");
      out.write("\t\t\t\t\t\tfunction(data) {\r\n");
      out.write("\t\t\t\t\t\t\t//[{\"cid\":\"xx\",\"cname\":\"xxx\"},{},{}]\r\n");
      out.write("\t\t\t\t\t\t\t//拼接多个<option value=\"\"></option>放到select中\r\n");
      out.write("\t\t\t\t\t\t\tvar content = \"\";\r\n");
      out.write("\t\t\t\t\t\t\tfor (var i = 0; i < data.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\tcontent += \"<option value='\"+data[i].sname+\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ data[i].sname + \"</option>\";\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#sname\").html(content);\r\n");
      out.write("\t\t\t\t\t\t}, \"json\");\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"optitle clearfix\">\r\n");
      out.write("\t\t\t<em></em>\r\n");
      out.write("\t\t\t<div class=\"title\">账单管理&gt;&gt;</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form method=\"post\" id=\"bill\" name=\"bill\"\r\n");
      out.write("\t\t\taction=\"BillAction_billAdd.action\" onsubmit=\"return checkform();\">\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<table class=\"box\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">商品名称：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"bill.productName\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"productName\" class=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.bill.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\tonblur=\"return checkproductName();\" /><span id=\"sproductName\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">交易金额：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"bill.money\" id=\"money\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.bill.money}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\tonblur=\"return checkmoney();\" /><span id=\"smoney\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">交易单位：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"bill.unit\" id=\"unit\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.bill.unit}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\tonblur=\"return checkunit();\" /><span id=\"sunit\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">交易数量：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"bill.amount\" id=\"amount\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.bill.amount}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\tonblur=\"return checkamount();\" /><span id=\"samount\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red; font-size: 12px\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">商品描述：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><textarea name=\"bill.description\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.bill.description}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">所属供应商：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><select id=\"sname\" name=\"bill.sname\"\r\n");
      out.write("\t\t\t\t\t\t\tonblur=\"return checksname();\">\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"field\">是否付款：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><select name=\"bill.isPay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"已付款\">是</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"未付款\">否</option>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"buttons\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"submit\" name=\"submit\" value=\"确认\" class=\"input-button\" />\r\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"button\" value=\"返回\" class=\"input-button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"history.back();\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('	');
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
    // /billAdd.jsp(219,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addisPay eq 'yes'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<script type=\"text/javascript\">\r\n");
        out.write("\t\t\talert(\"添加成功\");\r\n");
        out.write("\t\t</script>\r\n");
        out.write("\t");
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
    // /billAdd.jsp(224,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addisPay eq 'no'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<script type=\"text/javascript\">\r\n");
        out.write("\t\t\talert(\"网路故障添加失败！！,添加失败\");\r\n");
        out.write("\t\t</script>\r\n");
        out.write("\t");
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
