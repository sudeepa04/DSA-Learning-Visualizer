package ui;

import linkedlist.LinkedListVisualizer;

import javax.swing.*;
import java.awt.*;

public class LinkedListPanel extends JPanel {

    private LinkedListVisualizer list;

    public LinkedListPanel() {

        list = new LinkedListVisualizer();

        setBackground(Color.WHITE);
    }

    public LinkedListVisualizer getList() {

        return list;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.setFont(new Font("Arial", Font.BOLD, 22));

        g.drawString("LINKED LIST VISUALIZER", 140, 40);

        String display = list.display();

        String[] lines = display.split("\n");

        int y = 100;

        g.setFont(new Font("Arial", Font.BOLD, 20));

        for (String line : lines) {

            g.drawString(line, 60, y);

            y += 40;
        }
    }
}