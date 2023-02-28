import java.util.*;
public class Market {
    public static void main(String[] args) {

        TreeMap<Double,Toys>  weightMap=new TreeMap<>();

        Toys designer= new Toys.ToysBuilder(1,"Designer", 3, 0.3).build();
        Toys robot=new Toys.ToysBuilder(2,"Robot", 6, 0.5).build();
        Toys doll=new Toys.ToysBuilder(3,"Doll",10,0.2).build();
        Toys car=new Toys.ToysBuilder(4,"Car",14,0.1).build();
        Toys train=new Toys.ToysBuilder(5,"Train",4,0.4).build();
        Toys airplane=new Toys.ToysBuilder(6,"Airplane",7,0.05).build();

        ArrayList<Toys> toys = new ArrayList<>();
        toys.add(designer);
        toys.add(doll);
        toys.add(robot);
        toys.add(car);
        toys.add(train);
        toys.add(airplane);

        ArrayList<Double> listWeight=lw(toys);
       // System.out.println(Arrays.deepToString(listWeight.toArray())); // список получившихся накопленных весов
        //проверочная информация

        weightMap.put(listWeight.get(0),toys.get(0)); //добавление в соответствии с накопленным весом
        weightMap.put(listWeight.get(1),toys.get(1));
        weightMap.put(listWeight.get(2),toys.get(2));
        weightMap.put(listWeight.get(3),toys.get(3));
        weightMap.put(listWeight.get(4),toys.get(4));
        weightMap.put(listWeight.get(5),toys.get(5));

        raffle(weightMap);
    }

public static ArrayList<Double> lw(ArrayList<Toys>t){  // метод для накопления веса, возвращает массив накопленных весов
    ArrayList<Double> listWeight= new ArrayList<>();  // последний элемент это сумма всех весов
    double count=0.0;
    for (Toys el: t){
       count+= el.getWeightToys();
       listWeight.add(count);
    }
        return listWeight;
}

public static void raffle(TreeMap<Double,Toys> wp){
        while (!wp.isEmpty()){
            Toys prizeToys;
            int count;
            Double key;
            do {
                //System.out.println("Сумма всех весов "+ wp.lastKey());    //проверочная информация
                Double randomWeight = Math.random() * wp.lastKey(); // выбор рандомного числа между диапазоном [0,max weight)
               // System.out.println("Рандомное число в интервале от 0 до суммы всех весов "+ randomWeight);  // проверочная инф-я
                key = wp.tailMap(randomWeight, false).firstKey(); // поиск по ключу веса меньше или равного рандомному
                prizeToys = wp.get(key);
                count=prizeToys.getCountToys()-1;
                prizeToys.setCountToys(count);
                System.out.println("Поздравляем! Вы выиграли " + prizeToys.getNameToys());
            } while (count!=0);
            wp.remove(key);
                        
        }
    System.out.println("Розыгрыш окончен. Игрушек больше нет");
}

}