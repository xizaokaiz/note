package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie��������б���೤ʱ�䣿
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. ����cookie����
        Cookie c1 = new Cookie("msg","setMaxAge");
        //2. ����cookie�Ĵ��ʱ��
        c1.setMaxAge(30);//��cookie�־û���Ӳ�̣�30�����Զ�ɾ��cookie�ļ�
        //c1.setMaxAge(-1);
        //c1.setMaxAge(0);

        //3. ����cookie
        response.addCookie(c1);
    }
}
