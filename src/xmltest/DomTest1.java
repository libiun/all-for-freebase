package xmltest;
//模式化过程,使用jaxp ,java api for xml parsing
//jdk自带的处理类
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomTest1 {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse("resource/testjavaxml.xml");


        //System.out.println(document.getXmlEncoding());
        //System.out.println(document.getDocumentURI());
        NodeList list = document.getElementsByTagName("person");
        //System.out.println(list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            String content = element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
            System.out.println("name:" + content);

            content = element.getElementsByTagName("age").item(0).getFirstChild().getNodeValue();
            System.out.println("age:" + content);


            content = element.getElementsByTagName("workspace").item(0).getFirstChild().getNodeValue();
            System.out.println("workspace:" + content);
        }
    }
}
