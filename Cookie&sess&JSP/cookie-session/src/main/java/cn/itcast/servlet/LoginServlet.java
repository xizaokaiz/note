package cn.itcast.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置request编码
        request.setCharacterEncoding("utf-8");
        //2. 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //3. 先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //删除session中存储的验证码,保证验证码是一次性的
        session.removeAttribute("checkCode_session");
        //4. 先判断验证码是否正确
        if(checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)){
            //忽略验证码的大小写比较
            //验证码正确
            //判断用户名和密码是否一致
            if("zhangsan".equals(username) && "123".equals(password)){//需要调用UserDao查询数据库
                //登陆成功
                //存储用户信息
                session.setAttribute("user",username);
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                //登陆失败
                //存储提示信息到request
                request.setAttribute("login_error","用户名或密码错误");
                //转发到登陆页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            //转发到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
