public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);

        MyLinkedListV2 myLinkedListV2=new MyLinkedListV2();
        myLinkedListV2.addFirst(45);
        myLinkedListV2.addFirst(98);
        myLinkedListV2.addFirst(4);
        myLinkedListV2.addFirst(41);
        myLinkedListV2.addFirst(2);

        myLinkedListV2.print();
        myLinkedListV2.revert();
        myLinkedListV2.print();

        //Node head = linkedList.getHead();

        //Node res = getMiddle(head);

        linkedList.print();
        linkedList.revert();
        linkedList.print();

    }

    public static Node getMiddle(Node head){
        int count = 1;

        Node node = head;
        while (node.getNext() != null) {
            count++;
            node = node.getNext();
        }

        count = count / 2 + 1;

        node = head;
        for (int i = 0; i < count - 1; i++){
            node = node.getNext();
        }
        return node;
    }
    }
