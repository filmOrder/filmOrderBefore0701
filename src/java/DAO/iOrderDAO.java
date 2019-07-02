package DAO;

import java.util.List;
import java.util.Map;

import Domain.*;


public interface iOrderDAO {

	public List<Order> select(String condt);
	
	
}
