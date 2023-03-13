public class MyHashTable<K,V> {

    private Backet[] backets;
    private static final int INIT_BACKET_COUNT=16;
    private  class Entity{

        private K key;
        private V value;
    }

    private class Backet<K,V>{
        private Node head; // это линкед лист по сути, здесь должно быть поле ноды со ссылкой на хид(голову)

        private class Node{
            private Node next;
            private Entity value;
        }

    public V get(K key){ //полуить значение по ключу
       Node node=head;
       while (node!=null){ // перебор связного списка через цикл вайл, пока нода не равна нал, те пока не дойдем до конца,
           //перезаписываем значение переменной ноде на след ноду
           if(node.value.key.equals(key)){
               return (V)node.value.value;
           }
           node=node.next;
       }
       return  null;
    }

    public boolean add(Entity entity){
            Node node=new Node(); // элементом связного списка является нода, добавим ее
            node.value=entity;  //создадим и проинициализируем ноду
            if (head!=null){
                Node currentNode=head;
                while (true){
                    if (currentNode.value.key.equals(entity.key)){
                        return false;
                    }
                    if (currentNode.next!=null){
                        currentNode=currentNode.next;
                    }else {
                        currentNode.next=node;
                        return true;
                    }
                }
            }else {
                head=node;
                return true;
            }

    }
    public boolean remove(K key){
            if (head==null){
                return false;
            }
            if (head.value.key.equals(key)){
                head=head.next;
            }else {
                Node node=head;
                while (node.next!=null){
                    if (node.next.value.key.equals(key)){
                        node.next=node.next.next;
                        return true;
                    }
                    node=node.next;
                }
            }
            return true;
    }

    }

    public MyHashTable(){
        this(INIT_BACKET_COUNT); // обращение через зис из конструктора по умолчанию к конструктору с параметрами

    }

    public MyHashTable(int initSize){
        backets=new Backet[initSize];
    }

    private int calculateBucketIndex(K key){ //метод для вычисления индекса ассоцииативного массива(хэш мэп) из бакетов
        //на основе метода хэш код который применяется к ключу и деления полученного значения с остатком на длину массива
        return key.hashCode()%backets.length;
        }
    public V get(K key){ // поиск значения по ключу
        int index=calculateBucketIndex(key);
        Backet<K,V> backet=backets[index];
        if (backet!=null)
             return backet.get(key); // взовем метод гет из класса бакет
        return null;
    }

    public boolean put(K key, V value){
        int index=calculateBucketIndex(key);
        Backet backet=backets[index];
        if (backet==null){
            backet=new Backet();
            backets[index]=backet;
        }
        Entity entity=new Entity();
        entity.key=key;
        entity.value=value;
        return  backet.add(entity);
    }

    public boolean remove(K key){
        int index=calculateBucketIndex(key);
        Backet backet=backets[index];
        if (backet!=null){
            backet.remove(key);
        }
        return false;
    }

}
