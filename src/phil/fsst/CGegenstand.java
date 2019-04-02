package phil.fsst;


public class CGegenstand {

    public String BZ; //Bezeichnung
    public int AGW; //Angriffswert
    public int VTW; //Verteigidungswert
    public int HW; //Heilwert
    public int GW; //Gewicht
    public int HK; //Haltbarkeit

    public int money = 200;


    public CGegenstand() {
        BZ = "Schwert";
        AGW = 20;
        VTW = 5;
        HW = 10;
        GW = 5;
        HK = 100;
    }

    public CGegenstand(String Bezeichnung,int Angriffswert,int Verteidigungswert, int Heilwert, int Gewicht, int Haltbarkeit) {
        BZ = Bezeichnung;
        AGW = Angriffswert;
        VTW = Verteidigungswert;
        HW = Heilwert;
        GW = Gewicht;
        HK = Haltbarkeit;
    }

    public String getCGegenstand() {
        return ("Bezeichnung: " + getBZ() + "\nAngriffswert: " + getAGW() + "\nVerteidigungswert: " + getVTW() + "\nHeilwert: " + getHW() + "\nGewicht: " + getGW() + "\nHaltbarkeit: " + getHK() );
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    public int getAGW() {
        return AGW;
    }

    public void setAGW(int AGW) {
        this.AGW = AGW;
    }

    public int getVTW() {
        return VTW;
    }

    public void setVTW(int VTW) {
        this.VTW = VTW;
    }

    public int getHW() {
        return HW;
    }

    public void setHW(int HW) {
        this.HW = HW;
    }

    public int getGW() {
        return GW;
    }

    public void setGW(int GW) {
        this.GW = GW;
    }

    public int getHK() {
        return HK;
    }

    public void setHK(int HK) {
        this.HK = HK;
    }

    public CGegenstand repair(CGegenstand item){
        money = money - 20;
        item.setHK(100);
        return new CGegenstand();
    }
}