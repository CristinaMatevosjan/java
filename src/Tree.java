import java.util.ArrayList;
import java.util.List;

// это не бинарное дерево, у него может быть много потомков, поэтому дети тут списком

//небинарные деревья реализуют способы обхода в глубину СЕРХУ ВНИЗ И СЛЕВА НАПРАВО
// ( рекурсивно, испольуется чаще, тк прост и не требует много ресурсов)
// и в ширину СВЕРХУ ВНИЗ ПОСТРОЧНО И ТОЖЕ СЛЕВА НАПРАВО
// ( нерекурсивно) или поуровневый называют, когда детей не обрабатывают до тех пор пока все родители
// не были обработаны. Обход в ширину чаще используется не для поиска, а для массовых операций со зачениями

//пример небинарных деревьев это файловая система, где каждый узед это папка, а лист файл или пустая папка

// с точки зрения реализации на яп дерево похоже на связный список, но , ссылаться каждый узел может не на один,
// а на любое колличество дочерних элементов
public class Tree<V extends Comparable> {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private class Node {
        V value;
        List<Node> children;
    }

    public boolean bypassInDepth(V value) {
        return bypassInDepth(value, root);
    }

    private boolean bypassInDepth(V value, Node node) {
        if (node!=null) {
            if (node.value.equals(value)) return true;
            else {
                for (Node child : node.children) {
                    boolean result = bypassInDepth(value, child);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

// но более затратный по помяти
    public List<V> bypassInWidth(){  // чаще применяетс дла анализа, например когда надо отобразить
        // все элементы одной иерархии или отрисовать дерево
        List<V> result=new ArrayList<>();
        List<Node> line=new ArrayList<>();
        line.add(root);
        while (!line.isEmpty()){
            List<Node> nextLine=new ArrayList<>();
            for (Node node:line){
                result.add(node.value);
                nextLine.addAll(node.children);
            }
            line=nextLine;
        }
        return  result;
    }

    public Node findBypassInWidth(V value){
        List<Node> line=new ArrayList<>();
        line.add(root);
        while (!line.isEmpty()){ // до тех пор пока сущестует след линия
            List<Node> nextline=new ArrayList<>();
            for (Node node:line){
                if (node.value.equals(value)){
                    return node;
                }
                nextline.addAll(node.children); //для анализа след строки, добавляем в нее всех детей текущей ноды
            }
            line=nextline;  //обнвляем строку на следующую для новой итерации цикла
        }
        return null;
    }


}
