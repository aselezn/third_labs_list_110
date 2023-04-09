package doubleDirdList;

public class Node {
    Object data;
    Node prev;
    Node next;

    Node(Object data) {
        this.data = data;
        prev = null;
        next = null;
    }
}
