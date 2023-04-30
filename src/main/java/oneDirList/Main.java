package oneDirList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        list.addToEnd(4);
        list.addToEnd(5);
        list.addToEnd(6);
        list.addToBeginning(0);
        list.reverseList();

        list.printAll();

        for (Integer item : list.headToValue(3)){
            System.out.println(item);
        }
        System.out.println();

        for (Integer item : list.valueToTail(3)){
            System.out.println(item);
        }
        System.out.println();

    }
}
