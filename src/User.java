public class User {
    private final String fullName;
    private final int userId;
    private final String userName;
    private final boolean isBot;
    private Chat chatroom;

    public String getUserName() {
        return userName;
    }

    private User(Builder builder) {
        userId = builder.userId;
        fullName = builder.fullName;
        userName = builder.userName;
        isBot = builder.isBot;
        chatroom = builder.chatroom;
    }


    public static class Builder {
        // Обязательные параметры
        private final int userId;
        private final String userName;
        // Дополнительные параметры - инициализируются значениями по умолчанию

        private String fullName = "Empty";
        private boolean isBot = false;

        private Chat chatroom=null;  //???


        public Builder(int userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        public Builder fullName(String val) {
            fullName = val;
            return this;
        }

        public Builder isBot(boolean val) {
            isBot = val;
            return this;
        }

        public Builder chatroom(Chat val) {
            chatroom = val;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
    @Override
    public String toString(){
        return "Зарегистрирован новый пользователь:" + "\n"+ "id=" + userId +"\n"+ " Ник: " + userName +"\n" + " Имя: "
                + fullName+"\n"+ " Это бот? " +isBot + "\n";

    }

    void printMessage(String msg) {
        System.out.printf("Чат %s: %s\n", userName, msg);
    }

    void sendMsg(String text) {
        chatroom.sendMessage(text, this);
    }
}




