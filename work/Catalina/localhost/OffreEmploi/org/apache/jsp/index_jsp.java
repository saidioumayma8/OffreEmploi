/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.36
 * Generated at: 2025-03-07 15:55:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Les JSPs ne permettent que GET, POST ou HEAD. Jasper permet aussi OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/open-iconic-bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/animate.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/magn\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/aos.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/ionicons.min.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/jquery.timepicker.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/flaticon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/icomoon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"goto-here\">\r\n");
      out.write("<div class=\"py-1 bg-primary\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row no-gutters d-flex align-items-start align-items-center px-md-0\">\r\n");
      out.write("            <div class=\"col-lg-12 d-block\">\r\n");
      out.write("                <div class=\"row d-flex\">\r\n");
      out.write("                    <div class=\"col-md pr-4 d-flex topper align-items-center\">\r\n");
      out.write("                        <div class=\"icon mr-2 d-flex justify-content-center align-items-center\"><span class=\"icon-phone2\"></span></div>\r\n");
      out.write("                        <span class=\"text\">+ 1235 2355 98</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md pr-4 d-flex topper align-items-center\">\r\n");
      out.write("                        <div class=\"icon mr-2 d-flex justify-content-center align-items-center\"><span class=\"icon-paper-plane\"></span></div>\r\n");
      out.write("                        <span class=\"text\">oumayma@email.com</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-5 pr-4 d-flex topper align-items-center text-lg-right\">\r\n");
      out.write("                        <span class=\"text\">3-5 Business days delivery &amp; Free Returns</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light\" id=\"ftco-navbar\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"index.jsp\">Vegefoods</a>\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#ftco-nav\" aria-controls=\"ftco-nav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("            <span class=\"oi oi-menu\"></span> Menu\r\n");
      out.write("        </button>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"ftco-nav\">\r\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("                <li class=\"nav-item active\"><a href=\"index.jsp\" class=\"nav-link\">Home</a></li>\r\n");
      out.write("                <li class=\"nav-item dropdown\">\r\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown04\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Shop</a>\r\n");
      out.write("                    <div class=\"dropdown-menu\" aria-labelledby=\"dropdown04\">\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"shop.jsp\">les Offres</a>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"cart.jsp\">login</a>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"checkout.jsp\">Register</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\"><a href=\"about.jsp\" class=\"nav-link\">About</a></li>\r\n");
      out.write("                <li class=\"nav-item\"><a href=\"blog.jsp\" class=\"nav-link\">Blog</a></li>\r\n");
      out.write("                <li class=\"nav-item\"><a href=\"contact.jsp\" class=\"nav-link\">Contact</a></li>\r\n");
      out.write("                <li class=\"nav-item\"><a href=\"OffreEmploi/create-offre.jsp\" class=\"nav-link\">Crete Offre</a></li>\r\n");
      out.write("                <li class=\"nav-item cta cta-colored\"><a href=\"cart.jsp\" class=\"nav-link\"><span class=\"icon-shopping_cart\"></span>[0]</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<section id=\"home-section\" class=\"hero\">\r\n");
      out.write("    <div class=\"home-slider owl-carousel\">\r\n");
      out.write("        <div class=\"slider-item\" style=\"background-image: url(images/bg_1.jpg);\">\r\n");
      out.write("            <div class=\"overlay\"></div>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row slider-text justify-content-center align-items-center\" data-scrollax-parent=\"true\">\r\n");
      out.write("                    <div class=\"col-md-12 ftco-animate text-center\">\r\n");
      out.write("                        <h1 class=\"mb-2\">We serve Fresh Vegestables &amp; Fruits</h1>\r\n");
      out.write("                        <h2 class=\"subheading mb-4\">We deliver organic vegetables &amp; fruits</h2>\r\n");
      out.write("                        <p><a href=\"#\" class=\"btn btn-primary\">View Details</a></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"slider-item\" style=\"background-image: url(images/bg_2.jpg);\">\r\n");
      out.write("            <div class=\"overlay\"></div>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row slider-text justify-content-center align-items-center\" data-scrollax-parent=\"true\">\r\n");
      out.write("                    <div class=\"col-sm-12 ftco-animate text-center\">\r\n");
      out.write("                        <h1 class=\"mb-2\">100% Fresh &amp; Organic Foods</h1>\r\n");
      out.write("                        <h2 class=\"subheading mb-4\">We deliver organic vegetables &amp; fruits</h2>\r\n");
      out.write("                        <p><a href=\"#\" class=\"btn btn-primary\">View Details</a></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<footer class=\"ftco-footer ftco-section\">\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-migrate-3.0.1.min.js\"></script>\r\n");
      out.write("<script src=\"js/popper.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.easing.1.3.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.waypoints.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.stellar.min.js\"></script>\r\n");
      out.write("<script src=\"js/owl.carousel.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("<script src=\"js/aos.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.animateNumber.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap-datepicker.js\"></script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
