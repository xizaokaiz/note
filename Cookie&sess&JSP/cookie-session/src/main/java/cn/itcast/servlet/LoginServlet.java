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
        //1. ����request����
        request.setCharacterEncoding("utf-8");
        //2. ��ȡ����
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //3. �Ȼ�ȡ���ɵ���֤��
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //ɾ��session�д洢����֤��,��֤��֤����һ���Ե�
        session.removeAttribute("checkCode_session");
        //4. ���ж���֤���Ƿ���ȷ
        if(checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)){
            //������֤��Ĵ�Сд�Ƚ�
            //��֤����ȷ
            //�ж��û����������Ƿ�һ��
            if("zhangsan".equals(username) && "123".equals(password)){//��Ҫ����UserDao��ѯ���ݿ�
                //��½�ɹ�
                //�洢�û���Ϣ
                session.setAttribute("user",username);
                //�ض���success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                //��½ʧ��
                //�洢��ʾ��Ϣ��request
                request.setAttribute("login_error","�û������������");
                //ת������½ҳ��
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            //��֤�벻һ��
            //�洢��ʾ��Ϣ��request
            request.setAttribute("cc_error","��֤�����");
            //ת������½ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
