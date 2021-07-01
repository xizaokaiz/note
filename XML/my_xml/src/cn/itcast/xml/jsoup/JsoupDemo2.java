package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup������
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        //2.1��ȡstudent.xmlpath
        String path = JsoupDemo2.class.getClassLoader().getResource("student.xml").getPath();
        //2.2����xml�ĵ��������ĵ����ڴ棬��ȡdom��-->Document
        /*Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);*/

        //�����ַ����ĵڶ��ַ�ʽ��parse(String html)������xml��html�ַ���
        /*String str = " <students>\n" +
                " \t<student number=\"heima_0001\">\n" +
                "\t\t<name>tom</name>\n" +
                "\t\t<age>23</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>11</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "\n" +
                " </students>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/

        //�����з�ʽ��parse(URL url, int timeoutMillis)��ͨ������·����ȡָ����html��xml���ĵ�����
        URL url = new URL("http://manmanbuy.com/");//���������е�һ����Դ·��
        Document document = Jsoup.parse(url,10000);
        System.out.println(document);//exp:�а�ȫ��֤����վ���޷���ȡ

    }
}
