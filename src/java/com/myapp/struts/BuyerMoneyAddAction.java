/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.dao.BuyerDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author tellw
 */
public class BuyerMoneyAddAction extends org.apache.struts.action.Action {

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
        BuyerMoneyAddForm buyerMoneyAddForm = (BuyerMoneyAddForm)form;
        int addedBuyerMoney = buyerMoneyAddForm.getAddedBuyerMoney();
        String buyerId = buyerMoneyAddForm.getBuyerId();
        BuyerDao buyerDao = new BuyerDao();
        if(addedBuyerMoney != 0){
         if(buyerDao.addBuyerMoney(addedBuyerMoney, buyerId) == 1){
            request.setAttribute("error", "充值成功");
        }else
            request.setAttribute("error", "充值失败");   
        }else
            request.setAttribute("error", "请填入值");
        request.getRequestDispatcher("me.jsp");
        return mapping.findForward(SUCCESS);
    }
}
