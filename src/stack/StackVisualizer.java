package stack;

import java.util.Stack;

public class StackVisualizer {

    private Stack<Integer> stack;

    public StackVisualizer() {

        stack = new Stack<>();
    }

    public String push(int value) {

        stack.push(value);

        return "Pushed : " + value;
    }

    public String pop() {

        if(stack.isEmpty()) {

            return "Stack Underflow";
        }

        int value = stack.pop();

        return "Popped : " + value;
    }

    public String peek() {

        if(stack.isEmpty()) {

            return "Stack is Empty";
        }

        return "Top Element : " + stack.peek();
    }

    public boolean isEmpty() {

        return stack.isEmpty();
    }

    public int size() {

        return stack.size();
    }

    public void clear() {

        stack.clear();
    }

    public String displayStack() {

        if(stack.isEmpty()) {

            return "Stack Empty";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("----------- TOP -----------\n\n");

        for(int i = stack.size() - 1; i >= 0; i--) {

            sb.append("      | ")
              .append(stack.get(i))
              .append(" |\n");

            sb.append("      -------\n");
        }

        return sb.toString();
    }

    public String getCode() {

        return
                "Stack<Integer> stack = new Stack<>();\n\n"

              + "stack.push(x);\n"
              + "stack.pop();\n"
              + "stack.peek();\n"
              + "stack.isEmpty();\n"
              + "stack.size();\n\n"

              + "Time Complexity\n\n"

              + "Push : O(1)\n"
              + "Pop  : O(1)\n"
              + "Peek : O(1)\n"
              + "Size : O(1)";
    }
}