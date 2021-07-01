package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * ѡ������ѯ
 */
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        //1��ȡstudent.xmlpath
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        //2.��ȡDocument����
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.��ѯname��ǩ
        /*
            div{

            }
         */
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("-----------------");

        //4.��ѯidֵΪitcast��Ԫ��
        Elements elements1 = document.select("#itcast");
        System.out.println(elements1);
        System.out.println("-----------------");

        //5.��ȡstudent��ǩ����number����ֵΪheima_0001��age�ӱ�ǩ
        //5.1 ��ȡstudent��ǩ����number����ֵΪheima_0001
        Elements elements2 = document.select("student[number='heima_0001']");
        System.out.println(elements2);
        System.out.println("-----------------");

        //5.2��ȡstudent��ǩ����number����ֵΪheima_0001��age�ӱ�ǩ
        Elements elements3 = document.select("student[number='heima_0001'] > age");
        System.out.println(elements3);
        System.out.println("-----------------");


    }
}
