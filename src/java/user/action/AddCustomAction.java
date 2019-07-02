package user.action;

import common.util.StringUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import user.dao.CustomDao;
import user.form.CustomForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCustomAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
        CustomForm customForm = (CustomForm) form;
        if(checkCustomFiled(customForm)){
            if(CustomDao.addCustom(customForm)) {
                request.setAttribute("msg", "Success add a new custom " + customForm.toString());
                return mapping.findForward("success");
            }
            else {
                request.setAttribute("errorInfo", "Fail to add custom" + customForm.toString());
                return mapping.findForward("error");
            }
        }
        else {
            request.setAttribute("errorInfo", "error custom form " + customForm.toString() );
            return mapping.findForward("error") ;
        }
    }
    private boolean checkCustomFiled(CustomForm customForm){
//        if( 0 >= customForm.getBuyerId() || StringUtil.isBlank(customForm.getBuyerName()) || StringUtil.isBlank(customForm.getBuyerPwd())){
//            return false;
//        }
//        else{
//            return true;
//        }
return true;
    }
}
