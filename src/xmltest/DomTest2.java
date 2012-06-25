package xmltest;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest2 {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("resource/student.xml"));

        //获得文档的根元素节点
        Element root = document.getDocumentElement();
        NodeList list = root.getChildNodes();
        //System.out.println(list.getLength()); //return 7, 空格也作为child
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.item(i).getNodeName());
            //#text
            //学生
            //#text
            //学生
            //#text
            //学生
            //#text
        }

        System.out.println("-------------------------");
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            System.out.println(n.getNodeType() + ":" + n.getNodeValue());
            //nodeType在jdk里定义的是final常量
        }

        System.out.println("-------------------------");
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            System.out.println(n.getTextContent());
        }

        System.out.println("-------------------------");
        NodeList nodeList = document.getElementsByTagName("学生");
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap nnm = nodeList.item(i).getAttributes();
            String attrName = nnm.item(0).getNodeName();
            String attrValue = nnm.item(0).getNodeValue();
            System.out.println(attrName + "=" + attrValue);
        }

    }
}
