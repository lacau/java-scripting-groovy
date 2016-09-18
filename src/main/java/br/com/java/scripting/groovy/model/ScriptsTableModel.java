package br.com.java.scripting.groovy.model;

import javax.swing.table.DefaultTableModel;

/**
 * Created by Lacau on 18/09/2016.
 */
public class ScriptsTableModel extends DefaultTableModel {

    public ScriptsTableModel(String... columns) {
        super();
        for(String column : columns) {
            addColumn(column);
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0)
            return Boolean.class;

        return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 0;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        if(column == 0) {
            for(int i = 0; i < getRowCount(); i++)
                super.setValueAt(false, i, 0);
        }

        super.setValueAt(aValue, row, column);
    }
}