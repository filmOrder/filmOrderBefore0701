/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import Domain.Seat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import DAO.iStudioDAO;
import Domain.Studio;
import Servlet.StudioSlt;
import static java.lang.System.out;

import util.DBUtil;
import java.sql.ResultSet;

public class StudioDAO implements iStudioDAO {
    
	SeatDAO seatDAO = new SeatDAO();
        
	public int insert(Studio stud) {
		try {
			String sqlstr = "insert into room( roomName, roomCinemaId, roomRow, roomColumn, roomType ) values( '"
					+ stud.getName() + "','"+stud.getRoomCinemaId()+"'," + stud.getRowCount() + "," + stud.getColCount() + ","
					+ stud.getStype() + ")";  //插入
                        System.out.println(sqlstr);
			DBUtil db = new DBUtil();
			db.openConnection();
                        db.getInsertObjectIDs(sqlstr);
//			ResultSet rst = db.getInsertObjectIDs(sqlstr);//获取插入对象的ID
//			if (rst != null && rst.first()) {
//				stud.setID(rst.getInt(1));
//        
//				db.close(rst); }
			        db.close(); 
			        return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}//添加

	
	public int update(Studio stud) {
		int rtn = 0;
		try {
			String sqlstr = "update room set roomName = '" + stud.getName() + "', roomRow = "
					+ stud.getRowCount() + ", roomColumn = " + stud.getColCount() + ", roomType = "
					+ stud.getStype();
                        out.println(sqlstr);
			sqlstr += " where roomId = " + stud.getID();
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn = db.execCommand(sqlstr);//执行语句
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
	}//修改

	@Override
	public int delete(Studio stud) {
		int rtn = 0;
		try {
			String sqlstr = "delete from room ";
			sqlstr += " where roomId = " + stud.getID()+" and roomCinemaId='"+stud.getRoomCinemaId()+"'";
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn = db.execCommand(sqlstr);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
	}//删除

	@Override
	public List<Studio> select(String condt) {
		List<Studio> stuList = null;
		stuList = new LinkedList<Studio>();
		try {
			String sqlstr = "select roomId, roomName, roomRow, roomColumn, roomType from room ";
			condt.trim();
			if (!condt.isEmpty() && !condt.contains("limit")) {
				sqlstr += " where " + condt;
			} else {
				sqlstr += condt;
			}
			DBUtil db = new DBUtil();
			if (!db.openConnection()) {
				return null;
			}
			ResultSet rst = db.execQuery(sqlstr);
			if (rst != null) {
				while (rst.next()) {
					Studio stu = new Studio();
					stu.setID(rst.getInt("roomId"));
					stu.setName(rst.getString("roomName"));
					stu.setRowCount(rst.getInt("roomRow"));
                                        stu.setColCount(rst.getInt("roomColumn"));
					stu.setStype(rst.getInt("roomType"));
					stuList.add(stu);
				}
			}
			
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return stuList;
	}
       //显示
	@Override
	public int createSeats(Studio stud) {
		Seat seat = new Seat();
		try {
			for (int i = 1; i <= stud.getRowCount(); i++)
				for (int j = 1; j <= stud.getColCount(); j++) {
					seat.setStudioId(stud.getID());
					seat.setRow(i);
					seat.setColumn(j);
					seat.setSeatStatus(1);
					seatDAO.insert(seat);
				}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
//座位
	public List<Studio> select_(Map<String, String> map) {
		List<Studio> stuList = null;
		stuList = new LinkedList<Studio>();
		String condt = ""; //语句字符串
                
		if (map.get("id")!= null && !map.get("id").equals("")) {  //map
			if (condt.equals("")) {
				condt += " roomId=" + map.get("id") + "";
			} else {
				condt += " and roomId=" + map.get("id") + "";
			}
		}
		if (map.get("name")!= null && !map.get("name").equals("")) {
			if (condt.equals("")) {
				condt += " roomName='" + map.get("name") + "'";
			} else {
				condt += " and roomName='" + map.get("name") + "'";
			}
		}
		if (map.get("row")!= null && !map.get("row").equals("")) {
			if (condt.equals("")) {
				condt += " roomRow=" + map.get("row");
			} else {
				condt += " and roomRow=" + map.get("row");
			}
		}
		if (map.get("col")!= null && !map.get("col").equals("")) {
			if (condt.equals("")) {
				condt += " roomColumn=" + map.get("col");
			} else {
				condt += " and roomColumn=" + map.get("col");
			}
		}
		if (map.get("Stype")!= null && !map.get("stype").equals("")) {
			if (condt.equals("")) {
				condt += " roomType='" + map.get("stype") + "'";
			} else {
				condt += " and  roomType='" + map.get("stype") + "'";
			}
		}
		/*if (map.get("flag")!= null && !map.get("flag").equals("")) {
			if (condt.equals("")) {
				condt += " studio_flag=" + map.get("flag");
			} else {
				condt += " and studio_flag=" + map.get("flag");
			}
		}*/
		try {
			String sqlstr = "select roomId, roomName, roomRow, roomColumn, roomType from room ";
			condt.trim();//去掉字符串两端多余的空格
			if (!condt.isEmpty())
				sqlstr += " where " + condt;//加入查询字符串
			System.out.println(sqlstr);
			DBUtil db = new DBUtil();
			if (!db.openConnection()) {
				return null;
			}
			ResultSet rst = db.execQuery(sqlstr);//执行字符串
			if (rst != null) {
				while (rst.next()) {
					Studio stu = new Studio();
					stu.setID(rst.getInt("roomId"));
                                        stu.setName(rst.getString("roomName"));
                                        stu.setRowCount(rst.getInt("roomRow"));
					stu.setColCount(rst.getInt("roomColumn"));
					stu.setStype(rst.getInt("roomType"));
					stuList.add(stu);
				}//属性
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return stuList;
	}
}
//查询