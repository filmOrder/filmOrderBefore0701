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
public class Buyer {
    private String buyerId;
    private String buyerName;
    private String buyerPwd;
    private int buyerMoney = 0;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPwd() {
        return buyerPwd;
    }

    public void setBuyerPwd(String buyerPwd) {
        this.buyerPwd = buyerPwd;
    }

    public int getBuyerMoney() {
        return buyerMoney;
    }

    public void setBuyerMoney(int buyerMoney) {
        this.buyerMoney = buyerMoney;
    }
}
