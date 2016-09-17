package br.com.java.scripting.groovy;

import java.io.IOException;

import br.com.java.scripting.groovy.core.MonitorTask;
import br.com.java.scripting.groovy.message.Message;
import br.com.java.scripting.groovy.message.MessageType;
import br.com.java.scripting.groovy.service.GitService;
import br.com.java.scripting.groovy.view.MainDialog;

;

/**
 * Created by lacau on 27/07/16.
 */
public class Application {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();

        MonitorTask monitorTask = new MonitorTask();
        monitorTask.start();

        try {
            GitService.getInstance().init();
        } catch(IOException e) {
            System.out.println(Message.createMessage(MessageType.ERROR, "IOException, application crash."));
            MonitorTask.kill();
            System.exit(0);
        }

        dialog.setVisible(true);
    }
}