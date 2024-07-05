package com.DevGroup114514;
/*
 * @Author 古佳乐
 * @Date 2024/7/5
 * @Description
 */

import java.util.Date;

public class Video {
    int id;
    String src;
    String title;
    User author;
    int seen;
    Date date;
    Comment[] comments;

    public Video(String src, String title, User author, Date date) {
        this.src = src;
        this.title = title;
        this.author = author;
        this.date = date;
        this.seen = 0;
        this.comments = new Comment[0];
    }

    public Video(int id, String src, String title, User author, int seen, Date date, Comment[] comments) {
        this.id = id;
        this.src = src;
        this.title = title;
        this.author = author;
        this.seen = seen;
        this.date = date;
        this.comments = comments;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}