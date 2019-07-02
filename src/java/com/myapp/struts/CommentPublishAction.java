/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.dao.FilmCommentDao;
import com.myapp.domain.Buyer;
import com.myapp.domain.FilmComment;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author tellw
 */
public class CommentPublishAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        CommentPublishForm commentPublishForm = (CommentPublishForm)form;
        String comment = commentPublishForm.getComment();
        String filmId = commentPublishForm.getFilmId();
        FilmCommentDao filmCommentDao = new FilmCommentDao();
        FilmComment filmComment = new FilmComment();
        Buyer buyer = (Buyer)request.getSession().getAttribute("user");
        filmComment.setFilmId(Integer.parseInt(filmId));
        filmComment.setCommentBuyerId(buyer.getBuyerId());
        filmComment.setComment(comment);
        if(comment != null && !comment.trim().equals("")){
            filmCommentDao.add(filmComment);
        }else{
            request.setAttribute("error", "请不要什么都不填");
        }
        request.getRequestDispatcher("filmShow.jsp?filmId="+filmId);
        return mapping.findForward(SUCCESS);
    }
}
