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
在服务器中的Servlet判断是否有一个名为lastTime的cookie
    * 有：不是第一次访问
        1. 响应数据：欢迎回来，您上次访问时间为：2022年1月8日18:22:58
        2. 写回cookie：lastTime = 2022年1月8日18:22:58
    * 没有：是第一次访问
        1. 响应数据：您好，欢迎您首次访问
        2. 写回cookie：lastTime = 2022年1月8日18:23:38

 */

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码 -- 避免中文乱码
        response.setContentType("text/html;charset=utf-8");

        //1. 获取所有的cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//初始时没有cookie，即为lastTime
        //2. 遍历cookie数组
        if(cookies!=null && cookies.length>0){
            for(Cookie cookie:cookies){
                //3. 获取cookie的名称
                String name = cookie.getName();
                //4. 判断名称是否是：lastTime
                if("lastTime".equals(name)){
                    //表明有该cookie,不是第一次访问
                    flag = true;//有lastTime的cookie

                    //设置cookie的value
                    //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//时间格式初始化
                    String str_date = sdf.format(date);

                    System.out.println("编码前："+str_date);
                    //URLb编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后："+str_date);

                    cookie.setValue(str_date);
                    //设置cookie存活时间
                    cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
                    response.addCookie(cookie);

                    //响应数据
                    //获取cookie的value，即时间
                    String value = cookie.getValue();
                    //URL解码
                    System.out.println("解码前："+value);
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);

                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为" +
                            value+"</h1>");

                    break;//找到之后，只需遍历一次
                }
            }
        }

        if(cookies == null || cookies.length==0 || flag == false){
            //表明没有，即第一次访问

            //设置cookie的value
            //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//时间格式初始化
            String str_date = sdf.format(date);

            System.out.println("编码前："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后："+str_date);

            Cookie cookie = new Cookie("lastTime","str_date");//新的cookie对象
            //设置cookie存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }
}
