package cn.itcast.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
�ڷ������е�Servlet�ж��Ƿ���һ����ΪlastTime��cookie
    * �У����ǵ�һ�η���
        1. ��Ӧ���ݣ���ӭ���������ϴη���ʱ��Ϊ��2022��1��8��18:22:58
        2. д��cookie��lastTime = 2022��1��8��18:22:58
    * û�У��ǵ�һ�η���
        1. ��Ӧ���ݣ����ã���ӭ���״η���
        2. д��cookie��lastTime = 2022��1��8��18:23:38

 */

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //������Ӧ����Ϣ������ݸ�ʽ�Լ����� -- ������������
        response.setContentType("text/html;charset=utf-8");

        //1. ��ȡ���е�cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//��ʼʱû��cookie����ΪlastTime
        //2. ����cookie����
        if(cookies!=null && cookies.length>0){
            for(Cookie cookie:cookies){
                //3. ��ȡcookie������
                String name = cookie.getName();
                //4. �ж������Ƿ��ǣ�lastTime
                if("lastTime".equals(name)){
                    //�����и�cookie,���ǵ�һ�η���
                    flag = true;//��lastTime��cookie

                    //����cookie��value
                    //��ȡ��ǰʱ����ַ�������������cookie��ֵ�����·���cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");//ʱ���ʽ��ʼ��
                    String str_date = sdf.format(date);

                    System.out.println("����ǰ��"+str_date);
                    //URLb����
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("�����"+str_date);

                    cookie.setValue(str_date);
                    //����cookie���ʱ��
                    cookie.setMaxAge(60 * 60 * 24 * 30);//һ����
                    response.addCookie(cookie);

                    //��Ӧ����
                    //��ȡcookie��value����ʱ��
                    String value = cookie.getValue();
                    //URL����
                    System.out.println("����ǰ��"+value);
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("�����"+value);

                    response.getWriter().write("<h1>��ӭ���������ϴη��ʵ�ʱ��Ϊ" +
                            value+"</h1>");

                    break;//�ҵ�֮��ֻ�����һ��
                }
            }
        }

        if(cookies == null || cookies.length==0 || flag == false){
            //����û�У�����һ�η���

            //����cookie��value
            //��ȡ��ǰʱ����ַ�������������cookie��ֵ�����·���cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");//ʱ���ʽ��ʼ��
            String str_date = sdf.format(date);

            System.out.println("����ǰ��"+str_date);
            //URL����
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("�����"+str_date);

            Cookie cookie = new Cookie("lastTime","str_date");//�µ�cookie����
            //����cookie���ʱ��
            cookie.setMaxAge(60 * 60 * 24 * 30);//һ����
            response.addCookie(cookie);

            response.getWriter().write("<h1>���ã���ӭ���״η���</h1>");
        }
    }
}
