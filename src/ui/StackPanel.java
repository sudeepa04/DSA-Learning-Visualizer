package ui;

import java.awt.*;
import javax.swing.*;
import stack.StackVisualizer;

public class StackPanel extends JPanel {

    private StackVisualizer stack;

    public StackPanel() {

        stack = new StackVisualizer();

        setBackground(Color.WHITE);
    }

    public StackVisualizer getStack() {

        return stack;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.BOLD, 18));

        g.drawString("STACK VISUALIZER", 220, 40);

        String display = stack.displayStack();

        String[] lines = display.split("\n");

        int y = 90;

        for(String line : lines) {

            g.drawString(line, 220, y);

            y += 25;
        }
    }
}