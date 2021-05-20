package bsu.rfe.java.zhibul.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bsu.rfe.java.zhibul.entity.ChatMessage;
import bsu.rfe.java.zhibul.entity.ChatUser;
public class NewMessageServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getSession().getServletContext().getRealPath("/compose_message.htm");
        List<String> strings = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        PrintWriter pw = resp.getWriter();
        for (String row : strings) {
            pw.write(row);
        }
        pw.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
// По умолчанию используется кодировка ISO-8859. Так как мы
// передаѐм данные в кодировке UTF-8
// то необходимо установить соответствующую кодировку HTTP-запроса
        request.setCharacterEncoding("UTF-8");
// Извлечь из HTTP-запроса параметр 'message'
        String message = (String)request.getParameter("message");
// Если сообщение не пустое, то
        if (message!=null && !"".equals(message)) {
// По имени из сессии получить ссылку на объект ChatUser
            ChatUser author = activeUsers.get((String)
                    request.getSession().getAttribute("name"));
            synchronized (messages) {
// Добавить в список сообщений новое
                messages.add(new ChatMessage(message, author,
                        Calendar.getInstance().getTimeInMillis()));
            }
        }
// Перенаправить пользователя на страницу с формой сообщения
        response.sendRedirect("/labA8_war_exploded/chat/compose_message.htm");
    }
}