package common.util;

import common.MySqlRawData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MySqlOperationUtil {
    public static void insert(String sql ,Connection connection) throws SQLException {
        System.out.println("[ " + Thread.currentThread().toString() + " ] execute sql:" + sql);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
    public static void insertBatch(List<String> sqlList, Connection connection) throws SQLException {
        System.out.println("[ " + Thread.currentThread().toString() + " ] execute sql:" + sqlList.toString());
        Statement statement = connection.createStatement();
        for(String sql : sqlList){
            statement.addBatch(sql);
        }
        statement.executeBatch();
        statement.close();
        statement.close();
    }

    public static void update(String sql, Connection connection) throws SQLException {
        System.out.println("[ " + Thread.currentThread().toString() + " ] execute sql:" + sql);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
    public static void updateBatch(List<String> sqlList, Connection connection) throws SQLException {
        System.out.println("[ " + Thread.currentThread().toString() + " ] execute sql:" + sqlList.toString());
        Statement statement = connection.createStatement();
        for(String sql : sqlList){
            statement.addBatch(sql);
        }
        statement.executeBatch();
        statement.close();
        statement.close();
    }

    public static void delete(String sql, Connection connection) throws SQLException {
        System.out.println("[ " + Thread.currentThread().toString() + " ] execute sql:" + sql);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
    public static void deleteBatch(List<String> sqlList, Connection connection) throws SQLException {
        System.out.println("[ " + Thread.currentThread().toString() + " ] execute sql:" + sqlList.toString());
        Statement statement = connection.createStatement();
        for(String sql : sqlList){
            statement.addBatch(sql);
        }
        statement.executeBatch();
        statement.close();
        connection.close();
    }

    public static MySqlRawData select(String sql ,Connection connection) throws SQLException, ClassNotFoundException {
        System.out.println("[ " + Thread.currentThread().toString() + "] execute sql:" + sql);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        int columncount = resultSet.getMetaData().getColumnCount();
        String[][] colNameAndClassName = new String[columncount][2];
        for(int i = 1 ; i <=columncount ; i ++ ){
            colNameAndClassName[i-1][0] = resultSet.getMetaData().getColumnName(i);
            colNameAndClassName[i-1][1] = resultSet.getMetaData().getColumnClassName(i);
        }
        List<Object[]> rawResultList = new LinkedList<>();
        while(resultSet.next()){
            Object[] rawResult = new Object[columncount];
            for(int i = 0 ; i < columncount ; i ++ ){
                rawResult[i] = resultSet.getObject(colNameAndClassName[i][0],Class.forName(colNameAndClassName[i][1]));
            }
            rawResultList.add(rawResult);
        }
        MySqlRawData mySqlRawData = new MySqlRawData();
        mySqlRawData.setColNameAndClassName(colNameAndClassName);
        mySqlRawData.setRawResultList(rawResultList);
        statement.close();
        connection.close();
        return mySqlRawData;
    }
}
