package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueVisualizer {

    private Queue<Integer> queue;

    public QueueVisualizer() {

        queue = new LinkedList<>();
    }

    public String enqueue(int value) {

        queue.offer(value);

        return "Enqueued : " + value;
    }

    public String dequeue() {

        if(queue.isEmpty()) {

            return "Queue Underflow";
        }

        int value = queue.poll();

        return "Dequeued : " + value;
    }

    public String front() {

        if(queue.isEmpty()) {

            return "Queue is Empty";
        }

        return "Front Element : " + queue.peek();
    }

    public boolean isEmpty() {

        return queue.isEmpty();
    }

    public int size() {

        return queue.size();
    }

    public String displayQueue() {

        if(queue.isEmpty()) {

            return "Queue Empty";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("FRONT\n\n");

        for(Integer num : queue) {

            sb.append("[ ")
              .append(num)
              .append(" ] ");
        }

        sb.append("\n\nREAR");

        return sb.toString();
    }

    public String getCode() {

        return
                "Queue<Integer> queue = new LinkedList<>();\n\n"

              + "queue.offer(x);\n"
              + "queue.poll();\n"
              + "queue.peek();\n\n"

              + "Time Complexity\n\n"

              + "Enqueue : O(1)\n"
              + "Dequeue : O(1)\n"
              + "Front   : O(1)";
    }
}