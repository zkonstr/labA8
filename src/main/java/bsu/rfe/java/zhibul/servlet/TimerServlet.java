package bsu.rfe.java.zhibul.servlet;

import bsu.rfe.java.zhibul.entity.ChatMessage;
import bsu.rfe.java.zhibul.entity.ChatUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Calendar;

public class TimerServlet extends ChatServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // Извлечь из HTTP-запроса параметр 'message'
        String timeout = request.getParameter("timeout");
        if (timeout != null && !"".equals(timeout)) {
            try {
                int timeoutValue = Integer.parseInt(timeout);
                synchronized (activeUsers) {
                    ChatUser author = activeUsers.get((String) request.getSession().getAttribute("name"));
                    if (author != null) {
                        author.setTimeout(timeoutValue);
                    }
                }
            } catch (NumberFormatException ignored) {
            }
        }
        response.sendRedirect("/labA8_war_exploded/message.html");
    }
}
