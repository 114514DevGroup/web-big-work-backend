package com.DevGroup114514;
/*
 * @Author 古佳乐
 * @Date 2024/7/5
 * @Description
 */

public class Controller implements UserCount, UserManage, VideoManage {

    @Override
    public boolean register(String username, String password) {
        return false;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Video[] getRandomVideo() {
        return new Video[0];
    }

}