
//get and set methods for a few differet attributes

package com.example.demo.model;

public class Greeting {
    private long id;
    private String content;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getContent() { 
        return content; 
    }
    public void setContent(String content) { this.content = content; }
}