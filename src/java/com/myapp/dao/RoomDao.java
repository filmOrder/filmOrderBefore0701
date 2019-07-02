/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.domain.Cinema;
import com.myapp.domain.Room;
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
public class RoomDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private void openConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url);      
    }
    
    public List getAllRoomsByCinema(Cinema cinema) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from room where roomCinemaId = '"+cinema.getCinemaId()+"'";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map rooms = new HashMap();
                rooms.put("roomId", rs.getInt("roomId"));
                rooms.put("roomName", rs.getString("roomName"));
                rooms.put("roomCinemaId", rs.getString("roomCinemaId"));
                rooms.put("roomRow", rs.getInt("roomRow"));
                rooms.put("roomColumn", rs.getInt("roomColumn"));
                rooms.put("roomType", rs.getInt("roomType"));
                list.add(rooms);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public Room getRoomByName(String roomName, Cinema cinema) throws SQLException, ClassNotFoundException{
        Room room = new Room();
        openConn();
        String sql = "select * from room where roomName='"+roomName+"' and roomCinemaId='"+cinema.getCinemaId()+"'";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            if(rs.next()){
                room.setRoomId(rs.getInt("roomId"));
                room.setRoomName(rs.getString("roomName"));
                room.setRoomCinemaId(rs.getString("roomCinemaId"));
                room.setRoomRow(rs.getInt("roomRow"));
                room.setRoomColumn(rs.getInt("roomColumn"));
                room.setRoomType(rs.getInt("roomType"));
            }else
                return null;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return room;
    }
    public Room getRoomById(int roomId) throws SQLException, ClassNotFoundException{
        Room room = new Room();
        openConn();
        String sql = "select * from room where roomId="+roomId;
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            if(rs.next()){
                room.setRoomId(rs.getInt("roomId"));
                room.setRoomName(rs.getString("roomName"));
                room.setRoomCinemaId(rs.getString("roomCinemaId"));
                room.setRoomRow(rs.getInt("roomRow"));
                room.setRoomColumn(rs.getInt("roomColumn"));
                room.setRoomType(rs.getInt("roomType"));
            }else
                return null;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return room;
    }
}
