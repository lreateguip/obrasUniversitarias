package modelo.bodegaDTO;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FormatoTablas extends DefaultTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(null);
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        boolean oddRow = (row % 2 == 0);

        Color c = new Color(204, 204, 204);

        //Si las filas son pares, se cambia el color a gris
        if (oddRow) {
            setBackground(c);
        } else {

        }
        return this;
    }

    public static void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new FormatoTablas());
        }
        Font fuente = new Font(null, Font.BOLD, 16);
        table.getTableHeader().setFont(fuente);
    }

    public static void setOrdenar(JTable tabla){
        TableRowSorter<TableModel> modOrdTblR = new TableRowSorter<TableModel>(tabla.getModel());
        tabla.setRowSorter(modOrdTblR);
    }
    
    public static void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int numFilas = tabla.getRowCount();

        for (int i = 0; i < numFilas; i++) {
            modelo.removeRow(0);
        }
    }

    public static void calcularTotalPeso(JTable tabla,int col, JTextField texto) {
        float valor = 0.0f;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int numFilas = tabla.getRowCount();

        for (int i = 0; i < numFilas; i++) {
            valor += Float.parseFloat(modelo.getValueAt(i, col).toString());
        }
        texto.setText(String.valueOf(valor));
    }
}
