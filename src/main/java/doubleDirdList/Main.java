package doubleDirdList;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList list1 = new DoublyLinkedList();
        list.addToEnd("1");
        list.addToEnd("2");
        list.addToEnd("3");
        list.addToEnd("4");
        list.addToEnd("5");
        list.addToEnd("6");
        list1.addFirst("a");
        list1.addToEnd("b");

        list.absorbListToEnd(list1);
        list.printAll();

    }
}
