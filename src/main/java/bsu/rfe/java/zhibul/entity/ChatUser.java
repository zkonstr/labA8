package bsu.rfe.java.zhibul.entity;

public class ChatUser {
    // Имя пользователя
    private String name;
    // Последнее время взаимодействия с сервером в количестве микросекунд,
// прошедших с 1 января 1970 года
    private long lastInteractionTime;
    // Идентификатор Java-сессии пользователя
    private String sessionId;

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    private long timeout = 60;

    public ChatUser(String name,long lastInteractionTime,String sessionId) {
        super();
        this.name = name;
        this.lastInteractionTime = lastInteractionTime;
        this.sessionId = sessionId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getLastInteractionTime() {
        return lastInteractionTime;
    }
    public void setLastInteractionTime(long lastInteractionTime) {
        this.lastInteractionTime = lastInteractionTime;
    }
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
