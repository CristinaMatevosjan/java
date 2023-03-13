import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MyHashTable<Integer,String> myTable=new MyHashTable<>();
//        myTable.put(1,"dvdfv");
//        myTable.put(2,"vbfgbfgb");
//        myTable.put(2,"dd");
//        myTable.put(3,"ddfvd");
//        myTable.put(4,"dddfvd");
//
//        Tree<String > newTree=new Tree<>();
//        newTree.bypassInDepth("dgf");
//        List<String> values = newTree.bypassInWidth();

       final RedBlackTree tree=new RedBlackTree();
       try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
           while (true){
               try {
                   Integer value =Integer.parseInt(reader.readLine());
                   tree.add(value);
                   System.out.println("finish");
               }catch (Exception ignored){

               }
           }

       }catch (IOException e){
           throw new RuntimeException(e);
       }
     }
}