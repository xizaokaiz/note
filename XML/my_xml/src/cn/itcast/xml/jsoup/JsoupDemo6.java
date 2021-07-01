package cn.itcast.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * XPath��ѯ
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1��ȡstudent.xmlpath
        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        //2.��ȡDocument����
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.����document���󣬴���JXDocument����
        JXDocument jxDocument = new JXDocument(document);

        //4.���xpath�﷨��ѯ
        //4.1��ѯ����student��ǩ
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for(JXNode jxNode:jxNodes){
            System.out.println(jxNode);
        }
        System.out.println("--------------------");
        //4.2��ѯ����student��ǩ�µ�name��ǩ
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for(JXNode jxNode:jxNodes2){
            System.out.println(jxNode);
        }
        System.out.println("--------------------");

        //4.3��ѯstudent��ǩ�´���id���Ե�name��ǩ
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for(JXNode jxNode:jxNodes3){
            System.out.println(jxNode);
        }
        System.out.println("--------------------");
        //4.4��ѯstudent��ǩ�´���id���Ե�name��ǩ������id����ֵΪitcast
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='itcast']");
        for(JXNode jxNode:jxNodes4){
            System.out.println(jxNode);
        }

    }
}
