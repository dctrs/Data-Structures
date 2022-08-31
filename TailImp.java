package tailimp;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "->" + next;
    }
}

class LinkedList {

    Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(Node f) {
        if (head == null) {
            head = f;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = f;
        }
    }

    public void print() {
        System.out.println(this.head);
    }

}

public class TailImp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Node l1 = new Node(1);
        Node l2 = new Node(5);
        Node l3 = new Node(4);
        Node l4 = new Node(2);

        list.print();
        list.add(l1);
        list.print();
        list.add(l2);
        list.print();
        list.add(l3);
        list.print();
        list.add(l4);
        list.print();

    }

}
