package Service;

import DAO.*;
import DAO.*;
import Servlet.*;
import java.util.List;
import java.util.Map;
import com.myapp.domain.Cinema;

public class sinfoSrv {

	private iSinfoDAO cinDAO = DAOFactory.creatSinfoDAO();

	
    
	public int modify(Cinema cin) {
		return cinDAO.update(cin);
	}//更新
        
	
	/*public List<Cinema> Fetch(String condt) {
		return cinDAO.select(condt);
	}*/
	/*public List<Cinema> Fetch_(Map<String, String> map) {
		return cinDAO.select_(map);
	} //查找并修改*/
        

	
	
	/*
	public List<Cinema> FetchByPage(int start, int size) {
		return cinDAO.select("limit "+start+","+size);
	}*/
}
