package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element������
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        //1��ȡstudent.xmlpath
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        //2.��ȡDocument����
        Document document = Jsoup.parse(new File(path), "utf-8");

        /*
        Element:Ԫ�ض���
				1. ��ȡ��Ԫ�ض���
					* getElementById(String id)������ID����ֵ����ȡΨһ��element����
					* getElementsByTag(String tagName)�����ݱ�ǩ���ƻ�ȡԪ�ض��󼯺�
					* getElementsByAttribute(String key)�������������ƻ�ȡԪ�ض��󼯺�
					* getElementsByAttributeValue(String key, String value)�����ݶ�Ӧ��������������ֵ��ȡԪ�ض��󼯺�
				2. ��ȡ����ֵ
					* String attr(String key):�����������ƻ�ȡ����ֵ
				3. ��ȡ�ı�����
					* String text():��ȡ�ı�����
					* String html():��ȡ��ǩ����������ݣ������ӱ�ǩ���ַ������ݣ�
         */

        //ͨ��Document�����ȡname��ǩ����ȡ���е�name��ǩ�����Ի�ȡ������
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println("------------------");
        //ͨ��element��������ȡ�ӱ�ǩ����
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        //��ȡstudent���������ֵ
        String number = element_student.attr("NUMBER");
        System.out.println(number);

        //��ȡ�ı�����
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);//���ı�����
        System.out.println(html);//����ǩ���ı�����


    }
}
