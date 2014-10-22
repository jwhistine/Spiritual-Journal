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
    
    /*********************************************************
     * MAIN
     * Just calls the run function
     ********************************************************/
    public static void main(String[] args) throws Exception{
        new Journal().run();
    }
    
    /**************************************************************
     * RUN
     * This will call all of the necessary functions to make this 
     * program work.
     *************************************************************/
    public void run() throws Exception {
        FileService f = new FileService();
        String propertyFile = "/resources/journal.properties";
        String termFile = f.getProperties("terms", propertyFile);
        String bookFile = f.getProperties("books", propertyFile);
        String inFile = "c:/journal.txt";
        String outFile = "c:/journalOutput.txt";
        String xmlOut = "c:/xmlOutput.txt";
        
        
        Map<String, List<String>> bookList  = f.readBook(bookFile);
        Map<String, List<String>> topicList = f.readTopic(termFile);
        
        entries = f.fileProcess(inFile, bookList, topicList);
        
        try {
            f.buildXML(entries, xmlOut);
            f.writeFile(entries, outFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**********************************************************************
     * This is the display for Milestone 3A
     *********************************************************************/
    void display(List<Entry> entry) { 
        for (Entry e : entry) {
            System.out.println("Entry: ");
            System.out.println("Date: " + e.getDate());
            System.out.println("Content: \n" + e.getContent() + "\n");
        }
    }
    
    /*************************************************************************
     * This is the display for Milestone 3B
     ************************************************************************/
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
