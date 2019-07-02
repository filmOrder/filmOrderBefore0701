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
public class CinemaRegisterForm extends org.apache.struts.action.ActionForm {
    
    private String cinemaId;
    private String cinemaUsrName;
    private String cinemaPwd;
    private String cinemaPwdAgain;
    private String cinemaName;
    private String cinemaAddr;
    private String cinemaTel;
    private String cinemaService;
    private String cinemaIdError;
    private String cinemaUsrNameError;
    private String cinemaPwdError;
    private String cinemaPwdAgainError;
    private String cinemaNameError;
    private String cinemaAddrError;
    private String cinemaTelError;
    private String cinemaServiceError;

    public String getCinemaIdError() {
        return cinemaIdError;
    }

    public void setCinemaIdError(String cinemaIdError) {
        this.cinemaIdError = cinemaIdError;
    }

    public String getCinemaUsrNameError() {
        return cinemaUsrNameError;
    }

    public void setCinemaUsrNameError(String cinemaUsrNameError) {
        this.cinemaUsrNameError = cinemaUsrNameError;
    }

    public String getCinemaPwdError() {
        return cinemaPwdError;
    }

    public void setCinemaPwdError(String cinemaPwdError) {
        this.cinemaPwdError = cinemaPwdError;
    }

    public String getCinemaPwdAgainError() {
        return cinemaPwdAgainError;
    }

    public void setCinemaPwdAgainError(String cinemaPwdAgainError) {
        this.cinemaPwdAgainError = cinemaPwdAgainError;
    }

    public String getCinemaNameError() {
        return cinemaNameError;
    }

    public void setCinemaNameError(String cinemaNameError) {
        this.cinemaNameError = cinemaNameError;
    }

    public String getCinemaAddrError() {
        return cinemaAddrError;
    }

    public void setCinemaAddrError(String cinemaAddrError) {
        this.cinemaAddrError = cinemaAddrError;
    }

    public String getCinemaTelError() {
        return cinemaTelError;
    }

    public void setCinemaTelError(String cinemaTelError) {
        this.cinemaTelError = cinemaTelError;
    }

    public String getCinemaServiceError() {
        return cinemaServiceError;
    }

    public void setCinemaServiceError(String cinemaServiceError) {
        this.cinemaServiceError = cinemaServiceError;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaUsrName() {
        return cinemaUsrName;
    }

    public void setCinemaUsrName(String cinemaUsrName) {
        this.cinemaUsrName = cinemaUsrName;
    }

    public String getCinemaPwd() {
        return cinemaPwd;
    }

    public void setCinemaPwd(String cinemaPwd) {
        this.cinemaPwd = cinemaPwd;
    }

    public String getCinemaPwdAgain() {
        return cinemaPwdAgain;
    }

    public void setCinemaPwdAgain(String cinemaPwdAgain) {
        this.cinemaPwdAgain = cinemaPwdAgain;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddr() {
        return cinemaAddr;
    }

    public void setCinemaAddr(String cinemaAddr) {
        this.cinemaAddr = cinemaAddr;
    }

    public String getCinemaTel() {
        return cinemaTel;
    }

    public void setCinemaTel(String cinemaTel) {
        this.cinemaTel = cinemaTel;
    }

    public String getCinemaService() {
        return cinemaService;
    }

    public void setCinemaService(String cinemaService) {
        this.cinemaService = cinemaService;
    }

    /**
     *
     */
    public CinemaRegisterForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) { 
        try { 
            request.setCharacterEncoding("UTF-8"); 
        } catch (Exception e) {  
            // TODO: handle exception 
        } 
    }

}
