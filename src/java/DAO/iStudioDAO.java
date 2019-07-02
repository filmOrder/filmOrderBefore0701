/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Domain.Studio;
import java.util.List;
import java.util.Map;

public interface iStudioDAO {

	public int insert(Studio stud); //插入

	public int update(Studio stud);//更新

	public int delete(Studio stud);

	public List<Studio> select(String condt);

	public int createSeats(Studio stud);

	public List<Studio> select_(Map<String, String> map);
}

