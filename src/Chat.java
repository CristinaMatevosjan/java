public interface Chat {
    void sendMessage(String msg, User user);

    void appendClient(User user);
}


