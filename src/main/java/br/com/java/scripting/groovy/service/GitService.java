package br.com.java.scripting.groovy.service;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;

/**
 * Created by lacau on 10/08/16.
 */
public class GitService {

    private static final GitService INSTANCE;

    private static final String PATH = "files";

    private Repository localRepository;
    static {
        INSTANCE = new GitService();
    }
    public static GitService getInstance() {
        return INSTANCE;
    }

    public void init() throws IOException {
        createDirectory();
        createRepository();
    }

    private void createDirectory() {
        File file = new File(PATH);
        if(!file.exists()) {
            file.mkdir();
        }
    }

    private void createRepository() throws IOException {
        try {
            localRepository = new FileRepository(PATH + "/.git");
            localRepository.create();
        } catch(IllegalStateException e) {
            System.out.println("WARNING: repository already exists.");
        }
    }
}