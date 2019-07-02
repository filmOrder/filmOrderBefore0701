package Service;

import java.util.List;
import java.util.Map;

import DAO.DAOFactory;
import Domain.Order;

import DAO.*;

public class OrderSrv {

	private iOrderDAO OrderDAO = DAOFactory.creatOrderDAO();

	public List<Order> FetchAll() {
		return OrderDAO.select("");
	}
	
}
