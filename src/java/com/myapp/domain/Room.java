/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

/**
 *
 * @author tellw
 */
public class Room {
    private int roomId;
    private String roomName;
    private String roomCinemaId;
    private int roomRow;
    private int roomColumn;
    private int roomType;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomCinemaId() {
        return roomCinemaId;
    }

    public void setRoomCinemaId(String roomCinemaId) {
        this.roomCinemaId = roomCinemaId;
    }

    public int getRoomRow() {
        return roomRow;
    }

    public void setRoomRow(int roomRow) {
        this.roomRow = roomRow;
    }

    public int getRoomColumn() {
        return roomColumn;
    }

    public void setRoomColumn(int roomColumn) {
        this.roomColumn = roomColumn;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }
    
}
