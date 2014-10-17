/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mormon
 */
public class journalIdea {
    private String content;
    private String date;
    private String title;

    // getters and setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    public List<String> getTopics() {
	return null;
    }

    public ArrayList<Scripture> getScriptures() {
	return new ArrayList<Scripture>(); // actual concrete class: creates a list.
    }

    public String getContent() {
	return null;
    }
    
}
