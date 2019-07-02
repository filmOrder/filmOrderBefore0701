/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.domain.Cinema;
import com.myapp.domain.CinemaFilm;
import com.myapp.domain.Room;
import common.util.StringUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tellw
 */
public class CinemaFilmDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private void openConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url);      
    }
    public List getAllCinemaFilmByRoomAndDate(Room room, String showDate) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from cinemafilm where showRoomId = "+room.getRoomId()+" and showDate="+showDate;
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map cinemafilms = new HashMap();
                cinemafilms.put("cinemaFilmId", rs.getInt("cinemaFilmId"));
                cinemafilms.put("showFilmId", rs.getInt("showFilmId"));
                cinemafilms.put("showRoomId", rs.getInt("showRoomId"));
                cinemafilms.put("showTime", rs.getInt("showTime"));
                cinemafilms.put("price", rs.getInt("price"));
                cinemafilms.put("showDate", rs.getDate("showDate"));
                list.add(cinemafilms);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public int add(CinemaFilm cinemaFilm) throws SQLException, ClassNotFoundException{
        openConn();
        try {
			String sqlstr = "insert into cinemafilm(showFilmId, showRoomId, showTime, price, showDate) values("
					+ cinemaFilm.getShowFilmId() + ","+cinemaFilm.getShowRoomId()+"," + cinemaFilm.getShowTime() + "," + cinemaFilm.getPrice() + ","
					+ StringUtil.dateConvert(cinemaFilm.getShowDate()) + ")";  //插入
                        psmt = conn.prepareStatement(sqlstr);
        psmt.executeUpdate();
			        return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
    }
    
    public List getCinemaFilmByFilm(int filmId) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from cinemafilm where showFilmId = "+filmId;
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map cinemafilms = new HashMap();
                cinemafilms.put("cinemaFilmId", rs.getInt("cinemaFilmId"));
                cinemafilms.put("showFilmId", rs.getInt("showFilmId"));
                cinemafilms.put("showRoomId", rs.getInt("showRoomId"));
                cinemafilms.put("showTime", rs.getInt("showTime"));
                cinemafilms.put("price", rs.getInt("price"));
                cinemafilms.put("showDate", rs.getDate("showDate"));
                list.add(cinemafilms);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List getTheFilmOfCinema(String cinemaId) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select cinemafilm.showFilmId from cinemafilm, room where cinemafilm.showRoomId=room.roomId and room.roomCinemaId = '"+cinemaId+"'";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map cinemafilms = new HashMap();
                cinemafilms.put("showFilmId", rs.getInt("showFilmId"));
                list.add(cinemafilms);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List getBuyResource(int filmId, String cinemaId) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select cinemafilm.*, room.roomName, room.roomRow, room.roomColumn, room.roomType from cinemafilm, room where cinemafilm.showFilmId = "+filmId+" and room.roomId=cinemafilm.showRoomId and room.roomCinemaId='"+cinemaId+"'";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map cinemafilms = new HashMap();
                cinemafilms.put("cinemaFilmId", rs.getInt("cinemaFilmId"));
                cinemafilms.put("showFilmId", rs.getInt("showFilmId"));
                cinemafilms.put("showRoomId", rs.getInt("showRoomId"));
                cinemafilms.put("showTime", rs.getInt("showTime"));
                cinemafilms.put("price", rs.getInt("price"));
                cinemafilms.put("showDate", new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("showDate")));
                cinemafilms.put("roomName", rs.getString("roomName"));
                cinemafilms.put("roomRow", rs.getInt("roomRow"));
                cinemafilms.put("roomColumn", rs.getInt("roomColumn"));
                cinemafilms.put("roomType", rs.getInt("roomType"));
                list.add(cinemafilms);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public CinemaFilm getById(int cinemaFilmId) throws SQLException, ClassNotFoundException{
        CinemaFilm cinemaFilm = new CinemaFilm();
        openConn();
        String sql = "select * from cinemafilm where cinemaFilmId="+cinemaFilmId;
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            if(rs.next()){
                cinemaFilm.setCinemaFilmId(rs.getInt("cinemaFilmId"));
                cinemaFilm.setShowFilmId(rs.getInt("showFilmId"));
                cinemaFilm.setShowRoomId(rs.getInt("showRoomId"));
                cinemaFilm.setShowTime(rs.getInt("showTime"));
                cinemaFilm.setPrice(rs.getInt("price"));
                cinemaFilm.setShowDate(rs.getString("showDate"));
            }else
                return null;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cinemaFilm;
    }
}
