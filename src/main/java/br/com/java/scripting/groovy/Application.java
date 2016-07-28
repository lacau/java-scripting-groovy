package br.com.java.scripting.groovy;

import javax.swing.JDialog;

import br.com.java.scripting.groovy.view.MainDialog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lacau on 27/07/16.
 */
@SpringBootApplication
public class Application {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        SpringApplication.run(Application.class, args);

        dialog.setVisible(true);
    }
}