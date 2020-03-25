/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BotonTabla;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author joelb
 */
public class myeditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    Boolean currentValue;
    JButton button;
    protected static final String EDIT = "edit";
    private JTable jTable1;

    public myeditor(JTable jTable1) {
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(false);
        this.jTable1 = jTable1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // mymodel t = (mymodel) jTable1.getModel();
        // t.addNewRecord();
        fireEditingStopped();
    }

    //Implement the one CellEditor method that AbstractCellEditor doesn't.
    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    //Implement the one method defined by TableCellEditor.
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Va a mostrar el botón solo en la última fila.
        // de otra forma muestra un espacio en blanco.
        if (row == table.getModel().getRowCount() - 1) {
            currentValue = (Boolean) value;
            return button;
        }
        return new JLabel();
    }
}
