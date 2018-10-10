
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pascal
 */
public class AnlagenRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
         Anlagenverzeichnis a = (Anlagenverzeichnis) value;
         JLabel lb = new JLabel(value.toString());
         lb.setOpaque(true);
         
        
         return lb;
    }
    
}
