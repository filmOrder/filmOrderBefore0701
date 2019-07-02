/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import user.dao.CinemaDao;
import user.form.CinemaForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllCinemaAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
//        CinemaForm cinemaForm = (CinemaForm) form;
//        String id = cinemaForm.getCinemaId();
//        if( 0 >= id){
//            request.setAttribute("errorInfo", "Id is null or negatice num");
//            return mapping.findForward("error");
//        }
//        else {
            List<CinemaForm> result = CinemaDao.getAllCinemaList();
            request.setAttribute("noticeList", result);
            return mapping.findForward("success");
//        }
    }
}
