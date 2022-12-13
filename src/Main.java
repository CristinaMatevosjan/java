public class Main {
    public static void main(String[] args) {
        ICQ icq = new ICQ();

        User client1 = new User.Builder(123, "Маша")
                .fullName("Маша Иванова")
                .isBot(false)
                .chatroom(icq)
                .build();

        System.out.println(client1);


        User client2 = new User.Builder(456,"Петя")
                .fullName("Петя Васечкин")
                .isBot(false)
                .chatroom(icq)
                .build();
        System.out.println(client2);
        User client4 = new User.Builder(789,"Сережа")
                .fullName("Сережа Сидоров")
                .isBot(false)
                .chatroom(icq)
                .build();

        System.out.println(client4);

        icq.appendClient(client1);
        icq.appendClient(client2);
        icq.appendClient(client4);

        client1.sendMsg("Привет! Как дела?");
        client2.sendMsg("Хай");
        User client3 = new User.Builder(111,"Катя Петрова")
                .fullName("Катя Петрова")
                .isBot(false)
                .chatroom(icq)
                .build();
        System.out.println(client4);

        icq.appendClient(client3);

        client3.sendMsg("hello world!");
    }
}




