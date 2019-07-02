/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.domain.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tellw
 */
public class OrderDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private void openConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url);      
    }
    public int add(Order order){
        try{
            openConn();
        String sql = "insert into order(buyerId, cinemaFilmId, seatRow, seatColumn) values('"+order.getBuyerId()+"', "+order.getCinemaFilmId()+", "+order.getSeatRow()+", "+order.getSeatColumn()+")";
        psmt = conn.prepareStatement(sql);
        psmt.executeUpdate();
        return 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
