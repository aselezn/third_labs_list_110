package doubleDirdList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

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













}
