package bsu.rfe.java.zhibul.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import bsu.rfe.java.zhibul.entity.ChatMessage;
import bsu.rfe.java.zhibul.entity.ChatUser;
import jakarta.servlet.ServletException;

public class ChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // Карта текущих пользователей
    protected HashMap<String, ChatUser> activeUsers;
    // Список сообщений чата
    protected ArrayList<ChatMessage> messages;

    @SuppressWarnings("unchecked")
    public void init() throws ServletException, ServletException {
// Вызвать унаследованную от HttpServlet версию init()
        super.init();
// Извлечь из контекста карту пользователей и список сообщений
        activeUsers = (HashMap<String, ChatUser>)
                getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>)
                getServletContext().getAttribute("messages");
// Если карта пользователей не определена ...
        if (activeUsers==null) {
// Создать новую карту
            activeUsers = new HashMap<String, ChatUser>();
// Поместить еѐ в контекст сервлета,
// чтобы другие сервлеты могли до него добраться
            getServletContext().setAttribute("activeUsers",
                    activeUsers);
        }
// Если список сообщений не определѐн ...
        if (messages==null) {
// Создать новый список
            messages = new ArrayList<ChatMessage>(100);
// Поместить его в контекст сервлета,
// чтобы другие сервлеты могли до него добрать
            getServletContext().setAttribute("messages", messages);
        }
    }
}
