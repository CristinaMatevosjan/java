// предложение SELECT -выбор данных из таблицы   SELECT{columns} FROM {table_name}
// INSERT вставлять строки в БД - INSERT INTO {table_name}({table_columns}) VALUES({values})
// UPDATE обновление данных в таблице-UPDATE {table_name} SET {column_name}={value} WHERE {column_name}={value}
//DELETE FROM {table_name} WHERE {condition}

import javax.swing.plaf.PanelUI;
import java.sql.*;

public class Main {

    public static String sqlCreateUsersTable="CREATE TABLE IF NOT EXISTS users (id integer PRIMARY KEY, login text NOT NULL  )";
    public static String sqlInsertUserInTable="INSERT INTO users(login) VALUES(\"oldLogin\");";
    public static String sqlSelectUsersFromTable= "SELECT login FROM users;";
    public static String sqlUpdateUser="UPDATE users SET login=\"чикчирик\" WHERE id=1";
    public static String sqlDeleteUser="DELETE FROM users WHERE id=1";
    public static String sqlInsertUserInTablePreparedQuery="INSERT INTO users(login) VALUES(?);";
    public static String sqlInsertQueryWithParameter= "INSERT INTO users(login) VALUES(?);";




    public static void main(String[] args) {
        // Connection класс для соединения с бд
        //Statement класс для выполнения запросов к бд с использованием эскуэл, пример с 10 по 15 строку,
        // эти запросы с помощью объекта класса стэйтмент полетят в бд
        //PreparedStatement класс, используемый когда надо вставить несколько записей в бд и они однотипны, чтобы не копировать код,
        // можно использовать параметризованные запросы с подставляемым параметром и он обозначется знаком вопроса

        //jdbc:sqlite:sqlite_database_file_path
        //апи  драйвер    путь

        //класс драйвер менеджер парсит строку выше и пытается найти установленный драйвер и подключить бд

        String url="jdbc:sqlite:test.db"; // здесь идет подключение
        //надо получить объект класса конекшен через драйвер меенеджэр у него есть метод гет конекшен,
        // этот метод может бросить исключение, подключение работает как ресурс значит можно взять трай вит ресурс

        String[] logins={   //если надо добавить несколько логинов в бд
                "hello",
                "bye",
                "login1",
                "jojo"
        };

        try(Connection sqliteConnection= DriverManager.getConnection(url); // подключение к бд
            //Statement statement=sqliteConnection.createStatement()){ //создали объект класса стейтмент
            PreparedStatement preparedStatement=sqliteConnection.prepareStatement(sqlInsertQueryWithParameter)){ //
            // чтобы не передавать один и тот же запрос на добавление писать 4 раза, надо использовать объект перепэрэдстейтмент,
            // через вызов одгноименного метода, который на вход принимает параметризованный запрос
            System.out.println("Подключились!");

            for (String login: logins){
                preparedStatement.setString(1,login); //здесь нумерация с 1 начинается,
                // здесь еденица соответствует появлению первого знака вопроса в запросе,
                // на его место помещается хзначение хранимое в переменной логин
                preparedStatement.execute(); //после чего вызвать метод экзекют который выполнит запрос
            }
            //statement.execute(sqlDeleteUser);
            //statement.execute(sqlUpdateUser);
            //statement.execute(sqlInsertUserInTable); // метод для исполнения созданного запроса

            //ResultSet usersResultSet=statement.executeQuery(sqlSelectUsersFromTable); //чтобы получить данные из какой то таблицы
            //надо создать объект класса резалтсет, который будет содержать данные из таблицы,
            // через метод экзекут квери у объекта класса стейтмент, который на вход берет эс ку эл запрос,
            // в результате получим в юзерс резалт сет список из записей таблицы
            //чтобы получить что из резалт сета надо пройтись по нему циклом, у объекта этого класса есть метод некст
            //котороый вернет тру если есть запись которую можно вернуть и фолс если ничего не найдено

//            while (usersResultSet.next()){
//                String login=usersResultSet.getString("login"); // гет стринг надо переопределить,
//                // на вход он просит название колонки его и указываем
//                System.out.println(login); // теперь выведем полученные данные
//            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}