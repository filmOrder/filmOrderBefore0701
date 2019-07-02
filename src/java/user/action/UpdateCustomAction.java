package user.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import user.dao.CustomDao;
import user.form.CustomForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCustomAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
        CustomForm customForm = (CustomForm) form;
        String id = customForm.getBuyerId();
//        if( 0 > id){
//            request.setAttribute("errorInfo", String.format("Id is null or negatice num"+"<meta http-equiv='refresh' content='3;url=%s'", 
//				request.getContextPath()+"/admin_buyer.jsp"));
//            return mapping.findForward("error");
//        }
//        else {
            if(CustomDao.updateCustom(customForm)) {
                request.setAttribute("msg", String.format("Update buyer successfully id = " + id+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_buyer.jsp"));
                return mapping.findForward("success");
            }
            else {
                request.setAttribute("errorInfo", String.format("Fail to update buyer id = " + id+"<meta http-equiv='refresh' content='3;url=%s'", 
				request.getContextPath()+"/admin_buyer.jsp"));
                return mapping.findForward("error");
            }
//        }
    }
}
