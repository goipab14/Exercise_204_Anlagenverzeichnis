
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pascal
 */
public class AnlagenModel extends AbstractTableModel{
        private ArrayList <Anlagenverzeichnis> verzeichniss = new ArrayList();
private String [] names = {
 " Bezeichnung","AK","Inbetriebname","ND","bisherige ND","Afa bisher","Wert vor Afa","Afa d. J.","Buchwert 31.12"  
};
    @Override
    public int getRowCount() {
       return verzeichniss.size();
    }

    @Override
    public int getColumnCount() {
       return names.length;
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return verzeichniss.get(rowIndex).getBezeichnung();
            case 1: return verzeichniss.get(rowIndex).getAk();
            case 2: return verzeichniss.get(rowIndex).getInbetriebname();
            case 3: return verzeichniss.get(rowIndex).getNd();
            case 4: return verzeichniss.get(rowIndex).getBisherigeND();
            case 5: return verzeichniss.get(rowIndex).getAfaBisher();
            case 6: return verzeichniss.get(rowIndex).getWertVorAfa();
            case 7: return verzeichniss.get(rowIndex).getAfaDJ();
            case 8: return verzeichniss.get(rowIndex).getBuchWert();
            default:
                return "Uups";
        }
    }
    public void load()
    {
        
    }
}
