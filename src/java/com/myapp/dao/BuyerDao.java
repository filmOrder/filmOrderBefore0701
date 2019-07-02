/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.domain.Buyer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tellw
 */
public class BuyerDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private void openConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url);      
    }
    public Buyer find(String buyerId, String buyerPwd) throws SQLException, ClassNotFoundException {
        Buyer buyer = new Buyer();
        openConn();
        String sql = "select * from buyer where buyerId='" + buyerId + "' and buyerPwd='" + buyerPwd + "'";
        psmt = conn.prepareStatement(sql);
        rs = psmt.executeQuery();
        if(rs.next()){
            buyer.setBuyerId(""+rs.getObject("buyerId"));
            buyer.setBuyerName(""+rs.getObject("buyerName"));
            buyer.setBuyerPwd(""+rs.getObject("buyerPwd"));
            buyer.setBuyerMoney(Integer.parseInt(String.valueOf(rs.getObject("buyerMoney"))));
        }else{
            sql = "select * from buyer where buyerName='" + buyerId + "' and buyerPwd='" + buyerPwd + "'";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            if(rs.next()){
                buyer.setBuyerId(""+rs.getObject("buyerId"));
                buyer.setBuyerName(""+rs.getObject("buyerName"));
                buyer.setBuyerPwd(""+rs.getObject("buyerPwd"));
                buyer.setBuyerMoney(Integer.parseInt(String.valueOf(rs.getObject("buyerMoney"))));
            }else
                return null;
        }
        return buyer;
    }
    public void add(Buyer buyer) throws SQLException, ClassNotFoundException{
        openConn();
        String sql = "insert into buyer(buyerId, buyerName, buyerPwd) values('"+buyer.getBuyerId()+"', '"+buyer.getBuyerName()+"', '"+buyer.getBuyerPwd()+"')";
        psmt = conn.prepareStatement(sql);
        psmt.executeUpdate();
    }
    public Buyer find1(String buyerId) throws SQLException, ClassNotFoundException{
        openConn();
        Buyer buyer = new Buyer();
        String sql = "select * from buyer where buyerId='"+buyerId+"'";
        psmt = conn.prepareStatement(sql);
        rs = psmt.executeQuery();
        if(rs.next()){
            buyer.setBuyerId(""+rs.getObject("buyerId"));
            buyer.setBuyerName(""+rs.getObject("buyerName"));
            buyer.setBuyerPwd(""+rs.getObject("buyerPwd"));
            buyer.setBuyerMoney(Integer.parseInt(String.valueOf(rs.getObject("buyerMoney"))));
        }else
            return null;
        return buyer;
    }
    public Buyer find2(String buyerName) throws SQLException, ClassNotFoundException{
        openConn();
        Buyer buyer = new Buyer();
        String sql = "select * from buyer where buyerName='"+buyerName+"'";
        psmt = conn.prepareStatement(sql);
        rs = psmt.executeQuery();
        if(rs.next()){
            buyer.setBuyerId(""+rs.getObject("buyerId"));
            buyer.setBuyerName(""+rs.getObject("buyerName"));
            buyer.setBuyerPwd(""+rs.getObject("buyerPwd"));
            buyer.setBuyerMoney(Integer.parseInt(String.valueOf(rs.getObject("buyerMoney"))));
        }else
            return null;
        return buyer;
    }
    
    public int addBuyerMoney(int addedBuyerMoney, String buyerId){
        try{
        openConn();
        String sql = "update buyer set buyerMoney=buyerMoney+"+addedBuyerMoney+" where buyerId='"+buyerId+"'";
        psmt = conn.prepareStatement(sql);
        psmt.executeUpdate();
        return 1;
        } catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
