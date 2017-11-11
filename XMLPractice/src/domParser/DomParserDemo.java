package domParser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class DomParserDemo {

    public static void main(String[] args) {
        try {
            File inputFile = new File("D:\\IDB-BISEW\\Git_Advance-Java\\XMLPractice\\src\\domParser\\Demo.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();
            
            System.out.println("Root element :" + classElement.getName());
            
            
            List<Element> studentList = classElement.getChildren();
            
            System.out.println("----------------------------");
            
            for (int i = 0; i < studentList.size(); i++) {
                
                Element student = studentList.get(i);
                
                System.out.println("\nCurrent Element :" + student.getName());
                
                Attribute attribute = student.getAttribute("rollno");
                Attribute attribute2 = student.getAttribute("lang");
                
                System.out.println("Student roll no : " + attribute.getValue());
                System.out.println("Student favorite language : " + attribute2.getValue());
                System.out.println("First Name : " + student.getChild("firstname").getText());
                System.out.println("Last Name : " + student.getChild("lastname").getText());
                System.out.println("Nick Name : " + student.getChild("nickname").getText());
                System.out.println("Marks : " + student.getChild("marks").getText());
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
