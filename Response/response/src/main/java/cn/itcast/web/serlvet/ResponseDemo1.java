package cn.itcast.web.serlvet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * �ض���
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1.....");

        //���� /responseDemo1 ���Զ���ת�� /responseDemo2
        /*//1.����״̬��Ϊ302
        response.setStatus(302);
        //2.������Ӧͷlocation
        response.setHeader("location","/response/responseDemo2");*/

        request.setAttribute("msg","response");

        //��̬��ȡ����Ŀ¼
        String contextPath = request.getContextPath();

        //�򵥵��ض��򷽷�
        response.sendRedirect(contextPath+"/responseDemo2");
        //response.sendRedirect("http://www.itcast.cn");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
