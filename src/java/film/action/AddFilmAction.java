package film.action;

import common.util.StringUtil;
import film.dao.FilmDao;
import film.form.FilmForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFilmAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        FilmForm filmForm = (FilmForm) form;
        System.out.println(filmForm.getReleaseDate());
        if(checkFilmField(filmForm)){
            if(FilmDao.addFilm(filmForm)) {
                request.setAttribute("msg", String.format("Success publish a new film " + filmForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_film.jsp"));
                return mapping.findForward("success");
            }
            else {
                request.setAttribute("errorInfo", String.format("Fail to add film " + filmForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_film.jsp"));
                return mapping.findForward("error");
            }
        }
        else {
            request.setAttribute("errorInfo", String.format("error film form " + filmForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_film.jsp"));
            return mapping.findForward("error") ;
        }
    }
    private boolean checkFilmField(FilmForm filmForm){
        if(StringUtil.isBlank(filmForm.getDirective()) || StringUtil.isBlank(filmForm.getFilmAbstract()) || StringUtil.isBlank(filmForm.getFilmName())|| 0 == filmForm.getDuration() || null == filmForm.getReleaseDate() || StringUtil.isBlank(filmForm.getDurationType())){
            return false;
        }
        else {
            return true;
        }
    }
}
