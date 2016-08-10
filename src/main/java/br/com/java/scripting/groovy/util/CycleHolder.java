package br.com.java.scripting.groovy.util;

import br.com.java.scripting.groovy.core.Cycle;

/**
 * Created by lacau on 10/08/16.
 */
public class CycleHolder {

    private static Cycle current;

    public static void refresh(Cycle cycle) {
        current = cycle;
    }

    public static Cycle get() {
        return current;
    }
}