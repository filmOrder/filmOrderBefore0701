/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.dao.BuyerDao;
import com.myapp.domain.Buyer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author tellw
 */
public class BuyerRegisterAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "buyerRegisterSuccess";
    private static final String FAILURE = "buyerRegisterFailure";

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
        BuyerRegisterForm buyerRegisterForm = (BuyerRegisterForm)form;
        String buyerId = buyerRegisterForm.getBuyerId();
        String buyerName = buyerRegisterForm.getBuyerName();
        String buyerPwd = buyerRegisterForm.getBuyerPwd();
        String buyerPwdAgain = buyerRegisterForm.getBuyerPwdAgain();
        BuyerDao buyerDao = new BuyerDao();
        boolean hasErrors = false;
        if(buyerId == null || !buyerId.matches("\\d{11}")){
            hasErrors = true;
            String buyerIdError = "<span style='color:red'>手机号必须有11位数字</span>";
            buyerRegisterForm.setBuyerIdError(buyerIdError);
        }else if(buyerDao.find1(buyerId) != null){
            hasErrors = true;
            String buyerIdError = "<span style='color:red'>该手机号已注册</span>";
            buyerRegisterForm.setBuyerIdError(buyerIdError);
        }
        if(buyerName == null || !buyerName.matches("\\w{1,20}")){
            hasErrors = true;
            String buyerNameError = "<span style='color:red'>用户名由1-20位的数字、字母或下划线组成</span>";
            buyerRegisterForm.setBuyerNameError(buyerNameError);
        }else if(buyerDao.find2(buyerName) != null){
            hasErrors = true;
            String buyerNameError = "<span style='color:red'>该用户名已被使用</span>";
            buyerRegisterForm.setBuyerNameError(buyerNameError);
        }
        if(buyerPwd == null || !buyerPwd.matches("\\w{1,20}")){
            hasErrors = true;
            String buyerPwdError = "<span style='color:red'>密码由1-20位的数字、字母或下划线组成</span>";
            buyerRegisterForm.setBuyerPwdError(buyerPwdError);
        }
        if(buyerPwdAgain == null || buyerPwdAgain.trim().equals("")){
            hasErrors = true;
            String buyerPwdAgainError = "<span style='color:red'>密码不能为空</span>";
            buyerRegisterForm.setBuyerPwdAgainError(buyerPwdAgainError);
        }else if(!buyerPwdAgain.equals(buyerPwd)){
            hasErrors = true;
            String buyerPwdAgainError = "<span style='color:red'>两次密码不一致</span>";
            buyerRegisterForm.setBuyerPwdAgainError(buyerPwdAgainError);
        }
        if(hasErrors == true)
            return mapping.findForward(FAILURE);
        else{
            Buyer buyer = new Buyer();
            buyer.setBuyerId(buyerId);
            buyer.setBuyerName(buyerName);
            buyer.setBuyerPwd(buyerPwd);
            buyerDao.add(buyer);
            return mapping.findForward(SUCCESS);
        }
    }
}
