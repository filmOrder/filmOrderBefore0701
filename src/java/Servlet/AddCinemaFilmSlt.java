/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import com.myapp.dao.CinemaFilmDao;
import com.myapp.dao.RoomDao;
import com.myapp.domain.Cinema;
import com.myapp.domain.CinemaFilm;
import com.myapp.domain.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tellw
 */
public class AddCinemaFilmSlt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddCinemaFilmSlt</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AddCinemaFilmSlt at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
                String arrangeDate = request.getParameter("arrangeDate");
		String arrangeRoom = request.getParameter("arrangeRoom");
		String arrangeTime = request.getParameter("arrangeTime");
		String price = request.getParameter("price");//
                String showFilmId = request.getParameter("showFilmId");
		if (arrangeDate != null && arrangeRoom != null && arrangeTime != null && price != null && !arrangeDate.equals("")
				&& !arrangeRoom.equals("") && !arrangeTime.equals("") && !price.equals("")) {
            try {
                CinemaFilm cinemaFilm = new CinemaFilm();
                Cinema cinema = (Cinema)request.getSession().getAttribute("user");
                RoomDao roomDao = new RoomDao();
                Room room = roomDao.getRoomByName(arrangeRoom, cinema);
                CinemaFilmDao cinemaFilmDao = new CinemaFilmDao();
                //stud.setStudioFlag(0);
                cinemaFilm.setPrice(Integer.parseInt(price));
                cinemaFilm.setShowDate(arrangeDate);
                cinemaFilm.setShowTime(Integer.parseInt(arrangeTime));
                cinemaFilm.setShowRoomId(room.getRoomId());
                cinemaFilm.setShowFilmId(Integer.parseInt(showFilmId));
                if (cinemaFilmDao.add(cinemaFilm) == 1) { //成功
                    request.setAttribute("error", "添加成功!");
                    request.getRequestDispatcher("filmCinema_main.jsp?showFilmId="+showFilmId).forward(request, response);
                    //
                } else {
                    request.setAttribute("error", "添加失败!请检查数据库状态后再提交添加");
                    request.getRequestDispatcher("filmCinema_main.jsp?showFilmId="+showFilmId).forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddCinemaFilmSlt.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddCinemaFilmSlt.class.getName()).log(Level.SEVERE, null, ex);
            }
		} else {
			request.setAttribute("error", "添加失败!请将信息补充完整后再提交添加");
			request.getRequestDispatcher("filmCinema_main.jsp?showFilmId="+showFilmId).forward(request, response);
		}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
