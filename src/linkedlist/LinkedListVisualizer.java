package linkedlist;

public class LinkedListVisualizer {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public String insert(int value) {

        Node newNode = new Node(value);

        if(head == null) {

            head = newNode;

        } else {

            Node temp = head;

            while(temp.next != null) {

                temp = temp.next;
            }

            temp.next = newNode;
        }

        return "Inserted : " + value;
    }

    public String delete(int value) {

        if(head == null)
            return "List Empty";

        if(head.data == value) {

            head = head.next;

            return "Deleted : " + value;
        }

        Node temp = head;

        while(temp.next != null &&
                temp.next.data != value) {

            temp = temp.next;
        }

        if(temp.next == null)
            return "Value Not Found";

        temp.next = temp.next.next;

        return "Deleted : " + value;
    }

    public String search(int value) {

        Node temp = head;

        int pos = 0;

        while(temp != null) {

            if(temp.data == value) {

                return "Found at Position : " + pos;
            }

            pos++;

            temp = temp.next;
        }

        return "Not Found";
    }

    public String display() {

        if(head == null)
            return "HEAD -> NULL";

        StringBuilder sb =
                new StringBuilder();

        sb.append("HEAD\n\n");

        Node temp = head;

        while(temp != null) {

            sb.append(temp.data);

            if(temp.next != null) {

                sb.append(" -> ");
            }

            temp = temp.next;
        }

        sb.append(" -> NULL");

        return sb.toString();
    }

    public String getCode() {

        return
                "class Node {\n" +
                "   int data;\n" +
                "   Node next;\n" +
                "}\n\n" +

                "Insert : O(n)\n" +
                "Delete : O(n)\n" +
                "Search : O(n)";
    }
}