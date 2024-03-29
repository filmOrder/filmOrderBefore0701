/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil
{
    private Connection conn = null;
    private String dbDriver = "com.mysql.jdbc.Driver"; // 定义驱动
    private String dbURL = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8"; // 定义URL
    private String userName = "root"; // 定义用户名
    private String password = "123456"; // 定义密码

    // 从配置文件取数据库链接参数
    private void loadConnProperties()
    {

    }

    public boolean openConnection()
    {
        try
        {
            loadConnProperties();
            Class.forName(dbDriver);
            this.conn = DriverManager.getConnection(dbURL, userName, password);
            return true;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            classnotfoundexception.printStackTrace();
            System.err.println("db: " + classnotfoundexception.getMessage());
        }
        catch (SQLException sqlexception)
        {
            System.err.println("db.getconn(): " + sqlexception.getMessage());
        }
        return false;
    }
//连接数据库
    protected void finalize() throws Exception
    {
        try
        {
            if (null != conn)
                conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    // 查询并得到结果集
    public ResultSet execQuery(String sql) throws Exception
    {
        ResultSet rstSet = null;
        try
        {
            if (null == conn)
                throw new Exception("Database not connected!");
            Statement stmt = conn.createStatement();
            rstSet = stmt.executeQuery(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return rstSet;
    }

    // 插入一条新纪录，并获取标识列的值
    public ResultSet getInsertObjectIDs(String insertSql) throws Exception
    {
        ResultSet rst = null;
        try
        {
            if (null == conn)
                throw new Exception("Database not connected!");

            Statement stmt = conn.createStatement();  //创建一个statement对象
            stmt.executeUpdate(insertSql);
//            stmt.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
//            rst = stmt.getGeneratedKeys(); //关闭

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return rst;
    }

    // 插入、更新、删除
    public int execCommand(String sql) throws Exception
    {
        int flag = 0;
        try
        {
            if (null == conn)
                throw new Exception("Database not connected!");

            Statement stmt = conn.createStatement();
            flag = stmt.executeUpdate(sql);

            stmt.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    // add by @author Wang
    // 2016 5 29
    public PreparedStatement execPrepared(String psql) throws Exception
    {
        PreparedStatement pstmt = null;
        try
        {
            if (null == conn)
                throw new Exception("Database not connected!");
            pstmt = conn.prepareStatement(psql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pstmt;
    }

    // 释放资源
    public void close(ResultSet rst) throws Exception
    {
        try
        {  
            Statement stmt = rst.getStatement();
            rst.close();
            stmt.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // 释放资源
    public void close(Statement stmt) throws Exception
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

    // 释放资源
    public void close() throws SQLException, Exception
    {
        if (null != conn)
        {
            conn.close();
            conn = null;
        }
    }

    public Connection getConn()
    {
        return conn;
    }

}
