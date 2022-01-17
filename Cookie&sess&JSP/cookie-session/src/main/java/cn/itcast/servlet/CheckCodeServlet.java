package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * ��֤��
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.����һ���������ڴ���ȥ��ͼ(��֤��ͼƬ����)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2.����ͼƬ
        //2.1 ��䱳��ɫ
        Graphics g = image.getGraphics();//���ʶ���
        g.setColor(Color.PINK);//���û�����ɫ
        g.fillRect(0,0,width,height);

        //2.2 ���߿�
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //��������Ǳ�
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();//���ڴ���session

        for(int i=0;i<4;i++){
            int index = ran.nextInt(str.length());
            //��ȡ�ַ�
            char ch = str.charAt(index);//����ַ�
            sb.append(ch);
            //2.3 д��֤��
            g.drawString(ch+"",width/5*i,height/2);
        }
        String checkCode_session = sb.toString();
        //����֤��洢session
        request.getSession().setAttribute("checkCode_session",checkCode_session);

        //2.4 ��������
        g.setColor(Color.GREEN);

        //������������
        int x1 = ran.nextInt(width);
        int x2 = ran.nextInt(width);
        int y1 = ran.nextInt(height);
        int y2 = ran.nextInt(height);
        for(int i=0;i<10;i++){
            g.drawLine(x1,y1,x2,y2);
        }

        //3.��ͼƬ�����ҳ��չʾ
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
