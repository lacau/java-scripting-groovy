package br.com.java.scripting.groovy.util;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created by lacau on 10/08/16.
 */
public class GroovyFileChooser extends JFileChooser {

    public GroovyFileChooser() {
        super();
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Script file(.groovy)", "groovy", "text");
        setFileFilter(filter);
    }
}