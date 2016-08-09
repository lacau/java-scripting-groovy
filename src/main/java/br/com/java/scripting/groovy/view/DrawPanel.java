package br.com.java.scripting.groovy.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Created by lacau on 09/08/16.
 */
public class DrawPanel extends JPanel {

    public DrawPanel() {
        setBackground(Color.black);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}