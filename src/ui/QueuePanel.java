package ui;

import java.awt.*;
import javax.swing.*;
import queue.QueueVisualizer;

public class QueuePanel extends JPanel {

    private QueueVisualizer queue;

    public QueuePanel() {

        queue = new QueueVisualizer();

        setBackground(Color.WHITE);
    }

    public QueueVisualizer getQueue() {

        return queue;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.setFont(new Font("Arial", Font.BOLD, 20));

        g.drawString("QUEUE VISUALIZER", 200, 40);

        String display = queue.displayQueue();

        String[] lines = display.split("\n");

        int y = 100;

        for (String line : lines) {

            g.drawString(line, 100, y);

            y += 35;
        }
    }
}