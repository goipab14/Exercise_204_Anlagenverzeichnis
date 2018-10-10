/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pascal
 */
public class Anlagenverzeichnis {
      public String Bezeichnung;
    public double ak;
    public double inbetriebname;
    public double nd;
    public double bisherigeND;
    public double afaBisher;
    public double wertVorAfa;
    public double afaDJ;
    public double buchWert;

    public Anlagenverzeichnis(String Bezeichnung, double ak, double inbetriebname, double nd, double bisherigeND, double afaBisher, double wertVorAfa, double afaDJ, double buchWert) {
        this.Bezeichnung = Bezeichnung;
        this.ak = ak;
        this.inbetriebname = inbetriebname;
        this.nd = nd;
        this.bisherigeND = bisherigeND;
        this.afaBisher = afaBisher;
        this.wertVorAfa = wertVorAfa;
        this.afaDJ = afaDJ;
        this.buchWert = buchWert;
    }

    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String Bezeichnung) {
        this.Bezeichnung = Bezeichnung;
    }

    public double getAk() {
        return ak;
    }

    public void setAk(int ak) {
        this.ak = ak;
    }

    public double getInbetriebname() {
        return inbetriebname;
    }

    public void setInbetriebname(double inbetriebname) {
        this.inbetriebname = inbetriebname;
    }

    public double getNd() {
        return nd;
    }

    public void setNd(double nd) {
        this.nd = nd;
    }

    public double getBisherigeND() {
        return bisherigeND;
    }

    public void setBisherigeND(double bisherigeND) {
        this.bisherigeND = bisherigeND;
    }

    public double getAfaBisher() {
        return afaBisher;
    }

    public void setAfaBisher(double afaBisher) {
        this.afaBisher = afaBisher;
    }

    public double getWertVorAfa() {
        return wertVorAfa;
    }

    public void setWertVorAfa(double wertVorAfa) {
        this.wertVorAfa = wertVorAfa;
    }

    public double getAfaDJ() {
        return afaDJ;
    }

    public void setAfaDJ(double afaDJ) {
        this.afaDJ = afaDJ;
    }

    public double getBuchWert() {
        return buchWert;
    }

    public void setBuchWert(double buchWert) {
        this.buchWert = buchWert;
    }
}
