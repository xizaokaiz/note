package cn.itcast.web.download;

import cn.itcast.web.utils.DownLoadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.��ȡ����������ļ�����
        String filename = request.getParameter("filename");
        //2.ʹ���ֽ������������ļ����ڴ�
        //2.1 �ҵ��ļ�������·��
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2 ���ֽ�������
        FileInputStream fis = new FileInputStream(realPath);
        //3.����response����Ӧͷ
        //3.1������Ӧͷ���ͣ�content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("Content-Type",mimeType);

        //��������ļ�������
        //1.��ȡuser-agent����ͷ
        String agent = request.getHeader("user-agent");
        //2.ʹ�ù����෽�������ļ�������
        filename = DownLoadUtils.getFileName(agent, filename);

        //3.2������Ӧͷ�򿪷�ʽ��content-disposition
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        //4.��������������д�����������
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024* 8];//������
        int len = 0;
        while((len = fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();

    }
}
