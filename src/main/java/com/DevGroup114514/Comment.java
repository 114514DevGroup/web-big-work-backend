package com.DevGroup114514;
/*
 * @Author 古佳乐
 * @Date 2024/7/5
 * @Description
 */

import java.util.Date;

public class Comment {
    private User author;
    private String content;
    private Date date;
    private Comment[] comments;

    public Comment(User author, String content, Date date) {
        this.author = author;
        this.content = content;
        this.date = date;
        this.comments = new Comment[0];
    }

    public Comment(User author, String content, Date date, Comment[] comments) {
        this.author = author;
        this.content = content;
        this.date = date;
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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