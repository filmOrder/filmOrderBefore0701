package film.dao;

import common.MySqlConnectionFactory;
import common.MySqlRawData;
import common.util.MySqlOperationUtil;
import common.util.SqlGenerator;
import common.util.StringUtil;
import film.form.FilmForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;

public class FilmDao {
    private static final MySqlConnectionFactory mySqlConnectionFactory = MySqlConnectionFactory.getInstance();
    public static boolean addFilm(FilmForm filmForm) throws ParseException{
        try {
            MySqlOperationUtil.insert(SqlGenerator.insertFilm(filmForm), mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFilm(int id){
        try {
            MySqlOperationUtil.delete(SqlGenerator.deleteFile(id), mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<FilmForm> getFilmList(int id){
        List<FilmForm> result = new LinkedList<>();
        try {
            MySqlRawData mySqlRawData = MySqlOperationUtil.select(SqlGenerator.selectFilm(id), mySqlConnectionFactory.getConnection());
            for(Object[] rawDataCell : mySqlRawData.getRawResultList()){
                FilmForm each = new FilmForm();
                each.setFilmId((Integer) rawDataCell[0]);
                each.setFilmName((String) rawDataCell[1]);
                each.setDuration((Integer) rawDataCell[2]);
                each.setFilmAbstract((String) rawDataCell[3]);
                each.setDirective((String) rawDataCell[4]);
                each.setNewReleaseDate((Date) rawDataCell[5]);
                each.setDurationType((String) rawDataCell[6]);
                result.add(each);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean updateFilm(FilmForm filmForm) throws ParseException, ClassNotFoundException{
//        try {
//            MySqlOperationUtil.update(SqlGenerator.updateFilm(filmForm),mySqlConnectionFactory.getConnection());
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
          try{
              Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/movie?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url); 
        PreparedStatement psmt = null;
          if(!filmForm.getFilmName().trim().equals("")){
              String sql = "update film set filmName = '"+filmForm.getFilmName()+"' where filmId = "+filmForm.getFilmId();
              psmt = conn.prepareStatement(sql);
              psmt.executeUpdate();
          }
          if(filmForm.getDuration() > 0){
              String sql = "update film set duration = '"+filmForm.getDuration()+"' where filmId = "+filmForm.getFilmId();
              psmt = conn.prepareStatement(sql);
              psmt.executeUpdate();
          }
          if(!filmForm.getFilmAbstract().trim().equals("")){
              String sql = "update film set abstract = '"+filmForm.getFilmAbstract()+"' where filmId = "+filmForm.getFilmId();
              psmt = conn.prepareStatement(sql);
              psmt.executeUpdate();
          }
          if(!filmForm.getDirective().trim().equals("")){
              String sql = "update film set directive = '"+filmForm.getDirective()+"' where filmId = "+filmForm.getFilmId();
              psmt = conn.prepareStatement(sql);
              psmt.executeUpdate();
          }
          if(!filmForm.getReleaseDate().trim().equals("")){
              String sql = "update film set releaseDate = "+StringUtil.dateConvert(filmForm.getReleaseDate())+" where filmId = "+filmForm.getFilmId();
              psmt = conn.prepareStatement(sql);
              psmt.executeUpdate();
          }
          if(!filmForm.getDurationType().trim().equals("")){
              String sql = "update film set durationType = '"+filmForm.getDurationType()+"' where filmId = "+filmForm.getFilmId();
              psmt = conn.prepareStatement(sql);
              psmt.executeUpdate();
          }
          
          return true;
          }catch (SQLException e){
              e.printStackTrace();
              return false;
          }
    }
}
