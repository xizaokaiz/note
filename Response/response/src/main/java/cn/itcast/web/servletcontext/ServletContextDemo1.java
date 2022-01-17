package cn.itcast.web.servletcontext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 获取
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext对象获取
                1. 通过request对象获取
                    request.getServletContext();
                2. 通过HttpServlet获取
                    this.getServletContext();
         */
        //1. 通过request对象获取
        ServletContext servletContext = request.getServletContext();
        //2. 通过HttpServlet获取
        ServletContext servletContext1 = this.getServletContext();

        System.out.println(servletContext);
        System.out.println(servletContext1);

        System.out.println(servletContext==servletContext1);
    }
}
