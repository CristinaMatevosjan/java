public class MyLinkedListV2 {

    private NodeV2 head;
    private NodeV2 tail;

    public void addFirst(int value){
        NodeV2 node = new NodeV2(value);
        if (head != null){
            node.setNext(head);
            head.setPrev(node);
            //head = node;
        }
        else {
            tail = node;
            //head = node;
        }

        head = node;

    }

    public void removeFirst(){
        if (head != null && head.getNext() != null){
            head.getNext().setPrev(null);
            head = head.getNext();
        }
        else {
            head = null;
            tail = null;
        }
    }

    public void print() {
        NodeV2 current = head;
        while (current != null) {
            System.out.printf("%d ", current.getValue());
            current = current.getNext();
        }
        System.out.println();
    }

    public void revert(){
        NodeV2 currentNode=head;
        while (currentNode!=null){
            NodeV2 next=currentNode.getNext();
            NodeV2 previous=currentNode.getPrev();
            currentNode.setNext(previous);
            currentNode.setPrev(next);
            if (previous==null){
                tail=currentNode;
            }
            if (next==null){
                head=currentNode;
            }
            currentNode=next;
        }
        }

}
