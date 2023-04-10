package oneDirList;

public class LinkedList {

    private Node head; // Ссылка на первый узел списка

    private static class Node {
        Object data; // Значение узла
        Node next; // Ссылка на следующий узел в списке

        // Конструктор для создания нового узла с заданным значением
        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }


    //добавление значения в начало списка
    public void addToBeginning(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            // Если список пуст (head равен null), то newNode становится и головой, и хвостом списка.
            head = newNode;
        } else {
            // Если список не пуст (head не равен null), то добавляем newNode перед текущей головой списка.
            newNode.next = head;
            head = newNode;
        }
    }

    //извлечение значения из начала списка без его удаления из списка
    public Object pickFirst(){
        // Если список пуст, выбрасываем исключение с соответствующим сообщением
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        // Возвращаем значение первого элемента списка без удаления
        return head.data;
    }

    //извлечение значения из начала списка c его удалением из списка
    public Object pickDeleteFirst() {
        // Если список пуст, выбрасываем исключение с соответствующим сообщением
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        // Сохраняем значение, которое нужно извлечь
        Object removedValue = head.data;

        // Устанавливаем голову списка на следующий элемент
        head = head.next;

        // Возвращаем удаленное значение
        return removedValue;
    }


    //добавление значения в конец списка
    public void addToEnd(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            // Если список пуст (head равен null), то newNode становится и головой, и хвостом списка.
            head = newNode;
        } else {
            // Если список не пуст (head не равен null), то идем до последнего узла и добавляем newNode после него.
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //извлечение значения из конца списка без его удаления
    public Object pickTail(){
        // Если список пуст, выбрасываем исключение с соответствующим сообщением
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        // Если список не пуст (head не равен null), то идем до последнего узла и извлекаем его без удаления
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    //извлечение значения из конца списка с его удалением
    public Object pickDeleteTail(){
        // Если список пуст, выбрасываем исключение с соответствующим сообщением
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        // Если в списке только один элемент
        if (head.next == null) {
            Object removedValue = head.data;
            head = null;
            return removedValue;
        }

        Node current = head;
        Node previous = null;

        // Перемещаемся по списку до последнего элемента
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        // Удаляем последний элемент списка и возвращаем его значение
        Object removedValue = current.data;
        previous.next = null;
        return removedValue;

    }

    // определение, является ли список пустым, или нет
    public boolean isEmpty() {
        return head == null;
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

    //удаление заданного значения из списка; если значения в списке нет, то ничего происходить не должно
    public void remove(Object data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    //построение нового списка в обратном порядке
    public LinkedList reverseList() {
        // Если список пуст, выбрасываем исключение с соответствующим сообщением
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        // Создаем новый экземпляр класса LinkedList для хранения обратного списка
        LinkedList reversedList = new LinkedList();
        Node current = head;
        // Проходим по исходному списку, начиная с головы и добавляем каждый элемент исходного списка в начало обратного списка
        while (current != null) {
            reversedList.addToBeginning(current.data);
            current = current.next;
        }
        return reversedList;
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
