package bsu.rfe.java.zhibul.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bsu.rfe.java.zhibul.entity.ChatMessage;

public class MessageListServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
// Установить кодировку HTTP-ответа UTF-8
        response.setCharacterEncoding("utf8");
// Получить доступ к потоку вывода HTTP-ответа
        PrintWriter pw = response.getWriter();
// Записть в поток HTML-разметку страницы
        pw.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
        pw.println("<body>");
// В обратном порядке записать в поток HTML-разметку для каждого сообщения
        for (int i=messages.size()-1; i>=0; i--) {
            ChatMessage aMessage = messages.get(i);
            pw.println("<div><strong>" + aMessage.getAuthor().getName()
                    + "</strong>: " + aMessage.getMessage() + "</div>");
        }
        pw.println("</body></html>");
    }
}



























/*
<?xml version="1.0" encoding="UTF-8"?>
<web-app
        xmlns="https://jakarta.ee/xml/ns/jakartaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
        version="5.0"
>    <display-name>labA8</display-name>
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
    <servlet>
        <servlet-name>loginservlet</servlet-name>
        <servlet-class>bsu.rfe.java.zhibul.servlet.LoginServlet</servlet-class>

    </servlet>
    <servlet-mapping>
        <servlet-name>loginservlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
    <servlet>
        <servlet-name>chatservlet</servlet-name>
        <servlet-class>bsu.rfe.java.zhibul.servlet.NewMessageServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>chatservlet</servlet-name>
        <url-pattern>/chat/*</url-pattern>
    </servlet-mapping>
</web-app>
 */