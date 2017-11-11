package practice1;

import java.io.*;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class shihab {
    public static void main(String[] args) throws JDOMException, IOException {
        File file = new File("D:\\IDB-BISEW\\Git_Advance-Java\\XMLPractice\\test\\practice1\\shihab.xml");
        SAXBuilder saxb = new SAXBuilder();
        Document document = saxb.build(file);
        Element rootElement = document.getRootElement();
        
        System.out.println("The root element is: "+rootElement.getName());
        
        List<Element> list = rootElement.getChildren();
        
        for (int i = 0; i < list.size(); i++) {
            Element studentElement = list.get(i);
            
            System.out.println(studentElement.getChild("name").getText());
            System.out.println(studentElement.getChild("age").getText());
            System.out.println("---------------------");
        }
    }
}
