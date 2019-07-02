package notice.form;

import org.apache.struts.action.ActionForm;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;

public class NoticeForm extends ActionForm {
    private String noticeContent;
    private Date noticeTime;
    private Integer noticeId;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    @Override
    public String toString() {
        return "NoticeForm{" +
                "noticeContent='" + noticeContent + '\'' +
                ", noticeTime=" + noticeTime +
                ", noticeId=" + noticeId +
                '}';
    }
    
    public void reset(ActionMapping mapping, HttpServletRequest request) { 
        try { 
            request.setCharacterEncoding("UTF-8"); 
        } catch (Exception e) {  
            // TODO: handle exception 
        } 
    }
}
