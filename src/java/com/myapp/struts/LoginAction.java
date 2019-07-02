/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.dao.BuyerDao;
import com.myapp.dao.CinemaDao;
import com.myapp.domain.Buyer;
import com.myapp.domain.Cinema;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author tellw
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String BUYERSUCCESS = "buyerLoginSuccess";
    private static final String CINEMASUCCESS = "cinemaLoginSuccess";
    private static final String ADMINSUCCESS = "adminLoginSuccess";
    private static final String FAILURE = "loginFailure";

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
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        LoginForm loginForm = (LoginForm)form;
        String loginId = loginForm.getLoginId();
        String loginPwd = loginForm.getLoginPwd();
        String role = loginForm.getRole();
        boolean hasErrors = false;
        if(loginId == null || !loginId.matches("\\w{1,20}")){
            hasErrors = true;
            String loginIdError = "<span style='color:red'>用户名由1-20位的数字、字母或下划线组成</span>";
            loginForm.setLoginIdError(loginIdError);
        }
        if(loginPwd == null || !loginPwd.matches("\\w{1,20}")){
            hasErrors = true;
            String loginPwdError = "<span style='color:red'>密码由1-20位的数字、字母或下划线组成</span>";
            loginForm.setLoginPwdError(loginPwdError);
        }
        if(role == null || role.trim().equals("")){
            hasErrors = true;
            String roleError = "<span style='color:red'>没有选择你的用户类型</span>";
            loginForm.setRoleError(roleError);
        }
        PrintWriter out = response.getWriter();
        if(hasErrors == true){
            return mapping.findForward(FAILURE);
        }
        else{
            int flag = 0;
            if(role.equals("buyer")){
                if(loginId.equals("asadmin") && loginPwd.equals("asadmin")){
                    flag = 1;
                }else{
                    BuyerDao buyerDao = new BuyerDao();
                    Buyer buyer = buyerDao.find(loginId, loginPwd);
                    if(buyer != null){
                        flag = 2;
                        request.getSession().setAttribute("user", buyer);
                    }else{
                        out.print("<script>alert('用户名不存在或者密码错误，登录失败');window.location='login.jsp'</script>");
                        out.flush();
                        out.close();
                    }
                }
            }else if(role.equals("cinema")){
                CinemaDao cinemaDao = new CinemaDao();
                Cinema cinema = cinemaDao.find(loginId, loginPwd);
                if(cinema != null){
                    flag = 3;
                    request.getSession().setAttribute("user", cinema);
                }else{
                    out.print("<script>alert('用户名不存在或者密码错误，登录失败');window.location='login.jsp'</script>");
                    out.flush();
                    out.close();
                }
            }
            if(flag == 0)
                return mapping.findForward(FAILURE);
            else if(flag == 1)
                return mapping.findForward(ADMINSUCCESS);
            else if(flag == 2)
                return mapping.findForward(BUYERSUCCESS);
            else if(flag == 3)
                return mapping.findForward(CINEMASUCCESS);
        }
        return null;
    }   
}
