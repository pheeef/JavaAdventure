package phil.fsst;

public class CMonster{
    public String Namen = "";
    public int MaxLeben = 100; //Maximal des erreichbaren Leben
    public int Leben = 0; //Leben eines Monsters
    public double expiriencePoints = 0; //Punkte um Level aufzusteigen
    public int Level = 0; //Level vom Vieh
    public CGegenstand Waffe;


    public CMonster(String Namen, int MaxLeben, int Leben, CGegenstand Waffe,int Level) {
        this.Namen = Namen;
        this.MaxLeben = MaxLeben;
        this.Leben = Leben;
        this.Waffe = Waffe;
        this.Level = Level;

    }

    @Override
    public String toString() {
        return  "Name: " + Namen +
                " \nMaxLeben: " + MaxLeben +
                " \nLeben: " + Leben +
                " \nZugeordnete Waffe: " + Waffe +
                " \nLevel: " + Level +
                " \nExperiance Points: " + expiriencePoints;
    }

    public CGegenstand getWaffe() {
        return Waffe;
    }

    public int getLeben() {
        return Leben;
    }

    public int getLevel() {
        return Level;
    }

    public void setWaffe(CGegenstand Waffe) {
        this.Waffe = Waffe;
    }

    public void setLeben(int leben) {
        Leben = leben;
    }

    public int getMaxLeben() {
        return MaxLeben;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getNamen() {
        return Namen;
    }

    public void setMaxLeben(int maxLeben) {
        MaxLeben = maxLeben;
    }

    public void setNamen(String namen) {
        Namen = namen;
    }

    public void setExpiriencePoints(double expiriencePoints) {
        this.expiriencePoints = expiriencePoints;
    }

    public double getExpiriencePoints() {
        return expiriencePoints;
    }
}