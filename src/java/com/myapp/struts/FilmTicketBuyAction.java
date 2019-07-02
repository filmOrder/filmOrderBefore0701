/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.dao.CinemaFilmDao;
import com.myapp.dao.OrderDao;
import com.myapp.dao.RoomDao;
import com.myapp.domain.Buyer;
import com.myapp.domain.CinemaFilm;
import com.myapp.domain.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author tellw
 */
public class FilmTicketBuyAction extends org.apache.struts.action.Action {

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
        FilmTicketBuyForm filmTicketBuyForm = (FilmTicketBuyForm)form;
        String selectedRow = filmTicketBuyForm.getSelectedRow();
        String selectedColumn = filmTicketBuyForm.getSelectedColumn();
        String cinemaFilmId = filmTicketBuyForm.getCinemaFilmId();
        Order order = new Order();
        Buyer buyer = (Buyer)request.getSession().getAttribute("user");
        if(buyer!=null){
        String buyerId = buyer.getBuyerId();
        order.setBuyerId(buyerId);
        order.setCinemaFilmId(Integer.parseInt(cinemaFilmId));
        CinemaFilmDao cinemaFilmDao = new CinemaFilmDao();
        CinemaFilm cinemaFilm = cinemaFilmDao.getById(Integer.parseInt(cinemaFilmId));
        if(selectedRow==null||selectedColumn==null||!selectedRow.trim().equals("")||!selectedColumn.trim().equals("")){
            order.setSeatRow(Integer.parseInt(selectedRow));
            order.setSeatColumn(Integer.parseInt(selectedColumn));
        OrderDao orderDao = new OrderDao();
        if(orderDao.add(order)==1){
            request.setAttribute("error", "购买成功");
            request.getRequestDispatcher("buy.jsp?cinemaId"+new RoomDao().getRoomById(cinemaFilm.getShowRoomId()).getRoomCinemaId()+"&filmId="+cinemaFilm.getShowFilmId());
        }else{
            request.setAttribute("error", "座位号被占，请重新选");
            request.getRequestDispatcher("buy.jsp?cinemaId"+new RoomDao().getRoomById(cinemaFilm.getShowRoomId()).getRoomCinemaId()+"&filmId="+cinemaFilm.getShowFilmId());
        }
        }else{
            request.setAttribute("error", "请填上要选的座位号");
            request.getRequestDispatcher("buy.jsp?cinemaId"+new RoomDao().getRoomById(cinemaFilm.getShowRoomId()).getRoomCinemaId()+"&filmId="+cinemaFilm.getShowFilmId());
        }}else{
            request.setAttribute("error", "请登录");
            request.getRequestDispatcher("index.jsp");
        }
        return mapping.findForward(SUCCESS);
    }
}
