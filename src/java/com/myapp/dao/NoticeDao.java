/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tellw
 */
public class NoticeDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private void openConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url);      
    }
    public List getRecentNotice() throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from notice order by noticeTime desc limit 3";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map notices = new HashMap();
                notices.put("noticeId", rs.getInt("noticeId"));
                notices.put("noticeContent", rs.getString("noticeContent"));
                notices.put("noticeTime", rs.getString("noticeTime"));
                //System.out.println(rs.getString("noticeTime"));
                list.add(notices);
            }
            }catch(SQLException e){
                    e.printStackTrace();
                    }
            return list;
    }
}
