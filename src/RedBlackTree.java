public class RedBlackTree <T extends Comparable<T>>{
    private Node root;


    private class Node{
        private T value;
        private Color color;
        private  Node left;
        private Node right;


        @Override
        public String toString(){
            return "Node{"+
                    "value="+value+
                    ", color="+color+
                    '}';
        }
    }

    private enum Color{
        RED,BLACK
    }

    private void colorSwap(Node node){
        node.right.color=Color.BLACK;
        node.left.color=Color.BLACK;
        node.color=Color.RED;
    }
    private boolean addNode(Node node, T value){
        if(node.value.equals(value)){
            return false;
        }else {
            if (node.value.compareTo(value)>0){
                if (node.left!=null){
                    boolean res=addNode(node.left,value);
                    node.left=rebalance(node.left);
                    return  res;
                }else {
                    node.left=new Node();
                    node.left.color=Color.RED;
                    node.left.value=value;
                    return true;
                }
            }else {
                 if (node.right!=null){
                     boolean res=addNode(node.right,value);
                     node.right=rebalance(node.right);
                     return res;
                 }else {
                     node.right=new Node();
                     node.right.color=Color.RED;
                     node.right.value=value;
                     return true;
                 }
            }
        }
    }

    private Node leftSwap(Node node){
        Node leftchild=node.left; // берем левого ребенка и выделяем его в отдельную переменную для удобства
        Node betweenChild=leftchild.right; //промеж элемент это тот который меняет своего родителя
        leftchild.right=node; // здесь левост нода априори красная, и вместо правого ребенка красной ноды
        // назначаем рутовый элемент с которого начали ( т е текущего родителя)
        node.left=betweenChild;// а у родителя левым элементом становится не красная нода
        // на которую ссылались, а промежуточный ребенок
        leftchild.color=node.color; // левый ребенок получает цвет родителя
        node.color=Color.RED; // а сам корень, который был корнем и опустился ниже, становится красным
        return leftchild;
    }
    private Node rightSwap(Node node){
        Node rightChild=node.right;
        Node betweenChild=rightChild.left;
        rightChild.left=node;
        node.right=betweenChild;
        rightChild.color=node.color;
        node.color=Color.RED;
        return rightChild;
    }

    private Node rebalance(Node node){
        Node res=node;
        boolean needRebalance;
        do {
            needRebalance=false;
            if (res.right!=null && res.right.color == Color.RED && res.left==null||res.left.color==Color.BLACK){
                needRebalance=true;
                res=rightSwap(res); // правый поорот всегда идет со сменой цвета
            }
            if (res.left!=null && res.left.color==Color.RED&& res.left.left !=null&& res.left.left.color==Color.RED){
                needRebalance=true;
                res=leftSwap(res);
            }
            if (res.left!=null&&res.left.color==Color.RED&& res.right!=null&&res.right.color==Color.RED){
                needRebalance=true;
                colorSwap(res);
            }
        }
        while (needRebalance);
        return res;
    }

    public boolean add(T value){

        if (root!=null){       //обработка рутовой ноды, если она уже существует,
            boolean result=addNode(root,value);  // то создаем новую ноду относительно рута
            root=rebalance(root);  //и сам рут балансируем
            root.color=Color.BLACK;  // и ставим руту черный цвет
            return  result;
        }else {
            root=new Node();
            root.color=Color.BLACK;
            root.value=value;
            return  true;
        }
    }


}
