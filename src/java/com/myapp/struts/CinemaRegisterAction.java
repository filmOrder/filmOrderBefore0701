/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.dao.CinemaDao;
import com.myapp.domain.Cinema;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author tellw
 */
public class CinemaRegisterAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "cinemaRegisterSuccess";
    private static final String FAILURE = "cinemaRegisterFailure";

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
        CinemaRegisterForm cinemaRegisterForm = (CinemaRegisterForm)form;
        String cinemaId = cinemaRegisterForm.getCinemaId();
        String cinemaUsrName = cinemaRegisterForm.getCinemaUsrName();
        String cinemaPwd = cinemaRegisterForm.getCinemaPwd();
        String cinemaPwdAgain = cinemaRegisterForm.getCinemaPwdAgain();
        String cinemaName = cinemaRegisterForm.getCinemaName();
        String cinemaAddr = cinemaRegisterForm.getCinemaAddr();
        String cinemaTel = cinemaRegisterForm.getCinemaTel();
        String cinemaService = cinemaRegisterForm.getCinemaService();
//        request.setAttribute("message", cinemaService);
//        request.getRequestDispatcher("/message.jsp").forward(request, response);
        CinemaDao cinemaDao = new CinemaDao();
        boolean hasErrors = false;
        if(cinemaId == null || !cinemaId.matches("\\d{11}")){
            hasErrors = true;
            String buyerIdError = "<span style='color:red'>手机号必须有11位数字</span>";
            cinemaRegisterForm.setCinemaIdError(buyerIdError);
        }else if(cinemaDao.find1(cinemaId) != null){
            hasErrors = true;
            String buyerIdError = "<span style='color:red'>该手机号已注册</span>";
            cinemaRegisterForm.setCinemaIdError(buyerIdError);
        }
        if(cinemaUsrName == null || !cinemaUsrName.matches("\\w{1,20}")){
            hasErrors = true;
            String buyerNameError = "<span style='color:red'>用户名由1-20位的数字、字母或下划线组成</span>";
            cinemaRegisterForm.setCinemaUsrNameError(buyerNameError);
        }else if(cinemaDao.find2(cinemaUsrName) != null){
            hasErrors = true;
            String buyerNameError = "<span style='color:red'>该用户名已被使用</span>";
            cinemaRegisterForm.setCinemaUsrNameError(buyerNameError);
        }
        if(cinemaPwd == null || !cinemaPwd.matches("\\w{1,20}")){
            hasErrors = true;
            String buyerPwdError = "<span style='color:red'>密码由1-20位的数字、字母或下划线组成</span>";
            cinemaRegisterForm.setCinemaPwdError(buyerPwdError);
        }
        if(cinemaPwdAgain == null || cinemaPwdAgain.trim().equals("")){
            hasErrors = true;
            String buyerPwdAgainError = "<span style='color:red'>密码不能为空</span>";
            cinemaRegisterForm.setCinemaPwdAgainError(buyerPwdAgainError);
        }else if(!cinemaPwdAgain.equals(cinemaPwd)){
            hasErrors = true;
            String buyerPwdAgainError = "<span style='color:red'>两次密码不一致</span>";
            cinemaRegisterForm.setCinemaPwdAgainError(buyerPwdAgainError);
        }
        if(cinemaName == null || cinemaName.trim().equals("")){
            hasErrors = true;
            String cinemaNameError = "<span style='color:red'>影院名称不能为空</span>";
            cinemaRegisterForm.setCinemaNameError(cinemaNameError);
        }else if(cinemaName.length() > 15){
            hasErrors = true;
            String cinemaNameError = "<span style='color:red'>所填内容超过15个字符</span>";
            cinemaRegisterForm.setCinemaNameError(cinemaNameError);
        }
        if(cinemaAddr == null || cinemaAddr.trim().equals("")){
            hasErrors = true;
            String cinemaAddrError = "<span style='color:red'>影院地址不能为空</span>";
            cinemaRegisterForm.setCinemaAddrError(cinemaAddrError);
        }else if(cinemaAddr.length() > 15){
            hasErrors = true;
            String cinemaAddrError = "<span style='color:red'>所填内容超过15个字符</span>";
            cinemaRegisterForm.setCinemaAddrError(cinemaAddrError);
        }
        if(cinemaTel == null || cinemaTel.trim().equals("")){
            hasErrors = true;
            String cinemaTelError = "<span style='color:red'>影院电话不能为空</span>";
            cinemaRegisterForm.setCinemaTelError(cinemaTelError);
        }else if(cinemaTel.length() > 15){
            hasErrors = true;
            String cinemaTelError = "<span style='color:red'>所填内容超过15个字符</span>";
            cinemaRegisterForm.setCinemaTelError(cinemaTelError);
        }
        if(cinemaService == null || cinemaService.trim().equals("")){
            hasErrors = true;
            String cinemaServiceError = "<span style='color:red'>影院服务简介不能为空</span>";
            cinemaRegisterForm.setCinemaServiceError(cinemaServiceError);
        }else if(cinemaService.length() > 33){
            hasErrors = true;
            String cinemaServiceError = "<span style='color:red'>所填内容超过33个字符</span>";
            cinemaRegisterForm.setCinemaServiceError(cinemaServiceError);
        }
        if(hasErrors == true)
            return mapping.findForward(FAILURE);
        else{
            Cinema cinema = new Cinema();
            cinema.setCinemaId(cinemaId);
            cinema.setCinemaUsrName(cinemaUsrName);
            cinema.setCinemaPwd(cinemaPwd);
            cinema.setCinemaName(cinemaName);
            cinema.setCinemaAddr(cinemaAddr);
            cinema.setCinemaTel(cinemaTel);
            cinema.setCinemaService(cinemaService);
//            String message = cinemaDao.add(cinema);
//            request.setAttribute("message", message);
//            request.getRequestDispatcher("/message.jsp").forward(request, response);
            cinemaDao.add(cinema);
            return mapping.findForward(SUCCESS);
        }
    }
}
