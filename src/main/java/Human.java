import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.Arrays;

public class Human {

    //Здесь мы повторяем ту структуру которая придет из джейсон строки, с теми же полями, типами данных и названиями
    // те парсим джейсон объект
    private String name;
    private int age;
    private boolean isMarried;
    private Child[] children;
    private String [] skills;

    public Human(JsonObject jsonObject){
        name=jsonObject.getString("name");
        age=jsonObject.getInt("age");
        isMarried=jsonObject.getBoolean("is_married");

        // с массивами немного сложнее, нам надо явно сказать что по такому то ключу мы ждем массив
        //сделать это можно при помощи метода гет_джейсон_аррэй и он тоже на вход просит ключ

        JsonArray childrenArray=jsonObject.getJsonArray("children");
        children=new Child[childrenArray.size()]; //заполняем нащше поле-массив чилдренов,
        // те инициализируем массив, размемр определяем по методу сайз у объекта джейсон_аррея
        for (int i=0;i<children.length;i++){ // в цикле фор по индексу i будут лежать джейсон обжэкты
            JsonObject jsonChild=childrenArray.getJsonObject(i); // получив этот объект мы его парсим
            //создаем объект класса чайлд и в конструктор передаем джейсон_чайлд для инициализации
            Child child=new Child(jsonChild);
            children[i]=child; //после чего масив чилдрен по индексу i кладем объект чайлд

        }

        JsonArray jsonSkills=jsonObject.getJsonArray("skills");
        skills=new String[jsonSkills.size()];
        for (int i=0;i<skills.length;i++){
            skills[i]=jsonSkills.getJsonString(i).getString();
        }


    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("name: "+ name+"\n");
        sb.append("age: "+ age+ "\n");
        sb.append("is Married " +isMarried+"\n");
        sb.append("children: "+ Arrays.toString(children)+"\n");
        sb.append("skills: "+Arrays.toString(skills)+"\n");

        return sb.toString();
    }
}
