
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

            if (sb.length() >= 7) {
                sb.reverse();
                sb.replace(6, 7, "");
                sb.reverse();
            }
            if (sb.length() >= 10) {
                sb.reverse();
                sb.replace(9, 10, "");
                sb.reverse();
            }
            umwandler = array[2];
            StringBuilder sbInbet = new StringBuilder(umwandler);
            if (sbInbet.length() > 4) {
                sbInbet.replace(4, 5, ".");
            }
            char[] a = array[3].toCharArray();
            StringBuilder nd = new StringBuilder();
            for (int i = 0; i < a.length; i++) {
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

    public void berechnen(int year) {

        for (int i = 0; i < verzeichniss.size(); i++) {

            if (year - verzeichniss.get(i).getInbetriebname() >= 0) {
                verzeichniss.get(i).setBisherigeND(year - verzeichniss.get(i).getInbetriebname());
            } else {
                verzeichniss.get(i).setBisherigeND(0);
            }
            if (verzeichniss.get(i).getNd() <= verzeichniss.get(i).getBisherigeND()) {
                verzeichniss.get(i).setBisherigeND(verzeichniss.get(i).getNd());
            }
            if (verzeichniss.get(i).getBisherigeND() != 0) {
                verzeichniss.get(i).setAfaDJ((verzeichniss.get(i).getAk() * ((100 / verzeichniss.get(i).getNd()) / 100)));
            } else {
                verzeichniss.get(i).setAfaDJ(0);
            }
            if (verzeichniss.get(i).getNd() <= verzeichniss.get(i).getBisherigeND()) {
                verzeichniss.get(i).setAfaDJ(0);
            }
            verzeichniss.get(i).setAfaBisher((verzeichniss.get(i).getAk() * ((100 / verzeichniss.get(i).getNd()) / 100)) * verzeichniss.get(i).getBisherigeND());
            verzeichniss.get(i).setWertVorAfa(verzeichniss.get(i).getAk() - verzeichniss.get(i).getAfaBisher());
            verzeichniss.get(i).setBuchWert(verzeichniss.get(i).getWertVorAfa() - verzeichniss.get(i).getAfaDJ());
        }
        this.fireTableDataChanged();
    }
}
