/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal;

import java.util.List;

/**
 *
 * @author mormon
 */
public class Entry {
    private String date;
    private List<String> cont;
    private List<String> scrip;
    private List<String> topic;

    Entry(String date, String content, List<String> scriptures, List<String> topic) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setScripture(List<String> scriptures) {
        scrip = scriptures;
    }
    
    public void setDate(String dates) {
        date = dates;
    }
    
    public void setContent(List<String> content) {
        cont = content;
    }
    
    public void setTopic(List<String> top){
        topic = top;
    }
    
    public String getDate() {
        return date;
    }
    
    public List<String> getContent() {
        return cont;
    }
    
    public List<String> getScriptures() {
        return scrip;
    }
   
    public List<String> getTopic(){
        return topic;
    }
}
