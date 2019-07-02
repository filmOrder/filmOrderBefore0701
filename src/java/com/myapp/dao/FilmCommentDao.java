/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.domain.FilmComment;
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
public class FilmCommentDao {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private void openConn() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url);      
    }
    public void add(FilmComment filmComment) throws SQLException, ClassNotFoundException{
        openConn();
        String sql = "insert into filmcomment(filmId, commentBuyerId, comment) values("+filmComment.getFilmId()+", '"+filmComment.getCommentBuyerId()+"', '"+filmComment.getComment()+"')";
        psmt = conn.prepareStatement(sql);
        psmt.executeUpdate();
    }
    public List getAllFilmCommentByFilm(int filmId) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from filmcomment where filmId="+filmId+" order by filmCommentTime desc";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map filmComments = new HashMap();
                filmComments.put("filmCommentId", rs.getInt("filmCommentId"));
                filmComments.put("filmId", rs.getInt("filmId"));
                filmComments.put("commentBuyerId", rs.getString("commentBuyerId"));
                filmComments.put("comment", rs.getString("comment"));
                filmComments.put("filmCommentTime", rs.getString("filmCommentTime"));
                list.add(filmComments);
            }
            }catch(SQLException e){
                    e.printStackTrace();
                    }
            return list;
    }
    public List getAllFilmCommentsByPage(int pageSize, int pageIndex, int filmId){
        List list = new ArrayList();
        String sql = "select * from (SELECT filmCommentId, filmId, commentBuyerId, comment, filmCommentTime, @curRank := @curRank + 1 AS rank FROM (select * from filmcomment where filmId="+filmId+" order by filmCommentTime desc) p, (SELECT @curRank := 0) q) r where rank between "+(pageSize*(pageIndex-1)+1)+" and "+pageSize*pageIndex;
        try{
            psmt=conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map filmComments = new HashMap();
                filmComments.put("filmCommentId", rs.getInt("filmCommentId"));
                filmComments.put("filmId", rs.getInt("filmId"));
                filmComments.put("commentBuyerId", rs.getString("commentBuyerId"));
                filmComments.put("comment", rs.getString("comment"));
                filmComments.put("filmCommentTime", rs.getString("filmCommentTime"));
                list.add(filmComments);
}
            }catch(SQLException e){
                    e.printStackTrace();
                    }
            return list;
    }
    public int countFilmCommentByFilm(int filmId) throws SQLException, ClassNotFoundException{
        int count = 0;
        String sql = "select count(*) from filmcomment where filmId="+filmId;
        openConn();
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
    public int getTotalPage(int pageSize, int filmId) throws SQLException, ClassNotFoundException{
        int totalPage = countFilmCommentByFilm(filmId);
        return (totalPage%pageSize==0)?(totalPage/pageSize):(totalPage/pageSize+1);
    }
    public List getAllFilmCommentByBuyer(String buyerId) throws SQLException, ClassNotFoundException{
        List list = new ArrayList();
        openConn();
        String sql = "select * from filmcomment where commentBuyerId='"+buyerId+"' order by filmCommentTime desc";
        try{
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()){
                Map filmComments = new HashMap();
                filmComments.put("filmCommentId", rs.getInt("filmCommentId"));
                filmComments.put("filmId", rs.getInt("filmId"));
                filmComments.put("commentBuyerId", rs.getString("commentBuyerId"));
                filmComments.put("comment", rs.getString("comment"));
                filmComments.put("filmCommentTime", rs.getString("filmCommentTime"));
                list.add(filmComments);
            }
            }catch(SQLException e){
                    e.printStackTrace();
                    }
            return list;
    }
}
