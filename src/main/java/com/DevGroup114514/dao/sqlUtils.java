package com.DevGroup114514.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Description: 数据库工具类
 * @ClassName: sqlUtils
 * @Author: Edge
 * @Date: 2024/7/5 20:22
 * @Version: 1.0
 */
public class sqlUtils
{
    // 数据库连接池数据源
    public static DataSource druidDataSource;

    private sqlUtils()
    {

        /**
         * @description: 私有构造方法
         * @param:
         * @return:
         * @author Edge
         * @date: 2024/7/5 20:23
         **/
    }

    // 静态代码块，初始化数据库连接池
    static
    {

        /**
         * @description: 静态代码块，初始化数据库连接池
         * @param:
         * @param null
         * @return:
         * @author Edge
         * @date: 2024/7/5 20:24
         **/

        try
        {
            Properties pro = new Properties();
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            druidDataSource = DruidDataSourceFactory.createDataSource(pro);
        }
        catch (Exception e)
        {
            System.out.println("数据库连接池初始化失败！");
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {

        /**
         * @description: 获取数据库连接
         * @param:
         * @return: java.sql.Connection
         * @author Edge
         * @date: 2024/7/5 20:25
         **/

        try
        {
            return druidDataSource.getConnection();
        }
        catch (SQLException e)
        {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Statement stmt , Connection conn , ResultSet rs)
    {

        /**
         * @description: 关闭数据库连接，释放资源
         * @param:
         * @param stmt
         * @param conn
         * @param rs
         * @return: void
         * @author Edge
         * @date: 2024/7/5 20:26
         **/

        if (stmt != null)
        {
            try
            {
                stmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (rs != null)
        {
            try
            {
                rs.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Statement stmt , Connection conn)
    {

        /**
         * @description: 关闭数据库连接，释放资源
         * @param:
         * @param stmt
         * @param conn
         * @return: void
         * @author Edge
         * @date: 2024/7/5 20:26
         **/

        closeConnection(stmt , conn , null);
    }

    public static DataSource getDataSource()
    {

        /**
         * @description: 获取数据库连接池数据源
         * @param:
         * @return: javax.sql.DataSource
         * @author Edge
         * @date: 2024/7/5 20:26
         **/

        return druidDataSource;
    }

    public static JdbcTemplate getJdbcTemplate()
    {
        return new JdbcTemplate(druidDataSource);
    }
}
