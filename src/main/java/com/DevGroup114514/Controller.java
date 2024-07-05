package com.DevGroup114514;
/*
 * @Author 古佳乐
 * @Date 2024/7/5
 * @Description
 */

public class Controller implements UserCount, UserManage, VideoManage {
    @Override
    public boolean put(User user) {
        return false;
    }

    @Override
    public boolean register(String username, String password) {
        return false;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public boolean delete(String username) {
        return false;
    }

    @Override
    public boolean sendVideo(Video video) {
        return false;
    }

    @Override
    public Video[] getRandomVideo() {
        return new Video[0];
    }

    @Override
    public boolean deleteVideo(int id) {
        return false;
    }
}