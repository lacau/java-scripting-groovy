package br.com.java.scripting.groovy.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.java.scripting.groovy.util.MessageFactory;
import br.com.java.scripting.groovy.util.MessageType;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.treewalk.TreeWalk;

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
            System.out.println(MessageFactory.createMessage(MessageType.INFO, "file '%s' was committed.", fileName));
        } catch(GitAPIException e) {
            System.out.println(MessageFactory.createMessage(MessageType.ERROR, "could not commit file '%s'", fileName));
        }
    }

    public List<File> listFiles() {
        Git git = new Git(localRepository);
        List<File> files = new ArrayList<>();

        try(TreeWalk walker = new TreeWalk(localRepository)) {
            walker.setRecursive(true);
            List<Ref> branches = git.branchList().setListMode(ListBranchCommand.ListMode.ALL).call();
            if(branches.isEmpty())
                throw new GitAPIException("") {
                };

            Iterable<RevCommit> call = git.log().add(localRepository.resolve(branches.get(0).getName())).call();

            RevCommit c = call.iterator().next();
            walker.addTree(c.getTree());
            while(walker.next()) {
                File file = new File(walker.getNameString());
                FileOutputStream fos = new FileOutputStream(file);
                walker.getObjectId(0).copyTo(fos);
                fos.close();
                files.add(file);
            }
        } catch(GitAPIException e) {
            System.out.println(MessageFactory.createMessage(MessageType.WARNING, "could not found any branches into repository."));
        } catch(IOException e) {
            System.out.println(MessageFactory.createMessage(MessageType.ERROR, "could not read files from repository."));
        }

        return files;
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
            System.out.println(MessageFactory.createMessage(MessageType.INFO, "repository created."));
        } catch(IllegalStateException e) {
            System.out.println(MessageFactory.createMessage(MessageType.WARNING, "repository already exists."));
        }
    }
}