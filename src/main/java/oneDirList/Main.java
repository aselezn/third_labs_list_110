package oneDirList;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addToEnd("1");
        list.addToEnd("2");
        list.addToEnd("3");
        list.addToEnd("4");
        list.addToEnd("5");
        list.addToEnd("6");
        list.addToBeginning(7);
        list.reverseList();

        list.printAll();

    }
}
