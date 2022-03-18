package com.example.demo.pojo;


import org.springframework.data.annotation.Id;

public class Message {
  private long id;
  private String content;
  private String username;
  private String time;
  private long parentId;
  private long foreignId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public long getForeignId() {
    return foreignId;
  }

  public void setForeignId(long foreignId) {
    this.foreignId = foreignId;
  }

}
