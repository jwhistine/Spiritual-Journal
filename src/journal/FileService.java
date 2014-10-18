/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/******************************************************************************
 * @author mormon
 *****************************************************************************/
public class FileService {
    
    /**************************************************************************
     * READ XML
     * This will allow the XML file to be parsed in order to pull the information
     * needed to display.
    *************************************************************************/
    public List<Entry> readXML(String file) {
        List<Entry> entryList = new ArrayList<>();
        
        System.out.println("Loading file: \"" + file + "\"\n");
        
        try {
            File xmlFile = new File(file);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            
            doc.getDocumentElement().normalize();
            entryList = processData(doc);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return entryList;
    }
    
    /***************************************************************************
     * @param value
     * @param file
     * @return
     **************************************************************************/
    public String getProperties(String value, String file) throws Exception {
        Properties prop = new Properties();
        String propVal = null;
        
        try {
            prop.load(getClass().getResourceAsStream(file));
            propVal = prop.getProperty(value);
        }
        catch (Exception ex) {
            System.out.println("Could not load properties file " + file);
            //ex.printStackTrace();
        }
        
        return propVal;
    }
    
    /***************************************************************************
     * @param doc
     * @return 
     **************************************************************************/
    public List<Entry> processData(Document doc) {
        List<Entry> entryList = new ArrayList<>();
        List<String> scriptures = new ArrayList<>();
        List<String> topic = new ArrayList<>();
        String date;
        String content = null;
        String scrip;
            
        NodeList entry = doc.getElementsByTagName("entry");
            
        for (int temp = 0; temp < entry.getLength(); ++temp) {
            Node node = entry.item(temp);
                
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                NodeList childNodes = node.getChildNodes();
                    
                for (int i = 0; i < childNodes.getLength(); ++i) {
                    Node childNode = childNodes.item(i);
                        
                    if (childNode.getNodeName() == "scripture") {
                        Element childElement = (Element) childNode;
                            
                        scrip = childElement.getAttribute("book");
                            
                        if (childElement.hasAttribute("chapter")) {
                            scrip = scrip + " " + childElement.getAttribute("chapter");
                        }
                        if (childElement.hasAttribute("startverse")) {
                            scrip = scrip + ":" + childElement.getAttribute("startverse");
                        }
                        if (childElement.hasAttribute("endverse")) {
                            scrip = scrip + "-" + childElement.getAttribute("endverse");
                        }
                        scriptures.add(scrip);
                    }    
                    
                    if (childNode.getNodeName() == "topic") {
                        topic.add(childNode.getTextContent());
                    }
                    if (childNode.getNodeName() == "content") {
                        content = element.getTextContent().trim();
                        content = content.replaceAll("\\n\\s+", "\n");
                    }
                }
                date = element.getAttribute("date");
                entryList.add(new Entry(date, content, scriptures, topic));
            }
        } 
        return entryList;
    }
    
    /**
     *
     **/
    public Map<String, List<String>> readBook(String file) {
        Map<String, List<String>> book = new HashMap<>(); 
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            String line;
            
            while ((line = reader.readLine()) != null) {
                List<String> list = new ArrayList<>();
                String[] parts = line.split(":");
                String key = parts[0];
                
                String vList = parts[1];
                
                if (book.containsKey(key)) {
                    list = book.get(key);
                    List<String> nList = new ArrayList<>();
                    nList.add(vList);
                    list.addAll(nList);
                }
                else {
                    list.add(vList);
                }
                book.put(key, list);
            }
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
    
    /**
     *
     **/
    public Map<String, List<String>> readTopic(String file) {
        Map<String, List<String>> topic = new HashMap<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String key = parts[0];
                String vList = parts[1];
                String[] terms = vList.split(",");
                
                List<String> list = new ArrayList<>();
                list.addAll(Arrays.asList(terms));
                topic.put(key, list);
            }
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return topic;
    }
    
    /**
     *
     **/
    public Map<String, List<String>> bookWithDates(List<Entry> list) {
        Map<String, List<String>> mBook = new HashMap<>();
        String date;
        
        for (Entry ex : list) {
            List<String> scrip = ex.getScriptures();
            date = ex.getDate();
            
            for (String str : scrip) {
                List<String> temp = new ArrayList<>();
                
                if (mBook.containsKey(str)) {
                    temp = mBook.get(str);
                    List<String> nList = new ArrayList<>();
                    nList.add(date);
                    temp.addAll(nList);
                }
                else {
                    temp.add(date);
                }
                mBook.put(str, temp);
            }
        }
        
        return mBook;
    }
    
    /**
     * 
     **/
    public Map<String, List<String>> topicWithDates(List<Entry> list) {
        Map<String, List<String>> mTopic = new HashMap<>();
        String date;
        
        for (Entry ex : list) {
            List<String> topic = ex.getTopic();
            date = ex.getDate();
            
            for (String str : topic) {
                List<String> temp = new ArrayList<>();
                
                if (mTopic.containsKey(str)) {
                    temp = mTopic.get(str);
                    List<String> nList = new ArrayList<>();
                    nList.add(date);
                    temp.addAll(nList);
                }
                else {
                    temp.add(date);
                }
                mTopic.put(str, temp);
            }
        }
        return mTopic;
    }
}