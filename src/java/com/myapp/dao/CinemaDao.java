/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.domain.Buyer;
import com.myapp.domain.Cinema;
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
public class CinemaDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private void openConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url);      
    }
    public Cinema find(String cinemaId, String cinemaPwd) throws SQLException, ClassNotFoundException {
        Cinema cinema = new Cinema();
        openConn();
        String sql = "select * from cinema where cinemaId='" + cinemaId + "' and cinemaPwd='" + cinemaPwd + "'";
        psmt = conn.prepareStatement(sql);
        rs = psmt.executeQuery();
        if(rs.next()){
            cinema.setCinemaId(""+rs.getObject("cinemaId"));
            cinema.setCinemaUsrName(""+rs.getObject("cinemaUsrName"));
            cinema.setCinemaPwd(""+rs.getObject("cinemaPwd"));
            cinema.setCinemaName(""+rs.getObject("cinemaName"));
            cinema.setCinemaAddr(""+rs.getObject("cinemaAddr"));
            cinema.setCinemaTel(""+rs.getObject("cinemaTel"));
            cinema.setCinemaService(""+rs.getObject("cinemaService"));
            cinema.setCinemaMoney(Integer.parseInt(String.valueOf(rs.getObject("cinemaMoney"))));
        }else{
            sql = "select * from cinema where cinemaUsrName='" + cinemaId + "' and cinemaPwd='" + cinemaPwd + "'";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            if(rs.next()){
                cinema.setCinemaId(""+rs.getObject("cinemaId"));
                cinema.setCinemaUsrName(""+rs.getObject("cinemaUsrName"));
                cinema.setCinemaPwd(""+rs.getObject("cinemaPwd"));
                cinema.setCinemaName(""+rs.getObject("cinemaName"));
                cinema.setCinemaAddr(""+rs.getObject("cinemaAddr"));
                cinema.setCinemaTel(""+rs.getObject("cinemaTel"));
                cinema.setCinemaService(""+rs.getObject("cinemaService"));
                cinema.setCinemaMoney(Integer.parseInt(String.valueOf(rs.getObject("cinemaMoney"))));
            }else
                return null;
        }
        return cinema;
    }
    public String add(Cinema cinema) throws SQLException, ClassNotFoundException{
        openConn();
        String sql = "insert into cinema(cinemaId, cinemaUsrName, cinemaPwd, cinemaName, cinemaAddr, cinemaTel, cinemaService) values('"+cinema.getCinemaId()+"', '"+cinema.getCinemaUsrName()+"', '"+cinema.getCinemaPwd()+"', '"+cinema.getCinemaName()+"', '"+cinema.getCinemaAddr()+"', '"+cinema.getCinemaTel()+"', '"+cinema.getCinemaService()+"')";
        psmt = conn.prepareStatement(sql);
        psmt.executeUpdate();
        return sql;
    }
    public Cinema find1(String cinemaId) throws SQLException, ClassNotFoundException{
        openConn();
        Cinema cinema = new Cinema();
        String sql = "select * from cinema where cinemaId='"+cinemaId+"'";
        psmt = conn.prepareStatement(sql);
        rs = psmt.executeQuery();
        if(rs.next()){
            cinema.setCinemaId(""+rs.getObject("cinemaId"));
            cinema.setCinemaUsrName(""+rs.getObject("cinemaUsrName"));
            cinema.setCinemaPwd(""+rs.getObject("cinemaPwd"));
            cinema.setCinemaName(""+rs.getObject("cinemaName"));
            cinema.setCinemaAddr(""+rs.getObject("cinemaAddr"));
            cinema.setCinemaTel(""+rs.getObject("cinemaTel"));
            cinema.setCinemaService(""+rs.getObject("cinemaService"));
            cinema.setCinemaMoney(Integer.parseInt(String.valueOf(rs.getObject("cinemaMoney"))));
        }else
            return null;
        return cinema;
    }
    public Cinema find2(String cinemaName) throws SQLException, ClassNotFoundException{
        openConn();
        Cinema cinema = new Cinema();
        String sql = "select * from cinema where cinemaName='"+cinemaName+"'";
        psmt = conn.prepareStatement(sql);
        rs = psmt.executeQuery();
        if(rs.next()){
            cinema.setCinemaId(""+rs.getObject("cinemaId"));
            cinema.setCinemaUsrName(""+rs.getObject("cinemaUsrName"));
            cinema.setCinemaPwd(""+rs.getObject("cinemaPwd"));
            cinema.setCinemaName(""+rs.getObject("cinemaName"));
            cinema.setCinemaAddr(""+rs.getObject("cinemaAddr"));
            cinema.setCinemaTel(""+rs.getObject("cinemaTel"));
            cinema.setCinemaService(""+rs.getObject("cinemaService"));
            cinema.setCinemaMoney(Integer.parseInt(String.valueOf(rs.getObject("cinemaMoney"))));
        }else
            return null;
        return cinema;
    }
    
    public List searchCinemaName(String searchCinemaNameKey) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from cinema where cinemaName like '%"+searchCinemaNameKey+"%'";
        //System.out.println(sql);
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map cinemas = new HashMap();
                cinemas.put("cinemaId", rs.getString("cinemaId"));
                cinemas.put("cinemaUsrName", rs.getString("cinemaUsrName"));
                cinemas.put("cinemaPwd", rs.getString("cinemaPwd"));
                cinemas.put("cinemaName", rs.getString("cinemaName"));
                cinemas.put("cinemaAddr", rs.getString("cinemaAddr"));
                cinemas.put("cinemaTel", rs.getString("cinemaTel"));
                cinemas.put("cinemaService", rs.getString("cinemaService"));
                cinemas.put("cinemaMoney", rs.getInt("cinemaMoney"));
                //System.out.println(films.get("filmName"));
                list.add(cinemas);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List searchCinemaAddr(String searchCinemaAddrKey) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from cinema where cinemaAddr like '%"+searchCinemaAddrKey+"%'";
        //System.out.println(sql);
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map cinemas = new HashMap();
                cinemas.put("cinemaId", rs.getString("cinemaId"));
                cinemas.put("cinemaUsrName", rs.getString("cinemaUsrName"));
                cinemas.put("cinemaPwd", rs.getString("cinemaPwd"));
                cinemas.put("cinemaName", rs.getString("cinemaName"));
                cinemas.put("cinemaAddr", rs.getString("cinemaAddr"));
                cinemas.put("cinemaTel", rs.getString("cinemaTel"));
                cinemas.put("cinemaService", rs.getString("cinemaService"));
                cinemas.put("cinemaMoney", rs.getInt("cinemaMoney"));
                //System.out.println(films.get("filmName"));
                list.add(cinemas);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List getAllCinemas() throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from cinema";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map cinemas = new HashMap();
                cinemas.put("cinemaId", rs.getString("cinemaId"));
                cinemas.put("cinemaUsrName", rs.getString("cinemaUsrName"));
                cinemas.put("cinemaPwd", rs.getString("cinemaPwd"));
                cinemas.put("cinemaName", rs.getString("cinemaName"));
                cinemas.put("cinemaAddr", rs.getString("cinemaAddr"));
                cinemas.put("cinemaTel", rs.getString("cinemaTel"));
                cinemas.put("cinemaService", rs.getString("cinemaService"));
                cinemas.put("cinemaMoney", rs.getInt("cinemaMoney"));
                //System.out.println(films.get("filmName"));
                list.add(cinemas);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
