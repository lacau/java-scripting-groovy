package br.com.java.scripting.groovy.service;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
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

    public String getRepositoryPath() {
        return localRepository.getDirectory().getParent();
    }

    public void commitFile(File file) {
        Git git = new Git(localRepository);

        final String fileName = file.getName();
        try {
            git.add().addFilepattern(fileName).call();
            git.commit().setMessage(String.format("Add file '%s'", fileName)).call();
            System.out.println(String.format("INFO: file '%s' was committed.", fileName));
        } catch(GitAPIException e) {
            System.out.println(String.format("ERROR: could not commit file '%s'", fileName));
        }
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
            System.out.println("INFO: repository created.");
        } catch(IllegalStateException e) {
            System.out.println("WARNING: repository already exists.");
        }
    }
}