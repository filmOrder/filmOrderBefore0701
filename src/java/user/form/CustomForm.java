package user.form;

import org.apache.struts.action.ActionForm;

public class CustomForm extends ActionForm {
    private String buyerId;
    private String buyerPwd;
    private String buyerName;
    private int buyerMoney;
//    private int input;
//
//    public int getInput() {
//        return input;
//    }
//
//    public void setInput(int input) {
//        this.input = input;
//    }

    public int getBuyerMoney() {
        return buyerMoney;
    }

    public void setBuyerMoney(int buyerMoney) {
        this.buyerMoney = buyerMoney;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerPwd() {
        return buyerPwd;
    }

    public void setBuyerPwd(String buyerPwd) {
        this.buyerPwd = buyerPwd;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Override
    public String toString() {
        return "CinemaForm{" +
                "buyerId=" + buyerId +
                ", buyerPwd='" + buyerPwd + '\'' +
                ", buyerName='" + buyerName + '\'' +
                '}';
    }
}
