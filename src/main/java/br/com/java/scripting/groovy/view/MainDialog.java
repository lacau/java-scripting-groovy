package br.com.java.scripting.groovy.view;

/**
 * Created by lacau on 27/07/16.
 */

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.java.scripting.groovy.core.MonitorTask;
import br.com.java.scripting.groovy.util.GroovyFileChooser;

public class MainDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();

    private static DrawPanel drawPanel;

    /**
     * Create the dialog.
     */
    public MainDialog() {
        setResizable(false);
        setAutoRequestFocus(false);
        setBounds(100, 100, 800, 580);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 800, 580);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MonitorTask.kill();
                dispose();
            }
        });

        JPanel panelMenu = new JPanel();
        panelMenu.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
        panelMenu.setBounds(668, 12, 120, 179);
        contentPanel.add(panelMenu);
        panelMenu.setLayout(null);

        Button btLoadScript = new Button("load script");
        btLoadScript.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GroovyFileChooser fileChooser = new GroovyFileChooser();
                fileChooser.showOpenDialog(MainDialog.this);
            }
        });
        btLoadScript.setBounds(10, 15, 100, 23);
        panelMenu.add(btLoadScript);

        Button btScripts = new Button("scripts");
        btScripts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScriptsDialog dialog = new ScriptsDialog();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(contentPanel);
                dialog.setVisible(true);
            }
        });
        btScripts.setBounds(10, 45, 100, 23);
        panelMenu.add(btScripts);

        Button btRun = new Button("RUN");
        btRun.setBounds(10, 75, 100, 23);
        panelMenu.add(btRun);

        JPanel panelBorder = new JPanel();
        panelBorder.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelBorder.setBounds(12, 12, 644, 556);
        contentPanel.add(panelBorder);
        panelBorder.setLayout(null);

        drawPanel = new DrawPanel();
        drawPanel.setBounds(10, 10, 624, 536);
        panelBorder.add(drawPanel);
        drawPanel.setLayout(null);
    }

    public static DrawPanel getDrawPanel() {
        return drawPanel;
    }
}