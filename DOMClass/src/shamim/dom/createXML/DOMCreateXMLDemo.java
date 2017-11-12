package shamim.dom.createXML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMCreateXMLDemo {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            //root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);
            
            //staff elements
            Element staff = doc.createElement("staff");
            rootElement.appendChild(staff);
            
            //set attribute to staff element
//            Attr attr = doc.createAttribute("id");
//            attr.setValue("1");
//            staff.setAttributeNode(attr);
            
            // shorten way
            staff.setAttribute("id", "1");
            
            //firstname elements
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("Shariar"));
            staff.appendChild(firstname);
            
            //lastname elements
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("Islam"));
            staff.appendChild(lastname);
            
            //nickname elements
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("Topper"));
            staff.appendChild(nickname);
            
            //salary elements
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("20000"));
            staff.appendChild(salary);
            
            //salary elements
            Element country = doc.createElement("country");
            country.appendChild(doc.createTextNode("Bangladesh"));
            staff.appendChild(country);
            
            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("D:\\Git\\Advance-Java\\DOMClass\\src\\shamim\\dom\\createXML\\dom.xml"));
            
            transformer.transform(source, result);
            
            System.out.println("File Saved!");
            
            //output to console for testing
            //StreamResult res = new StreamResult(System.out);
            
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch(TransformerException tfe){
            tfe.printStackTrace();
        }
    }
}
