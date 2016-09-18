package br.com.java.scripting.groovy.service;

import java.io.File;
import java.io.IOException;

import br.com.java.scripting.groovy.message.Message;
import br.com.java.scripting.groovy.message.MessageType;
import org.apache.commons.io.FileUtils;

/**
 * Created by lacau on 10/08/16.
 */
public class CycleService {

    private static final CycleService INSTANCE;

    static {
        INSTANCE = new CycleService();
    }

    public static CycleService getInstance() {
        return INSTANCE;
    }

    public void loadNewFile(File file) {
        MainDialogService.getInstance().showScriptName(file.getName());
        MainDialogService.getInstance().showStatus(ScriptStatus.LOADED);

        File destination = new File(GitService.getInstance().getRepositoryPath() + "/" + file.getName());

        try {
            FileUtils.copyFile(file, destination);
            GitService.getInstance().commitFile(destination);
        } catch(IOException e) {
            System.out.println(Message.createMessage(MessageType.ERROR, "could no create file '%s'", file.getName()));
        }
    }
}