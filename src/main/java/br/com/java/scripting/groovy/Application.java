package br.com.java.scripting.groovy;

import javax.swing.JDialog;

import br.com.java.scripting.groovy.core.Engine;
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

        Engine engine = new Engine();
        new Thread(engine).start();

        dialog.setVisible(true);
    }
}