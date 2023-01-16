//                стрим апи
//работает с потоком данных как с цепочкой функций которые вызывают сами себя
// представляет из себя последовательность элементов и функций которые поддерживаютразличные виды операций
//функциональна парадигма программирования
//стри апи используется чаще для работы с коллекциями


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
       List<Integer> integers=makeNewCollection();
      //Stream<Integer> stream= integers.stream();  // для того чтобы сказать что мы используем стрим апи у коллекции надо вызвать метод стрим
        //этот метод возвращает объект потока , т е мы оборачиваем список в поток с данными, над которым мы
        // можем производить, различные функциональные манипуляции

        //                  1. фильтр функция

        //stream=stream.filter((number)->{return number%2==0;});  // далее у объекта стрим вызовем метод фильтр, который фильтрует коллекцию по заданному условию
        //фильтр на вход просит лямбда функцию, причем с 1 параметром только
        //если аргумент один то можно не ставить круглые скобки,  если один оператор
        // то можно не ставить фигурные скобки и не писать ретерн, т е это то же самое
        //stream.filter(number-> number%2==0);
        //лучше все писать в одну строчку:
        //Stream<Integer> stream= integers.stream().filter(number-> number%2==0);
        // далее из этого стрима можно получить обратно коллекцию совершенно новую, от старой отличающуюся тем,
        // что мы написали в фильтре, для этого заменим левую часть снвоа на лист
       // List<Integer> filtered=integers.stream().filter(number-> number%2==0).collect(Collectors.toList());// есть
        // метод коллект, который на вход просит объект коллекторс , который умеет из потока
        // собирать элементы в новую сущность и ее возвращать ( ту лист)
        //System.out.println(integers);
        //System.out.println(filtered);

        // далее, следующая функция стрим апи редус
       int result=integers                    //  это
               .stream()                      // источник данных
               .filter(number-> number%2==0)    // это промежуточный оператор, их может быть много

               //редукция на вход принимает
               // лямбда выражение, с 2 параметрами только(первый аргумент это аккумулятор, в который кладется, по заданному
               // правилу, преобразованное значение, которое хранится во втором аргументе, а во втором аргументе,
               // на каждой итерации всегда будет другое значение. редус может нал вернуть, поэтому после него хорошо
               // бы писать орэлс, то есть альтернативутому что вернуть если будет нал

               .reduce((eachResult,nextElement)->eachResult+nextElement)   // это терминальный оператор
               // их тоже может быть несколько видов
               .orElse(0);
        System.out.println(result);
// у коллекции каждый раз надо вызывать метод стрим,
        // чтобы преобразовать коллекцию в поток и объект этого потока можно использовать лишь 1 раз

// Познакомимся с другими промежуточными операторами
        //                              3. скип

        List<Integer> skiped=integers.stream().skip(50).collect(Collectors.toList()); // скип принимает на вход число,
        // в соответствии с которым будет пропущено эн элементов в коллекции
        System.out.println(skiped);


        //       4.дисникт следующий метод возвращает коллекцию без дубликатов, он работает с методом иквлс,
        // поэтому если в коллекции есть сложные ссылочные объекты то иквлс надо переопределить, чтобы их можно было сравнить

        List<Integer> duplicates=makeDuplicateCollection();
        List<Integer> uniq=duplicates.stream().distinct().collect(Collectors.toList());

        System.out.println(uniq);

        //           5.следующая функция мэп,преобразует каждый элемент потока по заданному правилу

        List<Integer> mapped=integers.stream().map(element->element*10).collect(Collectors.toList()); //на вход требует лямбду с 1 аргументом

        System.out.println(mapped);

        //             6. метод пик, применяет какую то функцию к каждому элементу потока

        List<Integer> peeked=integers.stream().peek(element-> System.out.println(element)).collect(Collectors.toList());

        //       7. лимит принимает на вход 1 аргумент, число, сколько элементов коллекции взять с начала коллекции

        List<Integer> limited=integers.stream().limit(50).collect(Collectors.toList());
        System.out.println(limited); // от 100 до 51 выведет

        // 8.  следующий промежуточный оператор сортед, позволяет сортировать значения

        //есть 2 перегрузки этого метода, первая не принимает никаких параметров,
        // т е примитивные типы сравнивает по математическим правилам(интежеры по возрастанию),
        // сложные типы отсортировать не сможет и нужен будет компаратор(этот интерфейс можно реализовать в классе
        // и запихать объект реализации компоратора в сортед и он будет сортировать объекты по описанным мною правилам

        List<Integer> sorted=integers.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);

        //9.     флэт мэп похож на мэп, но позволяет разворачивать вложенные структуры в 1 единственную

        List<List<String>> lists= Arrays.asList(Arrays.asList("a"),Arrays.asList("b"));
        System.out.println(lists);

        List<String> flatMapped=lists.stream().flatMap(element->element.stream()).collect(Collectors.toList());
        System.out.println(flatMapped);


        //                  Рассмотрим терминальные операторы другие еще

        // они ставятся в конце работы со стримом и всегда возвращает какое либо значение
        // редус и коллект мы уже рассмотрели

        //3. файнд ферст вернет первый элемент из стрима
        //тоже возвращает тип опшинал, т е это обертка над
        // другим типом для того чтобы не упасть из за нала

        System.out.println(integers.stream().findFirst()); //  Optional[100]

        //4. файнд эни возвращает первый попавшийся из стрима элемент

        System.out.println(integers.stream().findAny()); // если это однопоточный стрим, то разницы с предыдущим нет,
        // но в многопоточке разница будет

        //5. каунт, вернет колличество элементов в стриме

        System.out.println(integers.stream().count()); //100

        //6. эни мэч на вход требует лямбду, которая имеет 1 аргумент и вернет булеан,
        // тру будет если условие выполнено хотя бы для 1 лемента

        System.out.println(integers.stream().allMatch(element->element<0));

        //7.  нон мэч вернет тру если условие не выполнено ни для одного элемента

        System.out.println(integers.stream().noneMatch(element->element<0));  //true

        //8. ол мач проверяет чтобы каждый элемент соответствовал условию

        System.out.println(integers.stream().allMatch(element->element>0)); //true

        //9.  мин и макс на вход объект компаратора надо передать(у интежеров уже вшита она)

        System.out.println(integers.stream().min(Integer::compareTo)); //Optional[1]
        System.out.println(integers.stream().max(Integer::compareTo)); //Optional[100]

        //10. форыч

        integers.stream().forEach(element-> System.out.println(element));//но! форыч не изменяет никак поток,
        // его отличие от пик, в том что  пик промежуточный и после него может идти еще куча других опреаторов,
        // а форыч терминальный

//                     Итог!!!!

       // стрим апи жрет много памяти! лучше много его не использовать, но спросят на собесе
        // больше он используется в котлин, свифт, скала

    }

    public static List<Integer> makeNewCollection(){
        List<Integer> collection=new ArrayList<>();
        for (int i=100; i>0;i--){
            collection.add(i);
        }
        return collection;
    }

    public static List<Integer> makeDuplicateCollection(){
        List<Integer> collection=new ArrayList<>();
        for (int i=1; i<100;i++){
            collection.add(1);
        }
        return collection;
    }
}