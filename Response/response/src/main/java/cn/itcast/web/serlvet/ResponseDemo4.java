package cn.itcast.web.serlvet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ����������ַ��������
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ������֮ǰ����������Ĭ�ϱ��룺ISO-8859-1 ����Ϊ��GBK
        //response.setCharacterEncoding("utf-8");
        //��������������������͵���Ϣ�����ݵı��룬���������ʹ�øñ������
        response.setHeader("content-type","text/html;charset=utf-8");

        //�򵥵���ʽ�����ñ���
        response.setContentType("text/html;charset=utf-8");

        //1.��ȡ�ַ������
        PrintWriter pw = response.getWriter();
        //2.�������
        pw.write("<h1>hello response</h1>");
        pw.write("��� response");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
