package com.DevGroup114514;
/*
 * @Author 古佳乐
 * @Date 2024/7/5
 * @Description
 */

public class User {
    private String name;
    private int id;
    private String avert;
    private int coinCounter;
    private Video[] favor;
    private User[] subscribe;
    private User[] fan;

    public User(String name, int id, String avert) {
        this.name = name;
        this.id = id;
        this.avert = avert;
        this.coinCounter = 0;
        this.favor = new Video[0];
        this.fan = new User[0];
        this.subscribe = new User[0];
    }

    public User(String name, int id, String avert, int coinCounter, Video[] favor, User[] subscribe, User[] fan) {
        this.name = name;
        this.id = id;
        this.avert = avert;
        this.coinCounter = coinCounter;
        this.favor = favor;
        this.subscribe = subscribe;
        this.fan = fan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvert() {
        return avert;
    }

    public void setAvert(String avert) {
        this.avert = avert;
    }

    public int getCoinCounter() {
        return coinCounter;
    }

    public void setCoinCounter(int coinCounter) {
        this.coinCounter = coinCounter;
    }

    public Video[] getFavor() {
        return favor;
    }

    public void setFavor(Video[] favor) {
        this.favor = favor;
    }

    public User[] getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(User[] subscribe) {
        this.subscribe = subscribe;
    }

    public User[] getFan() {
        return fan;
    }

    public void setFan(User[] fan) {
        this.fan = fan;
    }
}