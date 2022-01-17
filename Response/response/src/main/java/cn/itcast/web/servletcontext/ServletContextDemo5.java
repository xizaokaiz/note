package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext功能
                3. 获取文件的真实路径(服务器路径)
         */

        //2. 通过HttpServlet获取
        ServletContext context = this.getServletContext();


        //获取文件的服务器路径
        String b = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(b);
        //File file = new File(realPath);

        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);

        String a = context.getRealPath("a.txt");//resources目录下的资源访问
        System.out.println(a);
    }
}
