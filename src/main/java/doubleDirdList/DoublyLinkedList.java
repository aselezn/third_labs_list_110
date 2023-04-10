package doubleDirdList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public static class Node {
        Object data;
        Node prev;
        Node next;

        Node(Object data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }


    // определение, является ли список пустым, или нет
    public boolean isEmpty() {
        return head == null;
    }


    //добавление значения в начало списка
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    //извлечение значения из начала списка без его удаления из списка;
    public Object pickFront() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    //извлечение значения из начала списка с удалением из списка
    public Object pickDeleteFront() {
        //Если список пусто - возвращаем null
        if (head == null) {
            return null;
        }

        //Сохраняем значение первого элемента и назначаем первым элементом второй элемент списка
        Object value = head.data;
        head = head.next;

        //если список стал пустым, после удаления элемента, то tail становиться null
        if (head == null) {
            tail = null;
            //Если список не пуст, то обнуляем ссылку предыдущего элемента, так как head его не имеет
        } else {
            head.prev = null;
        }

        return value;
    }

    //добавление значения в конец списка
    public void addToEnd(Object data) {
        Node newNode = new Node(data);
        //если список пустой - добавляем head
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    // извлечение значения из конца списка без его удаления
    public Object pickEnd() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }

    // извлечение значения из конца списка с его удалением
    public Object pickDeleteEnd() {
        if (tail == null) {
            return null;
        }

        Object data = tail.data;
        tail = tail.prev;

        if (tail == null) {
            head = null; // Если список стал пустым, обновляем head на null
        } else {
            tail.next = null;
        }

        return data;
    }

    // определение, содержит ли список заданное значение, или нет
    public boolean contains(Object value) {
        Node current = head;

        // Перебираем элементы списка, проверяя на совпадение значения
        while (current != null) {
            if (current.data.equals(value)) {
                return true; // Если значение найдено, возвращаем true
            }
            current = current.next;
        }

        return false; // Если значение не найдено в списке, возвращаем false
    }


    // Удаление заданного значения из списка
    public void remove(Object data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
            }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                } else {
                    tail = current;
                }
                return;
                }
            current = current.next;
            }
        }

    // поглощение списка другим списком с добавлением значений второго в начало первого списка
    public void absorbListToFront(DoublyLinkedList other) {
        while (!other.isEmpty()) { // Пока список "other" не пуст
            // Удаляем последний элемент из списка "other" и добавляем его в начало текущего списка
            addFirst(other.pickDeleteEnd());
        }
    }

    // поглощение списка другим списком с добавлением значений второго в конец первого списка
    public void absorbListToEnd(DoublyLinkedList other) {
        while (!other.isEmpty()) { // Пока список "other" не пуст
            // Удаляем первый элемент из списка "other" и добавляем его в конец текущего списка
            addToEnd(other.pickDeleteFront());
        }
    }

    // Печать всех значений списка в прямом порядке
    public void printListForward() {
        Node current = head; // Начинаем с головы списка
        while (current != null) { // Продолжаем до тех пор, пока не дойдем до конца списка
            System.out.print(current.data + " "); // Печатаем значение текущего узла
            current = current.next; // Переходим к следующему узлу
        }
        System.out.println(); // Печатаем перевод строки для красоты вывода
    }

    // Печать всех значений списка в обратном порядке
    public void printListBackward() {
        Node current = tail; // Начинаем с хвоста списка
        while (current != null) { // Продолжаем до тех пор, пока не дойдем до начала списка
            System.out.print(current.data + " "); // Печатаем значение текущего узла
            current = current.prev; // Переходим к предыдущему узлу
        }
        System.out.println(); // Печатаем перевод строки для красоты вывода
    }


    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


}
