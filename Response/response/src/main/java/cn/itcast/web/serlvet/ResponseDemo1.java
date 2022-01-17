package cn.itcast.web.serlvet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1.....");

        //访问 /responseDemo1 会自动跳转到 /responseDemo2
        /*//1.设置状态码为302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/response/responseDemo2");*/

        request.setAttribute("msg","response");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();

        //简单的重定向方法
        response.sendRedirect(contextPath+"/responseDemo2");
        //response.sendRedirect("http://www.itcast.cn");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
