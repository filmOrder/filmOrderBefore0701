package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory {
    private String driverClassName;
    private MySqlConnectionFactory(){
        driverClassName = MySqlConstant.MYSQL_DRIVER_NAME;
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static MySqlConnectionFactory getInstance(){
        return MySqlConnectionFactoryHolder.mySqlConnectionFactory;
    }
    private static class MySqlConnectionFactoryHolder {
        private static MySqlConnectionFactory mySqlConnectionFactory = new MySqlConnectionFactory();
    }
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        return DriverManager.getConnection(MySqlConstant.MYSQL_URL,MySqlConstant.MYSQL_USER, MySqlConstant.MYSQL_PASSWORD);
    }
}
