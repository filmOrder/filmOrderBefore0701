package film.action;

import film.dao.FilmDao;
import film.form.FilmForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFilmAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
        FilmForm filmForm = (FilmForm) form;
        int id = filmForm.getFilmId();
        if( 0 > id){
            request.setAttribute("errorInfo", String.format("Id is null or negatice num"+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_film.jsp"));
            return mapping.findForward("error");
        }
        else {
            if(FilmDao.updateFilm(filmForm)){
                request.setAttribute("msg", String.format("Update film successfully " + filmForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_film.jsp"));
                return mapping.findForward("success");
            }
            else {
                request.setAttribute("errorInfo", String.format("Fail to update film " + filmForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_film.jsp"));
                return mapping.findForward("error");
            }
        }
    }
}
