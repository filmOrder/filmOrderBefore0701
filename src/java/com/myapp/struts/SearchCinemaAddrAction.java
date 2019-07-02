/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.dao.CinemaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author tellw
 */
public class SearchCinemaAddrAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        SearchCinemaAddrForm searchCinemaAddrForm = (SearchCinemaAddrForm) form;
        String searchCinemaAddrKey = searchCinemaAddrForm.getSearchCinemaAddrKey();
        CinemaDao cinemaDao = new CinemaDao();
        List list = cinemaDao.searchCinemaAddr(searchCinemaAddrKey);
        if(list.size() == 0)
            request.setAttribute("tip", 0);
        else
            request.setAttribute("tip", 1);
        request.setAttribute("list", list);
        return mapping.findForward(SUCCESS);
    }
}
