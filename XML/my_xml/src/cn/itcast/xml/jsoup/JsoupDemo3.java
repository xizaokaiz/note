package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document/Element������
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //1��ȡstudent.xmlpath
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //2.��ȡDocument����
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.��ȡԪ�ض���
        //3.1��ȡ����student����
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("------------------");

        //3.2��ȡ������Ϊid��Ԫ����
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("------------------");

        //3.3��ȡnumber����ֵΪheima_001��Ԫ�ض���
        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);
        System.out.println("------------------");

        //3.4��ȡid����ֵ��Ԫ�ض���
        Element element = document.getElementById("itcast");
        System.out.println(element);


    }
}
