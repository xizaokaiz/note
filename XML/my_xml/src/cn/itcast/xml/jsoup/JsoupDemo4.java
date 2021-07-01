package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象功能
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        //1获取student.xmlpath
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        /*
        Element:元素对象
				1. 获取子元素对象
					* getElementById(String id)：根据ID属性值来获取唯一的element对象
					* getElementsByTag(String tagName)：根据标签名称获取元素对象集合
					* getElementsByAttribute(String key)：根据属性名称获取元素对象集合
					* getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
				2. 获取属性值
					* String attr(String key):根据属性名称获取属性值
				3. 获取文本内容
					* String text():获取文本内容
					* String html():获取标签体的所有内容（包括子标签的字符串内容）
         */

        //通过Document对象获取name标签，获取所有的name标签，可以获取到两个
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println("------------------");
        //通过element对象来获取子标签对象
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        //获取student对象的属性值
        String number = element_student.attr("NUMBER");
        System.out.println(number);

        //获取文本内容
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);//纯文本内容
        System.out.println(html);//带标签的文本内容


    }
}
