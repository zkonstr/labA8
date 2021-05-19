package bsu.rfe.java.zhibul.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bsu.rfe.java.zhibul.entity.ChatUser;

@WebServlet("/view.do")
public class ViewServlet extends ChatServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf8");
		boolean b=false;
		for (ChatUser aUser: activeUsers.values()) {
			if(aUser.getName().equals((String)request.getSession().getAttribute("name"))){
				b=true;
			}
		}
		if(!b)
			response.sendRedirect(response.encodeRedirectURL("/chat/login.do"));
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>\n<html>" +
					"<head>" +
						"<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>" +
						"<title>����-���: ���������</title>" +
					"</head>");
		pw.println( "<frameset rows=\"90,10\">" +
						"<frameset cols=\"80,20\">"+
							"<frame name=\"frameMessages\" src=\"/chat/messages.do\">"+
							"<frame name=\"frameUsers\" src=\"/chat/users.do\" noresize>" +
							"</frameset>"+
						"<frame name=\"frameMessage\" src=\"/chat/compose_message.htm\" noresize>"+
					"</frameset>");
		pw.println("</html>");
	}
}
