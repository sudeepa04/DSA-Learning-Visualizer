package ui;

import java.awt.*;
import javax.swing.*;

public class SortingPanel extends JPanel {

    private int[] array = {};

    private int currentIndex1 = -1;
    private int currentIndex2 = -1;

    public void setArray(int[] arr) {

        this.array = arr.clone();

        repaint();
    }

    // ======================
    // Bubble Sort Dry Run
    // ======================

    public String generateDryRun() {

        if (array.length == 0) {
            return "No array entered.";
        }

        int[] temp = array.clone();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < temp.length - 1; i++) {

            sb.append("PASS ")
              .append(i + 1)
              .append("\n\n");

            for (int j = 0; j < temp.length - i - 1; j++) {

                sb.append("Compare ")
                  .append(temp[j])
                  .append(" and ")
                  .append(temp[j + 1])
                  .append("\n");

                if (temp[j] > temp[j + 1]) {

                    int t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;

                    sb.append("Swap -> ");

                    for (int num : temp) {
                        sb.append(num).append(" ");
                    }

                    sb.append("\n");
                }
                else {

                    sb.append("No Swap\n");
                }

                sb.append("\n");
            }
        }

        return sb.toString();
    }

    // ======================
    // Selection Sort Dry Run
    // ======================

    public String generateSelectionDryRun() {

        if (array.length == 0) {
            return "No array entered.";
        }

        int[] temp = array.clone();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < temp.length - 1; i++) {

            int minIndex = i;

            sb.append("PASS ")
              .append(i + 1)
              .append("\n\n");

            for (int j = i + 1; j < temp.length; j++) {

                sb.append("Compare ")
                  .append(temp[j])
                  .append(" with ")
                  .append(temp[minIndex])
                  .append("\n");

                if (temp[j] < temp[minIndex]) {

                    minIndex = j;

                    sb.append("New Minimum Found\n");
                }

                sb.append("\n");
            }

            int t = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex] = t;

            sb.append("Swap -> ");

            for (int num : temp) {
                sb.append(num).append(" ");
            }

            sb.append("\n\n");
        }

        return sb.toString();
    }

    // ======================
    // Bubble Sort Animation
    // ======================

    public void startBubbleSort() {

        if (array.length == 0) {
            return;
        }

        new Thread(() -> {

            try {

                for (int i = 0; i < array.length - 1; i++) {

                    for (int j = 0; j < array.length - i - 1; j++) {

                        currentIndex1 = j;
                        currentIndex2 = j + 1;

                        repaint();

                        Thread.sleep(700);

                        if (array[j] > array[j + 1]) {

                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;

                            repaint();

                            Thread.sleep(700);
                        }
                    }
                }

                currentIndex1 = -1;
                currentIndex2 = -1;

                repaint();

            } catch (Exception e) {

                e.printStackTrace();
            }

        }).start();
    }

    // ======================
    // Selection Sort Animation
    // ======================

    public void startSelectionSort() {

        if (array.length == 0) {
            return;
        }

        new Thread(() -> {

            try {

                for (int i = 0; i < array.length - 1; i++) {

                    int minIndex = i;

                    for (int j = i + 1; j < array.length; j++) {

                        currentIndex1 = minIndex;
                        currentIndex2 = j;

                        repaint();

                        Thread.sleep(700);

                        if (array[j] < array[minIndex]) {

                            minIndex = j;
                        }
                    }

                    int temp = array[i];
                    array[i] = array[minIndex];
                    array[minIndex] = temp;

                    repaint();

                    Thread.sleep(700);
                }

                currentIndex1 = -1;
                currentIndex2 = -1;

                repaint();

            } catch (Exception e) {

                e.printStackTrace();
            }

        }).start();
    }

    // ======================
    // Drawing Area
    // ======================

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.setFont(new Font("Arial", Font.BOLD, 16));

        if (currentIndex1 != -1 && currentIndex2 != -1) {

            g.drawString(
                    "Comparing : "
                            + array[currentIndex1]
                            + " and "
                            + array[currentIndex2],
                    50,
                    40);
        }

        if (array.length == 0) {

            g.drawString(
                    "Enter numbers and click Set Array",
                    250,
                    250);

            return;
        }

        int width = 50;
        int gap = 20;
        int startX = 50;

        for (int i = 0; i < array.length; i++) {

            int height = array[i] * 10;

            if (i == currentIndex1 || i == currentIndex2) {

                g.setColor(Color.RED);

            } else {

                g.setColor(Color.BLUE);
            }

            g.fillRect(
                    startX + (i * (width + gap)),
                    500 - height,
                    width,
                    height
            );

            g.setColor(Color.BLACK);

            g.drawString(
                    String.valueOf(array[i]),
                    startX + (i * (width + gap)) + 15,
                    520
            );
        }
    }
}