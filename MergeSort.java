// Osman Tosun, 02200201031,1.Grup


package recursion;

public class MergeSort {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node n1 = new Node(5);
        Node n2 = new Node(15);
        Node n3 = new Node(9);
        Node n4 = new Node(13);
        Node n5 = new Node(20);
        Node n6 = new Node(18);
        Node n7 = new Node(17);
        Node n8 = new Node(35);

        int d[] = new int[8];
        d[0] = n1.data;
        d[1] = n2.data;
        d[2] = n3.data;
        d[3] = n4.data;
        d[4] = n5.data;
        d[5] = n6.data;
        d[6] = n7.data;
        d[7] = n8.data;

        System.out.print("Sıralanmamış liste: ");

        for (int i = 0; i < 8; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();

        System.out.print("Sıralanmış liste: ");

        mergeSort(d);
        printArray(d);
    }

    public static void mergeSort(int array[]) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int leftHalf[] = new int[mid];
        int rightHalf[] = new int[array.length - mid];
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = array[i];
        }
        for (int j = mid; j < array.length; j++) {
            rightHalf[j - mid] = array[j];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(array, leftHalf, rightHalf);

    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    private static void printArray(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;

    }

    @Override
    public String toString() {
        return data + "->" + next;
    }

}

class LinkedList {

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node tmp = head;
            while (tmp.next != null) {

                tmp = tmp.next;

            }
            tmp.next = n;
        }

    }

    public void addinorder(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node tmp = head;

            while (tmp.next != null && tmp.next.data < n.data) {

                tmp = tmp.next;

            }
            n.next = tmp.next;
            tmp.next = n;
        }

    }

    public void print() {
        System.out.println(this.head);
    }

}
