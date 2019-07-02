package user.dao;

import common.MySqlConnectionFactory;
import common.MySqlRawData;
import common.util.MySqlOperationUtil;
import common.util.SqlGenerator;
import user.form.CustomForm;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomDao {
    private static final MySqlConnectionFactory mySqlConnectionFactory = MySqlConnectionFactory.getInstance();
    public static boolean addCustom(CustomForm customForm){
        try {
            MySqlOperationUtil.insert(SqlGenerator.addCustom(customForm),mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteCustom(String id){
        try {
            MySqlOperationUtil.delete(SqlGenerator.deleteCustom(id),mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateCustom(CustomForm customForm){
        try {
            MySqlOperationUtil.update(SqlGenerator.updateCustom(customForm), mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<CustomForm> getCustomList(String id){
        List<CustomForm> result = new LinkedList<>();
        try {
            MySqlRawData mySqlRawData = MySqlOperationUtil.select(SqlGenerator.selectCustom(id),mySqlConnectionFactory.getConnection());
            for(Object[] rawDataCell : mySqlRawData.getRawResultList()){
                CustomForm each = new CustomForm();
                each.setBuyerId((String) rawDataCell[0]);
                each.setBuyerName((String) rawDataCell[1]);
                each.setBuyerPwd((String) rawDataCell[2]);
                each.setBuyerMoney((Integer) rawDataCell[3]);
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
    
    public static List<CustomForm> getAllCustomList(){
        List<CustomForm> result = new LinkedList<>();
        try {
            MySqlRawData mySqlRawData = MySqlOperationUtil.select(SqlGenerator.selectCustom(),mySqlConnectionFactory.getConnection());
            for(Object[] rawDataCell : mySqlRawData.getRawResultList()){
                CustomForm each = new CustomForm();
                each.setBuyerId((String) rawDataCell[0]);
                each.setBuyerName((String) rawDataCell[1]);
                each.setBuyerPwd((String) rawDataCell[2]);
                each.setBuyerMoney((Integer) rawDataCell[3]);
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
