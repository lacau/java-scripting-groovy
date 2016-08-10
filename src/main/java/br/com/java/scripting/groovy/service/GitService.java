package br.com.java.scripting.groovy.service;

/**
 * Created by lacau on 10/08/16.
 */
public class GitService {

    private static final GitService INSTANCE;

    static {
        INSTANCE = new GitService();
    }

    public static GitService getInstance() {
        return INSTANCE;
    }
}