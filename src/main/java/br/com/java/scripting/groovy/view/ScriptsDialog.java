package br.com.java.scripting.groovy.view;

import java.awt.Button;
import java.io.File;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.java.scripting.groovy.model.NullSelectionModel;
import br.com.java.scripting.groovy.model.ScriptsTableModel;
import br.com.java.scripting.groovy.service.GitService;

/**
 * Created by lacau on 28/07/16.
 */
public class ScriptsDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();

    private ScriptsTableModel scriptsTableModel;

    /**
     * Create the dialog.
     */
    public ScriptsDialog() {
        setBounds(0, 0, 600, 400);
        getContentPane().setLayout(null);
        setTitle("Scripts");
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        Button loadButton = new Button("load");
        loadButton.setBounds(513, 328, 61, 23);
        getContentPane().add(loadButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 564, 306);
        getContentPane().add(scrollPane);

        JTable table = new JTable();
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionModel(new NullSelectionModel());
        scriptsTableModel = new ScriptsTableModel("", "Name");
        table.setModel(scriptsTableModel);

        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(30);

        scrollPane.setViewportView(table);
        loadFiles();
    }

    private void loadFiles() {
        List<File> files = GitService.getInstance().listFiles();
        for(File file : files) {
            scriptsTableModel.addRow(new Object[] {false, file.getName()});
        }
    }
}