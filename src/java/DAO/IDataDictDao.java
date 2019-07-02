/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.util.Map;

import Domain.*;

public interface IDataDictDao{

	public int insert(DataDict ddict);

	public int update(DataDict ddict);

	public int delete(int id);

	public List<DataDict> select(String condt);

	public List<DataDict> findByID(int id);

	public void findAllSonByID(List<DataDict> list, int id);

	public boolean hasChildren(int id);

	public List<DataDict> select_(Map<String, String> map);
}
