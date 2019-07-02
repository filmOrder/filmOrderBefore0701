package notice.action;

import notice.dao.NoticeDao;
import notice.form.NoticeForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateNoticeAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        NoticeForm noticeForm = (NoticeForm) form;
        int id = noticeForm.getNoticeId();
        if( 0 > id){
            request.setAttribute("errorInfo", String.format("Id is null or negatice num"+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_index.jsp"));
            return mapping.findForward("error");
        }
        else {
            if(NoticeDao.updateNotice(noticeForm)) {
                request.setAttribute("msg", String.format("Update notice successfully " + noticeForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_index.jsp"));
                return mapping.findForward("success");
            }
            else {
                request.setAttribute("errorInfo", String.format("Fail to update notice " + noticeForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_index.jsp"));
                return mapping.findForward("error");
            }
        }
    }
}
