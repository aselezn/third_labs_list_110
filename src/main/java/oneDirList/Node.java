package oneDirList;

class Node {
    Object data; // Значение узла
    Node next; // Ссылка на следующий узел в списке

    // Конструктор для создания нового узла с заданным значением
    Node(Object data) {
        this.data = data;
        this.next = null;
    }
}