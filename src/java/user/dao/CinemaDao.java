package user.dao;

import common.MySqlConnectionFactory;
import common.MySqlRawData;
import common.util.MySqlOperationUtil;
import common.util.SqlGenerator;
import user.form.CinemaForm;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CinemaDao {
    private static final MySqlConnectionFactory mySqlConnectionFactory = MySqlConnectionFactory.getInstance();
    public static boolean addCinema(CinemaForm cinemaForm){
        try {
            MySqlOperationUtil.insert(SqlGenerator.addCinema(cinemaForm),mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteCinema(String id){
        try {
            MySqlOperationUtil.delete(SqlGenerator.deleteCinema(id),mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateCinema(CinemaForm cinemaForm){
        try {
            MySqlOperationUtil.update(SqlGenerator.updateCinema(cinemaForm), mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<CinemaForm> getCinemaList(String id){
        List<CinemaForm> result = new LinkedList<>();
        try {
            MySqlRawData mySqlRawData =  MySqlOperationUtil.select(SqlGenerator.selectCinema(id),mySqlConnectionFactory.getConnection());
            for(Object[] rawDataCell : mySqlRawData.getRawResultList()){
                CinemaForm each = new CinemaForm();
                each.setCinemaId((String) rawDataCell[0]);
                each.setCinemaPwd((String) rawDataCell[2]);
                each.setCinemaAddr((String) rawDataCell[4]);
                each.setCinemaTel((String) rawDataCell[5]);
                each.setCinemaService((String) rawDataCell[6]);
                each.setCinemaName((String) rawDataCell[3]);
                each.setCinemaUsrName((String) rawDataCell[1]);
                each.setCinemaMoney((Integer) rawDataCell[7]);
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
    public static List<CinemaForm> getAllCinemaList(){
        List<CinemaForm> result = new LinkedList<>();
        try {
            MySqlRawData mySqlRawData =  MySqlOperationUtil.select(SqlGenerator.selectAllCinema(),mySqlConnectionFactory.getConnection());
            for(Object[] rawDataCell : mySqlRawData.getRawResultList()){
                CinemaForm each = new CinemaForm();
                each.setCinemaId((String) rawDataCell[0]);
                each.setCinemaPwd((String) rawDataCell[2]);
                each.setCinemaAddr((String) rawDataCell[4]);
                each.setCinemaTel((String) rawDataCell[5]);
                each.setCinemaService((String) rawDataCell[6]);
                each.setCinemaName((String) rawDataCell[3]);
                each.setCinemaUsrName((String) rawDataCell[1]);
                each.setCinemaMoney((Integer) rawDataCell[7]);
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

}
