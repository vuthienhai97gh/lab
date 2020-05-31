package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_param_value_name_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_var_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_url_var_value.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_param_value_name_nobody.release();
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js\" integrity=\"sha384-1CmrxMRARb6aLqgBO7yyAxTOQE2AKb9GfXnEo760AUcUmFx3ibVJJAzGytlQcNXd\" crossorigin=\"anonymous\"></script>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Search</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <form action=\"ControllerServlet\" method=\"POST\">\n");
      out.write("                <font color=\"red\">Welcome, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USERID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font>\n");
      out.write("                <!--<input type=\"submit\" value=\"Logout\" name=\"btAction\" />-->\n");
      out.write("                <input class=\"btn btn-primary\" type=\"submit\" value=\"Logout\" name=\"btAction\"><br/>\n");
      out.write("            </form>\n");
      out.write("            <h1 color=\"blue\">List Question</h1>\n");
      out.write("            <form action=\"ControllerServlet\" method=\"POST\">\n");
      out.write("\n");
      out.write("                Subject: <select name=\"cbCategory\">\n");
      out.write("                    <option value=\"All\">\n");
      out.write("                        ALL\n");
      out.write("                    </option>\n");
      out.write("                    <option value=\"PRJ311\">\n");
      out.write("                        PRJ311\n");
      out.write("                    </option>\n");
      out.write("                    <option value=\"PRJ321\">\n");
      out.write("                        PRJ321\n");
      out.write("                    </option>\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("                Status: <select name=\"cbStatus\">\n");
      out.write("                    <option value=\"ALL\">\n");
      out.write("                        ALL\n");
      out.write("                    </option>\n");
      out.write("                    <option value=\"ACTIVE\">\n");
      out.write("                        Active\n");
      out.write("                    </option>\n");
      out.write("                    <option value=\"INACTIVE\">\n");
      out.write("                        InActive\n");
      out.write("                    </option>\n");
      out.write("                </select><br/><br/>\n");
      out.write("\n");
      out.write("<!--Search question : <input type=\"text\" name=\"txtSearchValue\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtSearchValue}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br/>-->\n");
      out.write("                <!-- Search form -->\n");
      out.write("                <input class=\"form-control\" type=\"text\" placeholder=\"Search\" aria-label=\"Search\" name=\"txtSearchValue\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtSearchValue}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br/>\n");
      out.write("                <input class=\"btn btn-primary\" type=\"submit\" value=\"Search\" name=\"action\"><br/><br/>\n");
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("                <nav aria-label=\"Search results pages\">\n");
      out.write("                    <ul class=\"pagination\">\n");
      out.write("                        <li class=\"page-item disabled\" >\n");
      out.write("                            <a class=\"page-link\" href=\"#\" tabindex=\"-1\">Previous</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"page-item\">\n");
      out.write("                            <a class=\"page-link\" href=\"#\">1</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"page-item\">\n");
      out.write("                            <a class=\"page-link\" href=\"#\">2</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"page-item\">\n");
      out.write("                            <a class=\"page-link\" href=\"#\">3</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"page-item\">\n");
      out.write("                            <a class=\"page-link\" href=\"#\">Next</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("dto");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${LISTANSWER}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("counter");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    ");
          if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("\n");
          out.write("                    <form action=\"ControllerServlet\" method=\"POST\">\n");
          out.write("\n");
          out.write("                        <table border=\"2\" class=\"table\">\n");
          out.write("                            <thead>\n");
          out.write("                                <tr>\n");
          out.write("                                    <th colspan=\"2\" >\n");
          out.write("\n");
          out.write("                                        ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(". <input type=\"text\" name=\"txtQuestion\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.key.question_content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" />\n");
          out.write("                                    </th>\n");
          out.write("                                    <th>Answer Correct</th>\n");
          out.write("                                    <th>Status</th>\n");
          out.write("                                    <th>Delete</th>\n");
          out.write("                                    <th>Update</th>\n");
          out.write("                                </tr>\n");
          out.write("                            </thead>\n");
          out.write("                            <tbody>\n");
          out.write("                                <tr>\n");
          out.write("                                    <td>A.<input type=\"text\" name=\"answerA\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${answer.get(0).answerContent}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" ></td>\n");
          out.write("                                    <td>B.<input type=\"text\" name=\"answerB\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${answer.get(1).answerContent}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" ></td>\n");
          out.write("                                    <td>\n");
          out.write("\n");
          out.write("                                        <input type=\"text\" name=\"txtAnserCorrect\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.key.answer_correct}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" />\n");
          out.write("                                    </td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <select id=\"statusId\" name=\"dplStatus\">\n");
          out.write("                                            <option value=\"1\">Active</option>\n");
          out.write("                                            <option value=\"2\">InActive</option>\n");
          out.write("                                        </select>\n");
          out.write("\n");
          out.write("                                    </td>\n");
          out.write("                                    <td>\n");
          out.write("                                        ");
          if (_jspx_meth_c_url_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                        <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${delLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Delete</a>\n");
          out.write("                                    </td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <input type=\"submit\" value=\"Update\" name=\"btAction\" />\n");
          out.write("                                        <input type=\"hidden\" value=\"\" />\n");
          out.write("                                    </td>\n");
          out.write("                                </tr>\n");
          out.write("                                <tr>\n");
          out.write("                                    <td>C.<input type=\"text\" name=\"answerC\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${answer.get(2).answerContent}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" ></td>\n");
          out.write("                                    <td>D.<input type=\"text\" name=\"answerD\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${answer.get(3).answerContent}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" ></td>\n");
          out.write("                                </tr>\n");
          out.write("                            </tbody>\n");
          out.write("                        </table>\n");
          out.write("                        <br/>\n");
          out.write("                    </form>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_0.setVar("answer");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_url_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_url_0.setVar("delLink");
    _jspx_th_c_url_0.setValue("ControllerServlet");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_push_body_count_c_forEach_0[0]++;
        _jspx_th_c_url_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                            ");
        if (_jspx_meth_c_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                            ");
        if (_jspx_meth_c_param_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_url_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
        _jspx_push_body_count_c_forEach_0[0]--;
    }
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_0 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_0.setPageContext(_jspx_page_context);
    _jspx_th_c_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_0.setName("btAction");
    _jspx_th_c_param_0.setValue("del");
    int _jspx_eval_c_param_0 = _jspx_th_c_param_0.doStartTag();
    if (_jspx_th_c_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
    return false;
  }

  private boolean _jspx_meth_c_param_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_1 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_1.setPageContext(_jspx_page_context);
    _jspx_th_c_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_1.setName("pk");
    _jspx_th_c_param_1.setValue("");
    int _jspx_eval_c_param_1 = _jspx_th_c_param_1.doStartTag();
    if (_jspx_th_c_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
    return false;
  }
}
