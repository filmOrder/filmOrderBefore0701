package Domain;


public class Studio {

	private int id = 0;
	private String name = ""; //名字
	private int rowCount = 0;
	private int colCount = 0;
	private int stype= 0; //种类
        private String roomCinemaId;

    public String getRoomCinemaId() {
        return roomCinemaId;
    }

    public void setRoomCinemaId(String roomCinemaId) {
        this.roomCinemaId = roomCinemaId;
    }

//
	public void setID(int ID) {
		this.id = ID;
	}

	public int getID() {
		return id;
	}
//
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
//
	public void setRowCount(int count) {
		this.rowCount = count;
	}

	public int getRowCount() {
		return rowCount;
	}
//行
	public void setColCount(int count) {
		this.colCount = count;
	}

	public int getColCount() {
		return colCount;
	}
//列
	public void setStype(int type) {
		this.stype = type;
	}

	public int  getStype() {
		return stype;
	}

}

