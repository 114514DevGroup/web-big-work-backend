package com.DevGroup114514;
/*
 * @Author 古佳乐
 * @Date 2024/7/5
 * @Description
 */

public interface VideoManage {
    public boolean sendVideo(Video video);
    public Video[] getRandomVideo();
    public boolean deleteVideo(int id);
}
