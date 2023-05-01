package doubleDirdList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList <T> implements Iterable<T>{
    private Node head;
    private Node tail;

    public class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    // Метод для поиска узла с заданным значением
    private Node findNode(T value) {
        Node currentNode = head; //начинаем с головы
        while (currentNode != null) {
            // Если значение текущего узла совпадает с искомым значением
            if (currentNode.data.equals(value)) {
                // Возвращаем найденный узел с искомым значением
                return currentNode;
            }
            // Если значение не найдено, переходим к следующему узлу
            currentNode = currentNode.next;
        }
        // Если ничего не нашли - возвращаем null
        return null;
    }

    // Реализация итератора для двусвязного списка
    private class ListIterator implements Iterator<T> {
        private Node currentNode;
        private boolean reverse;

        public ListIterator(boolean reverse) {
            this.reverse = reverse;
            currentNode = reverse ? tail : head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = currentNode.data;
            currentNode = reverse ? currentNode.prev : currentNode.next;
            return data;
        }
    }

    // Создание итератора для списка (false - перебор начинается с головы)
    @Override
    public Iterator<T> iterator() {
        return new ListIterator(false);
    }

    // Создание итератора для списка (true - перебор начинается с хвоста)
    public Iterable<T> reverseIterator() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new ListIterator(true);
            }
        };
    }

    // Метод для перебора списка от головного узла до узла с заданным значением
    public Iterable<T> rangeFromHeadToValue(T value) {
        //возвращает объект, реализующий интерфейс Iterator<T>
        return () -> new Iterator<T>() {
            private Node currentNode = head; // Начинаем с головного узла

            @Override
            public boolean hasNext() {
                // Проверяем, что текущий узел не null и его значение не равно искомому значению
                // (итерация остановится, когда будет найден узел с заданным значением)
                return currentNode != null && !currentNode.data.equals(value);
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    // Метод для перебора списка от хвостового узла до узла с заданным значением
    public Iterable<T> rangeFromTailToValue(T value) {
        return () -> new Iterator<T>() {
            private Node currentNode = tail;

            @Override
            public boolean hasNext() {
                return currentNode != null && !currentNode.data.equals(value);
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = currentNode.data;
                currentNode = currentNode.prev;
                return data;
            }
        };
    }

    // Метод для перебора списка от узла с заданным значением до хвоста/головы списка
    public Iterable<T> rangeFromValueToTail(T value) {
        return () -> new Iterator<T>() {
            private Node currentNode = findNode(value);

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    public Iterable<T> rangeFromValueToHead(T value) {
        return () -> new Iterator<T>() {
            private Node currentNode = findNode(value);

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = currentNode.data;
                currentNode = currentNode.prev;
                return data;
            }
        };
    }



    // определение, является ли список пустым, или нет
    public boolean isEmpty() {
        return head == null;
    }


    //добавление значения в начало списка
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    //извлечение значения из начала списка без его удаления из списка;
    public T pickFront() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    //извлечение значения из начала списка с удалением из списка
    public T pickDeleteFront() {
        //Если список пусто - возвращаем null
        if (head == null) {
            return null;
        }

        //Сохраняем значение первого элемента и назначаем первым элементом второй элемент списка
        T value = head.data;
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
    public void addToEnd(T data) {
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
    public T pickEnd() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }

    // извлечение значения из конца списка с его удалением
    public T pickDeleteEnd() {
        if (tail == null) {
            return null;
        }

        T data = tail.data;
        tail = tail.prev;

        if (tail == null) {
            head = null; // Если список стал пустым, обновляем head на null
        } else {
            tail.next = null;
        }

        return data;
    }

    // определение, содержит ли список заданное значение, или нет
    public boolean contains(T value) {
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
    public void remove(T data) {
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
    public void absorbListToFront(DoublyLinkedList<T> other) {
        while (!other.isEmpty()) { // Пока список "other" не пуст
            // Удаляем последний элемент из списка "other" и добавляем его в начало текущего списка
            addFirst(other.pickDeleteEnd());
        }
    }

    // поглощение списка другим списком с добавлением значений второго в конец первого списка
    public void absorbListToEnd(DoublyLinkedList<T> other) {
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
