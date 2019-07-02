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

public class GetCinemaAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
        CinemaForm cinemaForm = (CinemaForm) form;
        String id = cinemaForm.getCinemaId();
//        if( 0 >= id){
//            request.setAttribute("errorInfo", "Id is null or negatice num");
//            return mapping.findForward("error");
//        }
//        else {
            List<CinemaForm> result = CinemaDao.getCinemaList(id);
            request.setAttribute("noticeList", result);
            return mapping.findForward("success");
//        }
    }
}
