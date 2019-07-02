/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author viki
 */


public class DAOFactory {
	
	
	public static iStudioDAO creatStudioDAO(){
		return new StudioDAO();
	}//Interface
	public static iSinfoDAO creatSinfoDAO(){
		return new SinfoDAO();
	}//Interface
        public static iOrderDAO creatOrderDAO(){
		return new OrderDAO();
	}//Interface
	/*public static IDataDictDAO creatDataDictDAO(){
		return new DataDictDAO();
	}

	public static iScheduleDAO creatScheduleDAO(){
		return new ScheduleDAO();
	}
	
	public static iPlayDAO creatPlayDAO(){
		return new PlayDAO();
	} */

	public static iSeatDAO creatSeatDAO(){
		return new SeatDAO();
	}

	/*public static iTicketDAO creatTicketDAO(){
		return new TicketDAO();
	}

	public static iSaleDAO creatSaleDAO(){
		return new SaleDAO();
	}
	
	public static iSaleItemDAO creatSaleItemDAO(){
		return new SaleItemDAO();
	}*/
}
