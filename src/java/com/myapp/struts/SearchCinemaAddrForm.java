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
public class SearchCinemaAddrForm extends org.apache.struts.action.ActionForm {
    
    private String name;
    
    private int number;
    
    private String searchCinemaAddrKey;

    public String getSearchCinemaAddrKey() {
        return searchCinemaAddrKey;
    }

    public void setSearchCinemaAddrKey(String searchCinemaAddrKey) {
        this.searchCinemaAddrKey = searchCinemaAddrKey;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param i
     */
    public void setNumber(int i) {
        number = i;
    }

    /**
     *
     */
    public SearchCinemaAddrForm() {
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
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) { 
        try { 
            request.setCharacterEncoding("UTF-8"); 
        } catch (Exception e) {  
            // TODO: handle exception 
        } 
    }
}
