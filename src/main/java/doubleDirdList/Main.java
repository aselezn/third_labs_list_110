package doubleDirdList;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        System.out.println("Прямой порядок:");
        for (Integer value : list) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Обратный порядок:");
        for (Integer value : list.reverseIterator()) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("От головы до значения 3:");
        for (Integer value : list.rangeFromHeadToValue(3)) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("От значения 3 до хвоста:");
        for (Integer value : list.rangeFromValueToTail(3)) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("От хвоста до значения 3:");
        for (Integer value : list.rangeFromTailToValue(3)) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("От значения 3 до головы:");
        for (Integer value : list.rangeFromValueToHead(3)) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    }
