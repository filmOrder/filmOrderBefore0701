package notice.action;

import common.util.StringUtil;
import notice.dao.NoticeDao;
import notice.form.NoticeForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNoticeAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        NoticeForm noticeForm = (NoticeForm)form;
        String content = noticeForm.getNoticeContent();
        System.out.println(content);
        if(StringUtil.isBlank(content)){
            request.setAttribute("errorInfo", String.format("Content is Empty <meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_index.jsp"));
            return mapping.findForward("error");
        }
        else {
            if(NoticeDao.addNotice(noticeForm)) {
                request.setAttribute("msg", String.format("Success publish a new notice " + noticeForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_index.jsp"));
                return mapping.findForward("success");
            }
            else {
                request.setAttribute("errorInfo", String.format("Fail to add notice " + noticeForm.toString()+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_index.jsp"));
                return mapping.findForward("error");
            }
        }
    }
}
