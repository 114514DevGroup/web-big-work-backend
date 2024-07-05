package com.DevGroup114514;
/*
 * @Author 古佳乐
 * @Date 2024/7/5
 * @Description
 */

public interface UserManage {
    public boolean register(String username, String password);
    public boolean login(String username, String password);
    public boolean delete(String username);
}
