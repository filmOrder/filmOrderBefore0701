/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAOFactory;
import DAO.iStudioDAO;
import Domain.Studio;
import Servlet.StudioSlt;
import java.util.List;
import java.util.Map;


public class StudioSrv {

	private iStudioDAO stuDAO = DAOFactory.creatStudioDAO();

	public int add(Studio stu) {
		return stuDAO.insert(stu);
	}// 添加
    
	public int modify(Studio stu) {
		return stuDAO.update(stu);
	}//更新
        
	public int delete(Studio stu) {
		return stuDAO.delete(stu);
	}//删除

	public List<Studio> Fetch(String condt) {
		return stuDAO.select(condt);
	}
	
	public List<Studio> Fetch_(Map<String, String> map) {
		return stuDAO.select_(map);
	}

	public List<Studio> FetchAll() {
		return stuDAO.select("");
	}

	public int createSeats(Studio stu) {
		
			return stuDAO.createSeats(stu);
		
	}
	
	public List<Studio> FetchByPage(int start, int size) {
		return stuDAO.select("limit "+start+","+size);
	}
}
