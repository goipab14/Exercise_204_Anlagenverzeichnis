
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class AnlagenModel extends AbstractTableModel {

    private ArrayList<Anlagenverzeichnis> verzeichniss = new ArrayList();
    private String[] names = {
        " Bezeichnung", "AK", "Inbetriebname", "ND", "bisherige ND", "Afa bisher", "Wert vor Afa", "Afa d. J.", "Buchwert 31.12"
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
        switch (columnIndex) {
            case 0:
                return verzeichniss.get(rowIndex).getBezeichnung();
            case 1:
                return verzeichniss.get(rowIndex).getAk();
            case 2:
                return verzeichniss.get(rowIndex).getInbetriebname();
            case 3:
                return verzeichniss.get(rowIndex).getNd();
            case 4:
                return verzeichniss.get(rowIndex).getBisherigeND();
            case 5:
                return verzeichniss.get(rowIndex).getAfaBisher();
            case 6:
                return verzeichniss.get(rowIndex).getWertVorAfa();
            case 7:
                return verzeichniss.get(rowIndex).getAfaDJ();
            case 8:
                return verzeichniss.get(rowIndex).getBuchWert();
            default:
                return "Uups";
        }
    }

    public void load() throws IOException {
        FileReader fr;
        fr = new FileReader("anlagenverzeichnis.csv");
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        String s = br.readLine();
        do {
            String[] array = s.split(";");
            String umwandler = array[1];
            StringBuilder sb = new StringBuilder(umwandler);
            if (sb.length() >= 4) {
                sb.reverse();
                sb.replace(3, 4, "");
                sb.reverse();
            }
            umwandler = array[2];
            StringBuilder sbInbet = new StringBuilder(umwandler);
            if (sbInbet.length() > 4) {
                sbInbet.replace(4, 5, ".");
            }
            char[] a = array[3].toCharArray();
            StringBuilder nd = new StringBuilder();
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] == ',') {
                    a[i] = '.';
                }
                nd.append(a[i]);
            }
            if (nd.length() == 0) {
                nd = new StringBuilder(array[3]);
            }
            verzeichniss.add(new Anlagenverzeichnis(array[0], Double.parseDouble(sb.toString()), Double.parseDouble(sbInbet.toString()), Double.parseDouble(nd.toString()), 0, 0, 0, 0, 0));
            this.fireTableDataChanged();
        } while ((s = br.readLine()) != null);
    }
}
