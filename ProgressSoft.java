/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progresssoft;
import java.io.*;
import java.net.URISyntaxException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ProgressSoft {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.net.URISyntaxException
     */
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, URISyntaxException {

            
            
         //  File csvFile =new File("transactions.csv");
         //  CsvParser.CsvParser(csvFile);
            
            File inputFile = new File("transactions.xml");
            XMLParser.XMLParser(inputFile);


    }
 

    }
class XMLParser implements TransactionParser{
    
    
public static void XMLParser(File e) throws org.xml.sax.SAXException, IOException, ParserConfigurationException
    {
        Transactions trans = new Transactions();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(e);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Transaction");
            NodeList AList = doc.getElementsByTagName("Amount");
            System.out.println("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    trans.setDescription(eElement.getElementsByTagName("Description").item(0).getTextContent());
                    trans.setDirection(eElement.getElementsByTagName("Direction").item(0).getTextContent());

                    Node ANode = AList.item(i);

                    if (ANode.getNodeType() == Node.ELEMENT_NODE) {
                        Element AElement = (Element) ANode;
                        trans.setAmount(AElement.getElementsByTagName("Value").item(0).getTextContent());
                        trans.setCurrency(AElement.getElementsByTagName("Currency").item(0).getTextContent());
}
                }
            }
        } 
}


    