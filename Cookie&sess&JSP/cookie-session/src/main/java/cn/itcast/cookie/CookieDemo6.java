package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie共享问题？
 */
@WebServlet("/cookieDemo6")
public class CookieDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建cookie对象
        Cookie c1 = new Cookie("msg","hello");
        //设置path，让当前服务器下部署的所有项目共享cookie信息
        c1.setPath("/");
        //2. 发送cookie
        response.addCookie(c1);
    }
}
