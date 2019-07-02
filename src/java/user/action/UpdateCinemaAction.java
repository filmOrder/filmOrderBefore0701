package user.action;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import user.dao.CinemaDao;
import user.form.CinemaForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCinemaAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
        CinemaForm cinemaForm = (CinemaForm) form;
        String id = cinemaForm.getCinemaId();
//        if( 0 > id){
//            request.setAttribute("errorInfo", "Id is null or negatice num");
//            return mapping.findForward("error");
//        }
//        else {
            if(CinemaDao.updateCinema(cinemaForm)) {
                request.setAttribute("msg", String.format("Update cinema successfully id = " + id +"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_cinema.jsp"));
                return mapping.findForward("success");
            }
            else {
                request.setAttribute("errorInfo", String.format("Fail to update cinema id = " + id+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_cinema.jsp"));
                return mapping.findForward("error");
            }
//        }
    }
}
