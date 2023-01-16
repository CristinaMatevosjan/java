import javax.json.JsonObject;

public class Child {
    private String name;
    private int age;

    public Child(JsonObject jsonObject){// напишем конструктор для объекта класса чайилд из джейсон обжэкта
        name=jsonObject.getString("name");  //у объектов класса джейсон обжэкт есть методы гет стринг гет инт гет булеан и т д
        age=jsonObject.getInt("age"); //гетеры эти на вход требуют наименование ключа по которому мы хотим достать значение


    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("name: "+ name);
        sb.append("age: "+ age);

        return sb.toString();
    }
}
