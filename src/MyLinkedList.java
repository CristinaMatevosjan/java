public class MyLinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.setNext(head);
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public Node contains(int value) {
        Node node = head;
        while (node != null) {
            if (node.getValue() == value)
                return node;
            node = node.getNext();
        }
        return null;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    public void removeLast() {
        if (head == null)
            return;

        Node node = head;
        while (node.getNext() != null) {
            if (node.getNext().getNext() == null) {
                node.getNext().setNext(null);
                return;
            }
            node = node.getNext();
        }

        head = null;

    }

    public void revert() {
        if (head != null && head.getNext() != null) {
            revert(head.getNext(), head);
        }
    }

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.getNext() == null) {
            head = currentNode;
        } else {
            revert(currentNode.getNext(), currentNode);
        }
        currentNode.setNext(previousNode);
        previousNode.setNext(null);

    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("%d ", current.getValue());
            current = current.getNext();
        }
        System.out.println();
    }
}