package xmltest;

import java.io.File;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest2 {

    public static void main(String[] args) throws Exception {
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        SAXParser sAXParser = sAXParserFactory.newSAXParser();
        sAXParser.parse(new File("resource/student.xml"), new MyHandler2());
    }
}

class MyHandler2 extends DefaultHandler {
    //stack

    private Stack<String> stack = new Stack<String>();
    private String name;
    private String gender;
    private String age;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String attrName = attributes.getQName(i);
            String attrValue = attributes.getValue(i);
            System.out.println(attrName + "=" + attrValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String tag = stack.peek(); //取值不弹出
        if (("姓名".equals(tag))) {
            name = new String(ch, start, length);
        } else if ("性别".equals(tag)) {
            gender = new String(ch, start, length);
        } else if ("年龄".equals(tag)) {
            age = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();  //表示钙元素已经解析完毕
        if("学生".equals(qName)){
            System.out.println("姓名:"+name);
            System.out.println("性别:"+gender);
            System.out.println("年龄:"+age);
            System.out.println();
        }
    }
}