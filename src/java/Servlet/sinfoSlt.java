package Servlet;
import DAO.*;
import Service.*;
import com.myapp.domain.Cinema;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.myapp.dao.CinemaDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.myapp.struts.LoginForm;

public class sinfoSlt extends HttpServlet {

	private static final long serialVersionUID = 5042128321408569090L;

	public sinfoSlt() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");   //接受来自页面的method值
		if ("modify".equalsIgnoreCase(method)) {
			doModify(request, response);
		}
	} //修改信息

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
        // 
        
	
  /*修改*/
	public void doModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sinfoPwd = request.getParameter("spwd");
		String sinfoAddr = request.getParameter("saddr");
		String sinfoTel = request.getParameter("stel");
		String sinfoServ = request.getParameter("sservice");
		//String studStype = request.getParameter("stype");
		//String studFlag = request.getParameter("flag");
		Cinema cin = (Cinema)request.getSession().getAttribute("user");//从登录处获取
		
                
               
			if (sinfoPwd != null && !sinfoPwd.equals("")) {
				cin.setCinemaPwd(sinfoPwd);
			}
			if (sinfoAddr != null && !sinfoAddr.equals("")) {
				cin.setCinemaAddr(sinfoAddr);
			}
			if (sinfoTel != null && !sinfoTel.equals("")) {
				cin.setCinemaTel(sinfoTel);
			}
			if (sinfoServ != null && !sinfoServ.equals("")) {
				cin.setCinemaService(sinfoServ);
			}
			 SinfoDAO cinDAO=new  SinfoDAO();
                         int success=cinDAO.update(cin);
			if (success == 1) {
				request.setAttribute("error", "修改成功!");
				request.getRequestDispatcher("sinfo_modify.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "修改失败!");
				request.getRequestDispatcher("sinfo_modify.jsp").forward(request, response);
                        
	} //修改
    
	

	
}}


