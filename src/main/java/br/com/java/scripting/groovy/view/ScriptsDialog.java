package br.com.java.scripting.groovy.view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Created by lacau on 28/07/16.
 */
public class ScriptsDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Create the dialog.
     */
    public ScriptsDialog() {
        setBounds(0, 0, 600, 400);
        getContentPane().setLayout(null);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);
    }
}