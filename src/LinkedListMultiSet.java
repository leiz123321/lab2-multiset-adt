
// Node is only used inside the LinkedList class, so we define it in the same file;
// there can only be one public class in a file, but there can also be non-public classes.
class Node {
    int item;
    Node next;
    Node(int item) {
        this.item = item;
    }
}


public class LinkedListMultiSet extends MultiSet {

    // a linked list initially is empty
    private Node front;
    private int size;


    public void add(int item) {
        Node newNode =  new Node(item);
        newNode.next = front;
        front = newNode;
        size += 1;
    }

    public void remove(int item) {
        Node previous = null;
        Node current = front;
        while (current != null) {
            if (current.item == item) {
                if (previous == null) {
                    front = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean contains(int item) {
        Node current = front;
        while (current != null) {
            if (current.item == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return front == null;
    }


    public int count(int item) {
        int occurrences = 0;
        Node current = front;
        while (current != null) {
            if (current.item == item) {
                occurrences++;
            }
            current = current.next;
        }
        return occurrences;
    }

    public int size() {
        return size;
    }
}
