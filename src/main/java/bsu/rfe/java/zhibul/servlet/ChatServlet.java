package bsu.rfe.java.zhibul.servlet;

import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import bsu.rfe.java.zhibul.entity.ChatMessage;
import bsu.rfe.java.zhibul.entity.ChatUser;
import jakarta.servlet.annotation.WebServlet;

import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "ChatServlet")
public class ChatServlet extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    // Карта текущих пользователей
    protected HashMap<String, ChatUser> activeUsers;
    // Список сообщений чата
    protected ArrayList<ChatMessage> messages;

    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
        // Вызвать унаследованную от HttpServlet версию init()
        super.init();
        // Извлечь из контекста карту пользователей и список сообщений
        activeUsers = (HashMap<String, ChatUser>)
                // Поместить еѐ в контекст сервлета,
// чтобы другие сервлеты могли до него добраться
                getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>)
                getServletContext().getAttribute("messages");
        if (activeUsers == null) {
            // Создать новую карту
            activeUsers = new HashMap<String, ChatUser>();
            getServletContext().setAttribute("activeUsers",
                    activeUsers);
        }
        if (messages == null) {
            // Создать новый список
            messages = new ArrayList<ChatMessage>(100);
            // Поместить его в контекст сервлета,
// чтобы другие сервлеты могли до него добрать
            getServletContext().setAttribute("messages", messages);
        }
    }
}