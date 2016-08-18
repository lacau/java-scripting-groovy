package br.com.java.scripting.groovy;

import java.io.IOException;
import javax.swing.JDialog;

import br.com.java.scripting.groovy.core.Engine;
import br.com.java.scripting.groovy.core.MonitorTask;
import br.com.java.scripting.groovy.service.GitService;
import br.com.java.scripting.groovy.view.MainDialog;

/**
 * Created by lacau on 27/07/16.
 */
public class Application {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        MonitorTask monitorTask = new MonitorTask();
        monitorTask.start();

        try {
            GitService.getInstance().init();
        } catch(IOException e) {
            System.out.println("ERROR: IOException, application crash.");
            Engine.kill();
            System.exit(0);
        }

        dialog.setVisible(true);
    }
}