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
public class LoginForm extends org.apache.struts.action.ActionForm {
    private String loginId;
    private String loginPwd;
    private String role;
    private String loginIdError;
    private String loginPwdError;
    private String roleError;

    public String getLoginIdError() {
        return loginIdError;
    }

    public void setLoginIdError(String loginIdError) {
        this.loginIdError = loginIdError;
    }

    public String getLoginPwdError() {
        return loginPwdError;
    }

    public void setLoginPwdError(String loginPwdError) {
        this.loginPwdError = loginPwdError;
    }

    public String getRoleError() {
        return roleError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     *
     */
    public LoginForm() {
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
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
