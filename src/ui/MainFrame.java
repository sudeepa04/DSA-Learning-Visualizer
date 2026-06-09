package ui;
import java.awt.*;
import javax.swing.*;
import linkedlist.LinkedListVisualizer;
import queue.QueueVisualizer;
import searching.BinarySearch;
import stack.StackVisualizer;
public class MainFrame extends JFrame {

private JTextArea codeArea;
private JTextArea dryRunArea;
private SortingPanel visualPanel;
private StackPanel stackPanel;
private QueuePanel queuePanel;
private LinkedListPanel linkedListPanel;

private CardLayout cardLayout;
private JPanel centerPanel;

private StackVisualizer stack;
private QueueVisualizer queue;
private LinkedListVisualizer linkedList;

public MainFrame() {

    setTitle("DSA Learning Visualizer");
    setSize(1200, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    JLabel title = new JLabel(
            "DSA LEARNING VISUALIZER",
            SwingConstants.CENTER);

    title.setFont(new Font("Arial", Font.BOLD, 28));

    add(title, BorderLayout.NORTH);

    visualPanel = new SortingPanel();

stackPanel = new StackPanel();
queuePanel = new QueuePanel();
linkedListPanel = new LinkedListPanel();

linkedList = linkedListPanel.getList();

queue = queuePanel.getQueue();

stack = stackPanel.getStack();

cardLayout = new CardLayout();

centerPanel = new JPanel(cardLayout);

centerPanel.add(visualPanel, "SORT");

centerPanel.add(stackPanel, "STACK");
centerPanel.add(queuePanel, "QUEUE");
centerPanel.add(linkedListPanel,"LIST");

    JPanel inputPanel = new JPanel();

    JTextField inputField = new JTextField(20);

    JButton setArrayBtn = new JButton("Set Array");
    JButton bubbleBtn = new JButton("Bubble Sort");
    JButton selectionBtn = new JButton("Selection Sort");
    JButton binaryBtn = new JButton("Binary Search");
    JButton stackBtn = new JButton("Stack");
    JButton queueBtn = new JButton("Queue");
    JButton listBtn = new JButton("Linked List");


    inputPanel.add(new JLabel("Numbers:"));
    inputPanel.add(inputField);
    inputPanel.add(setArrayBtn);
    inputPanel.add(bubbleBtn);
    inputPanel.add(selectionBtn);
    inputPanel.add(binaryBtn);
    inputPanel.add(stackBtn);
    inputPanel.add(queueBtn);
    inputPanel.add(listBtn);

    add(inputPanel, BorderLayout.SOUTH);

    codeArea = new JTextArea();
    codeArea.setEditable(false);
    codeArea.setFont(
            new Font("Monospaced", Font.PLAIN, 14));

    dryRunArea = new JTextArea();
    dryRunArea.setEditable(false);
    dryRunArea.setFont(
            new Font("Monospaced", Font.PLAIN, 14));

    JScrollPane codeScroll =
            new JScrollPane(codeArea);

    JScrollPane dryRunScroll =
            new JScrollPane(dryRunArea);

    JSplitPane rightPane =
            new JSplitPane(
                    JSplitPane.VERTICAL_SPLIT,
                    codeScroll,
                    dryRunScroll);

    rightPane.setDividerLocation(250);
JSplitPane mainPane =
        new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                centerPanel,
                rightPane);

    mainPane.setDividerLocation(650);

    add(mainPane, BorderLayout.CENTER);

    // Set Array
    setArrayBtn.addActionListener(e -> {

        try {

            String[] nums =
                    inputField.getText()
                            .trim()
                            .split("\\s+");

            int[] arr =
                    new int[nums.length];

            for (int i = 0; i < nums.length; i++) {

                arr[i] =
                        Integer.parseInt(nums[i]);
            }

            visualPanel.setArray(arr);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter valid numbers separated by spaces");
        }
    });

    // Bubble Sort
    bubbleBtn.addActionListener(e -> {

        codeArea.setText(
                "Bubble Sort (Java)\n\n" +
                "for(int i=0;i<n-1;i++) {\n" +
                "   for(int j=0;j<n-i-1;j++) {\n" +
                "      if(arr[j] > arr[j+1]) {\n" +
                "         swap(arr[j],arr[j+1]);\n" +
                "      }\n" +
                "   }\n" +
                "}\n\n" +
                "Best Case    : O(n)\n" +
                "Average Case : O(n²)\n" +
                "Worst Case   : O(n²)\n" +
                "Space        : O(1)"
        );

        dryRunArea.setText(
                visualPanel.generateDryRun());

        visualPanel.startBubbleSort();
    });

    // Selection Sort
    selectionBtn.addActionListener(e -> {

        codeArea.setText(
                "Selection Sort (Java)\n\n" +
                "for(int i=0;i<n-1;i++) {\n" +
                "   int min=i;\n" +
                "   for(int j=i+1;j<n;j++) {\n" +
                "      if(arr[j] < arr[min])\n" +
                "         min=j;\n" +
                "   }\n" +
                "   swap(arr[i],arr[min]);\n" +
                "}\n\n" +
                "Best Case    : O(n²)\n" +
                "Average Case : O(n²)\n" +
                "Worst Case   : O(n²)\n" +
                "Space        : O(1)"
        );

        dryRunArea.setText(
                visualPanel.generateSelectionDryRun());

        visualPanel.startSelectionSort();
    });

    // Binary Search
    binaryBtn.addActionListener(e -> {

        try {

            String targetInput =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Target Value");

            if (targetInput == null) {
                return;
            }

            int target =
                    Integer.parseInt(targetInput);

            String[] nums =
                    inputField.getText()
                            .trim()
                            .split("\\s+");

            int[] arr =
                    new int[nums.length];

            for (int i = 0; i < nums.length; i++) {

                arr[i] =
                        Integer.parseInt(nums[i]);
            }

            codeArea.setText(
                    "Binary Search (Java)\n\n" +
                    "int low=0;\n" +
                    "int high=n-1;\n\n" +
                    "while(low<=high){\n" +
                    "   int mid=(low+high)/2;\n\n" +
                    "   if(arr[mid]==target)\n" +
                    "      return mid;\n\n" +
                    "   else if(arr[mid]<target)\n" +
                    "      low=mid+1;\n\n" +
                    "   else\n" +
                    "      high=mid-1;\n" +
                    "}\n\n" +
                    "Best Case    : O(1)\n" +
                    "Average Case : O(log n)\n" +
                    "Worst Case   : O(log n)\n" +
                    "Space        : O(1)"
            );

            dryRunArea.setText(
                    BinarySearch.generateDryRun(
                            arr,
                            target));
        
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input");
        }
    });
    //Stack Operation
    stackBtn.addActionListener(event -> {

    cardLayout.show(centerPanel, "STACK");

    String[] options = {
            "Push",
            "Pop",
            "Peek",
            "Back"
    };

    while (true) {

        int choice = JOptionPane.showOptionDialog(

                this,

                "Choose Stack Operation",

                "Stack",

                JOptionPane.DEFAULT_OPTION,

                JOptionPane.INFORMATION_MESSAGE,

                null,

                options,

                options[0]);

        if (choice == 0) {

            String value = JOptionPane.showInputDialog(
                    this,
                    "Enter Value");

            if (value != null) {

                try {

                    int val =
                            Integer.parseInt(value);

                    dryRunArea.append(
                            stack.push(val)
                                    + "\n");

                    codeArea.setText(
                            stack.getCode());

                    stackPanel.repaint();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Number");
                }
            }

        } else if (choice == 1) {

            dryRunArea.append(
                    stack.pop()
                            + "\n");

            codeArea.setText(
                    stack.getCode());

            stackPanel.repaint();

        } else if (choice == 2) {

            JOptionPane.showMessageDialog(
                    this,
                    stack.peek());

        } else {

            cardLayout.show(
                    centerPanel,
                    "SORT");

            break;
        }
    }
});
queueBtn.addActionListener(event -> {

    cardLayout.show(centerPanel, "QUEUE");

    String[] options = {
            "Enqueue",
            "Dequeue",
            "Front",
            "Back"
    };

    while (true) {

        int choice = JOptionPane.showOptionDialog(

                this,

                "Choose Queue Operation",

                "Queue",

                JOptionPane.DEFAULT_OPTION,

                JOptionPane.INFORMATION_MESSAGE,

                null,

                options,

                options[0]);

        if (choice == 0) {

            String value = JOptionPane.showInputDialog(
                    this,
                    "Enter Value");

            if (value != null) {

                try {

                    int val = Integer.parseInt(value);

                    dryRunArea.append(
                            queue.enqueue(val)
                                    + "\n");

                    codeArea.setText(
                            queue.getCode());

                    queuePanel.repaint();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Number");
                }
            }

        } else if (choice == 1) {

            dryRunArea.append(
                    queue.dequeue()
                            + "\n");

            codeArea.setText(
                    queue.getCode());

            queuePanel.repaint();

        } else if (choice == 2) {

            JOptionPane.showMessageDialog(
                    this,
                    queue.front());

        } else {

            cardLayout.show(
                    centerPanel,
                    "SORT");

            break;
        }
    }
});
queueBtn.addActionListener(event -> {

    cardLayout.show(centerPanel, "QUEUE");

    String[] options = {
            "Enqueue",
            "Dequeue",
            "Front",
            "Back"
    };

    while (true) {

        int choice = JOptionPane.showOptionDialog(

                this,

                "Choose Queue Operation",

                "Queue",

                JOptionPane.DEFAULT_OPTION,

                JOptionPane.INFORMATION_MESSAGE,

                null,

                options,

                options[0]);

        if (choice == 0) {

            String value = JOptionPane.showInputDialog(
                    this,
                    "Enter Value");

            if (value != null) {

                try {

                    int val = Integer.parseInt(value);

                    dryRunArea.append(
                            queue.enqueue(val)
                                    + "\n");

                    codeArea.setText(
                            queue.getCode());

                    queuePanel.repaint();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Number");
                }
            }

        } else if (choice == 1) {

            dryRunArea.append(
                    queue.dequeue()
                            + "\n");

            codeArea.setText(
                    queue.getCode());

            queuePanel.repaint();

        } else if (choice == 2) {

            JOptionPane.showMessageDialog(
                    this,
                    queue.front());

        } else {

            cardLayout.show(
                    centerPanel,
                    "SORT");

            break;
        }
    }
});
listBtn.addActionListener(event -> {

    cardLayout.show(centerPanel, "LIST");

    String[] options = {
            "Insert",
            "Delete",
            "Search",
            "Back"
    };

    while (true) {

        int choice = JOptionPane.showOptionDialog(

                this,

                "Choose Linked List Operation",

                "Linked List",

                JOptionPane.DEFAULT_OPTION,

                JOptionPane.INFORMATION_MESSAGE,

                null,

                options,

                options[0]);

        if (choice == 0) {

            String value = JOptionPane.showInputDialog(
                    this,
                    "Enter Value");

            if (value != null) {

                try {

                    int val = Integer.parseInt(value);

                    dryRunArea.append(
                            linkedList.insert(val)
                                    + "\n");

                    codeArea.setText(
                            linkedList.getCode());

                    linkedListPanel.repaint();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Number");
                }
            }

        } else if (choice == 1) {

            String value = JOptionPane.showInputDialog(
                    this,
                    "Enter Value To Delete");

            if (value != null) {

                int val = Integer.parseInt(value);

                dryRunArea.append(
                        linkedList.delete(val)
                                + "\n");

                codeArea.setText(
                        linkedList.getCode());

                linkedListPanel.repaint();
            }

        } else if (choice == 2) {

            String value = JOptionPane.showInputDialog(
                    this,
                    "Enter Value To Search");

            if (value != null) {

                int val = Integer.parseInt(value);

                JOptionPane.showMessageDialog(
                        this,
                        linkedList.search(val));
            }

        } else {

            cardLayout.show(centerPanel, "SORT");

            break;
        }
    }
});

    setVisible(true);
}


}
