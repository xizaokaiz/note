package cn.itcast.web.servletcontext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * ��ȡ
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
            ServletContext�����ȡ
                1. ͨ��request�����ȡ
                    request.getServletContext();
                2. ͨ��HttpServlet��ȡ
                    this.getServletContext();
         */
        //1. ͨ��request�����ȡ
        ServletContext servletContext = request.getServletContext();
        //2. ͨ��HttpServlet��ȡ
        ServletContext servletContext1 = this.getServletContext();

        System.out.println(servletContext);
        System.out.println(servletContext1);

        System.out.println(servletContext==servletContext1);
    }
}
