package br.com.java.scripting.groovy.service;

import br.com.java.scripting.groovy.Application;

/**
 * Created by lacau on 10/08/16.
 */
public class MainDialogService {

    private static final MainDialogService INSTANCE;

    static {
        INSTANCE = new MainDialogService();
    }

    public static MainDialogService getInstance() {
        return INSTANCE;
    }

    public void showScriptName(String fileName) {
        Application.getMainDialog().getScriptLabel().setText(fileName);
    }

    public void showStatus(ScriptStatus scriptStatus) {
        Application.getMainDialog().getStatusLabel().setForeground(scriptStatus.getColor());
        Application.getMainDialog().getStatusLabel().setText(scriptStatus.getName());
    }
}