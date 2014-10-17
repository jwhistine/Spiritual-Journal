/*
 * Author: Justin Whistine
 * Collaborators: Class, Joel Lassen, Heidy Cespedes
 */
package journal;

import java.util.List;
import java.util.Map;

/**
 * @author mormon
 */
public class Journal {
    
    private List <Scripture> scripture;
    private List <Topic> topic;
    private List <Entry> entries;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        new Journal().run();
    }
    
    /**************************************************************
     * RUN
     *************************************************************/
    public void run() throws Exception{
        FileService f = new FileService();
        String propertyFile = "C:/Users/mormon/Documents/NetBeansProjects/Journal/src/resourcesjournal.properties";
        String file = "c:/burtonJournal.xml";
        String termFile = f.getProperties("terms", file);
        String bookFile = f.getProperties("books", file); 
        
        Map<String, List<String>> bookList = f.readBook(bookFile);
        Map<String, List<String>> topicList = f.readTopic(termFile);
        
        List<Entry> list = f.readXML(file);
        
        //Map<String, List<String>> scripDate = f.bookWithDates(list);
        //Map<String, List<String>> topicDate = f.bookWithDates(list);
        
        //displayInfo(scripDate, "Scripture References:");
        //displayInfo(topicDate, "\nTopic References:");
    }
    
    /**
     * @param entry 
     **/
    void display(List<Entry> entry) { 
        for (Entry e : entry) {
            System.out.println("Entry: ");
            System.out.println("Date: " + e.getDate());
            System.out.println("Content: \n" + e.getContent() + "\n");
        }
    }
    
    /**
     * 
     **/
    public void displayInfo(Map<String, List<String>> map, String head) {
        System.out.println(head);
        
        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                System.out.println(key + ":");
                List<String> date = map.get(key);
                for (String str : date) {
                    System.out.println("\t" + str);
                }
            }
        }
    }
}
