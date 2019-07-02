/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.domain.Film;
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
public class FilmDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private void openConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url);      
    }
    public List searchFilmName(String searchFilmNameKey) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from film where filmName like '%"+searchFilmNameKey+"%'";
        //System.out.println(sql);
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map films = new HashMap();
                films.put("filmId", rs.getInt("filmId"));
                films.put("filmName", rs.getString("filmName"));
                films.put("duration", rs.getInt("duration"));
                films.put("filmAbstract", rs.getString("abstract"));
                films.put("directive", rs.getString("directive"));
                films.put("releaseDate", rs.getDate("releaseDate"));
                films.put("durationType", rs.getString("durationType"));
                //System.out.println(films.get("filmName"));
                list.add(films);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List searchFilmType(String searchFilmTypeKey) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from film where durationType like '%"+searchFilmTypeKey+"%'";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map films = new HashMap();
                films.put("filmId", rs.getInt("filmId"));
                films.put("filmName", rs.getString("filmName"));
                films.put("duration", rs.getInt("duration"));
                films.put("filmAbstract", rs.getString("abstract"));
                films.put("directive", rs.getString("directive"));
                films.put("releaseDate", rs.getDate("releaseDate"));
                films.put("durationType", rs.getString("durationType"));
                list.add(films);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List searchFilmDate(int style) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String intoDBDate = StringUtil.dateConvert(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        String sql = "";
        if(style == 1)
            sql = "select * from film where releaseDate <= "+intoDBDate;
        else if(style == 2)
            sql = "select * from film where releaseDate > "+intoDBDate;
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map films = new HashMap();
                films.put("filmId", rs.getInt("filmId"));
                films.put("filmName", rs.getString("filmName"));
                films.put("duration", rs.getInt("duration"));
                films.put("filmAbstract", rs.getString("abstract"));
                films.put("directive", rs.getString("directive"));
                films.put("releaseDate", rs.getDate("releaseDate"));
                films.put("durationType", rs.getString("durationType"));
                list.add(films);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public List getAllFilms() throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from film";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map films = new HashMap();
                films.put("filmId", rs.getInt("filmId"));
                films.put("filmName", rs.getString("filmName"));
                films.put("duration", rs.getInt("duration"));
                films.put("filmAbstract", rs.getString("abstract"));
                films.put("directive", rs.getString("directive"));
                films.put("releaseDate", rs.getDate("releaseDate"));
                films.put("durationType", rs.getString("durationType"));
                list.add(films);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public Film getFilm(int filmId) throws SQLException, ClassNotFoundException{
        Film film = new Film();
        openConn();
        String sql = "select * from film where filmId="+filmId;
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            if(rs.next()){
                film.setFilmId(rs.getInt("filmId"));
                film.setFilmName(rs.getString("filmName"));
                film.setDuration(rs.getInt("duration"));
                film.setFilmAbstract(rs.getString("abstract"));
                film.setDirective(rs.getString("directive"));
                film.setReleaseDate(rs.getDate("releaseDate"));
                film.setDurationType(rs.getString("durationType"));
            }else
                return null;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return film;
    }
}
