package Domain;

import java.util.Date;
import java.sql.Timestamp;
public class Order {
//o.orderId ,o.buyerId, f.filmName ,o.seatRow,o.seatColumn ,o.orderTime
	private int orderId;
	private String buyerId;
	private String filmName;
        private int seatRow;
        private int seatColumn;
	private Timestamp  orderTime;
        
        
        
        
	public int getorderId() {
		return orderId;
	}

	public void setorderId(int oid) {
		this.orderId = oid;
	}

	public String getbuyerId() {
		return buyerId;
	}

	public void setbuyerId(String bid) {
		this.buyerId = bid;
	}
        public String getfilmName() {
		return filmName;
	}

	public void setfilmName(String filmname) {
		this.filmName = filmname;
	}
	public int getseatRow() {
		return seatRow;
	}

	public void setseatRow(int seatrow) {
		this.seatRow=seatrow;
	}

	public int getseatColumn() {
		return seatColumn;
	}

	public void setseatColumn(int seatcolumn) {
		this.seatColumn = seatcolumn;
	}

	public Timestamp getorderTime() {
		return orderTime;
	}

	public void setorderTime(Timestamp ot) {
		this.orderTime = ot;
	}

}