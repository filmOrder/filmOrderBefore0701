package notice.dao;

import common.MySqlConnectionFactory;
import common.MySqlRawData;
import common.util.MySqlOperationUtil;
import common.util.SqlGenerator;
import film.form.FilmForm;
import notice.form.NoticeForm;

import java.sql.SQLException;
import java.util.*;

public class NoticeDao {
    private static final MySqlConnectionFactory mySqlConnectionFactory = MySqlConnectionFactory.getInstance();
    public static boolean addNotice(NoticeForm noticeForm){
        try {
            MySqlOperationUtil.insert(SqlGenerator.insertNotice(noticeForm),mySqlConnectionFactory.getConnection() );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean deleteNotice(int id){
        try {
            MySqlOperationUtil.delete(SqlGenerator.deleteNotice(id),mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean updateNotice(NoticeForm noticeForm){
        try {
            MySqlOperationUtil.update(SqlGenerator.updateNotice(noticeForm), mySqlConnectionFactory.getConnection());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static List<NoticeForm> getNoticeList(int id){
        List<NoticeForm> result = new LinkedList<>();
        try {
            MySqlRawData mySqlRawData = MySqlOperationUtil.select(SqlGenerator.selectNotice(id), mySqlConnectionFactory.getConnection());
            for(Object[] rawDataCell : mySqlRawData.getRawResultList()){
                NoticeForm each = new NoticeForm();
                each.setNoticeId((Integer) rawDataCell[0]);
                each.setNoticeContent((String) rawDataCell[1]);
                each.setNoticeTime((Date)rawDataCell[2]);
                result.add(each);
            }
            return result;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
