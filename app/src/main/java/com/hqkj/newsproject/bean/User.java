package com.hqkj.newsproject.bean;

public class User {
    public String head_url;
    public String id;
    public String user_name;

    public User(String head_url, String id, String user_name) {
        this.head_url = head_url;
        this.id = id;
        this.user_name = user_name;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
