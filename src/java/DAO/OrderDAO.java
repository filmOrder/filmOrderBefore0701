package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Domain.Order;

import util.DBUtil;
import DAO.iOrderDAO;

public class OrderDAO implements iOrderDAO {

	DBUtil db;
	Connection con;
	float prices = 0;
	public List<Order> select(String condt) {
		List<Order> orderList = null;
		orderList = new LinkedList<Order>();
		try {
			String sqlstr = "select o.orderId ,o.buyerId, f.filmName ,o.seatRow,o.seatColumn ,o.orderTime from order o,cinemafilm cf,film f";
                        //where o.cinemaFilmId = cf.cinemaFilmId AND f.filmId =cf.showCinemaId
			condt.trim();
			if (condt.isEmpty())
				sqlstr += " where o.cinemaFilmId = cf.cinemaFilmId AND f.filmId =cf.showCinemaId" + condt;
			DBUtil db = new DBUtil();
			if (!db.openConnection()) {
				return null;
			}
			ResultSet rst = db.execQuery(sqlstr);
			if (rst != null) {
				while (rst.next()) {
					Order order = new Order();
					order.setorderId(rst.getInt("o.orderId"));
					order.setbuyerId("o.buyerId");
					order.setfilmName("f.filmName");
					order.setseatRow(rst.getInt("o.seatRow"));
					order.setseatColumn(rst.getInt("o.seatColumn"));
					order.setorderTime(rst.getTimestamp("o.orderTime"));
					
					orderList.add(order);
				}
                                db.close(rst);
			}
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return orderList;
	}

}
