package user.action;

import common.util.StringUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import user.dao.CinemaDao;
import user.form.CinemaForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCinemaAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
        CinemaForm cinemaForm = (CinemaForm) form;
        if(checkCinemaField(cinemaForm)){
            if(CinemaDao.addCinema(cinemaForm)) {
                request.setAttribute("msg", "Success add a new cinema " + cinemaForm.toString() );
                return mapping.findForward("success");
            }
            else {
                request.setAttribute("errorInfo", "Fail to add cinema " + cinemaForm.toString());
                return mapping.findForward("error");
            }
        }else {
            request.setAttribute("errorInfo", "error cinema form " + cinemaForm.toString());
            return mapping.findForward("error") ;
        }


    }
    private boolean checkCinemaField(CinemaForm cinemaForm){
//        if(StringUtil.isBlank(cinemaForm.getCinemaAddr()) || 0 >= cinemaForm.getCinemaId() || StringUtil.isBlank(cinemaForm.getCinemaName())
//                || StringUtil.isBlank(cinemaForm.getCinemaPwd()) || StringUtil.isBlank(cinemaForm.getCinemaService()) || StringUtil.isBlank(cinemaForm.getCinemaTel())){
//                return false;
//        }
        return true;
    }
}
