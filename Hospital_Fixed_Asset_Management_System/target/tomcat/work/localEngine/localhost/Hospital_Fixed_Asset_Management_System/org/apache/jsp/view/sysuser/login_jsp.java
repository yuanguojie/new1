package org.apache.jsp.view.sysuser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html  PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("\r\n");
      out.write("<title>医院固定资产管理系统</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui-1.5.2/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui-1.5.2/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/common.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/login.css\">\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui-1.5.2/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui-1.5.2/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui-1.5.2/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jQuery.md5.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function changeCheckCode(){\r\n");
      out.write("\t  var src=$(\"#checkCode\").attr(\"src\");\r\n");
      out.write("\t   $(\"#checkCode\").attr(\"src\",src);\r\n");
      out.write("}\r\n");
      out.write("// 去除掉登录信息\r\n");
      out.write("function getPrefix(){\r\n");
      out.write("\r\n");
      out.write("\tvar arr=location.href.split('/');\r\n");
      out.write("\tif (arr.length>0){\r\n");
      out.write("\t\treturn \"/\"+arr[3]+\"/\";\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\treturn \"/\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function out(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t    type : \"post\",\r\n");
      out.write("\t    url : getPrefix()+\"/logout\",\r\n");
      out.write("\t    data : {\r\n");
      out.write("\t        \r\n");
      out.write("\t    },\r\n");
      out.write("\t    async:false,\r\n");
      out.write("\t    success : function(data) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    },\r\n");
      out.write("\t    error : function(data) {\r\n");
      out.write("\t        alert(\"处理出现异常...\");\r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("out();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   $(function () {\r\n");
      out.write("\t\r\n");
      out.write("\tvar $footer=$(\".loginfooter\");\r\n");
      out.write("   $footer.css(\"line-height\",$footer.height()+\"px\");\r\n");
      out.write("\r\n");
      out.write("   $(\".easyui-textbox\").textbox('clear');\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   $(\"#loginbtn\").click(function(){\r\n");
      out.write("\r\n");
      out.write("\t   $(\"#login\").form('submit',{\r\n");
      out.write("\t\t   onSubmit:function(){\r\n");
      out.write("\t\t\t   var result=false;\r\n");
      out.write("\t\t\t  if ($(\"[name='userCode']\").val()==\"\"){\r\n");
      out.write("\t\t\t\t  $(\"#msg\").html(\"请输入用户编码\");\r\n");
      out.write("\t\t\t\t   return false;\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t\t  if ($(\"#password\").val()==\"\"){\r\n");
      out.write("\t\t\t\t    $(\"#msg\").html(\"请输入密码\");\r\n");
      out.write("\t\t\t\t\t return false;\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t    $(\"[name='PassWord']\").val($.md5( $(\"#password\").val()));\r\n");
      out.write("\t\t\t    $(\"[name='sysRoleId']\").val($(\"#Type\").val())\r\n");
      out.write("\r\n");
      out.write("\t\t   },\r\n");
      out.write("\t\t   success:function(data){\r\n");
      out.write("\t\t\t   var data = eval('(' + data + ')');\r\n");
      out.write("\t\t        if (data.success){\r\n");
      out.write("\t\t        \tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"+data.url;   \r\n");
      out.write("\t\t        }  else{\r\n");
      out.write("\t\t        \t $(\"#msg\").html(data.message);\r\n");
      out.write("\t\t        \t $(\"#login\").form(\"clear\");\r\n");
      out.write("\t\t        \t/* $.messager.show({\r\n");
      out.write("\t\t        \t\ttitle:\"信息提示\",\r\n");
      out.write("\t\t        \t\tmsg:\"<div style='color:red;font-size: 15px'>\"+data.message+\"</div>\",\r\n");
      out.write("\t\t        \t\ttimeout:2000,\r\n");
      out.write("\t\t        \t\tshowType:'slide'\r\n");
      out.write("\r\n");
      out.write("\t\t        \t}); */\r\n");
      out.write("\t\t        }  \r\n");
      out.write("\t\t   }\r\n");
      out.write("\t   })\r\n");
      out.write("\t   \r\n");
      out.write("   })\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"loginTop\"></div>\r\n");
      out.write("\t<div class=\"loginCentr\">\r\n");
      out.write("\t\t<form id=\"login\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/login\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class='divCenter'>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<select id=\"Type\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rolelist}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<input name=\"sysRoleId\" type=\"hidden\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<input name=\"LoginAccount\" class=\"easyui-textbox\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"prompt:'用户编码',iconCls:'icon-man',iconWidth:38\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<input id=\"password\" class=\"easyui-textbox\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"prompt:'5-7位密码',iconCls:'icon-lock',iconWidth:38\">\r\n");
      out.write("\t\t\t\t\t<input name=\"PassWord\" type=\"hidden\" type=\"text\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<button id=\"loginbtn\" type=\"button\">登 录</button>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"msg\" style=\"margin-top: -6px;color:red;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"loginfooter\">\r\n");
      out.write("\t\tCopyright © 2017-2019 <a href='#'>医院固定资产管理系统</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
