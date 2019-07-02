/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author tellw
 */
public class BuyerRegisterForm extends org.apache.struts.action.ActionForm {
    
    private String buyerId;
    private String buyerName;
    private String buyerPwd;
    private String buyerPwdAgain;
    private String buyerIdError;
    private String buyerNameError;
    private String buyerPwdError;
    private String buyerPwdAgainError;

    public String getBuyerIdError() {
        return buyerIdError;
    }

    public void setBuyerIdError(String buyerIdError) {
        this.buyerIdError = buyerIdError;
    }

    public String getBuyerNameError() {
        return buyerNameError;
    }

    public void setBuyerNameError(String buyerNameError) {
        this.buyerNameError = buyerNameError;
    }

    public String getBuyerPwdError() {
        return buyerPwdError;
    }

    public void setBuyerPwdError(String buyerPwdError) {
        this.buyerPwdError = buyerPwdError;
    }

    public String getBuyerPwdAgainError() {
        return buyerPwdAgainError;
    }

    public void setBuyerPwdAgainError(String buyerPwdAgainError) {
        this.buyerPwdAgainError = buyerPwdAgainError;
    }

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

    public String getBuyerPwdAgain() {
        return buyerPwdAgain;
    }

    public void setBuyerPwdAgain(String buyerPwdAgain) {
        this.buyerPwdAgain = buyerPwdAgain;
    }

//    }

    /**
     *
     */
    public BuyerRegisterForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getBuyerName() == null || getBuyerName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
