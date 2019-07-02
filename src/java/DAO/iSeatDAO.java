/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import Domain.Seat;
import java.util.List;
import java.util.Map;



public interface iSeatDAO {

	public int insert(Seat seat);

	public int update(Seat seat);

	public int delete(int id);

	public List<Seat> select(String condt);
	
	public List<Seat> select_(Map<String, String> map);
}


