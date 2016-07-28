package br.com.java.scripting.groovy;

import javax.swing.JDialog;

import br.com.java.scripting.groovy.view.MainDialog;

/**
 * Created by lacau on 27/07/16.
 */
public class Application {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            MainDialog dialog = new MainDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}