/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Service.StudioSrv;
import Domain.Studio;
import com.myapp.domain.Cinema;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudioSlt extends HttpServlet {

	private static final long serialVersionUID = 5042128321408569090L;

	public StudioSlt() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");   //接受来自页面的method值

		if ("add".equalsIgnoreCase(method)) {
			doAdd(request, response);
		} else if ("fetch".equalsIgnoreCase(method)) {
			doFetch(request, response);
		} else if ("modify".equalsIgnoreCase(method)) {
			doModify(request, response);
		} else if ("delete".equalsIgnoreCase(method)) {
			doDelete(request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studName = request.getParameter("name");
		String studRows = request.getParameter("rows");
		String studCols = request.getParameter("cols");
		String studStype = request.getParameter("stype");//
		if (studName != null && studRows != null && studCols != null && studStype != null && !studName.equals("")
				&& !studRows.equals("") && !studCols.equals("") && !studStype.equals("")) {
			Studio stud = new Studio();//new Studio object
                        Cinema cinema = (Cinema)request.getSession().getAttribute("user");
                        stud.setRoomCinemaId(cinema.getCinemaId());
			stud.setName(studName);
			stud.setRowCount(Integer.parseInt(studRows)); //转换关系
			stud.setColCount(Integer.parseInt(studCols));
			stud.setStype(Integer.parseInt(studStype));
                        
			//stud.setStudioFlag(0);
                        
			if (new StudioSrv().add(stud) == 1) { //成功
				request.setAttribute("error", "添加成功!");
				request.getRequestDispatcher("studio_add.jsp").forward(request, response);
                                //
			} else {
				request.setAttribute("error", "添加失败!请检查数据库状态后再提交添加");
				request.getRequestDispatcher("studio_add.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "添加失败!请将信息补充完整后再提交添加");
			request.getRequestDispatcher("studio_add.jsp").forward(request, response);
		}
	}
        //Add
	public void doFetch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studId = request.getParameter("id");
                if (studId != null && !studId.equals("")) {
			Studio stud = new Studio();//new Studio object
                        Cinema cinema = (Cinema)request.getSession().getAttribute("user");
                        stud.setRoomCinemaId(cinema.getCinemaId());
			stud.setID(Integer.parseInt(studId));
                        
			//stud.setStudioFlag(0);
                        
			if (new StudioSrv().delete(stud) == 1) { //成功
				request.setAttribute("error", "删除成功!");
				request.getRequestDispatcher("studio_fetch.jsp").forward(request, response);
                                //
			} else {
				request.setAttribute("error", "删除失败!请检查你的影厅列表id号 后再提交删除");
				request.getRequestDispatcher("studio_fetch.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "删除失败!请将信息补充完整后再提交删除");
			request.getRequestDispatcher("studio_fetch.jsp").forward(request, response);
		}
//		String studName = request.getParameter("name");
//		String studRows = request.getParameter("rows");
//		String studCols = request.getParameter("cols");
//		String studStype= request.getParameter("stype");
//		//String studFlag = request.getParameter("flag");
//                Map<String, String> map = new HashMap<String, String>();
//		if (studId != null && !studId.equals("")) {
//			map.put("id", studId);
//		}
//		if (studName != null && !studName.equals("")) {
//			map.put("name", studName);
//		}
//		if (studRows != null && !studRows.equals("")) {
//			map.put("row", studRows);
//		}
//		if (studCols != null && !studCols.equals("")) {
//			map.put("col", studCols);
//		}
//		if (studStype != null && !studStype.equals("")) {
//			map.put("stype", studStype);
//		}
//		/*if (studFlag != null && !studFlag.equals("")) {
//			map.put("flag", studFlag);
//		}*/
//		List<Studio> studList = new StudioSrv().Fetch_(map);
//		if (studList.size() > 0) {
//			request.setAttribute("error", null);
//			request.setAttribute("list", studList);
//			request.getRequestDispatcher("/main/studio/studio_fetch.jsp").forward(request, response);
//		} else {
//			request.setAttribute("error", "未找到符合条件的影厅!");
//			request.getRequestDispatcher("/main/studio/studio_fetch.jsp").forward(request, response);
//		}
                
	}

	public void doModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studId = request.getParameter("id");
		String studName = request.getParameter("name");
		String studRows = request.getParameter("rows");
		String studCols = request.getParameter("cols");
		String studStype = request.getParameter("stype");
		//String studFlag = request.getParameter("flag");
		Studio stud = new Studio();
		stud.setID(Integer.parseInt(studId));
                //stud.setStype(Integer.parseInt(studStype));
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", studId);
		List<Studio> rst = new StudioSrv().Fetch_(map);
		if (rst!=null && rst.size() > 0) {
			stud = rst.get(0);
			if (studName != null && !studName.trim().equals("")) {
				stud.setName(studName);
			}
			if (studRows != null && !studRows.trim().equals("")) {
				stud.setRowCount(Integer.parseInt(studRows));
			}
			if (studCols != null && !studCols.trim().equals("")) {
				stud.setColCount(Integer.parseInt(studCols));
			}
			if (studStype != null && !studStype.trim().equals("")) {
				stud.setStype(Integer.parseInt(studStype));
			}
			/*if (studFlag != null && !studFlag.equals("")) {
				stud.setStudioFlag(Integer.parseInt(studFlag));
			}*/
			if (new StudioSrv().modify(stud) == 1) {
				request.setAttribute("error", "修改成功!");
				request.getRequestDispatcher("studio_modify.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "修改失败!请检查数据库状态后再提交修改");
				request.getRequestDispatcher("studio_modify.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "修改失败!未找到符合条件的演出厅");
			request.getRequestDispatcher("studio_modify.jsp").forward(request, response);
		}
	} //修改
    
//	public void doDelete(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String studId = request.getParameter("id");
//		Studio stud = new Studio();
//		stud.setID(Integer.parseInt(studId));
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("id", studId);
//		List<Studio> rst = new StudioSrv().Fetch_(map);
//		if (rst.size() > 0) {
//			stud = rst.get(0);
//			if (new StudioSrv().delete(Integer.parseInt(studId)) == 1) {
//				request.setAttribute("error", "删除成功!");
//				request.getRequestDispatcher("studio_delete.jsp").forward(request, response);
//			} else {
//				request.setAttribute("error", "删除失败!请检查数据库状态后再提交删除");
//				request.getRequestDispatcher("studio_delete.jsp").forward(request, response);
//			}
//		} else {
//			request.setAttribute("error", "删除失败!未找到符合条件的演出厅");
//			request.getRequestDispatcher("studio_delete.jsp").forward(request, response);
//		}
//	}//删除

	public void destroy() {
		super.destroy();
	}
}

